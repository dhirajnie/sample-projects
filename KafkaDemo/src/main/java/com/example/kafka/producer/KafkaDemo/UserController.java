package com.example.kafka.producer.KafkaDemo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@RestController @RequestMapping ("kafka") public class UserController
{
    private static String TOPIC = "demo";
    @Autowired KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping ("/publish/{message}") public String post( @PathVariable ("message") String message )
        throws InterruptedException, JsonProcessingException
    {
        for ( int i = 0; i < 100; i++ ) {
            String message1 = "I am counting " + i;
            ObjectMapper objectMapper = new ObjectMapper();
            User user = new User( "Dhiraj", i, "Patna" );
            kafkaTemplate.send( TOPIC, objectMapper.writeValueAsString( user ) );
        }
        return "Publihes Successfully";
    }


    @Scheduled (fixedRate = 2000) public void cronJobExecutor()
    {
        System.out.println(Thread.currentThread().getName());
        System.out.println( "Cron jon at every second" );
    }

}

