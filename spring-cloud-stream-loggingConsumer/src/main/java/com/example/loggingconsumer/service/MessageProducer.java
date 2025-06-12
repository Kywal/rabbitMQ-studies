package com.example.loggingconsumer.service;

import com.example.loggingconsumer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private StreamBridge streamBridge;

    public void sendPerson(Person person) {
        // Send the Person object to the "log-in-0" binding
        streamBridge.send("log-in-0", person);
    }
}
