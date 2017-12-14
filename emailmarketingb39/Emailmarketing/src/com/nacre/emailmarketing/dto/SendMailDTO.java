//Author: Satyajeet and Amit
package com.nacre.emailmarketing.dto;

import java.util.ArrayList;
import java.util.Map;

public class SendMailDTO {
	private Integer productId;
	private String imageName;
	private String productType;
	private String productName;
	private Integer price;
	private Map<Integer, Map<Integer,String>> mailListwithServiceId;

	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Map<Integer, Map<Integer, String>> getMailListwithServiceId() {
		return mailListwithServiceId;
	}
	public void setMailListwithServiceId(Map<Integer, Map<Integer, String>> mailListwithProductId) {
		this.mailListwithServiceId = mailListwithProductId;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}