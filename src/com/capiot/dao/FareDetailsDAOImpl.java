package com.capiot.dao;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capiot.entity.FareDetails;

@Repository
public class FareDetailsDAOImpl implements FareDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public FareDetails fetchFareDetails(String source,String destination,String journeyType) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FareDetails> theQuery = currentSession.createQuery("from FareDetails fd where fd.source = :source,fd.destination = :destination and fd.journeyType = :journeyType",FareDetails.class);	
		FareDetails fareDetails = theQuery.getSingleResult();
		
		return fareDetails;
	}

}
