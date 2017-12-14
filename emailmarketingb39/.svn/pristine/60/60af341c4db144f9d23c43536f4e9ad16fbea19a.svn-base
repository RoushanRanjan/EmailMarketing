package com.nacre.emailmarketing.daoI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.nacre.emailmarketing.dao.AdminDaoI;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dbutil.SQLQueryConstants;
import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.Operation;
import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.ServiceDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.ServiceDetailsDto;
import com.nacre.emailmarketing.formbean.TrackingDto;

public class AdminDaoImpl implements AdminDaoI {
       Connection con=null;
	PreparedStatement pst=null;
	String clickedViewQuery=null;
	
	ResultSet rs=null;
	@Override
	public List<ServiceDetailsDto> clickedViewAdminDao() throws DatabaseException, SQLException {
		List <ServiceDetailsDto> list=new ArrayList();
		// get the connection from the DbUtil class
		 con=DbUtil.getConnection();
		 // create the preparedStatement
		 pst=con.prepareStatement(SQLQueryConstants.totalMailCount);
		 // set the argument to the parameter
		/* pst.setInt(1, TrackingDto.getClickOption());*/
		 // execute the query
		 rs=pst.executeQuery();
		 int i=0;
		 // store the data into the ServiceDetailsDto class 
		 while(rs.next()){
			 ServiceDetailsDto dt=  new ServiceDetailsDto();
			dt.setServiceId(rs.getInt(1));
			dt.setServiceName(rs.getString(2));
	        // storing object 
			list.add(dt);
		}
		/* System.out.println(list);*/
		return list;
	}
   
	// Method for getting the No_Of_Clicked_User
	
	public List<TrackingDto> no_Of_Clicked_User(int a) throws DatabaseException, SQLException {
		  // Query
		 TrackingDto tdto=null;
		String clickedUser=null;
		List <TrackingDto> list=null;
		// get the query from the SqlConstants class
		list=new ArrayList<TrackingDto>();
		clickedUser=SQLQueryConstants.noOfClickedUser;
		// get the connection from the DbUtil class
		 con=DbUtil.getConnection();
		 // create the preparedStatement
		 pst=con.prepareStatement(clickedUser);
		 // set the argument to the parameter
		 pst.setInt(1, a);
		 // execute the query
		 rs=pst.executeQuery();
		 // store the data into the ServiceDetailsDto class 
		 while(rs.next()){
			tdto=new TrackingDto();
			 tdto.setClickOption(rs.getInt(1));
			 tdto.setServiceId(rs.getInt(2));
			 // add to the list object
			 list.add(tdto);
			 System.out.println(list);
		 }
		 // return the details of Service Record
		return list;
	}
	
	//code by sagar
	
	Map map = null;
	ProductDto productDto = null;
	ServiceDto serviceDto = null;
	Operation operation = null;
	OperationtypeDto  operationtypeDto= null;
	RegisterDto registerDto = null;
	MailListDto mailListDto = null;
	PreparedStatement ps=null;
	int b = 0;
	int status1 =2;
	int status =1;
		@Override
	public Map productNotification() {
		// TODO Auto-generated method stub
			try {
				 con=DbUtil.getConnection();
					ps=con.prepareStatement(SQLQueryConstants._SelectProductNotification);
					ps.setInt(1, status);
					rs=ps.executeQuery();
					 map=new TreeMap();
					 while (rs.next()) {
						 map.put(rs.getInt(1),rs.getString(2 ));
					 }
					
					
			} catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return map;
		
	}

	@Override
	public Map servicesNotification() {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
			ps=con.prepareStatement(SQLQueryConstants._SelectServiesNotification);
			ps.setInt(1, status);
			rs=ps.executeQuery();
			 map=new TreeMap();
			 while (rs.next()) {
				 map.put(rs.getInt(1),rs.getString(2));
			 }
			
			
	} catch (DatabaseException|SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return map;	
		
	}

	@Override
	public Map userNotification() {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
			ps=con.prepareStatement(SQLQueryConstants._SelectUserNotification);
			ps.setInt(1, status);
			rs=ps.executeQuery();
			 map=new TreeMap();
			 while (rs.next()) {
				 map.put(rs.getInt(1),rs.getString(2));
				
			 }
			 System.out.println(map+"hjhejw");
			
	} catch (DatabaseException|SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return map;
	}

