package org.hocviencntt.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.hoccntt.dao.EmployeeDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
public class SalaryServiceTest {

	@Mock
	EmployeeDAO employeeDAO;

	@Mock
	TaxCalculator taxCalculator;

	@InjectMocks
	SalaryService salaryService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinimumSalary() {

		BigDecimal annualSalary = new BigDecimal(10000);
		when(employeeDAO.getAnnualSalary(111)).thenReturn(annualSalary);
		when(taxCalculator.calculateTaxes(annualSalary)).thenReturn(new BigDecimal(1000));
		BigDecimal actual = salaryService.getNetSalary(111);
		assertThat(actual.compareTo(new BigDecimal(10000)),is(0));

	}

}
