package com.capiot.dao;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.capiot.entity.Wallet;



public class WalletDAOImpl implements WalletDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void saveWallet(Wallet theWallet) {
			
		// create session
		Session currentSession = sessionFactory.getCurrentSession();
								
		// save Wallet Info
		System.out.println("Save the Object");
		currentSession.saveOrUpdate(theWallet);
		currentSession.close();
	}

	@Override
	@Transactional
	public Wallet getWallet(int theId) {
		System.out.println("wallet Dao : get wallet Info");
		// create session
		Session currentSession = sessionFactory.getCurrentSession();
		//execute query and get the result 
		Wallet theWallet = currentSession.get(Wallet.class,theId);
		System.out.println("Wallet Dao : " +theWallet);
		currentSession.close();
		return theWallet;
	}
}
