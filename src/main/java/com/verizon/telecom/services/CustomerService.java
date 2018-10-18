package com.verizon.telecom.services;

import java.util.List;	

import com.verizon.telecom.model.Customer;

public interface CustomerService {
	
	Customer getCustomerByCustomerId(long customerId);
	List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	boolean deleteCustomer(long customerId);
	
	boolean existsByCustomerMobileNumber(String customerMobileNumber);

	boolean existsByEmailId(String emailId);

	Customer findByCustomerMobileNumber(String mobileNumber);

	Customer findByEmailId(String emailId);

	List<Customer> findAllByLastName(String lastName);
	

}
