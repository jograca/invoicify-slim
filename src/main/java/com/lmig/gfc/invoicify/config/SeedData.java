package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.Invoice;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;
import com.lmig.gfc.invoicify.services.FlatFeeBillingRecordRepository;
import com.lmig.gfc.invoicify.services.InvoiceRepository;
import com.lmig.gfc.invoicify.services.RateBasedBillingRecordRepository;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepository, //
			PasswordEncoder encoder, //
			CompanyRepository companyRepo, //
			BillingRecordRepository billingRepo, //
			FlatFeeBillingRecordRepository flatFeeBillingRepo, //
			InvoiceRepository invoiceRepo, //
			RateBasedBillingRecordRepository rateBasedRepo) {

		String encodedPassword = encoder.encode("password");
		User user = new User();
		user.setUsername("admin");
		user.setPassword(encodedPassword);
		user.addRole("ADMIN");
		userRepository.save(user);

		encodedPassword = encoder.encode("password");
		user = new User();
		user.setUsername("clerk");
		user.setPassword(encodedPassword);
		user.addRole("CLERK");
		userRepository.save(user);

		encodedPassword = encoder.encode("password");
		user = new User();
		user.setUsername("accountant");
		user.setPassword(encodedPassword);
		user.addRole("ACCOUNTANT");
		userRepository.save(user);

		// Company Seed Data

		Company company = new Company();
		company.setName("Seed Data Company");
		companyRepo.save(company);

		Company company1 = new Company();
		company1.setName("Seed Data Other Company");
		companyRepo.save(company1);

		// Invoice Seed Data
		Invoice invoice = new Invoice();
		invoice.setCompany(company1);
		invoice.setCreatedBy(user);
		invoice.setInvoiceNumber("12A");
		invoiceRepo.save(invoice);

		// Flat Fee Billing Record Seed Data

		// FlatFeeBillingRecord ffbr = new FlatFeeBillingRecord();
		// ffbr.setAmount(45.0);
		// ffbr.setClient(company);
		// ffbr.setDescription("Flat Fee Bill for Goods");
		// ffbr.setCreatedBy(user);
		// flatFeeBillingRepo.save(ffbr);

		// Rate Based Billing Seed Data
	}

}
