package com.gft.exam.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gft.exam.customer.exception.ResourceNotFoundException;
import com.gft.exam.customer.model.CustomerDetail;
import com.gft.exam.customer.service.CustomerService;

@RestController
public class CustomerDetailController {

	@Autowired
	CustomerService customerService;

	/*
	 * This API look up information about customers
	 * 
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/customers")
	public String getCustomerDetails(@RequestHeader(value = "x-santander-global-id", required = true) String globalId,
											 @RequestHeader(value = "authorization", required = true) String authorization,
											 @RequestHeader(value = "x-ibm-client-id", required = true) String clientId,
											 @RequestHeader(value = "content-type", required = true) String contentType,
											 @RequestHeader(value = "accept-language", required = true) String acceptlanguage,
											 @RequestHeader(value = "accept", required = true)String accept,
											 @RequestParam(value = "customer_id", required = false) String customerId,
											 @RequestParam(value = "document_number", required = false) String documentNumber,
											 @RequestParam(value = "company_name", required = false) String companyName,
											 @RequestParam(value = "account_number", required = false) String accountNumber,
											 @RequestParam(value = "name", required = false) String name,
											 @RequestParam(value = "paternal_name", required = false) String paternalName,
											 @RequestParam(value = "maternal_name", required = false) String maternalName
											) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String response = null;
		
		if( customerId == null && documentNumber == null && companyName == null && 
				accountNumber == null && name == null && paternalName == null && maternalName == null  ){
			List<CustomerDetail> customerDetailList =  customerService.getAllCustomerDetail();
			response = mapper.writeValueAsString(customerDetailList);
		}
		else if(customerId != null){
			CustomerDetail customerDetail =  customerService.getCustomerDetailbyCustomerId(customerId);
			if(customerDetail == null) throw new ResourceNotFoundException("customer not found.");
			response = mapper.writeValueAsString(customerDetail);
		}
		
		return response;
		
	}

}
