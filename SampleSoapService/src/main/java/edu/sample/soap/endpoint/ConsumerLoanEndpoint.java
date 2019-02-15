package edu.sample.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import edu.sample.soap.business.service.ConsumerLoanBusinessService;
import edu.sample.soap.jaxb.ConsumerLoan;
import edu.sample.soap.jaxb.PostConsumerLoanRequest;
import edu.sample.soap.jaxb.PostConsumerLoanResponse;
import edu.sample.soap.translator.ConsumerLoanTranslator;
import edu.sample.soap.vo.ConsumerLoanVO;

@Endpoint
public class ConsumerLoanEndpoint {

	@Autowired
	private ConsumerLoanBusinessService consumerLoanBusinessService;
	
	@Autowired
	private ConsumerLoanTranslator consumerLoanTranslator;

	@PayloadRoot(namespace = "http://www.soap.sample.edu/jaxb", localPart = "PostConsumerLoanRequest")
	@ResponsePayload
	public PostConsumerLoanResponse processConsumerLoanRequest(@RequestPayload PostConsumerLoanRequest request) {

		final ConsumerLoan consumerLoanJaxB = request.getConsumerLoan();
		final ConsumerLoanVO consumerLoanVO = consumerLoanTranslator.translateJaxBToVO(consumerLoanJaxB);
		final boolean serviceSuccess = consumerLoanBusinessService.processConsumerLoan(consumerLoanVO);
		PostConsumerLoanResponse response = new PostConsumerLoanResponse();
		response.setStatus("failed");
		if (serviceSuccess) {
			response.setStatus("success");
		}
		return response;
	}

}
