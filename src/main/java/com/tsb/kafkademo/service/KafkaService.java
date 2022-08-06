package com.tsb.kafkademo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    Logger log= LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    KafkaTemplate<String ,String> kafkaTemplate;

    public boolean publishKafkaMsg(String msg){
        try{
            kafkaTemplate.send("demo-topic",msg,msg);
        }catch (Exception exception){
            log.error("Exception while sending kafka msg {}",exception.getMessage());
            return false;
        }
        return true;
    }
}
