package com.capiot.dao;

import com.capiot.entity.FareDetails;

public interface FareDetailsDAO {
	public FareDetails fetchFareDetails(String source,String dest,String journeyType);
}
