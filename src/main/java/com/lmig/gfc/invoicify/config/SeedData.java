package com.lmig.gfc.invoicify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.Invoice;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;
import com.lmig.gfc.invoicify.services.InvoiceRepository;
import com.lmig.gfc.invoicify.services.UserRepository;

@Configuration
public class SeedData {

	public SeedData(UserRepository userRepository, //
			PasswordEncoder encoder, //
			CompanyRepository companyRepo, //
			BillingRecordRepository billingRepo, //
			InvoiceRepository invoiceRepo) {

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

		Company company2 = new Company();
		company2.setName("Seed Data Yet Another Company");
		companyRepo.save(company2);

		// Invoice Seed Data
		Invoice invoice = new Invoice();
		invoice.setCompany(company1);
		invoice.setCreatedBy(user);
		invoice.setInvoiceNumber("12A");
		invoiceRepo.save(invoice);

		Invoice invoice2 = new Invoice();
		invoice2.setCompany(company1);
		invoice2.setCreatedBy(user);
		invoice2.setInvoiceNumber("12B");
		invoiceRepo.save(invoice2);

		Invoice invoice3 = new Invoice();
		invoice3.setCompany(company1);
		invoice3.setCreatedBy(user);
		invoice3.setInvoiceNumber("12C");
		invoiceRepo.save(invoice3);

		// Billing Record Seed Data
		FlatFeeBillingRecord ffbr = new FlatFeeBillingRecord();
		ffbr.setAmount(450.0);
		ffbr.setClient(company2);
		ffbr.setCreatedBy(user);
		ffbr.setDescription("Flat Fee Billing Record");
		ffbr.setLineItem(null);
		billingRepo.save(ffbr);
	}

}
