package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel rate;
	
	String errMessage=null;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public RateDomainModel getRate() {
		return rate;
	}

	public RateException(RateDomainModel r) {

		rate=r;
		
		
	}

	public RateDomainModel getRateDomainModel() {
		return rate;
	}
	
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}