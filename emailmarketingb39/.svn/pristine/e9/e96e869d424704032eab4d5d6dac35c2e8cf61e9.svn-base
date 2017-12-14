package com.nacre.emailmarketing.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.Operation;
import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.ServiceDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.ServiceDetailsDto;
import com.nacre.emailmarketing.formbean.TrackingDto;

public interface AdminDaoI {
       
	 // creating the method for clicked_view process
	 public List<ServiceDetailsDto> clickedViewAdminDao() throws DatabaseException, SQLException;
	 // getting no_Of _clicked _User on the basis of service
	 public List<TrackingDto> no_Of_Clicked_User(int a) throws DatabaseException, SQLException;
	 
	 //code by sagar
	 public Map productNotification();
	 public Map servicesNotification();
	 public Map userNotification();
	 
	public ProductDto productDetail(int key);
	public ServiceDto serviceDetail(int key);
	public Operation userDetail(int key);

	public int updateProductStatuse(int key);
	public int updateServiceStatuse(int key);
	public int updateUserStatuse(int key);

	public int countProduct();
	public int countServices();
	public int countOperation();
	
	//code by chinmayi
	public String checkUpdate(Connection con, OperationtypeDto otd) throws DatabaseException;
		
}
