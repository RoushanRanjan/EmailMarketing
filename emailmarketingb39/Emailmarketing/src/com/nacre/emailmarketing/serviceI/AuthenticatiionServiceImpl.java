package com.nacre.emailmarketing.serviceI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nacre.emailmarketing.dao.AuthenticationDaoI;
import com.nacre.emailmarketing.daoI.AuthenticationDaoImpl;

import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.AuthenticationServiceI;
import com.nacre.emailmarketing.util.EmailUtilty;
import com.nacre.emailmarketing.util.SendMailUtil1;

public class AuthenticatiionServiceImpl implements AuthenticationServiceI {



Connection con = null;
/*
*
*/
	@Override
	public String findPre_Password(String prepassword,LoginDto ldto) {
		
		try {
			con = DbUtil.getConnection();
		} catch (DatabaseException e) {

			e.printStackTrace();
		}
		AuthenticationDaoI dao=new AuthenticationDaoImpl();
		String result=dao.getPre_Password(con,prepassword,ldto);
		return result;
		
	}

	@Override
	public String find_changePassword(LoginDto ldto) {
		try {
			con = DbUtil.getConnection();
		} catch (DatabaseException e) {

			e.printStackTrace();
		}
		AuthenticationDaoI dao=new AuthenticationDaoImpl();
		
		
		String result=dao.getChangePassword(con, ldto);
		
		return result;
		
	}
//login
	@Override
	public List<Integer> checkLoginService(LoginDto dto) throws SQLException, DatabaseException {
		AuthenticationDaoI dao = null;
		// create AuthenticationDaoImpl class object
		dao = new AuthenticationDaoImpl();
		return dao.checkLoginDao(dto);
	}// public int checkLoginService(-)
	@Override
	public boolean getPassword(String username) throws DatabaseException, SQLException {
		 // transfer the control to the daoImpl layer
		String reData=null;
		boolean flag=false;
		// create the DaoImpl interface
		reData=new  AuthenticationDaoImpl().authenticationpassword(username);
		  if(reData!=null) {
			  // send the mail if condition is true
			  new SendMailUtil1().sendGmail(username, "Your password is ", reData);
			  flag=true;
		  } //if
		  else {
		     flag=false;
		  } //else
		  return flag;
	}//method
}//class
	


