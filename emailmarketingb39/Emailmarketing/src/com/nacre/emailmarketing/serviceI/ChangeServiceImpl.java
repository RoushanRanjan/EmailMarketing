package com.nacre.emailmarketing.serviceI;


import java.sql.Connection;

import com.nacre.emailmarketing.daoI.ChangeDaoImpl;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ChangeService;

public class ChangeServiceImpl implements ChangeService{
	Connection con = null;

	@Override
	public String findPre_Password(String prepassword,LoginDto ldto) {
		
		try {
			con = DbUtil.getConnection();
		} catch (DatabaseException e) {

			e.printStackTrace();
		}
		ChangeDaoImpl dao=new ChangeDaoImpl();
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
		ChangeDaoImpl dao=new ChangeDaoImpl();
		
		String result=dao.getChangePassword(con, ldto);
		
		return result;
		
	}
		
	}