package com.nacre.emailmarketing.dto;

public class OperationtypeDto {
	private Integer operationTypeId;
	private String operation;
	private Double price;
	
	
	public Integer getOperationTypeId() {
		return operationTypeId;
	}
	public void setOperationTypeId(Integer operationTypeId) {
		this.operationTypeId = operationTypeId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}