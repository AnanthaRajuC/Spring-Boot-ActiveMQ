package io.github.anantharajuc.sbamq.jms;

import javax.jms.DeliveryMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import io.github.anantharajuc.sbamq.model.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JmsProducer 
{
	@Autowired
    JmsTemplate jmsTemplate;
	
	@Value("${active-mq.topic}")
    private String topic;
	
	public void sendMessage(Person person)
	{
        try
        {
            log.info("Attempting Send message to Topic: "+ topic);
            
            jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
            jmsTemplate.convertAndSend(topic, person);
        } 
        catch(Exception e)
        {
            log.error("Recieved Exception during send Message: ", e);
        }
    }
}
