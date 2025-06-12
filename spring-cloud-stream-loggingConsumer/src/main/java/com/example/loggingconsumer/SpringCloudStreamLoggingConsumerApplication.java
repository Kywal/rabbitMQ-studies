package com.example.loggingconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    public static class Person {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
