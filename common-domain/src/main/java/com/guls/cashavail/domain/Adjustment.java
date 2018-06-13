package com.guls.cashavail.domain;

import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * Domain Object for Adjustment Service
 * 
 * @author guls
 *
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Adjustment {

	private Long adjustmentId;

	private BigInteger adjustedAmount;

	private Fund fund;

	/**
	 * For simplicity Date is a String
	 */
	private String effectiveDate;

	/**
	 * NEWADJ - New Adjustment<br/>
	 * OBADJ - Opening Balance Adjustment
	 * 
	 */
	private String adjustmentType;

	/**
	 * AGGR - Aggregational Adjustment<br/>
	 * TRX - Transactional Adjustment
	 */
	private String adjustmentLevel;

	private String adjustmentStatus;

	/**
	 * List of Varainces Associated to this Adjumtmnet
	 */
	private List<Variance> variances;

	public Adjustment(Long adjustmentId, BigInteger adjustedAmount, Fund fund, String effectiveDate,
			String adjustmentType, String adjustmentLevel, String adjustmentStatus) {
		super();
		this.adjustmentId = adjustmentId;
		this.adjustedAmount = adjustedAmount;
		this.fund = fund;
		this.effectiveDate = effectiveDate;
		this.adjustmentType = adjustmentType;
		this.adjustmentLevel = adjustmentLevel;
		this.adjustmentStatus = adjustmentStatus;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setVariances(List<Variance> variances) {
		this.variances = variances;
	}

	public Long getAdjustmentId() {
		return adjustmentId;
	}

}
