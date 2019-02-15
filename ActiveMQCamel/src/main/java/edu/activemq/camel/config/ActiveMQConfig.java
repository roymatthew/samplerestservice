package edu.activemq.camel.config;


import javax.jms.ConnectionFactory;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfig {

	@Bean(name="activemq")
	public ActiveMQComponent createComponent(ConnectionFactory factory)
	{
		ActiveMQComponent activeMQComponent = new ActiveMQComponent();
		activeMQComponent.setConnectionFactory(factory);
		return activeMQComponent;
	}
}
