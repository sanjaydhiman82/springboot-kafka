package com.tsb.kafkademo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@EnableKafka
@Service
public class KafkaListner {
    private final Logger logger = LoggerFactory.getLogger(KafkaListner.class);
    @KafkaListener(topics = "demo-topic")
    public void consumeMessage(String msg){
        logger.info(String.format("Message recieved -> %s", msg));
    }
}
