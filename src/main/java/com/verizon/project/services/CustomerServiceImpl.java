package com.verizon.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.project.dao.CustomerDao;
import com.verizon.project.models.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getByCustomerId(long customerId) {
		
		Customer customer=null;
		Optional<Customer> optCust = customerDao.findById(customerId);
		if(optCust.isPresent()) {
			customer=optCust.get();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		boolean isDeleted = false;
		if(customerDao.existsById(customerId)) {
			customerDao.deleteById(customerId);
			return true;
		}
		return false;
	}

	@Override
	public Customer findByPhoneNo(String phoneNo) {
		return customerDao.findByPhoneNo(phoneNo);
	}

	@Override
	public Customer findByEmailId(String emailId) {
		return customerDao.findByEmailId(emailId);
	}

	@Override
	public List<Customer> findAllByCustomerFirstName(String firstName) {
		return customerDao.findAllByFirstName(firstName);
	}

	@Override
	public List<Customer> findAllByCustomerLastName(String lastName) {
		return customerDao.findAllByLastName(lastName);
	}

	@Override
	public boolean existsByPhoneNo(String phoneNo) {
		return customerDao.existsByPhoneNo(phoneNo);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		return customerDao.existsByEmailId(emailId);
	}
	
	

}
