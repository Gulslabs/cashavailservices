package com.guls.cashavail.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Fund {

	private String fundNbr;

	private String currencyCode;

	private Long currencySid;

	private Long fundSid;

	public Fund() {
	}

	public Fund(@JsonProperty("fundNbr") String fundNbr, @JsonProperty("currencyCode") String currencyCode,
			@JsonProperty("currencySid") Long currencySid, @JsonProperty("fundSid") Long fundSid) {
		super();
		this.fundNbr = fundNbr;
		this.currencyCode = currencyCode;
		this.currencySid = currencySid;
		this.fundSid = fundSid;
	}

}
