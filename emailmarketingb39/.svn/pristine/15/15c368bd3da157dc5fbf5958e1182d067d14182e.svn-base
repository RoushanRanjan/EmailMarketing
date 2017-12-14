package com.nacre.emailmarketing.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.InsertProductDto;
import com.nacre.emailmarketing.dto.OwnerInformationWithProductDTO;
import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.dto.ProductOwnerNotificationDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.SendMailDTO;
import com.nacre.emailmarketing.dto.ServiceDTOForProductOwnerHomePage;
import com.nacre.emailmarketing.dto.UserOperationDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface ProductOwnerDaoI {
	//Author: Satyajeet and Amit
	public OwnerInformationWithProductDTO getProductDetials(Integer registerId, Integer startNo, Integer endNo, Connection con)throws DatabaseException;
	public SendMailDTO insertProductData(InsertProductDto dto, Connection con) throws DatabaseException;
	public Integer deleteProduct(Integer productId, Connection con) throws DatabaseException;
	public ProductDTOForProductOwner featchProductDetailsForUpdateProduct(Integer productId, Connection con) throws DatabaseException;
	public SendMailDTO sendMailToAddedServic(String[] serviceNo, Integer productId, Connection con) throws DatabaseException;
	public Integer updateProduct(ProductDTOForProductOwner dto,String imageName, Connection con) throws DatabaseException;
	public Map<String, Integer> getServiceOnwerDetails(Connection con) throws DatabaseException;
	public List<ServiceDTOForProductOwnerHomePage> getServiceDetails(Connection con)throws DatabaseException;
	//Author: Satyajeet and Amit
	//Author: Rajkumar and Hemanth
	public List<ProductOwnerNotificationDto> getNotificationsClick(Connection connection) throws DatabaseException;
	public List<ProductOwnerNotificationDto> getNotificationsBuy(Connection connection) throws DatabaseException;
	public List<ProductOwnerNotificationDto> getNotificationsCart(Connection connection) throws DatabaseException;
	public Integer getProductOwnetTotalNotificatons() throws DatabaseException;
	//Author: Rajkumar and Hemanth
	//Create Account:Rajkumar and Supriya start
	public int registerProductOwnerDetails(Connection connection,RegisterDto registerDto) throws DatabaseException;
	public Map<String, Integer> getCity(Connection connection,int cityId);
	public Map<String, Integer> getSate(Connection connection,int stateId);
	public Map<String, Integer> getCountry(Connection connection);
	//Create Account:Rajkumar and Supriya End
//Author: Harish
	public List<UserOperationDto> get_ProductOwnerName_OPerationTypecount(int operationtypeid,int  registerid) throws DatabaseException;
	public List<UserOperationDto> get_ServiceName_OperationType(int operationtypeid,int  registerid) throws DatabaseException ;
}
