package edu.boot.camel.domain;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Item {


	private String transactionType;
	
	private String sku;
	
	private String itemDescription;
	
	private BigDecimal price;
}
