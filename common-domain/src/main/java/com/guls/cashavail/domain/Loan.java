package com.guls.cashavail.domain;

import java.math.BigInteger;

public class Loan {

	private Long loanId;

	private Fund borrowerFund;

	private Fund lenderFund;

	private BigInteger loanAmount;

	private BigInteger accuredInterest;

	private String startDate;

	private String endDate;

	/**
	 * OPEN - Loan is open; so endDate will be null<br/>
	 * CLOSED - Lona is closed.
	 */
	private String loanStatus;

	/**
	 * IFL, ISL, Bank.
	 */
	private String loanType;

}
