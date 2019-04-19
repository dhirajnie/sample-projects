package consumer;

import config.PropertyFileHandler;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;


public class TwitterDataConsumer
{



    public static void main( String args[] )
    {

        CountDownLatch countDownLatch = new CountDownLatch( 4 );
        Runnable myConsumer1 = new ConsumerThread(countDownLatch );
        Runnable myConsumer2 = new ConsumerThread(countDownLatch );
        Runnable myConsumer3 = new ConsumerThread(countDownLatch );
        Runnable myConsumer4 = new ConsumerThread(countDownLatch );
        Thread t1 = new Thread( myConsumer1 );
        Thread t2 = new Thread( myConsumer2 );
        Thread t3 = new Thread( myConsumer3 );
        Thread t4 = new Thread( myConsumer4 );
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            countDownLatch.await();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}


class ConsumerThread implements Runnable
{
    private static final Properties producerProperties = PropertyFileHandler.loadProperties( "kafka-producer" );
    CountDownLatch countDownLatch;
    public ConsumerThread( CountDownLatch countDownLatch )
    {
        this.countDownLatch= countDownLatch;
    }



    @Override
    public void run()
    {
        System.out.println("Running thread "+Thread.currentThread().getName());
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>( producerProperties );
        consumer.subscribe( Arrays.asList("estopic") );
        while ( true ){
            ConsumerRecords<String ,String> record = consumer.poll( Duration.ofSeconds( 1 ) );
            for(ConsumerRecord<String,String> record1:record){
                System.out.println("Name of Partition: "+record1.partition()+"  Key: "+record1.key()+" value: "+record1.value());
                System.out.println("Offset "+record1.offset());
            }
        }

    }


    public void shutdown()
    {

    }
}
