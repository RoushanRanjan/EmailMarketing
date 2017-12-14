package com.nacre.emailmarketing.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.ServiceDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface ServiceOwnerDaoI {
 	//wasik &n junaid
/*	public Map ViewServicedao(ServiceDto dto,Connection con)throws  SQLException;
*/	public List<ServiceDto> getAllServices()throws SQLException;
	public void deleteService(int serviceId)throws DatabaseException; 
	//public void getAllEmails(int serviceId) throws SQLException;
	public List<ServiceDto> getAllmails(int serviceId)throws SQLException;
 	 /*public Map ViewServicedao(ServiceDto dto,Connection con)throws  SQLException;
	 public List<ServiceDto> getAllEmails()throws SQLException;
 	 public void deleteServices(int serviceId);
*/
 // End 	
	//Create Account:Rajkumar and Supriya start
	public int registerServiceOwnerDetails(Connection connection,RegisterDto registerDto) throws DatabaseException;
	public Map<String, Integer> getCity(Connection connection,int cityId);
	public Map<String, Integer> getSate(Connection connection,int stateId);
	public Map<String, Integer> getCountry(Connection connection);
	//Create Account:Rajkumar and Supriya End
	
	//Code By bhushan
	public boolean addMailListExcel(MailListDto dto ,Connection con) throws SQLException,IOException;
	public boolean addMailIndividual(MailListDto dto ,Connection con) throws SQLException;
}
