package com.prepwork.kreadwritemsg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-consumer")
public class KafkaContainerController {

    @Autowired
    private KafkaListenerEndpointRegistry endpointRegistry;

    // kafkaTopicId QSE-01
    @GetMapping("/start/{kafkaTopicId}")
    public String startKafkaConsumer(@PathVariable String kafkaTopicId){
        endpointRegistry.getListenerContainer(kafkaTopicId).start();
        return "kafka consumer topic started";
    }

    @GetMapping("/stop/{kafkaTopicId}")
    public String stopKafkaConsumer(@PathVariable String kafkaTopicId){
        endpointRegistry.getListenerContainer(kafkaTopicId).stop();
        return "kafka consumer topic stopped";
    }

}
