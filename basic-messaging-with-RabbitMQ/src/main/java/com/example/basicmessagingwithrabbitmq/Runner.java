package com.example.basicmessagingwithrabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        chat();
        receiver.getLatch().await(0, TimeUnit.MILLISECONDS);
    }

    public void chat() {
        System.out.println("Chating with myself?...");
        Scanner scanner = new Scanner(System.in);

        Boolean continueWriting = true;
        do {
            String message = scanner.nextLine();
            rabbitTemplate.convertAndSend(BasicMessagingWithRabbitMQ.topicExchangeName, "foo.bar.baz", message);
            receiver.getLatch().countDown();
            System.out.println("Message sent: " + message);
        } while (continueWriting);
    }

}
