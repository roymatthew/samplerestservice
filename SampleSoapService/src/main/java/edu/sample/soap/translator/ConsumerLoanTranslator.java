package edu.sample.soap.translator;

import org.springframework.stereotype.Component;

import edu.sample.soap.jaxb.ConsumerLoan;
import edu.sample.soap.vo.ConsumerLoanVO;

@Component
public class ConsumerLoanTranslator {
	
	public ConsumerLoanVO translateJaxBToVO(final ConsumerLoan consumerLoanJaxB)
	{
		final ConsumerLoanVO vo = new ConsumerLoanVO();
		vo.setBorrowerName(consumerLoanJaxB.getBorrowerName());
		vo.setCreditScore(consumerLoanJaxB.getCreditScore());
		vo.setLoanAmount(consumerLoanJaxB.getLoanAmount());
		vo.setLoanNumber(consumerLoanJaxB.getLoanNumber());
		vo.setLoanType(consumerLoanJaxB.getLoanType());
		vo.setSsn(consumerLoanJaxB.getSsn());
		return vo;
	}

}
