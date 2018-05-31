package com.capiot.dao;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.capiot.entity.Customer;

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
		System.out.println("Save the Object");
		currentSession.saveOrUpdate(theCustomer);	
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
