package com.dawoud.kafka.consumer;
import com.dawoud.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "dawoud", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info(format("Consuming the message from dawoud Topic:: %s", student.toString()));
    }
}