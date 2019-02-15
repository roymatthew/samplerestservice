package edu.sample.soap.queue.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
 

import edu.sample.soap.vo.ConsumerLoanVO;
 
@Component
public class JmsProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${activemq.queue}")
	String queue;
	
	public void send(ConsumerLoanVO consumerLoanVO){
		jmsTemplate.convertAndSend(queue, consumerLoanVO);
	}
}