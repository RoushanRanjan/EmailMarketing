package com.nacre.emailmarketing.service;

import java.sql.SQLException;
import java.util.List;

import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface AuthenticationServiceI {

public String findPre_Password(String prepassword,LoginDto ldto);
	public String find_changePassword(LoginDto ldto);



public List<Integer> checkLoginService(LoginDto dto) throws SQLException, DatabaseException;
	public boolean getPassword(String username) throws DatabaseException, SQLException;

}
