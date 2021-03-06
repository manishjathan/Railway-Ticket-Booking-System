package com.capiot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="journey_type")
	private String journeyType;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="total_fare")
	private int totalFare;
	
	@Column(name="expiry_Date")
	private Date expiryDate;
	
	@Column(name="customer_id")
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJourneyType() {
		return journeyType;
	}

	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public Ticket(String journeyType, String source, String destination, int totalFare, Date expiryDate) {
		this.journeyType = journeyType;
		this.source = source;
		this.destination = destination;
		this.totalFare = totalFare;
		this.expiryDate = expiryDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", journeyType=" + journeyType + ", source=" + source + ", destination="
				+ destination + ", totalFare=" + totalFare + ", expiryDate=" + expiryDate + "]";
	}
	
	public Ticket() {
		
	}
}
