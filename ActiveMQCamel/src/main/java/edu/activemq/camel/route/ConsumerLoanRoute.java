package edu.activemq.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerLoanRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
        onException(HttpOperationFailedException.class).log(LoggingLevel.ERROR,"RuntimeException in route ${body}")
        .maximumRedeliveries(5).redeliveryDelay(5000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.ERROR);

		log.info("Starting the ConsumerLoanRoute");
		from("{{consumerLoanRoute}}")
		.log("Read consumer loan info. ${body}")
		.log("Calling consumer loan rest service...")
        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
		.to("{{toRoute}}")
		.log("Consumer loan rest service response: ${body}")
		.end();

	}

}
