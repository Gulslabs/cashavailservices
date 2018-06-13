package com.guls.cashavail.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Stats {

	private String currentTime;

	private int blotterVarianceFundCount;

	private int projectedVarianceFundCount;

	private int acceptedFundCount;

	private int releaseFundCount;

	private int fiCashReleaseFundCount;

}
