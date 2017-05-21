package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {
//FINISHED
	// TODO - RocketBLL rate_test
	// Check to see if a known credit score returns a known interest rate

	// TODO - RocketBLL rate_test
	// Check to see if a RateException is thrown if there are no rates for a
	// given
	// credit score


	
	@Test
	public void TestRates(){
		ArrayList<RateDomainModel> ratesall;
		ratesall = RateDAL.getAllRates();
		
		for (RateDomainModel r: ratesall){
			try {
				double RRate = RateBLL.getRate(r.getiMinCreditScore());
				assertEquals(r.getdInterestRate(),RRate,0.01);
			} catch (RateException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	
	@Test (expected=RateException.class)
	public void TestRateException() throws RateException{
		double Rate = RateBLL.getRate(300);
	}
	
	@Test
	public void TestPayment(){
		double pv= 300000;
		double fv = 0;
		int NumOfPayments = 360;
		double Rte= 0.04/12;
		double pmt= RateBLL.getPayment(Rte, NumOfPayments, pv, fv, false);
		
		assertEquals(-1432.25,pmt,0.01);
		}
}