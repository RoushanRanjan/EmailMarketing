package com.nacre.emailmarketing.daoI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nacre.emailmarketing.dao.ChangeDao;
import com.nacre.emailmarketing.dto.LoginDto;

public class ChangeDaoImpl implements ChangeDao{
	 String message = null;
	 PreparedStatement statement=null;
	 String  change;
	 private static final String SELECT_PASSWORD="SELECT PASSWORD FROM TBL_LOGIN WHERE LOGINID = ? AND PASSWORD=?";
	 private static final String CHANGE_PASSWORD="UPDATE TBL_LOGIN SET PASSWORD=? WHERE  loginid=?";
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