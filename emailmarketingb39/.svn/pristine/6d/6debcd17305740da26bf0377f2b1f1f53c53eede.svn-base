package com.nacre.emailmarketing.daoI;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nacre.emailmarketing.dao.ServiceOwnerDaoI;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dbutil.SQLQueryConstants;
import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.ServiceDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.util.DateUtil;
import com.nacre.emailmarketing.util.IntegerConstants;


public class ServiceOwnerDaoImpl implements ServiceOwnerDaoI {

	//wasik & junaid upto line number 299

	@Override
	 public List<ServiceDto> getAllServices() throws SQLException
	{
		//System.out.println("from dao impl");
		List<ServiceDto> sdto = new ArrayList<ServiceDto>();
	  	try
		{
		 	Connection con=DbUtil.getConnection();
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(SQLQueryConstants.serviceQuery);
			while(rs.next())
			{
				ServiceDto dto=new ServiceDto();		
				dto.setServiceId(rs.getInt(1));
				dto.setServiceName(rs.getString(2));
				DateUtil d=new DateUtil();
				java.sql.Date dd=d.getSqlDate(rs.getDate(4));
				
			  	dto.setServiceDate(DateUtil.getUtilDate(dd));
			//System.out.println(rs.getString(4));
				sdto.add(dto);
			}
		 }
		catch(DatabaseException e)
		{
			e.printStackTrace();
		}
		return sdto;
	}
	@Override
	public void deleteService(int serviceId) throws DatabaseException {
	 
		java.sql.PreparedStatement pStmt=null;
		 try {
			Connection con=DbUtil.getConnection();
		 	pStmt = con.prepareStatement(SQLQueryConstants.DeleteService);
			pStmt.setInt(1, serviceId);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	 @Override
	public List<ServiceDto> getAllmails(int serviceId) throws SQLException {
	 
		List<ServiceDto> sdto = new ArrayList<ServiceDto>();
	  	try
		{
	  		ResultSet rs=null;
	  		Connection con=DbUtil.getConnection();
			java.sql.PreparedStatement pstmt=null;
			pstmt=con.prepareStatement( SQLQueryConstants.emails);
			pstmt.setInt(1, serviceId);
 			rs=pstmt.executeQuery();
			//pstmt.setInt(2, serviceId);
			while(rs.next())
			{
				System.out.println("from dao impl demo");
				ServiceDto dto=new ServiceDto();		
			//	dto.setServiceId(rs.getInt(1));
				dto.setEmails(rs.getString(2));
				System.out.println("==================");
				System.out.println(rs.getString(2));
				System.out.println("==================");
				
				//System.out.println(rs.getString(3));
		
			sdto.add(dto);
			}
		}	
	  	catch(DatabaseException e)
	  	{
	  		e.printStackTrace();
	  		
	  	}
	  	return sdto;
	}
	/*@Override
	public Map ViewServicedao(ServiceDto dto, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}	 */
	

	
	
	/*HashMap map=new HashMap<>();
 	public  Map ViewServicedao(ServiceDto dto, Connection con) throws SQLException {
 		System.out.println("from service impl");
 			int sId=0;
 			String sName=null;
 			Date sDate = null;
 			int rId=0;
 			int statusId=0;
 			ResultSet rs1=null;
 		java.sql.PreparedStatement ps1=null;
		ps1= con.prepareStatement(SQLQueryConstants.serviceQuery);
		//ps1.setInt(1, dto.getServiceId() );
		rs1=ps1.executeQuery();
		while (rs1.next())
		{
		sId=rs1.getInt(1);
		sName=rs1.getString(2);
		rId=rs1.getInt(3);
		sDate=rs1.getDate(4);
		}	
		System.out.println(sId+ sName );
		ServiceDto dt=new ServiceDto();
		dt.setServiceId(sId);
		dt.setServiceName(sName);
		dt.setRegisterId(rId);
		dt.setServiceDate(sDate);
		map.put(1, dt.getServiceDate());
		map.put(2, dt.getServiceName());
		map.put(3,  dt.getServiceId());
		map.put(4, dt.getRegisterId());
		//System.out.println(map);
		return map;



HashMap map=new HashMap<>();
 	public  Map ViewServicedao(ServiceDto dto, Connection con) throws SQLException {
 		System.out.println("from service impl");
 			int sId=0;
 			String sName=null;
 			Date sDate = null;
 			int rId=0;
 			int statusId=0;
 			ResultSet rs1=null;
 		java.sql.PreparedStatement ps1=null;
		ps1= con.prepareStatement(SQLQueryConstants.serviceQuery);
		//ps1.setInt(1, dto.getServiceId() );
		rs1=ps1.executeQuery();
		while (rs1.next())
		{
		sId=rs1.getInt(1);
		sName=rs1.getString(2);
		rId=rs1.getInt(3);
		sDate=rs1.getDate(4);
		
		 }
		System.out.println(sId+ sName );
		ServiceDto dt=new ServiceDto();
		dt.setServiceId(sId);
		dt.setServiceName(sName);
		dt.setRegisterId(rId);
		dt.setServiceDate(sDate);
		map.put(1, dt.getServiceDate());
		map.put(2, dt.getServiceName());
		map.put(3,  dt.getServiceId());
		map.put(4, dt.getRegisterId());
		//System.out.println(map);
		return map;
	}

	   

	
}
		System.out.println(sId+ sName );
		ServiceDto dt=new ServiceDto();
		dt.setServiceId(sId);
		dt.setServiceName(sName);
		dt.setRegisterId(rId);
		//dt.setServiceDate(sDate);
		map.put(1, dt.getServiceDate());
		map.put(2, dt.getServiceName());
		map.put(3,  dt.getServiceId());
		map.put(4, dt.getRegisterId());
		//System.out.println(map);
		return map;
	}
	
	@Override
	 public List<ServiceDto> getAllServices() throws SQLException
	{
		//System.out.println("from dao impl");
		List<ServiceDto> sdto = new ArrayList<ServiceDto>();
	  	try
		{
		 	Connection con=DbUtil.getConnection();
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(SQLQueryConstants.serviceQuery);
			while(rs.next())
			{
				ServiceDto dto=new ServiceDto();		
				dto.setServiceId(rs.getInt(1));
				dto.setServiceName(rs.getString(2));
				dto.setServiceDate(rs.getString(4));
				//System.out.println(rs.getString(4));
				sdto.add(dto);
			}
		 }
		catch(DatabaseException e)
		{
			e.printStackTrace();
		}
		return sdto;
	}
	@Override
	public void deleteService(int serviceId) throws DatabaseException {
	 
		java.sql.PreparedStatement pStmt=null;
		 try {
			Connection con=DbUtil.getConnection();
		 	pStmt = con.prepareStatement(SQLQueryConstants.DeleteService);
			pStmt.setInt(1, serviceId);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void getAllEmails(int serviceId) throws SQLException {
	 	List<ServiceDto> sdto = new ArrayList<ServiceDto>();
	  	try
		{
	  		ResultSet rs=null;
	  		Connection con=DbUtil.getConnection();
			PreparedStatement pstmt=null;
			pstmt=con.prepareStatement(SQLQueryConstants.emails);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("from dao impl demo");
				ServiceDto dto=new ServiceDto();		
				dto.setServiceId(rs.getInt(1));
				dto.setEmails(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}	
	  	catch(DatabaseException e)
	  	{
	  		e.printStackTrace();
	  		
	  	}
	  	return sdto;
 	}
	@Override
	public List<ServiceDto> getAllmails(int serviceId) throws SQLException {
	 
		List<ServiceDto> sdto = new ArrayList<ServiceDto>();
	  	try
		{
	  		ResultSet rs=null;
	  		Connection con=DbUtil.getConnection();
			java.sql.PreparedStatement pstmt=null;
			pstmt=con.prepareStatement( SQLQueryConstants.emails);
			pstmt.setInt(1, serviceId);
  			rs=pstmt.executeQuery();
 			//pstmt.setInt(2, serviceId);
			while(rs.next())
			{
				System.out.println("from dao impl demo");
				ServiceDto dto=new ServiceDto();		
			//	dto.setServiceId(rs.getInt(1));
				dto.setEmails(rs.getString(2));
				System.out.println("==================");
				System.out.println(rs.getString(2));
				System.out.println("==================");
				
				//System.out.println(rs.getString(3));
		
			sdto.add(dto);
			}
		}	
	  	catch(DatabaseException e)
	  	{
	  		e.printStackTrace();
	  		
	  	}
	  	return sdto;
 	}	 
	
*/

	//End 
	//Create Account:Rajkumar and Supriya start	
	@Override
	public int registerServiceOwnerDetails(Connection connection,RegisterDto registerDto) throws DatabaseException {
		String emailId=null,password=null,address=null,firstName=null,lastName=null,companyName=null;
		Long contactNumber=0L;
		int cityId=0,addressId=0,registerId=0;
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int roleId=0,loginId=0;
		try{
			//get DTO Values
			emailId=registerDto.getLdto().getUserName();
			password=registerDto.getLdto().getPassword();
			address=registerDto.getAddressDto().getAddress();
			cityId=registerDto.getAddressDto().getCityId();
			firstName=registerDto.getFname();
			lastName=registerDto.getLname();
			companyName=registerDto.getCompanyName();
			//Set connection to setAutoCommit(false)
			connection.setAutoCommit(false);
			//Insert Details into Login Table
			if(connection!=null){
				preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_LOGIN_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1,emailId);
				preparedStatement.setString(2,password);
				preparedStatement.setInt(3, IntegerConstants._SERVICEOWNER);
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
				preparedStatement.setString(3,companyName);
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
			if(registerId!=-1)
				connection.commit();
			else
				connection.rollback();
			return registerId;
		}catch (Exception e){ 
			try {
				e.printStackTrace();
				if(connection!=null)
					connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DatabaseException("Rollback Not Performed");
			}//try-catch
			return -1;
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
	
	//Code By Bhushan
	
	
	
	
	@Override
	public boolean addMailListExcel(MailListDto dto, Connection con) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		PreparedStatement prepStmt=null;
		java.sql.Statement stmt = null;
		
		
		FileInputStream fis=null;
		
		
		
		//int registerId=rdto.getRegisterId();
	
		
		int count = 0;
		
		
		Part filePath=dto.getFilepath();
		String serviceName=dto.getServiceName();
		
		int registerId=dto.getRegisterId();
		int serviceid=0;
		
		
		int dbflag = 0;
		try {
			
			PreparedStatement ps3=null;
			ps3 = con.prepareStatement(SQLQueryConstants.GET_SERVICEID);
			ps3.setString(1, serviceName);
			
			ResultSet rs3=ps3.executeQuery();
			
			if(rs3.next())
			{
				serviceid=rs3.getInt(1);
			}
			else
			{
				// service insertion query logic
				PreparedStatement ps4=null;
				ps4 = con.prepareStatement(SQLQueryConstants.ADD_SERVICE,PreparedStatement.RETURN_GENERATED_KEYS);
				
				ps4.setString(1, serviceName);
				ps4.setInt(2, registerId);
				ps4.executeUpdate();
				ResultSet rs4=ps4.getGeneratedKeys();
				if(rs4.next())
				{
					serviceid=rs4.getInt(1);
				}
				
			}
			
			
			
			
			prepStmt = con.prepareStatement(SQLQueryConstants.INSERT_RECORDS,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(SQLQueryConstants.GET_COUNT);
            while(result.next()) {

                int val = result.getInt(1);
                System.out.println("val"+val);
                count = val+1;

            }


            //prepStmt.setInt(1,count);

            /* We should now load excel objects and loop through the worksheet data */
            //FileInputStream fis = new FileInputStream(new File(filePath));
             fis = (FileInputStream)filePath.getInputStream();
            System.out.println("FileInputStream Object created..! ");
             /* Load workbook */
            XSSFWorkbook workbook = new XSSFWorkbook (fis);
            System.out.println("XSSFWorkbook Object created..! ");
            /* Load worksheet */
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println("XSSFSheet Object created..! ");
               // we loop through and insert data
            Iterator ite = sheet.rowIterator();
            System.out.println("Row Iterator invoked..! ");

               while(ite.hasNext()) {
                        Row row = (Row) ite.next(); 
                        System.out.println("Row value fetched..! ");
                        Iterator<Cell> cellIterator = row.cellIterator();
                        System.out.println("Cell Iterator invoked..! ");
                        int index=1;
                                while(cellIterator.hasNext()) {

                                        Cell cell = cellIterator.next();
                                        System.out.println("getting cell value..! ");

                                        switch(cell.getCellType()) { 
                                        case Cell.CELL_TYPE_STRING: //handle string columns
                                                prepStmt.setString(index, cell.getStringCellValue());                                                                                     
                                                break;
                                        case Cell.CELL_TYPE_NUMERIC: //handle double data
                                            int i = (int)cell.getNumericCellValue();
                                            prepStmt.setInt(index, (int) cell.getNumericCellValue());
                                                break;
                                        }
                                        
                                        index++;
                                        
                                        prepStmt.setInt(index, serviceid);
                                        
                                        index++;



                                }
                //we can execute the statement before reading the next row
                prepStmt.executeUpdate();
                
                ResultSet rs1=prepStmt.getGeneratedKeys();
	    			if(rs1.next())
	    			{
	    				int mailid=rs1.getInt(1);
	    				System.out.println(mailid);
	    			}
                }
               
               
               /*
                Close input stream 
               fis.close();
                Close prepared statement 
               prepStmt.close();

                Close connection 
               con.close();
			*/
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dbflag=1;
			
			e.printStackTrace();
			
		}
		
		finally {
				
			//Close input stream 
            fis.close();
            // Close prepared statement 
            prepStmt.close();

             //Close connection 
            con.close();
            
            if(dbflag==1)
    		{
    			return false;
    		}
            
		}
		
		return true;
		
		
	}

	@Override
	public boolean addMailIndividual(MailListDto dto, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt=null;
		
		Integer serviceid = dto.getServiceId();
		String mails=dto.getMails();
		
		int dbflag = 0;
		try 
		{
			
			pstmt = con.prepareStatement(SQLQueryConstants.INSERT_RECORDS);
			
			pstmt.setString(1, mails);
			pstmt.setInt(2, serviceid);

			pstmt.executeUpdate();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			 dbflag=1;
			
			e.printStackTrace();
		}
		
		finally {
            // Close prepared statement 
            pstmt.close();

             //Close connection 
            con.close();
            
            if(dbflag==1)
    		{
    			return false;
    		}
           
		}
	
		return true;
	}

	

	}
