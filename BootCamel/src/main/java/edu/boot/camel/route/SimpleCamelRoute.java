package edu.boot.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import edu.boot.camel.domain.Item;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SimpleCamelRoute extends RouteBuilder {

	@Autowired
	private Environment environment;

	@Override
	public void configure() throws Exception {

		log.info("Starting the camel route");

		BindyCsvDataFormat bindy = new BindyCsvDataFormat(Item.class);

		from("{{startRoute}}").log("Timer invoked and the body is " + environment.getProperty("message")).choice()
				.when(header("env").isNotEqualTo("mock")).pollEnrich("{{fromRoute}}").otherwise()
				.log("mock env flow and the body is ${body}").end().to("{{toRoute1}}").unmarshal(bindy)
				.log("The unmarshalled object is ${body}")
				.split(body())
				.log("Record is ${body}")
				.end();

		log.info("Ending the camel route");

	}

}
