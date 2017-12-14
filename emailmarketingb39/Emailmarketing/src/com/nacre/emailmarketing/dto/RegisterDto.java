package com.nacre.emailmarketing.dto;

public class RegisterDto {
	private Integer registerId;
	private String fname;
	private String lname;
	private String companyName;
	private Integer loginId;
	private Integer addressId;
	private Long contactno;
	private LoginDto ldto;
	private AddressDto addressDto;
	private Integer productId;
	private Integer mailId;

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getMailId() {
		return mailId;
	}
	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	public LoginDto getLdto() {
		return ldto;
	}
	public void setLdto(LoginDto ldto) {
		this.ldto = ldto;
	}
	public Integer getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}
} 