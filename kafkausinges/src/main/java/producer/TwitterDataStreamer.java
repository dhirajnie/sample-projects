package producer;


import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import config.PropertyFileHandler;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class TwitterDataStreamer
{
    final static String consumerKey = "RRPFYm4j8ybazN6srJZBvpOzu";
    final static String consumerSecret = "fj93Wfxwth7lnIxqPloWDMKjcV0vj6Ax7uTKA7gEZ9Q8gDA4hS";
    final static String token = "2891058522-A5EpcmSaoOndE3ejGiVcK7JL9BPEjiR4aSXEVlr";
    final static String secret = "YG70Dd2efrEzLtA5QjLKfs4tSbZ7v3OOXULob6AP2wp8U";


    public static void main( String args[] ) throws InterruptedException
    {
        // start producer
        Thread producer = new Thread( new ProduceMessage() );
        producer.start();

    }


    public static Client createTwitterClient( BlockingQueue<String> msgQueue )
    {

        BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>( 1000 );

        /** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
        Hosts hosebirdHosts = new HttpHosts( Constants.STREAM_HOST );
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
        // Optional: set up some followings and track
        List<Long> followings = Lists.newArrayList( 1234L, 566788L );
        List<String> terms = Lists.newArrayList( "bitcoin", "usa" ,"sports","politics");
        hosebirdEndpoint.followings( followings );
        hosebirdEndpoint.trackTerms( terms );

        // These secrets should be read from a config file
        Authentication hosebirdAuth = new OAuth1( consumerKey, consumerSecret, token, secret );


        ClientBuilder builder = new ClientBuilder()
            .name( "Hosebird-Client-01" )                              // optional: mainly for the logs
            .hosts( hosebirdHosts ).authentication( hosebirdAuth ).endpoint( hosebirdEndpoint )
            .processor( new StringDelimitedProcessor( msgQueue ) ).eventMessageQueue(
                eventQueue );                          // optional: use this if you want to process client events

        Client hosebirdClient = builder.build();
        // Attempts to establish a connection.
        return hosebirdClient;

    }


}


class ProduceMessage implements Runnable
{
    private static final Properties producerProperties = PropertyFileHandler.loadProperties( "kafka-producer" );


    private String fetchMessage()
    {
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>( 1000 );

        Client client = TwitterDataStreamer.createTwitterClient( msgQueue );
        client.connect();
        while ( !client.isDone() ) {
            String message = null;
            try {
                message = msgQueue.poll( 1, TimeUnit.SECONDS );
            } catch ( Exception e ) {
                System.out.println( "Exception occured " + e );
            }
            if ( message != null ) {
                System.out.println(message);
                return message;


            } else {
                break;
            }

        }

        System.out.println( "End of applicaiotn" );
        return "";

    }


    public void run()
    {

        System.out.println( producerProperties );
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>( producerProperties );
        while ( true ) {
            String message = fetchMessage();
            ProducerRecord<String, String> record = new ProducerRecord<>( "estopic", message );
            producer.send( record );
          //  producer.flush();
        }

    }

}