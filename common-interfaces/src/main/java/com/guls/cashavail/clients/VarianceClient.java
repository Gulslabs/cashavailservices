package com.guls.cashavail.clients;

import java.util.List;

import com.guls.cashavail.domain.Variance;

public interface VarianceClient {

	public List<Variance> getAllVariances(String effectiveDate);

	public List<Variance> getVariancesByAdjustmentId(String adjustmentId);

}
