package com.verizon.telecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bills")
public class Bill { 

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long billId;
		
		@Column(name="customerId")
		private long customerId;
		
		@Column(name="serviceId")
		private long serviceId;
		
		@Column(name="month")
		@Enumerated(EnumType.STRING)
		private Months month;
		
		@Column(name="amount")
		private double amount;
		
		@Column(name="status")
		private boolean status;

		public long getBillId() {
			return billId;
		}

		public void setBillId(long billId) {
			this.billId = billId;
		}

		public long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}

		public long getServiceId() {
			return serviceId;
		}

		public void setServiceId(long serviceId) {
			this.serviceId = serviceId;
		}

		public Months getMonth() {
			return month;
		}

		public void setMonth(Months month) {
			this.month = month;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}
		
		
		

		
}
