package com.nacre.emailmarketing.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface UserDaoI {
	//interface  abstract method for product id and mailid (riyaz+rohit)
	public List getProduct(int prodId,int mailId) throws Exception;
	//Create Account:Rajkumar and Supriya start
	public int registerUserDetails(Connection connection,RegisterDto registerDto) throws DatabaseException;
	public Map<String, Integer> getCity(Connection connection,int cityId);
	public Map<String, Integer> getSate(Connection connection,int stateId);
	public Map<String, Integer> getCountry(Connection connection);
	//Create Account:Rajkumar and Supriya End
	
	
	//krishna & amit
	public ProductDto productInfo(ProductDto dto);
	
	//chinmayi
	public List checkSuccess(Connection con,ProductDto pd) throws DatabaseException;
	

	
}//class
