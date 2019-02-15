package edu.sample.soap.business.service;

import edu.sample.soap.vo.ConsumerLoanVO;

/**
 * @author rmathew
 *
 */
public interface ConsumerLoanBusinessService {
	
	boolean processConsumerLoan(final ConsumerLoanVO consumerLoan);

}
