package com.capiot.dao;

import java.util.List;

import com.capiot.entity.Customer;
import com.capiot.entity.Ticket;

public interface CustomerDAO {

	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void updateCustomer(Customer theCustomer);
	public List<Customer> getCustomers();
	

}

