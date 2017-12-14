package com.nacre.emailmarketing.dto;

public class AddressDto {
	private Integer addressId;
	private String address;
	private Integer cityId;
	private CityDto cityDto;
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public CityDto getCityDto() {
		return cityDto;
	}
	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}