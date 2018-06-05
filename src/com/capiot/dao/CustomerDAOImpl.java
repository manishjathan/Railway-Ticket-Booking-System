package com.capiot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capiot.entity.Customer;
import com.capiot.entity.Ticket;
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
		Wallet wallet = new Wallet(100);
		
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

	@Override
	@Transactional
	public void updateCustomer(Customer theCustomer) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		try {
		System.out.println("Get the current Session");
		
		//Save the Objects
		System.out.println("Saving the Objects...");

		currentSession.update(theCustomer);
		Wallet theWallet = theCustomer.getWallet();
		currentSession.update(theWallet);
		
		System.out.println("Objects Saved.");
		}catch(Exception e) {
		  e.printStackTrace();
		  currentSession.close();
		}
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public void addTicket(Customer customer, Ticket ticket) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		try {
		System.out.println("Get the current Session");
		//Save the Objects
		System.out.println("Saving the Objects...");

		if(customer.getTickets() == null) {
			List<Ticket> tickets = new ArrayList<Ticket>();
			customer.setTickets(tickets);
		}
		customer.getTickets().add(ticket);
		currentSession.update(customer);
		
		System.out.println("Objects Saved.");
		}catch(Exception e) {
		  e.printStackTrace();
		  currentSession.close();
		}
		
	}
	
	
}
