package com.guls.cashavail.variance.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guls.cashavail.clients.VarianceClient;
import com.guls.cashavail.domain.Fund;
import com.guls.cashavail.domain.Variance;

@RestController
public class VarianceController implements VarianceClient {

	/**
	 * TODO: Add error Handling via @ControllerAdvice
	 * http://www.baeldung.com/exception-handling-for-rest-with-spring
	 */

	private static final Logger LOG = LoggerFactory.getLogger(VarianceController.class);

	private List<Variance> variances;

	public VarianceController() {
		variances = new ArrayList<>();
		variances.add(new Variance(new Long(1001), "15-Jun-2018", "VAR", new Long(2001), "AGGR",
				new Fund("00010", "USD", new Long(152), new Long(10)), new BigInteger("1000")));
		variances.add(new Variance(new Long(1003), "15-Jun-2018", "RESOLVED", new Long(2001), "AGGR",
				new Fund("00010", "USD", new Long(152), new Long(10)), new BigInteger("2000")));

		variances.add(new Variance(new Long(1001), "15-Jun-2018", "VAR", new Long(2001), "TRX",
				new Fund("00010", "USD", new Long(152), new Long(10)), new BigInteger("100")));

		variances.add(new Variance(new Long(1002), "15-Jun-2018", "RESOLVED", new Long(2001), "TRX",
				new Fund("00010", "USD", new Long(152), new Long(10)), new BigInteger("1000")));

	}

	@Override
	@RequestMapping("/variance/{effectiveDate}")
	public List<Variance> getAllVariances(@PathVariable("effectiveDate") String effectiveDate) {
		LOG.debug(" All variances for effective Date {}", effectiveDate);
		return variances.stream().filter(e -> e.getEffectiveDate().equals(effectiveDate)).collect(Collectors.toList());
	}

	@Override
	@RequestMapping("/variance/adjustment/{adjustmentId}")
	public List<Variance> getVariancesByAdjustmentId(@PathVariable("adjustmentId") String adjustmentId) {
		LOG.debug("All variances for Adjustment Id {}", adjustmentId);
		return variances.stream().filter(e -> e.getAdjustmentId() == Long.valueOf(adjustmentId))
				.collect(Collectors.toList());
	}

}
