package edu.boot.camel.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("mock")
@RunWith(CamelSpringBootRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class SimpleCamelRouteMockTest {
	
	@Autowired
	private CamelContext context;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ProducerTemplate producerTemplate;
	
	@Autowired
	protected CamelContext createCamelContext()
	{
		return context;
	}
	
	@Test
	public void testMoveFileMock()
	{
		String message = "type,sku#,itemdescription,price\r\n" + 
				"ADD,100,Samsung TV,500\r\n" + 
				"ADD,101,LG TV,500";
		MockEndpoint mockEndpoint = new MockEndpoint(environment.getProperty("toRoute1"));
		mockEndpoint.expectedMessageCount(1);
		mockEndpoint.expectedBodiesReceived(message);
		
		producerTemplate.sendBodyAndHeader(environment.getProperty("startRoute"), message, "env", environment.getProperty("spring.profiles.active"));
		
		//assertMockEndpointsSatisfied();
	}

}
