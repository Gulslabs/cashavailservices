package com.guls.cashavail.clients;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.guls.cashavail.domain.Adjustment;

public interface AdjustmentClient {

	List<Adjustment> getAdjustments(String effectiveDate);

}
