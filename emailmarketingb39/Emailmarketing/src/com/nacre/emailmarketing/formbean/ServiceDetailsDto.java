package com.nacre.emailmarketing.formbean;

public class ServiceDetailsDto {
    // create the field
	private  String serviceName;
	private  int       serviceId;
	// create the setter and getter 
	
public  String getServiceName() {
		return serviceName;
	}

	public  void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public  int getServiceId() {
		return serviceId;
	}

	public  void setServiceId(int serviceId) {
		this.serviceId =serviceId;
	}
	// constructor
	/* public ServiceDetailsDto(int  numberOfUser,String  serviceName){
		 this. serviceName= serviceName;
		 this. numberOfUser= numberOfUser;
	 }*/
	// toString method
		@Override
		public String toString() {
			return "ServiceDetailsDto [serviceName=" + serviceName + ", numberOfUser=" + serviceId + "]";
		}

}
