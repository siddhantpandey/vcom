package com.verizon.telecom.services;

import java.util.List;

import com.verizon.telecom.model.Bill;
import com.verizon.telecom.model.Months;

public interface BillService {
	List<Bill> getBillsOfParticularService(long serviceId);
	List<Bill> getBillsOfParticularServiceMonthWise(Months month);
	List<Bill> getAllBills(long customerId);
	Bill payBill(Bill bill);
	boolean existsByBillId(long billId);

	//boolean deleteBill(long customerId);

}
