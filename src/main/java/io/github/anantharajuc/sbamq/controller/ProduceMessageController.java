package io.github.anantharajuc.sbamq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbamq.jms.JmsProducer;
import io.github.anantharajuc.sbamq.model.Person;

@RestController
public class ProduceMessageController 
{
    @Autowired
    JmsProducer jmsProducer;

    @PostMapping(value="/api/employee")
    public Person sendMessage(@RequestBody Person person)
    {
        jmsProducer.sendMessage(person);
        
        return person;
    }
}