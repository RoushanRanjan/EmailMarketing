package com.nacre.emailmarketing.serviceI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.nacre.emailmarketing.dao.ServiceOwnerDaoI;
import com.nacre.emailmarketing.dao.UserDaoI;
import com.nacre.emailmarketing.daoI.ServiceOwnerDaoImpl;
import com.nacre.emailmarketing.daoI.UserDaoImpl;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ServiceOwnerServiceI;

public class ServiceOwnerServiceImpl implements ServiceOwnerServiceI {
	//Create Account:Rajkumar and Supriya start
	@Override
	public boolean registerServiceOwnerDetails(RegisterDto registerDto) throws DatabaseException {
		Connection connection=null;
		ServiceOwnerDaoI serviceOwnerDaoI=null;
		
		//Create Connection
		connection=DbUtil.getConnection();
		//Create DAO obj
		serviceOwnerDaoI=new ServiceOwnerDaoImpl();
		if(serviceOwnerDaoI.registerServiceOwnerDetails(connection, registerDto)==-1)
			return false;
		else
			return true;
	}//registerUserDetails(-,-)
	@Override
	public Map<String, Integer> getCity(int cityId) {
		UserDaoI daoI=null;
		Connection connection=null;
		try {
			daoI=new UserDaoImpl();
			connection=DbUtil.getConnection();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoI.getCity(connection, cityId);
	}
	@Override
	public Map<String, Integer> getState(int stateId) {
		UserDaoI daoI=null;
		Connection connection=null;
		try {
			daoI=new UserDaoImpl();
			connection=DbUtil.getConnection();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoI.getSate(connection, stateId);
	}
	@Override
	public Map<String, Integer> getCountry() {
		UserDaoI daoI=null;
		Connection connection=null;
		try {
			daoI=new UserDaoImpl();
			connection=DbUtil.getConnection();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		return daoI.getCountry(connection);
	}
	//Create Account:Rajkumar and Supriya end
	//add services: By Bhushan
	
	
	
	@Override
	public boolean verifyMailList(MailListDto dto) throws DatabaseException, SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DbUtil.getConnection();
		ServiceOwnerDaoI bd=new ServiceOwnerDaoImpl();
		return bd.addMailListExcel(dto, con);
		
	}

	@Override
	public boolean verifyMailIndividual(MailListDto dto) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DbUtil.getConnection();
		ServiceOwnerDaoI bd=new ServiceOwnerDaoImpl();
		return bd.addMailIndividual(dto, con);
	}
	


}
