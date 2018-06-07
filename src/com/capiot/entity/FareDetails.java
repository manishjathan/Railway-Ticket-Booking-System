package com.capiot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faredetails")
public class FareDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="source")
	private String source;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="journeyType")
	private String journeyType;
	
	@Column(name="fareValue")
	private int fareValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getJourneyType() {
		return journeyType;
	}

	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}

	public int getFareValue() {
		return fareValue;
	}

	public void setFareValue(int fareValue) {
		this.fareValue = fareValue;
	}

	@Override
	public String toString() {
		return "FareDetails [id=" + id + ", source=" + source + ", destination=" + destination + ", journeyType="
				+ journeyType + ", fareValue=" + fareValue + "]";
	}
	
	
}
