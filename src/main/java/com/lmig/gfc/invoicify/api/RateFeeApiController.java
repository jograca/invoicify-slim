package com.lmig.gfc.invoicify.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.invoicify.models.RateBasedBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/ratefees")
public class RateFeeApiController {

	private BillingRecordRepository billingRepo;
	private CompanyRepository companyRepository;

	public RateFeeApiController(BillingRecordRepository billingRepo, CompanyRepository companyRepository) {
		this.billingRepo = billingRepo;
		this.companyRepository = companyRepository;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord record, Authentication auth) {
		User user = (User) auth.getPrincipal();
		record.setCreatedBy(user);
		record.setClient(companyRepository.findOne(record.getClient().getId()));
		return billingRepo.save(record);
	}

}
