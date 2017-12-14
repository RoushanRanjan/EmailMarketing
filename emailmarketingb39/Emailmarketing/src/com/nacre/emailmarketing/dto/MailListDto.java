package com.nacre.emailmarketing.dto;

import javax.servlet.http.Part;

public class MailListDto {
	private Integer maillistId;
	private String mails;
	private Integer serviceId;
		
	
	private Integer registerId;
	
	private Part filepath;
	private String serviceName;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	private ServiceDto serviceDto;
	
	public Integer getMaillistId() {
		return maillistId;
	}
	public void setMaillistId(Integer maillistId) {
		this.maillistId = maillistId;
	}
	public String getMails() {
		return mails;
	}
	public void setMails(String mails) {
		this.mails = mails;
	}
	public ServiceDto getServiceDto() {
		return serviceDto;
	}
	public void setServiceDto(ServiceDto serviceDto) {
		this.serviceDto = serviceDto;
	}
	public Part getFilepath() {
		return filepath;
	}
	public void setFilepath(Part filepath) {
		this.filepath = filepath;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}
	
	
}
