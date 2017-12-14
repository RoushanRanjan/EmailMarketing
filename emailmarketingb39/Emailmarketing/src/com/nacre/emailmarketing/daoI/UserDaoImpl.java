package com.nacre.emailmarketing.daoI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.nacre.emailmarketing.dao.UserDaoI;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dbutil.SQLQueryConstants;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.newArivalDto;
import com.nacre.emailmarketing.util.DateUtil;
import com.nacre.emailmarketing.util.IntegerConstants;

public class UserDaoImpl implements UserDaoI {
	//variable declaration
	//preparedStatement declaration
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	//resultset declaration
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	ResultSet rs4 = null;
	ResultSet rs5 = null;
	ResultSet rs6 = null;
	ResultSet rs7 = null;

	Date date;
	int operation_type_id;
	int statusId =0;
	String productName;
	String image;
	String producttype;
	int productprice;
	int quantity;
	List list = null;
	@Override
	public List getProduct(int prodId, int mailId) throws Exception {
		 System.out.println("maillid from dao:::"+mailId);
			System.out.println();
			ps4 = DbUtil.getConnection().prepareStatement(SQLQueryConstants.GET_PRODUCT_DETAILS);
			// setting the query params for retrieving the product details
			ps4.setInt(1, prodId);
			// execute the query for getting the product details
			rs6 = ps4.executeQuery();
			list = new ArrayList();
			while (rs6.next()) {
				productName = rs6.getString(1);
             image=rs6.getString(2);
				productprice = rs6.getInt(3);
				producttype = rs6.getString(4);
				quantity = rs6.getInt(5);
				list.add(productName);
				list.add(image);
				list.add(productprice);
				list.add(producttype);
				list.add(quantity);

			} // while5
			//System.out.println(list);
			// execute the query to get the operation-type-id from the operation
			ps2 = DbUtil.getConnection().prepareStatement(SQLQueryConstants.GET_OPERATIONTYPE_ID);
			// table and storing in resultSet object ie rs2..
			ps2.setString(1, "click");
			rs2 = ps2.executeQuery();
			// now getting the operationtype-id from the result set object
			while (rs2.next()) {
				operation_type_id = rs2.getInt(1);
			} // while
			System.out.println(operation_type_id);
			//get statusId
			ps6=DbUtil.getConnection().prepareStatement(SQLQueryConstants.GET_STATUS_ID);
			//set value
			ps6.setString(1, "read");
			//execute ps6
			rs7=ps6.executeQuery();
			if(rs7!=null) {
				rs7.next();
				statusId=rs7.getInt(1);
			}
			ps2=DbUtil.getConnection().prepareStatement("SELECT COUNT(*) FROM TBL_OPERATION WHERE TBL_PRODUCT_PRODUCTID=? AND tbl_maillist_mailid=?");
			ps2.setInt(1, prodId);
			ps2.setInt(2, mailId);
			rs2=ps2.executeQuery();
			int counter=0;
			if(rs2.next()){
				counter=rs2.getInt(1);
			}
			if(counter==0){
			ps1=DbUtil.getConnection().prepareStatement(SQLQueryConstants.INSERT_OPERATION_TABLE,Statement.RETURN_GENERATED_KEYS);
			// operation table
		//	ps1.setInt(1,Statement.RETURN_GENERATED_KEYS);
			ps1.setTimestamp(1, DateUtil.getCurrentTimeInTimeStampFormat());
			ps1.setInt(2, operation_type_id);
			ps1.setInt(3, prodId);
			ps1.setInt(4, mailId);
			ps1.setInt(5, IntegerConstants._UNREAD);
			// execute the query for the above entered params
			 int result=ps1.executeUpdate();
			// ResultSet key=ps1.getGeneratedKeys();
			if (result!= 0) {
				System.out.println("data inserted successfully");
			} // if
			else {
				System.out.println("data not inserted ,check it please");
			} // else
			}
			return list;
	}// method
	//Create Account:Rajkumar and Supriya start	
//	public static void main(String[] args) {
//		Connection
//	}
	@Override
	public int registerUserDetails(Connection connection,RegisterDto registerDto) throws DatabaseException {
		String emailId=null,password=null,address=null,firstName=null,lastName=null,companyName=null;
		Long contactNumber=0L;
		int cityId=0,addressId=0,registerId=0;
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int roleId=0,loginId=0;
		int counter=0;
		try{
			//get DTO Values
			emailId=registerDto.getLdto().getUserName();
			password=registerDto.getLdto().getPassword();
			address=registerDto.getAddressDto().getAddress();
			cityId=registerDto.getAddressDto().getCityId();
			firstName=registerDto.getFname();
			lastName=registerDto.getLname();
			contactNumber=registerDto.getContactno();
			companyName=registerDto.getCompanyName();
			//Set connection to setAutoCommit(false)
			connection.setAutoCommit(false);
			if(connection!=null){
				preparedStatement=connection.prepareStatement("SELECT QUANTITY FROM TBL_PRODUCT WHERE PRODUCTID=?");
				preparedStatement.setInt(1, registerDto.getProductId());
				resultSet=preparedStatement.executeQuery();
			}
			if(resultSet!=null){
				if(resultSet.next()){
					counter=resultSet.getInt(1);
				}//if
			}//if
			if(counter>0){
			//Get RoleId from Role Table
			statement=connection.createStatement();
			resultSet = statement.executeQuery(SQLQueryConstants.GET_ROLEID_USER);
			if(resultSet!=null){
				while(resultSet.next()){
					roleId= resultSet.getInt(1);
					registerDto.getLdto().setRoleId(roleId);
				}//while
			}//if
			//Insert Details into Login Table
			if(connection!=null){
				preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_LOGIN_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1,emailId);
				preparedStatement.setString(2,password);
				preparedStatement.setInt(3, roleId);
				preparedStatement.executeUpdate();
			}//if
			resultSet=preparedStatement.getGeneratedKeys();
			if(resultSet!=null){
				while(resultSet.next()){
					loginId=resultSet.getInt(1);
					registerDto.setLoginId(loginId);
				}//while
			}//if
			//Insert Details into Address Table
			if(connection!=null){
				preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_ADDRESS_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1,address);
				preparedStatement.setInt(2, cityId);
				preparedStatement.executeUpdate();
			}//if
			resultSet=preparedStatement.getGeneratedKeys();
			if(resultSet!=null){
				while(resultSet.next()){
					addressId=resultSet.getInt(1);
					registerDto.setAddressId(addressId);
				}//while
			}//if
			//Insert Details into Register Table
			if(connection!=null){
				preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_REGISTGER_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1,firstName);
				preparedStatement.setString(2,lastName);
				preparedStatement.setString(3, registerDto.getCompanyName());
				preparedStatement.setInt(4, loginId);
				preparedStatement.setInt(5, addressId);
				preparedStatement.setLong(6, contactNumber);
				preparedStatement.executeUpdate();
			}//if
			resultSet=preparedStatement.getGeneratedKeys();
			if(resultSet!=null){
				while(resultSet.next()){
					registerId=resultSet.getInt(1);
					registerDto.setRegisterId(registerId);
				}//while
			}//if
			if(connection!=null){
				preparedStatement=connection.prepareStatement("INSERT INTO TBL_USERMAIL(TBL_LOGIN_LOGINID, TBL_MAILLIST_MAILID) VALUES (?,?)");
				preparedStatement.setInt(1, loginId);
				preparedStatement.setInt(2, registerDto.getMailId());
				preparedStatement.executeUpdate();
			}
			// execute the query to get the operation-type-id from the operation
			preparedStatement = connection.prepareStatement(SQLQueryConstants.GET_OPERATIONTYPE_ID);
						// table and storing in resultSet object ie rs2..
			preparedStatement.setString(1, "buy");
			resultSet = preparedStatement.executeQuery();
						// now getting the operationtype-id from the result set object
						while (resultSet.next()) {
							operation_type_id = resultSet.getInt(1);
						} // while
						System.out.println(operation_type_id);
						//get statusId
						preparedStatement=connection.prepareStatement(SQLQueryConstants.GET_STATUS_ID);
						//set value
						preparedStatement.setString(1, "unread");
						//execute ps6
						resultSet=preparedStatement.executeQuery();
						if(resultSet!=null) {
							resultSet.next();
							statusId=resultSet.getInt(1);
						}
						preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_OPERATION_TABLE,Statement.RETURN_GENERATED_KEYS);
						// operation table
					//	ps1.setInt(1,Statement.RETURN_GENERATED_KEYS);
						preparedStatement.setTimestamp(1, DateUtil.getCurrentTimeInTimeStampFormat());
						preparedStatement.setInt(2, operation_type_id);
						preparedStatement.setInt(3, registerDto.getProductId());
						preparedStatement.setInt(4, registerDto.getMailId());
						preparedStatement.setInt(5, statusId);
						// execute the query for the above entered params
						 int result=preparedStatement.executeUpdate();
						 preparedStatement=connection.prepareStatement("UPDATE TBL_PRODUCT SET QUANTITY=QUANTITY-1 WHERE PRODUCTID=?");
						 preparedStatement.setInt(1, registerDto.getProductId());
						 preparedStatement.executeUpdate();
						 
						 connection.commit();
						 return 1;
			}else{
				connection.commit();
				return 2;
			}		 
			
			
		}catch (Exception e){ 
			try {
				e.printStackTrace();
				if(connection!=null)
					connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DatabaseException("Rollback Not Performed");
			}//try-catch
			return 0;
		}//try-catch
		finally{
			try {
				if(resultSet!=null)
						resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(statement!=null)
						statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(preparedStatement!=null)
						preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
	}//finally
	}//registerUserDetails(-,-)

	@Override
	public Map<String, Integer> getCity(Connection connection,int cityId) {
		Map<String , Integer> map=null;
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			//Get Cities from City Table
			if(connection!=null){
				preparedStatement=connection.prepareStatement(SQLQueryConstants.GET_CITY_ALL);
				preparedStatement.setInt(1,cityId);
				resultSet=preparedStatement.executeQuery();
			}
			if(resultSet!=null){
				map=new TreeMap<String,Integer>();
				while(resultSet.next()){
					map.put(resultSet.getString(2),resultSet.getInt(1));
				}//while
			}//if
		}catch (Exception e){ 
		}//try-catch
		//Close Connections
		finally{
			try {
				if(resultSet!=null)
						resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(preparedStatement!=null)
						preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(connection!=null)
						connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
	}//finally
	return map;
	}//getCity(-)
	@Override
	public Map<String, Integer> getSate(Connection connection, int stateId) {
		Map<String , Integer> map=null;
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			//Get Cities from City Table
			if(connection!=null){
				preparedStatement=connection.prepareStatement(SQLQueryConstants.GET_STATE_ALL);
				preparedStatement.setInt(1,stateId);
				resultSet=preparedStatement.executeQuery();
			}
			if(resultSet!=null){
				map=new TreeMap<String,Integer>();
				while(resultSet.next()){
					map.put(resultSet.getString(2),resultSet.getInt(1));
				}//while
			}//if
		}catch (Exception e){ 
		}//try-catch
		//Close Connections
		finally{
			try {
				if(resultSet!=null)
						resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(preparedStatement!=null)
						preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(connection!=null)
						connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
	}//finally
	return map;
	}//getState(-)
	@Override
	public Map<String, Integer> getCountry(Connection connection) {
		Map<String , Integer> map=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try{
			//Get Country from Country Table
			if(connection!=null){
				statement=connection.createStatement();
				resultSet=statement.executeQuery(SQLQueryConstants.GET_COUNTRY_ALL);
			}
			if(resultSet!=null){
				map=new TreeMap<String,Integer>();
				while(resultSet.next()){
					map.put(resultSet.getString(2),resultSet.getInt(1));
				}//while
			}//if
		}catch (Exception e){ 
		}//try-catch
		//Close Connections
		finally{
			try {
				if(resultSet!=null)
						resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(statement!=null)
						statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
			try {
				if(connection!=null)
						connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//try-catch
	}//finally
	return map;
	}//getCountry(-)
	//Create Account:Rajkumar and Supriya End
	@Override
	public ProductDto productInfo(ProductDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

		public List checkSuccess(Connection con, ProductDto pd) throws DatabaseException {
			System.out.println("hello user");
			List l=new ArrayList();
			PreparedStatement ps=null;
			
	     	
			try {
				
	ps=con.prepareStatement("SELECT * FROM (SELECT productid,productname,image,productprice,quantity "
			+ "FROM tbl_product ORDER BY productid DESC LIMIT 3) sub ORDER BY productid ASC");
					
					ResultSet rs = ps.executeQuery();
				        while(rs.next()){
				        	newArivalDto dto=new newArivalDto();
				         	
				         //Retrieve by column name
				        int productId=rs.getInt("productid");
				     	String productName=rs.getString("productname");
				     	String Image=rs.getString("image");
				     
				     
						
				     	int productPrice=rs.getInt("productprice");
				     	int quantity=rs.getInt("quantity");
				        
				     	System.out.println(productId);
				     	System.out.println(productName);
				     	System.out.println(Image);
				     	System.out.println(productPrice);
				     	System.out.println(quantity);
				     	dto.setImage(Image);
				     	dto.setProductName(productName);
				     	dto.setProductPrice(productPrice);
				     	dto.setQuantity(quantity);

				     	l.add(dto);
				     	//l.add(productId);
				     	/*l.add(productName);
				     	l.add(Image);
				     	l.add(productPrice);
				     	l.add(quantity);*/
				     	//l.add(dto);
		
				        }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			//System.out.println(l);
			return l;
			
			
		}

	//Chinmayi
}//class