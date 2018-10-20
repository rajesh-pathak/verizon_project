package com.verizon.project.services;

import java.util.List;

import com.verizon.project.models.Customer;

public interface CustomerService {
	
	Customer getByCustomerId(long customerId);
	List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	boolean deleteCustomer(long customerId);
	
	boolean existsByPhoneNo(String phoneNo);

	boolean existsByEmailId(String emailId);
	
	Customer findByPhoneNo(String phoneNo);
	Customer findByEmailId(String emailId);

	List<Customer> findAllByCustomerFirstName(String firstName);
	
	List<Customer> findAllByCustomerLastName(String lastName);


}
