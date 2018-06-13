package com.guls.cashavail.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Feed {

	private long feedId;

	/**
	 * INBOUND, OUTBOUND
	 */
	private String feedType;

	/**
	 * FILE - Inbound/OutBound is a file <br/>
	 * MESSAGE - Inbound/OutBound is a JMS Message<br/>
	 * FILE-SERVICE -Inbound/OutBound is a file through HTTP REST API<br/>
	 * MESSAGE-SERVICE - Inbound/OutBound is through HTTP REST API
	 */
	private String feedStyle;

	/**
	 * FAILED, PROCESSED, IN-PROCESS.
	 */
	private String feedStatus;

	private String feedRecievedTime;

	/**
	 * Null if the feedStatus is IN-PROGRESS.
	 */
	private String feedProcessedTime;

}
