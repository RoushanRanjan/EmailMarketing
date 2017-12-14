package com.nacre.emailmarketing.daoI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nacre.emailmarketing.dao.AuthenticationDaoI;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dbutil.SQLQueryConstants;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public class AuthenticationDaoImpl implements AuthenticationDaoI {



String message = null;
//	 PreparedStatement statement=null;
	 String  change;
	 private static final String SELECT_PASSWORD="SELECT PASSWORD FROM TBL_LOGIN WHERE LOGINID = ? AND PASSWORD=?";
	 private static final String CHANGE_PASSWORD="UPDATE TBL_LOGIN SET PASSWORD=? WHERE  loginid=?";
		@Override
		public List<Integer> checkLoginDao(LoginDto dto) throws SQLException, DatabaseException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs1 = null, rs2 = null;
			List<Integer> list = null;
			boolean flag = false;
			int result = 0;
			//create Arraylist object
			list = new ArrayList<>();
			// get Connection obj
			con = DbUtil.getConnection();
			// create PreparedStatement obj
			ps = con.prepareStatement(SQLQueryConstants.CHECK_LOGIN_DETAILS);
			// set the values for ps
			ps.setString(1, dto.getUserName());
			ps.setString(2, dto.getPassword());
			// execute the query
			rs1 = ps.executeQuery();
			if(rs1.next()) 
				if (rs1.getInt(1) == 1) {
					System.out.println("countdao"+rs1.getInt(1));
					list.add(rs1.getInt(2));
					System.out.println("loginiddao"+rs1.getInt(2));
					list.add(rs1.getInt(3));
					System.out.println("roleiddao"+rs1.getInt(3));
				} else {
					list.add(rs1.getInt(1));
				} // else
			if(rs1.getInt(1)!=0){
			ps = con.prepareStatement(SQLQueryConstants.GET_REGISTERID);
			// set the values for ps
			ps.setInt(1, list.get(0));
			// execute the query
			rs2 = ps.executeQuery();
			if (rs2.next()){
				System.out.println("registeriddao"+rs2.getInt(1));
				list.add(rs2.getInt(1));
			}//if
			System.out.println("this is dao"+list);
			}//if
			return list;
		}// checkLoginDao(-)
		public String authenticationpassword(String username) throws DatabaseException, SQLException  {
			// TODO Auto-generated method stub
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String password=null;
			// getting the connection
			con=DbUtil.getConnection();
			//create prepared statement 
			if(con!=null) {
				ps=con.prepareStatement(SQLQueryConstants.GET_PASSWORD);
			}
			if(ps!=null) {
				ps.setString(1, username);
				rs=ps.executeQuery();
			}
			if(rs!=null) {
				if(rs.next()) {
					password=rs.getString(1);
				}
			}
			
			return password;
		}

	@Override
	public String getPre_Password(Connection con,String prepassword,LoginDto ldto) {
		try{
        PreparedStatement statement = con.prepareStatement(SELECT_PASSWORD);
        statement.setString(2, prepassword);
        
       // statement.setString(2, "1234");
        statement.setInt(1,ldto.getLoginId());
        
        ResultSet rs = statement.executeQuery();
        if(rs.next()){
            message = "SUCCESS";
        }else{
            message = "FAILURE";
        }
        
    }
		catch (Exception e) {
        message = "FAILURE1";
        e.printStackTrace();
    }
		
    return message;

	
	}
	@Override
	public String getChangePassword(Connection con, LoginDto ldto) {
		try{
	        PreparedStatement statement = con.prepareStatement(CHANGE_PASSWORD);

	        statement.setString(1, ldto.getPassword());
	        statement.setInt(2,ldto.getLoginId());
	       
	        
	        int rs = statement.executeUpdate();
	        
	       if(rs==1){
	    	   return  change="<h1 style=color:green> YOUR PASSWORD HAS BEEN CHANGED SUCCESSFULL </h1>";
	       }
	       else{
	    	   change= "password not changed";
	       }
		
	}
		catch (Exception e) {
	       change = "FAILURE";
	        e.printStackTrace();
	    }
		return change;
}


}
