package com.nacre.emailmarketing.formbean;

public class TrackingDto1 {
    // creating the filed member on the basis of tracking details
	private static int      clickOption;
	// create the setter and getter method for the field
	public static int getClickOption() {
		return clickOption;
	}
	public  void setClickOption(int clickOption) {
		 this.clickOption = clickOption;
	}
	// toString
	public String toString(){
		return "Click_Value   "+clickOption;
	}
}
