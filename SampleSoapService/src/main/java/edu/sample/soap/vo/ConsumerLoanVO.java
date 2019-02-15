package edu.sample.soap.vo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ConsumerLoanVO {	

	private String loanNumber;
	private String loanType;
	private BigDecimal loanAmount;
	private String ssn;
	private String creditScore;
	private String borrowerName;
	

}
