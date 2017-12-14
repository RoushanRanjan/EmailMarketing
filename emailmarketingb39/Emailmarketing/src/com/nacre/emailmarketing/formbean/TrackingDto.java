package com.nacre.emailmarketing.formbean;

public class TrackingDto {
    // creating the filed member on the basis of tracking details
	private  int      clickOption;
	private int       serviceId;
	// create the setter and getter method for the field
	public  int getClickOption() {
		return clickOption;
	}
	public  void setClickOption(int clickOption) {
		 this.clickOption = clickOption;
	}
	
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	// toString
	@Override
	public String toString() {
		return "TrackingDto [clickOption=" + clickOption + ", serviceId=" + serviceId + "]";
	}
		
}
