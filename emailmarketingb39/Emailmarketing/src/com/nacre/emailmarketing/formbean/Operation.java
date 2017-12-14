package com.nacre.emailmarketing.formbean;



import java.util.Date;

import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.dto.ProductDto;

public class Operation {
	private Integer operationId;
	private Date operationDate;
	private Integer registerId;
	private Integer operationTypeId;
	private Integer productId;
	private ProductDto productDto;
	private OperationtypeDto opDto;
	private Integer statusId;
	
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	public OperationtypeDto getOpDto() {
		return opDto;
	}
	public void setOpDto(OperationtypeDto opDto) {
		this.opDto = opDto;
	}
	public Integer getOperationId() {
		return operationId;
	}
	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	public Integer getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}
	public Integer getOperationTypeId() {
		return operationTypeId;
	}
	public void setOperationTypeId(Integer operationTypeId) {
		this.operationTypeId = operationTypeId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
}