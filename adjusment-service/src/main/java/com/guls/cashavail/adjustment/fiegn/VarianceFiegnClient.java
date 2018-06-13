package com.guls.cashavail.adjustment.fiegn;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guls.cashavail.clients.VarianceClient;
import com.guls.cashavail.domain.Variance;

@FeignClient(value = "variance-service")
public interface VarianceFiegnClient extends VarianceClient {

	@RequestMapping("/variance/{effectiveDate}")
	public List<Variance> getAllVariances(@PathVariable("effectiveDate") String effectiveDate);

	@RequestMapping("/variance/adjustment/{adjustmentId}")
	public List<Variance> getVariancesByAdjustmentId(@PathVariable("adjustmentId") String adjustmentId);
}
