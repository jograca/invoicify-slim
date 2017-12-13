package com.lmig.gfc.invoicify.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.CompanyRepository;

public class AdminCompaniesControllerTests {

	private AdminCompaniesController controller;

	@Mock
	private CompanyRepository companyRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new AdminCompaniesController(companyRepo);
	}

	@Test
	public void create_company_saves_a_company() {
		// Arrange
		Company company = new Company();
		when(companyRepo.save(company)).thenReturn(company);

		// Act
		ModelAndView actual = controller.createCompany(company);

		// Assert
		assertThat(actual.getView()).isSameAs(company);
		verify(companyRepo).save(company);

	}

}
