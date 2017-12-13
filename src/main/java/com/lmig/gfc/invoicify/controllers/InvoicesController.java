package com.lmig.gfc.invoicify.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.Invoice;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;
import com.lmig.gfc.invoicify.services.InvoiceRepository;

@Controller
@RequestMapping("/invoices")
public class InvoicesController {

	private InvoiceRepository invoiceRepo;
	private CompanyRepository companyRepo;
	private BillingRecordRepository billingRecordRepo;

	public InvoicesController(InvoiceRepository invoiceRepo, CompanyRepository companyRepo,
			BillingRecordRepository billingRecordRepo) {
		this.invoiceRepo = invoiceRepo;
		this.companyRepo = companyRepo;
		this.billingRecordRepo = billingRecordRepo;
	}

	@GetMapping("")
	public ModelAndView showInvoices() {
		ModelAndView mv = new ModelAndView("invoices/list");

		// Get all the invoices and add them to the model and view with the key
		// "invoices"
		mv.addObject("invoices", invoiceRepo.findAll());

		// Add a key to the model and view named "showTable" which should be true if
		// there's more than one invoice and false if there are zero invoices
		mv.addObject("showTable", (invoiceRepo.findAll().size() > 0));

		return mv;
	}

	@GetMapping("/clients")
	public ModelAndView chooseClient() {
		ModelAndView mv = new ModelAndView("invoices/clients");

		// Get all the clients and add them to the model and view with the key "clients"
		mv.addObject("clients", companyRepo.findAll());

		return mv;
	}

	@GetMapping("/clients/{clientId}")
	public ModelAndView createInvoice(@PathVariable Long clientId) {
		ModelAndView mv = new ModelAndView("invoices/billing-records-list");

		// Get all the billing records for the specified client that have no associated
		// invoice line item and add them with the key "records"

		// Add the client id to the model and view with the key "clientId"

		return mv;
	}

	@PostMapping("/clients/{clientId}")
	public String createInvoice(Invoice invoice, @PathVariable Long clientId, long[] recordIds, Authentication auth) {
		// Get the user from the auth.getPrincipal() method
		// Find all billing records in the recordIds array

		// Create a new list that can hold invoice line items
		// For each billing record in the records found from recordIds
		// Create a new invoice line item
		// Set the billing record on the invoice line item
		// Set the created by to the user
		// Set the invoice on the invoice line item
		// Add the invoice line item to the list of invoice line items

		// Set the list of line items on the invoice
		// Set the created by on the invoice to the user
		// Set the client on the invoice to the company identified by clientId
		// Save the invoice to the database

		return "redirect:/invoices";
	}

}
