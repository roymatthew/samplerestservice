package edu.activemq.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import edu.activemq.camel.exception.InvalidItemException;
import edu.activemq.camel.processor.BuildSQLProcesser;
import edu.boot.camel.domain.Item;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ActiveMQCamelRoute extends RouteBuilder {

	@Autowired
	private Environment environment;
	@Autowired
	private BuildSQLProcesser sqlProcessor;

	@Override
	public void configure() throws Exception {

		log.info("Starting the camel activemq route");
		
		GsonDataFormat itemFormat = new GsonDataFormat(Item.class);
		
		onException(InvalidItemException.class).log(LoggingLevel.ERROR, "Invalid Item ${body}");
		
		from ("{{fromRoute}}")
		.log("Read message from ActiveMQ ${body}")
		.unmarshal(itemFormat)
		.log("unmarshalled message is: ${body}")
		.process(sqlProcessor)
		.to("{{toRoute}}");

		//BindyCsvDataFormat bindy = new BindyCsvDataFormat(Item.class);

/*		from("{{startRoute}}").log("Timer invoked and the body is " + environment.getProperty("message")).choice()
				.when(header("env").isNotEqualTo("mock")).pollEnrich("{{fromRoute}}").otherwise()
				.log("mock env flow and the body is ${body}").end().to("{{toRoute1}}").unmarshal(bindy)
				.log("The unmarshalled object is ${body}").split(body()).log("Record is ${body}").end();*/

		log.info("Ending the camel activemq route");

	}

}
