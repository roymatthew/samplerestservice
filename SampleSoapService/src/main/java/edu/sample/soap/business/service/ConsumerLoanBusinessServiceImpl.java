package edu.sample.soap.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sample.soap.queue.producer.JmsProducer;
import edu.sample.soap.vo.ConsumerLoanVO;

/**
 * @author rmathew
 *
 */
@Service
public class ConsumerLoanBusinessServiceImpl implements ConsumerLoanBusinessService {
	
	@Autowired
	private JmsProducer jmsProducer;

	@Override
	public boolean processConsumerLoan(final ConsumerLoanVO consumerLoan) {
		
		//do the business logic (if any) here
		jmsProducer.send(consumerLoan);
		return true;
	}

}