	@Override
	public ProductDto productDetail(int key) {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
			ps=con.prepareStatement(SQLQueryConstants._GetProductDetail);
			ps.setInt(1, key);
			rs=ps.executeQuery();
			 productDto = new ProductDto();
			 registerDto = new RegisterDto();
			 System.out.println("dao");
			 while (rs.next()) {
				 productDto.setProductName(rs.getString(1));
				registerDto.setFname(rs.getString(2));
				registerDto.setLname(rs.getString(3));
				productDto.setRegisterDto(registerDto);
				productDto.setProductPrice(rs.getInt(4));
				productDto.setProductType(rs.getString(5));
				
			 }
			
			 System.out.println(productDto.getProductName());
	} catch (DatabaseException|SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return productDto;
	}

	@Override
	public ServiceDto serviceDetail(int key) {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._GetServiceDetail);
		ps.setInt(1, key);
		rs=ps.executeQuery();
		serviceDto = new ServiceDto();
		 registerDto = new RegisterDto();
		 System.out.println("dao");
		 while (rs.next()) {
			 serviceDto.setServiceName(rs.getString(1));
			 registerDto.setFname(rs.getString(2));
			 registerDto.setLname(rs.getString(3));
			 serviceDto.setRegisterDto(registerDto);
			 serviceDto.setServiceDate(rs.getDate(4));
			
		 }
		
		
} catch (DatabaseException|SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return serviceDto;
	}

	@Override
	public Operation userDetail(int key) {
		// TODO Auto-generated method stub
		
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._GetUserDetail);
		ps.setInt(1, key);
		rs=ps.executeQuery();
		operation = new Operation();
		operationtypeDto = new  OperationtypeDto();
		 registerDto = new RegisterDto();
		 mailListDto = new MailListDto();
		 productDto = new ProductDto();
		 System.out.println("dao");
		 while (rs.next()) {
			 mailListDto.setMails(rs.getString(1));
			 operation.setMailListDto(mailListDto);
			productDto.setProductName(rs.getString(2));
			operation.setProductDto(productDto);
			operation.setOperationDate(rs.getDate(3));
			operationtypeDto.setOperation(rs.getString(4));
		   operation.setOpDto(operationtypeDto);
			
		 }
		
		 System.out.println(productDto.getProductName());
} catch (DatabaseException|SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return operation;
	}

	@Override
	public int updateProductStatuse(int key) {
		// TODO Auto-generated method stub
		
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._UpdateProductStatuse);
		ps.setInt(1, key);
		b=ps.executeUpdate();
		}
		 catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

	@Override
	public int updateServiceStatuse(int key) {
		// TODO Auto-generated method stub
		
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._UpdateServiceStatuse);
		ps.setInt(1, key);
		b=ps.executeUpdate();
		}
		 catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

	@Override
	public int updateUserStatuse(int key) {
		// TODO Auto-generated method stub
		
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._UpdateUserStatuse);
		ps.setInt(1, key);
		b=ps.executeUpdate();
		}
		 catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._ProductStatusCount);
		ps.setInt(1, status);
		rs=ps.executeQuery();
		 while (rs.next()) {
			 b= rs.getInt(1);
		 }
		}
		 catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

	@Override
	public int countServices() {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._ServiceStatusCount);
		ps.setInt(1, status);
		rs=ps.executeQuery();
		while (rs.next()) {
			 b= rs.getInt(1);
		 }
		}
		 catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

	@Override
	public int countOperation() {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getConnection();
			
		ps=con.prepareStatement(SQLQueryConstants._OperationStatusCount);
		ps.setInt(1, status);
		rs=ps.executeQuery();
		while (rs.next()) {
			 b= rs.getInt(1);
		 }
		}
		 catch (DatabaseException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}
	//code by chinmayi
	@Override
	public String checkUpdate(Connection con, OperationtypeDto otd) throws DatabaseException {
		
		System.out.println("hello user");
		try {
			 //con=DbUtil.getConnection();
			
ps=con.prepareStatement("UPDATE tbl_operationtype SET price=?  WHERE operationtypeId = ?");
				
				ps.setDouble(1,otd.getPrice());
				System.out.println(otd.getPrice());
				ps.setInt(2,otd.getOperationTypeId());
				int r=0;
				r=ps.executeUpdate();
				System.out.println(r);
				
				 
				if(r!=0)
				{
					return "success";
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "unable to update";
		

	}

}
