package io.github.anantharajuc.sbamq.jms;

import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import io.github.anantharajuc.sbamq.model.Person;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Log4j2
public class JmsConsumer implements MessageListener 
{
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) 
    {
        try
        {
            ObjectMessage objectMessage = (ObjectMessage)message;
            Person person = (Person)objectMessage.getObject();
            //do additional processing
            log.info("Received Message from Topic: "+ person.toString());
        } 
        catch(Exception e) 
        {
            log.error("Received Exception while processing message: "+ e);
        }
    }
}