package com.nacre.emailmarketing.service;

import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dto.InsertProductDto;
import com.nacre.emailmarketing.dto.OwnerInformationWithProductDTO;
import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.dto.ProductOwnerNotificationDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.ServiceDTOForProductOwnerHomePage;
import com.nacre.emailmarketing.dto.UserOperationDto;
import com.nacre.emailmarketing.exception.DatabaseException;

public interface ProductOwnerServiceI {
	//Author: Satyajeet and Amit
		public OwnerInformationWithProductDTO getProductDetials(Integer registerId, Integer pageNo)throws DatabaseException; 
		public Integer insertProduct(InsertProductDto dto);
		public Integer deleteProduct(Integer productId);
		public ProductDTOForProductOwner fetchProductForUpdate(Integer productId) throws DatabaseException; 
		public Integer sendMail(String[] serviceNo, Integer productId) throws DatabaseException, Exception;
		public Integer updateProduct(ProductDTOForProductOwner dto, String imageName) throws DatabaseException;
		public Map<String, Integer> getServiceOnwerDetails() throws DatabaseException; 
		public List<ServiceDTOForProductOwnerHomePage> getServiceDetails()throws DatabaseException;
		//Author: Satyajeet and Amit
		//Author: Rajkumar and Hemanth
		public List<ProductOwnerNotificationDto> getNotificationClick() throws DatabaseException;
		public List<ProductOwnerNotificationDto> getNotificationBuy() throws DatabaseException;
		public List<ProductOwnerNotificationDto> getNotificationCart() throws DatabaseException;
		public Integer getProductOwnerTotalNotificatons() throws DatabaseException;
		//Author: Rajkumar and Hemanth
		//Create Account:Rajkumar and Supriya start
		public boolean registerProductOwnerDetails(RegisterDto registerDto) throws DatabaseException;
		public Map<String, Integer> getCity(int cityId);
		public Map<String, Integer> getState(int stateId);
		public Map<String, Integer> getCountry();
		//Create Account:Rajkumar and Supriya end
	//Author: Harish
		public List<UserOperationDto> get_ProductOwnerName_OPerationTypecount(int operationtypeid,int  registerid) throws DatabaseException;
		public List<UserOperationDto> get_ServiceName_OperationType(int operationtypeid,int  registerid) throws DatabaseException ;
	//Author: Harish
}
