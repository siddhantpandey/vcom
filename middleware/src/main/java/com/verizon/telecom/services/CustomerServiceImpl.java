package com.verizon.telecom.services;

import java.util.List;	
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.telecom.dao.CustomerDao;
import com.verizon.telecom.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer getCustomerByCustomerId(long customerId) {
		Customer customer = null;
		
		Optional<Customer> optCust = customerDao.findById(customerId);
		if(optCust.isPresent()) {
			customer = optCust.get();
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
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public boolean existsByCustomerMobileNumber(String customerMobileNumber) {
		return customerDao.existsByCustomerMobileNumber(customerMobileNumber);
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		return customerDao.existsByEmailId(emailId);
	}

	@Override
	public Customer findByCustomerMobileNumber(String mobileNumber) {
		return customerDao.findByCustomerMobileNumber(mobileNumber);
	}

	@Override
	public Customer findByEmailId(String emailId) {
		return customerDao.findByEmailId(emailId);
	}

	@Override
	public List<Customer> findAllByLastName(String lastName) {
		return customerDao.findAllByCustomerLastName(lastName);
	}
}
