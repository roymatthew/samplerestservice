package edu.activemq.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerLoanRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		log.info("Starting the ConsumerLoanRoute");
		from("{{consumerLoanRoute}}")
		.log("Read consumer loan info. ${body}")
		.end();

	}

}
