package com.nacre.emailmarketing.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface ServiceOwnerServiceI {
	//Create Account:Rajkumar and Supriya start
	public boolean registerServiceOwnerDetails(RegisterDto registerDto) throws DatabaseException;
	public Map<String, Integer> getCity(int cityId);
	public Map<String, Integer> getState(int stateId);
	public Map<String, Integer> getCountry();
	//Create Account:Rajkumar and Supriya end
	//Code By bhushan
	
	public boolean verifyMailList(MailListDto dto) throws DatabaseException, SQLException, IOException;
	public boolean verifyMailIndividual(MailListDto dto) throws DatabaseException, SQLException;
}
