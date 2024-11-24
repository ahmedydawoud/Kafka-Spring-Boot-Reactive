package com.dawoud.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service

public class WikimediaProducer {

    private final KafkaTemplate<String,String>kafkaTemplate;
    public void SendMsg(String message){
        kafkaTemplate.send("wikimedia-stream",message);
    }

}
