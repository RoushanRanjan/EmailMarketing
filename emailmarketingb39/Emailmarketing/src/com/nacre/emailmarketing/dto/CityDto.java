package com.nacre.emailmarketing.dto;

public class CityDto {
	private Integer cityId;
	private String city;
	private Integer stateId;
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	private StateDto stateDto;
	
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StateDto getStateDto() {
		return stateDto;
	}
	public void setStateDto(StateDto stateDto) {
		this.stateDto = stateDto;
	}
}