package com.guls.cashavail.domain;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain Object for Varaince Service.
 * 
 * @author guls
 *
 */
// http://www.baeldung.com/jackson-jsonmappingexception. No serializer found for
// class
// getter Setter.
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Variance {

	private Long varianceId;

	private String effectiveDate;

	private String varianceStatus;

	/**
	 * This is not best pattern. We should avoid cross-coupling of attributes in
	 * individual micro-services.<br/>
	 * TODO Remove this attribute ; when we enhance this exmple with JPA.
	 */
	private long adjustmentId;

	/**
	 * AGGR - Variance At aggregation level<br/>
	 * TRX - Variance At transactional level
	 */
	private String varianceLevel;

	private Fund fund;

	private BigInteger varainceAmount;

	/**
	 * Overcome JsonMappingException: No suitable constructor found for type. Refer:
	 * https://stackoverflow.com/questions/7625783/jsonmappingexception-no-suitable-constructor-found-for-type-simple-type-class
	 * Other approach would be to Use JsonProperty
	 */
	public Variance() {
	}

	public Variance(@JsonProperty("varianceId") Long varianceId, @JsonProperty("effectiveDate") String effectiveDate,
			@JsonProperty("varianceStatus") String varianceStatus, @JsonProperty("adjustmentId") long adjustmentId,
			@JsonProperty("varianceLevel") String varianceLevel, @JsonProperty("fund") Fund fund,
			@JsonProperty("varainceAmount") BigInteger varainceAmount) {
		super();
		this.varianceId = varianceId;
		this.effectiveDate = effectiveDate;
		this.varianceStatus = varianceStatus;
		this.adjustmentId = adjustmentId;
		this.varianceLevel = varianceLevel;
		this.fund = fund;
		this.varainceAmount = varainceAmount;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public long getAdjustmentId() {
		return adjustmentId;
	}

}
