package com.capiot.dao;

import com.capiot.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void updateCustomer(Customer theCustomer);

}

