package com.capiot.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capiot.entity.Customer;
import com.capiot.entity.Wallet;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		try {
		System.out.println("Get the current Session");
		
		//Create Object
		System.out.println("Creating Objects...");
		Wallet wallet = new Wallet(1000);
		
		//Associate Objects
		System.out.println("Associating Objects...");
		theCustomer.setWallet(wallet);
		
		//Save the Objects
		System.out.println("Saving the Objects...");
		currentSession.saveOrUpdate(theCustomer);
		System.out.println("Objects Saved.");
		}catch(Exception e) {
		  e.printStackTrace();
		  currentSession.close();
		}
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, theId);
		customer.toString();
		System.out.println("Customer in DAO Implementation : " + customer);
		return customer;
	
	}
}
