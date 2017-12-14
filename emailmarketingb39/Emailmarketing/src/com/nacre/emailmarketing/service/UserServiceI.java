package com.nacre.emailmarketing.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.ProductVeiwDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface UserServiceI {
	// interface abstract method for passing ProductViewdto as argument
	// (riyaz+rohit)
	public List findProduct(ProductVeiwDto dto) throws Exception;
	//Create Account:Rajkumar and Supriya start
	public Integer registerUserDetails(RegisterDto registerDto) throws DatabaseException;
	public Map<String, Integer> getCity(int cityId);
	public Map<String, Integer> getState(int stateId);
	public Map<String, Integer> getCountry();
	//Create Account:Rajkumar and Supriya end
	public int login(LoginDto dto);
	
	
	//chinmayi
	
	public List checkNewArival(ProductDto pd) throws DatabaseException;
	

}//class
