package com.lmig.gfc.invoicify.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;

@RestController
@RequestMapping("/api/ratefees")
public class RateFeeApiController {

	private BillingRecordRepository billingRepo;

	public RateFeeApiController(BillingRecordRepository billingRepo) {
		this.billingRepo = billingRepo;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord rbbr) {
		return billingRepo.save(rbbr);
	}

}
