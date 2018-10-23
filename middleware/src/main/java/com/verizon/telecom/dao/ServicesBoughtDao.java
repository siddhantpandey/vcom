package com.verizon.telecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.telecom.model.Customer;
import com.verizon.telecom.model.ServicesBought;
@Repository
public interface ServicesBoughtDao extends JpaRepository<ServicesBought, Long> {

	boolean existsByServiceId(Long serviceId);
	List<ServicesBought> getServiceByCustomer(Customer cust);
}
