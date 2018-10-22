package com.verizon.telecom.dao;

import java.util.List;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.telecom.model.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill , Long> {
	List<Bill> findAllByCustomerId(long customerId);
	//List<Bill> findAllByCustomerAndServiceId(long customerId, long serviceId);
	boolean existsByBillId(long billId);

}
