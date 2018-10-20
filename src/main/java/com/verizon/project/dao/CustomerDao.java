package com.verizon.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.project.models.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>{
	boolean existsByPhoneNo(String phoneNo);

	boolean existsByEmailId(String emailId);
	
	
	Customer findByPhoneNo(String phoneNo);
	Customer findByEmailId(String emailId);

	List<Customer> findAllByFirstName(String firstName);
	
	List<Customer> findAllByLastName(String lastName);

}
