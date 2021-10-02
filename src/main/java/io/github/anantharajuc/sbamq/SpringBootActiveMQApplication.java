package io.github.anantharajuc.sbamq;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import lombok.extern.log4j.Log4j2;

/**
 * Spring Boot ActiveMQ.
 *
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 *
 */
@Log4j2
@SpringBootApplication
public class SpringBootActiveMQApplication 
{
	public static void main(String[] args) 
	{
		ApplicationContext applicationContext = SpringApplication.run(SpringBootActiveMQApplication.class, args);
		
		log.info("Spring Boot Application Template started at {}", LocalDateTime.now());
		
		JmsTemplate jms = applicationContext.getBean(JmsTemplate.class);
		
		jms.convertAndSend("Spring-Boot-ActiveMQ", "Hello World!");
	}
}
