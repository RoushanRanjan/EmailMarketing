//Author: Satyajeet and Amit
package com.nacre.emailmarketing.dto;

import java.io.Serializable;

public class ProductDTOForProductOwner implements Serializable{
	private Integer productId;
	private String proudctName;
	private Integer quantity;
	private String image;
	private Integer pirce;
	private String productType;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProudctName() {
		return proudctName;
	}
	public void setProudctName(String proudctName) {
		this.proudctName = proudctName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPirce() {
		return pirce;
	}
	public void setPirce(Integer pirce) {
		this.pirce = pirce;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}

}
