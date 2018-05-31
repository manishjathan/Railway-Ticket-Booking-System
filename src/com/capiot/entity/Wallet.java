package com.capiot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="amount")
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Wallet(int amount) {
		this.amount = amount;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id  + ", amount=" + amount + "]";
	}
	
	
	
	
	
}
