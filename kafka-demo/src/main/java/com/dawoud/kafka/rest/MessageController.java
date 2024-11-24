package com.dawoud.kafka.rest;

import com.dawoud.kafka.payload.Student;
import com.dawoud.kafka.producer.KafkaJsonProducer;
import com.dawoud.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> SendMessage
            (@RequestBody String msg)
    {
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message sent successfully");

    }

    @PostMapping("/json")
    public ResponseEntity<String> SendStudentMessage
            (@RequestBody Student student)
    {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Student Message sent successfully");

    }
}
