package com.nacre.emailmarketing.formbean;

public class PieChartDetails {
	// create the field
		private  String serviceName;
		private  int       userEvent;
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public int getUserEvent() {
			return userEvent;
		}
		public void setUserEvent(int userEvent) {
			this.userEvent = userEvent;
		}
		// toString
		@Override
		public String toString() {
			return "PieChartDetails [serviceName=" + serviceName + ", userEvent=" + userEvent + "]";
		}
		
}
