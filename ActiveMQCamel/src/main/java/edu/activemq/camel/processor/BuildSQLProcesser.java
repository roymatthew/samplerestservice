package edu.activemq.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import edu.activemq.camel.exception.InvalidItemException;
import edu.boot.camel.domain.Item;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BuildSQLProcesser implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String tableName = "Item";

		Item item = (Item) exchange.getIn().getBody();
		StringBuilder query = new StringBuilder();
		
		if (ObjectUtils.isEmpty(item.getSku()))
		{
			throw new InvalidItemException("Item SKU is null or empty");
		}

		if ("ADD".equals(item.getTransactionType())) {
			
			query.append("Insert into " + tableName  + "(ID, Description, Price) Values(");
			query.append(item.getSku() + ",'" + item.getItemDescription() + "'," + item.getPrice() + ")");

		}
		log.info("Final query is : " + query);
		exchange.getIn().setBody(query.toString());
		exchange.getIn().setHeader("sku", item.getSku());

	}

}