package com.guls.cashavail.clients;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guls.cashavail.domain.Loan;

public interface LoanClient {

	@RequestMapping("/loan")
	List<Loan> getLoans(@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate);
}
