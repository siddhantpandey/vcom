package com.vcom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcom.dao.CustomerDao;
import com.vcom.model.Customer;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsByCustomerMobileNumber(String customerMobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findByCustomerMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}
