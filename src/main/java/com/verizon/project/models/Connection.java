package com.verizon.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="connection")
public class Connection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long conId;

	@NotEmpty(message="Plan cannot be left empty")
	@Column(name="plan")
	private Plans plan;
	
	@NotEmpty(message="Package cannot be empty")
	@Column(name="package")
	private Packages packages;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	public Connection() {
		super();
	}

	public Connection(@NotEmpty(message="Plans cannot be empty") Plans plan,@NotEmpty(message="Packages cannot be empty")  Packages packages) {
		super();
		this.plan = plan;
		this.packages = packages;
	}
	
	public long getConId() {
		return conId;
	}

	public void setConId(long conId) {
		this.conId = conId;
	}

	public Plans getPlan() {
		return plan;
	}

	public void setPlan(Plans plan) {
		this.plan = plan;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
