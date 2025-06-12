package com.example.loggingconsumer.controller;

import com.example.loggingconsumer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    PersonService personService;

    @PostMapping
    public String test(@RequestBody PersonDTO person) {

        personService.create(person.name(), person.age());

        return "Person logged successfully!";
    }
}
