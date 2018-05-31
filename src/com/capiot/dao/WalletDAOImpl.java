package com.capiot.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import com.capiot.entity.Wallet;


public class WalletDAOImpl implements WalletDAO {

	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveWallet(Wallet theWallet) {
				
		//get the current hibernate session
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Wallet.class)
				.buildSessionFactory();

		// create session
		Session currentSession = sessionFactory.getCurrentSession();
								
		// save/update the customer
		System.out.println("Save the Object");
		currentSession.saveOrUpdate(theWallet);
		currentSession.close();
	}

}
