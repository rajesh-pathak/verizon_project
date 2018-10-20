package com.verizon.project.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="bills")
public class Bills {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long billId;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Due date cannot be left empty")
	@Column(name="duedate")
	private LocalDate dueDate;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message="Payment date cannot be left empty")
	@Column(name="paiddate")
	private LocalDate paidDate;
	
	@NotEmpty(message="Amount cannot be left empty")
	@Column(name="amount")
	private double amount;
	
	@Column(name="payMode")
	private PaymentMode payMode;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	public Bills() {
		super();
	}



	public Bills(@NotNull(message = "Due date cannot be left empty") LocalDate dueDate,
			@NotNull(message = "Payment date cannot be left empty") LocalDate paidDate,
			@NotEmpty(message = "Amount cannot be left empty") double amount, PaymentMode payMode) {
		super();
		this.dueDate = dueDate;
		this.paidDate = paidDate;
		this.amount = amount;
		this.payMode = payMode;
	}



	public long getBillId() {
		return billId;
	}



	public void setBillId(long billId) {
		this.billId = billId;
	}



	public LocalDate getDueDate() {
		return dueDate;
	}



	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}



	public LocalDate getPaidDate() {
		return paidDate;
	}



	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public PaymentMode getPayMode() {
		return payMode;
	}


	public void setPayMode(PaymentMode payMode) {
		this.payMode = payMode;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
