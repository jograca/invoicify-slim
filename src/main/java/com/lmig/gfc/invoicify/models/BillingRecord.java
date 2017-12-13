package com.lmig.gfc.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// This needs to be an entity
@Entity
@Table(name = "invoicify_billing_record")
public abstract class BillingRecord {

	// This needs an id
	@Id
	@GeneratedValue(generator = "billing_record_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "billing_record_id_seq", sequenceName = "billing_record_id_seq")
	private Long id;

	// This needs a user named createdBy
	@Column
	private User createdBy;

	// This needs a string named description
	@Column
	private String description;

	// This needs an invoice line item named lineItem. It should be a one-to-one
	// relationship mapped by billingRecord
	@OneToOne(mappedBy = "billingRecord")
	private InvoiceLineItem lineItem;

	// This needs a company named client that is a many-to-one relationship
	@ManyToOne
	private Company client;

	public BillingRecord() {

	}

	// This needs an abstract method that returns a double named getTotal()
	public abstract double getTotal();

	// All the getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
	}

	public InvoiceLineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(InvoiceLineItem lineItem) {
		this.lineItem = lineItem;
	}

}
