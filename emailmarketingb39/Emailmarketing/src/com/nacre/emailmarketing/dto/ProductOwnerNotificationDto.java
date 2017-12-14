package com.nacre.emailmarketing.dto;

import java.sql.Date;

public class ProductOwnerNotificationDto {
	private Integer productId;
	private String productName;
	private Integer productPrice;
	private String productType;
	private Integer productQuantity;
	private Date productRegisteredDate;
	private String productStatus;
	private String FullName;
	private Long ContactNumber;
	private String Address;
	private String CustomerType;
	private String MailId;
	//Setters and getters
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Date getProductRegisteredDate() {
		return productRegisteredDate;
	}
	public void setProductRegisteredDate(Date productRegisteredDate) {
		this.productRegisteredDate = productRegisteredDate;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public Long getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCustomerType() {
		return CustomerType;
	}
	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}
	public String getMailId() {
		return MailId;
	}
	public void setMailId(String mailId) {
		MailId = mailId;
	}
}//class