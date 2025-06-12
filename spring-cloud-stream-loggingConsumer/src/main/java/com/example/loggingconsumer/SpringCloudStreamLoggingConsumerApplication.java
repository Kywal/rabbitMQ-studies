package com.example.loggingconsumer;

import com.example.loggingconsumer.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class SpringCloudStreamLoggingConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamLoggingConsumerApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(SpringCloudStreamLoggingConsumerApplication.class);

    @Bean
    public Consumer<Person> log() {
        return person -> {
            // Log the received Person object
            log.info("Received Person: {}", person);
        };
    }


}
