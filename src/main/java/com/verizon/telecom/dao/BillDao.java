package com.verizon.telecom.dao;

import java.util.List;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.telecom.model.Bill;
import com.verizon.telecom.model.Months;

@Repository
public interface BillDao extends JpaRepository<Bill , Long> {
	List<Bill> findAllByCustomerId(long customerId);
	List<Bill> findAllByServiceId(long serviceId);
	List<Bill> findAllByMonth(Months month);
	boolean existsByBillId(long billId);

}
