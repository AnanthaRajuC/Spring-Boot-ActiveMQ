package io.github.anantharajuc.sbamq.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMQConfig 
{
    @Bean
    public ConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("io.github.anantharajuc.sbamq"));
        
        return  activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate()
    {
        JmsTemplate jmsTemplate = new JmsTemplate();
        
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        
        return jmsTemplate;
    }
    
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory()
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        
        return factory;
    }
}
