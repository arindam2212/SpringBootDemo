package com.gft.exam.customer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gft.exam.customer.model.CustomerDetail;

@Repository
public class CustomerDataRepository {

	/*
	 * Mock DataSource Response
	 */
	
	public List<CustomerDetail> findAllCustomer() {

		List<CustomerDetail> customerList = new ArrayList<>();
		customerList.add(new CustomerDetail("00021244", "BANCA SERFIN", "ACEVES GONZALEZ ADOLFO", "CLIENTE", "PREMIER",
				"LOMA BONITA 1839", "FISICA"));
		customerList.add(new CustomerDetail("00021245", "BANCA MOVIL", "ACEVES JUAREZ", "CLIENTE", "APP",
				"LOMAS DE SANTA FE", "FISICA"));
		customerList.add(new CustomerDetail("00021246", "BANCA CORPORTE", "GONZALEZ ADOLFO", "AGENT", "CORPOATIVO",
				"LOMA BONITA 109", "FISICA"));
		customerList.add(new CustomerDetail("00021247", "BANCA INTERNET", "ADOLFO DANIEL", "CLIENTE", "PREMIER",
				"CALLE MONTE ALBAN", "FISICA"));
		return customerList;
		
	}

}
