package com.lmig.gfc.invoicify.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;

@RestController
@RequestMapping("/api/flatfees")
public class FlatFeeApiController {

	private BillingRecordRepository billingRepo;

	public FlatFeeApiController(BillingRecordRepository billingRepo) {
		this.billingRepo = billingRepo;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord fbbr) {
		return billingRepo.save(fbbr);
	}
}
