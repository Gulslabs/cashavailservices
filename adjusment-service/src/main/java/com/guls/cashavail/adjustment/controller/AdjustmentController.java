package com.guls.cashavail.adjustment.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guls.cashavail.adjustment.fiegn.VarianceFiegnClient;
import com.guls.cashavail.clients.AdjustmentClient;
import com.guls.cashavail.domain.Adjustment;
import com.guls.cashavail.domain.Fund;
import com.guls.cashavail.domain.Variance;

@RestController
public class AdjustmentController implements AdjustmentClient {

	private static final Logger LOG = LoggerFactory.getLogger(AdjustmentController.class);
	List<Adjustment> adjustments;

	@Autowired
	private VarianceFiegnClient varainceFiegnClient;

	public AdjustmentController() {
		// new Fund("00010", "USD", new Long(152), new Long(10))
		adjustments = new ArrayList<Adjustment>();
		adjustments.add(new Adjustment(new Long("2001"), new BigInteger("1000"),
				new Fund("00010", "USD", new Long(152), new Long(10)), "15-Jun-2018", "NEWADJ", "AGGR", "ACCEPTED"));
		adjustments.add(new Adjustment(new Long("2001"), new BigInteger("1000"),
				new Fund("00010", "USD", new Long(152), new Long(10)), "15-Jun-2018", "OBADJ", "AGGR", "NOTACCEPTED"));
		adjustments.add(new Adjustment(new Long("2001"), new BigInteger("1000"),
				new Fund("00010", "USD", new Long(152), new Long(10)), "15-Jun-2018", "NEWADJ", "TRX", "ACCEPTED"));
		adjustments.add(new Adjustment(new Long("2001"), new BigInteger("1000"),
				new Fund("00010", "USD", new Long(152), new Long(10)), "15-Jun-2018", "OBADJ", "TRX", "NOTACCEPTED"));

	}

	@RequestMapping("/adjustment/{effectiveDate}")
	public List<Adjustment> getAdjustments(@PathVariable("effectiveDate") String effectiveDate) {
		// TODO: After configuring eureka; load varainces based on adjustment Id.

		LOG.debug(" All adjustment for effective Date {}", effectiveDate);
		List<Adjustment> results = adjustments.stream().filter(e -> e.getEffectiveDate().equals(effectiveDate))
				.collect(Collectors.toList());

//		List<Variance> varainces = varainceFiegnClient.getAllVariances(effectiveDate);
		for (Adjustment adjustment : results) {
			adjustment.setVariances(
					varainceFiegnClient.getVariancesByAdjustmentId(adjustment.getAdjustmentId().toString()));
		}
		return results;
	}

}
