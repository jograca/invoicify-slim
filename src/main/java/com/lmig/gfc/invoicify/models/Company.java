package com.lmig.gfc.invoicify.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// This needs to be an entity
@Entity
@Table(name = "invoicify_company")
public class Company {

	// This needs an id
	@Id
	@GeneratedValue(generator = "company_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "company_id_seq", sequenceName = "company_id_seq")
	private Long id;

	// This needs a name
	@Column(nullable = false)
	private String name;

	// This needs a list of invoice objects named invoices as one-to-many
	// relationship mapped by "company"
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Invoice> invoices;

	// Lots of getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
}
