package com.nacre.emailmarketing.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.InsertProductDto;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.dto.OwnerInformationWithProductDTO;
import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.dto.SendMailDTO;
import com.nacre.emailmarketing.dto.ServiceDTOForProductOwnerHomePage;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface AuthenticationDaoI {
	public List<Integer> checkLoginDao(LoginDto dto) throws SQLException, DatabaseException;
	
	
public String getPre_Password( Connection con,String prepassword,LoginDto ldto);
	public String getChangePassword(Connection con,LoginDto ldto);



}//interface

