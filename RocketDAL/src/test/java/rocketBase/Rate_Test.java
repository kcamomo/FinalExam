package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void RateTest() throws Exception {
		int size = RateDAL.getAllRates().size();
		assertTrue(size>0);
		if (size == 0) {
			throw new Exception();
		}
	}
}