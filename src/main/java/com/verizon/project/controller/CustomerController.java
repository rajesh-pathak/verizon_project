package com.verizon.project.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.project.models.Customer;
import com.verizon.project.services.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomersById(){
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId){
		ResponseEntity<Customer> resp;
		Customer cust=customerService.getByCustomerId(customerId);
		if(cust==null) {
			resp= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			resp = new ResponseEntity<>(cust, HttpStatus.OK);
		}
		return resp;
	}
	
	@GetMapping("/{field}/{searchVal}")
	public ResponseEntity<List<Customer>> getAllCustomers(@PathVariable("field") String field,
			@PathVariable("searchVal") String searchVal)
	{
		ResponseEntity<List<Customer>> resp;
		
		switch(field) {
		case "phoneNo":
			Customer custByPhone=customerService.findByPhoneNo(searchVal);
			if(custByPhone != null)
			{
				resp = new ResponseEntity<>(Collections.singletonList(custByPhone),HttpStatus.OK);
			}
			else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
			
		case "emailId":
			Customer custByEmail = customerService.findByEmailId(searchVal);
			if(custByEmail != null)
			{
				resp = new ResponseEntity<>(Collections.singletonList(custByEmail),HttpStatus.OK);
			}
			else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
			
		case "firstName":
			List<Customer> custByFirstName = customerService.findAllByCustomerFirstName(searchVal);
			if(custByFirstName != null && custByFirstName.size()!=0)
			{
				resp = new ResponseEntity<>(custByFirstName,HttpStatus.OK);
			}
			else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		
		case "lastName":
			List<Customer> custByLastName = customerService.findAllByCustomerLastName(searchVal);
			if(custByLastName != null && custByLastName.size()!=0)
			{
				resp = new ResponseEntity<>(custByLastName,HttpStatus.OK);
			}
			else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		default:
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			break;
		}
		
		return resp;
	}
}
