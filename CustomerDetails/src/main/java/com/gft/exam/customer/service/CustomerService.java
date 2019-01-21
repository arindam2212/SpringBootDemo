package com.gft.exam.customer.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.exam.customer.model.CustomerDetail;
import com.gft.exam.customer.repository.CustomerDataRepository;

@Service
public class CustomerService {
	
	@Autowired
    private CustomerDataRepository dataRepository;
	
	public CustomerDetail getCustomerDetailbyCustomerId(String queryParam) {
		
		List<CustomerDetail> customerList = dataRepository.findAllCustomer();
        return customerList.stream()
        		.filter(customer -> queryParam.equals(customer.getCustomerId()))
        		.findAny()
        		.orElse(null);
	}

	public List<CustomerDetail> getAllCustomerDetail() {
		return dataRepository.findAllCustomer();
	}
	
	

}
