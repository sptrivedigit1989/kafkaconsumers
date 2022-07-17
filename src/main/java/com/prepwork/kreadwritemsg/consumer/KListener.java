package com.prepwork.kreadwritemsg.consumer;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class KListener {

    @RetryableTopic(attempts = "3", backoff = @Backoff(delay = 5000, multiplier = 3.0))
    @KafkaListener(topics = "quickstart",
            groupId = "group_id",
            containerFactory = "myConsumerFactory")
    public void consume(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        System.out.println(msg +" from "+topic);

        int x = Integer.parseInt(msg);

    }

    @DltHandler
    public void dlt(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        System.out.println("Dead Message : "+msg +" from "+topic);
    }

}
