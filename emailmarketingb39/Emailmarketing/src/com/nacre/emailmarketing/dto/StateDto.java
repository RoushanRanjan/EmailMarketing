package com.nacre.emailmarketing.dto;

public class StateDto {
	private Integer stateId;
	private String state;
	private Integer countryId;
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	private Country countryDto;

	
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Country getCountryDto() {
		return countryDto;
	}
	public void setCountryDto(Country countryDto) {
		this.countryDto = countryDto;
	}
}