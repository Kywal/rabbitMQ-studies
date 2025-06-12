package com.example.loggingconsumer.service;

import com.example.loggingconsumer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private MessageProducer messageProducer;

    public Person create(String name, int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        messageProducer.sendPerson(person);

        return person;
    }


}
