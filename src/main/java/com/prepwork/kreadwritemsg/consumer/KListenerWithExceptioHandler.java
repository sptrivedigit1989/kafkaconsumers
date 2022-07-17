package com.prepwork.kreadwritemsg.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KListenerWithExceptioHandler {

    @KafkaListener(topics = "quickstartexception",
            groupId = "group_id",
            containerFactory = "myConsumerFactoryForException", id = "QSE-01")
    public void consume(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("topic name : {}", topic);
        log.info("consumed message is : {}", msg);
        int x = Integer.parseInt(msg);
        log.info("msg converted to int successfully : {}", x);
    }


    // enable below method when you want to acknowledge the message manually.
    /*@KafkaListener(topics = "quickstartexception",
            groupId = "group_id",
            containerFactory = "myConsumerFactoryForException", id = "QSE-01")
    public void consume(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        Acknowledgment acknowledgment) {
        log.info("topic name : {}", topic);
        log.info("consumed message is : {}", msg);
        int x = Integer.parseInt(msg);
        acknowledgment.acknowledge();
        log.info("msg acknowledged and converted to int successfully : {}", x);
    }*/

}
