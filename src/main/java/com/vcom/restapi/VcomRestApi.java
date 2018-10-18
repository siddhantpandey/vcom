package com.vcom.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcom.model.Customer;
import com.vcom.services.CustomerService;
import com.vcom.services.ServicesBoughtService;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class VcomRestApi {

	@Autowired
	CustomerService custService;
	
	//@Autowired
	//ServicesBoughtService sbService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(custService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId) {
		ResponseEntity<Customer> resp;
		Customer c = custService.getCustomerByCustomerId(customerId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}
	
	
	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<Customer>> getAllCustomers(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue) {

		ResponseEntity<List<Customer>> resp;

		switch (fieldBy) {
		case "mobileNumber":
			Customer cByMobNum = custService.findByCustomerMobileNumber(searchValue);
			if (cByMobNum != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByMobNum), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "emailId":
			Customer cByEmail = custService.findByEmailId(searchValue);
			if (cByEmail != null) {
				resp = new ResponseEntity<>(Collections.singletonList(cByEmail), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		case "lastName":
			List<Customer> results = custService.findAllByLastName(searchValue);
			if (results != null && results.size() != 0) {
				resp = new ResponseEntity<>(results, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			break;
		default:
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			break;
		}

		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> resp = null;

		if (custService.existsByEmailId(customer.getEmailId())) {
			resp = new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
		}

		if (custService.existsByCustomerMobileNumber(customer.getCustomerMobileNumber())) {
			resp = new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
		}

		if (resp == null) {
			Customer c = custService.addCustomer(customer);
			if (c == null)
				resp = new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> resp = null;

		Customer c = custService.getCustomerByCustomerId(customer.getCustomerId());
		if (!customer.getEmailId().equals(c.getEmailId())) {
			if (custService.existsByEmailId(customer.getEmailId())) {
				resp = new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
			}
		}

		if (!customer.getCustomerMobileNumber().equals(c.getCustomerMobileNumber())) {
			if (custService.existsByCustomerMobileNumber(customer.getCustomerMobileNumber())) {
				resp = new ResponseEntity<Customer>(HttpStatus.ALREADY_REPORTED);
			}
		}

		if (resp == null) {
			c = custService.updateCustomer(customer);
			if (c == null)
				resp = new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") long customerId) {
		ResponseEntity<Void> resp = null;

		if (custService.deleteCustomer(customerId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
	
}
