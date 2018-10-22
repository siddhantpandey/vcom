package com.verizon.telecom.restapi;

import java.util.Collections	;
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

import com.verizon.telecom.model.Bill;
import com.verizon.telecom.model.Customer;
import com.verizon.telecom.model.ServicesBought;
import com.verizon.telecom.services.BillService;
import com.verizon.telecom.services.CustomerService;
import com.verizon.telecom.services.ServicesBoughtService;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class VcomRestApi {

	@Autowired
	CustomerService custService;
	
	@Autowired
	ServicesBoughtService sbService;
	
	@Autowired
	BillService bService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(custService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/services")
	public ResponseEntity<List<ServicesBought>> getAllServices() {
		return new ResponseEntity<>(sbService.getAllServices(), HttpStatus.OK);
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
	//Post for entering customer details
	@PostMapping("/register")
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

	//post mapping for entering service
	@PostMapping("/services")
	public ResponseEntity<ServicesBought> addService(@RequestBody ServicesBought service ) {
		ResponseEntity<ServicesBought> resp = null;

		if (sbService.existsByServiceId(service.getServiceId())) {
			resp = new ResponseEntity<ServicesBought>(HttpStatus.ALREADY_REPORTED);
		}

		if (resp == null) {
			//service.setServiceId(serviceId);
			ServicesBought sb = sbService.addServicesBought(service);
			if (sb == null)
				resp = new ResponseEntity<ServicesBought>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<ServicesBought>(sb, HttpStatus.OK);
		}
		return resp;
	}
	//mapping to update customer
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
	
	//mapping to update service bought
	@PutMapping("/services")
	public ResponseEntity<ServicesBought> updateService(@RequestBody ServicesBought service) {
		ResponseEntity<ServicesBought> resp = null;

		ServicesBought sb = sbService.getServicesBoughtById(service.getServiceId());
				
		if (service.getServiceId()!=sb.getServiceId()) {
			if (sbService.existsByServiceId(service.getServiceId())) {
				resp = new ResponseEntity<ServicesBought>(HttpStatus.ALREADY_REPORTED);
			}
		}

		

		if (resp == null) {
			sb = sbService.updateServicesBought(service);
			if (sb == null)
				resp = new ResponseEntity<ServicesBought>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<ServicesBought>(sb, HttpStatus.OK);
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
	
	@DeleteMapping("/services/{id}")
	public ResponseEntity<Void> deleteService(@PathVariable("id") long serviceId) {
		ResponseEntity<Void> resp = null;

		if (sbService.deleteServicesBought(serviceId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
	
	
	
	//Get Mapping for bills per service
		@GetMapping("/getbillsForService/{cid}/{sid}")
		public ResponseEntity<List<Bill>> fetchBillForParticularService(@PathVariable("cid") long customerId, @PathVariable("sid") long serviceId){
			return new ResponseEntity<>(bService.getBillsOfParticularService(customerId, serviceId), HttpStatus.OK);
		}
		
		@GetMapping("/getAllbills/{id}")
		public ResponseEntity<List<Bill>> fetchAllBills(@PathVariable("id") long customerId){
			return new ResponseEntity<>(bService.getAllBills(customerId), HttpStatus.OK);
		}
		
		
		//Post for paying bills
			@PostMapping("/paybill")
			public ResponseEntity<Bill> payBill(@RequestBody Bill bill) {
				ResponseEntity<Bill> resp = null;

				if (bService.existsByBillId(bill.getBillId())) {
					resp = new ResponseEntity<Bill>(HttpStatus.ALREADY_REPORTED);
				}
				
				if (resp == null) {
					Bill b = bService.payBill(bill);
					if (b == null)
						resp = new ResponseEntity<Bill>(HttpStatus.BAD_REQUEST);
					else
						resp = new ResponseEntity<Bill>(b, HttpStatus.OK);
				}
				return resp;
			}
	
}
