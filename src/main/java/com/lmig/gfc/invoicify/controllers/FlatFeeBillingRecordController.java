package com.lmig.gfc.invoicify.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/billing-records/flat-fees")
public class FlatFeeBillingRecordController {

	private BillingRecordRepository flatFeeBillingRepo;
	private CompanyRepository companyRepo;

	public FlatFeeBillingRecordController(BillingRecordRepository flatFeeBillingRepo, CompanyRepository companyRepo) {
		this.flatFeeBillingRepo = flatFeeBillingRepo;
		this.companyRepo = companyRepo;
	}

	@PostMapping("")
	public ModelAndView create(FlatFeeBillingRecord record, long clientId, Authentication auth) {

		// Get the user from the auth.getPrincipal() method
		User user = (User) auth.getPrincipal();

		// Find the client using the client id
		Company client;
		client = companyRepo.findById(clientId);

		// Set the client on the record
		record.setClient(client);

		// Set the user on the record for the created by property
		record.setCreatedBy(user);

		// Save the record
		flatFeeBillingRepo.save(record);

		return new ModelAndView("redirect:/billing-records");
	}

}
