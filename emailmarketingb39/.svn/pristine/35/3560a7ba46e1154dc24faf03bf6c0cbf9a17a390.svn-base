package com.nacre.emailmarketing.serviceI;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.dao.ProductOwnerDaoI;

import com.nacre.emailmarketing.dao.UserDaoI;
import com.nacre.emailmarketing.daoI.ProductOwnerDaoImpl;

import com.nacre.emailmarketing.daoI.UserDaoImpl;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dto.InsertProductDto;
import com.nacre.emailmarketing.dto.OwnerInformationWithProductDTO;
import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.dto.ProductOwnerNotificationDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.SendMailDTO;
import com.nacre.emailmarketing.dto.ServiceDTOForProductOwnerHomePage;
import com.nacre.emailmarketing.dto.UserOperationDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.util.SendMailUtil;

public class ProductOwnerServiceImpl implements ProductOwnerServiceI {
	//Author: Satyajeet and Amit
		@Override
		public OwnerInformationWithProductDTO getProductDetials(Integer registerId, Integer pageNo)
				throws DatabaseException {
			ProductOwnerDaoI dao=new ProductOwnerDaoImpl();
			return dao.getProductDetials(registerId, ((pageNo-1)*16),16, DbUtil.getConnection());
		}
		
		@Override
		public Integer insertProduct(InsertProductDto dto) {
			ProductOwnerDaoI dao=null;
			Connection con=null;
			SendMailDTO sendMailDto=null;
			Integer count=0;
			try{
			//Create connection class object
			con=DbUtil.getConnection();
			//Create DAO class object
			dao=new ProductOwnerDaoImpl();
			//call the method
			sendMailDto=dao.insertProductData(dto, con);
			DbUtil.closeConnection(con);
			if(sendMailDto.getMailListwithServiceId().size()==1){
				return 1;
			}
			
			
			SendMailUtil mail=new SendMailUtil();
			 count=mail.sendGmail(sendMailDto,sendMailDto.getProductId());
			}catch(DatabaseException de){
				de.printStackTrace();
				return 0;
			}
			if(count==0){
				return 3;
			}else if(count==1){
				return 4;
			}else{
				return 1;
			}	
		}

		@Override
		public Integer deleteProduct(Integer productId) {
			Connection con=null;
			ProductOwnerDaoI dao=null;
			Integer count=0;
			try {
				//CreateConnection
				con=DbUtil.getConnection();
				//Create DAO class object
				dao=new ProductOwnerDaoImpl();
				count=dao.deleteProduct(productId, con);
				//Close the connection
				DbUtil.closeConnection(con);
				return count;
			} catch (DatabaseException e) {
				e.printStackTrace();
				return 0;
			}
			
		}

		@Override
		public ProductDTOForProductOwner fetchProductForUpdate(Integer productId) throws DatabaseException {
			Connection con=null;
			ProductOwnerDaoI dao=null;
			//Create Database connection
			con=DbUtil.getConnection();
			dao=new ProductOwnerDaoImpl();
			ProductDTOForProductOwner dto=dao.featchProductDetailsForUpdateProduct(productId, con);
			DbUtil.closeConnection(con);	
			return dto;
		}

		@Override
		public Integer sendMail(String[] serviceNo, Integer productId) throws DatabaseException, Exception {
			//Create connection object
			Connection con=null;
			ProductOwnerDaoI dao=null;
			SendMailDTO sendMailDto=null;
			//Create Database connection
			con=DbUtil.getConnection();
			dao=new ProductOwnerDaoImpl();
			sendMailDto=dao.sendMailToAddedServic(serviceNo, productId, con);
			SendMailUtil mail=new SendMailUtil();
			Integer count=mail.sendGmail(sendMailDto,sendMailDto.getProductId());
			if(count==0){
				return 0;
			}else{
				return 1;
			}
		}

		@Override
		public Integer updateProduct(ProductDTOForProductOwner dto, String imageName) throws DatabaseException {
			ProductOwnerDaoI dao=null;
			Connection con=null;
			//Create Connection object
			con=DbUtil.getConnection();
			//Create DAO class object
			dao=new ProductOwnerDaoImpl();
			return dao.updateProduct(dto,imageName, con);
			
		}
		public Map<String, Integer> getServiceOnwerDetails() throws DatabaseException{
			Connection con=null;
			Map<String, Integer> map=null;
			ProductOwnerDaoI dao=null;
			//Get the connection Object
			con=DbUtil.getConnection();
			//Create DAO class object
			dao=new ProductOwnerDaoImpl();
			map=dao.getServiceOnwerDetails(con);
			//Close the connection
			DbUtil.closeConnection(con);
			return map;
		}

		@Override
		public List<ServiceDTOForProductOwnerHomePage> getServiceDetails() throws DatabaseException {
			Connection con=null;
			ProductOwnerDaoI dao=null;
			//Get the connection
			con=DbUtil.getConnection();
			dao=new ProductOwnerDaoImpl();
			return dao.getServiceDetails(con);
		}
		//Author: Satyajeet and Amit
		
		//Author:Harish
		@Override
	public List<UserOperationDto> get_ProductOwnerName_OPerationTypecount(int operationtypeid,int  registerid) throws DatabaseException {
		ProductOwnerDaoI svpd = new ProductOwnerDaoImpl();
		return svpd.get_ProductOwnerName_OPerationTypecount(operationtypeid,registerid);
		}
		@Override
		public List<UserOperationDto> get_ServiceName_OperationType(int operationtypeid, int  registerid) throws DatabaseException {
			ProductOwnerDaoI svpd = new ProductOwnerDaoImpl();
			return svpd.get_ServiceName_OperationType(operationtypeid,registerid);
		}
		//Author: Rajkumar and Hemanth
		//Create Account:Rajkumar and Supriya start
		@Override
		public boolean registerProductOwnerDetails(RegisterDto registerDto) throws DatabaseException {
			Connection connection=null;
			ProductOwnerDaoI productOwnerDaoI=null;
			
			//Create Connection
			connection=DbUtil.getConnection();
			//Create DAO obj
			productOwnerDaoI=new ProductOwnerDaoImpl();
			if(productOwnerDaoI.registerProductOwnerDetails(connection, registerDto)==-1)
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
		@Override
		public List<ProductOwnerNotificationDto>getNotificationClick() throws DatabaseException {
			ProductOwnerDaoI productOwnerNotificationDao=null;
			ProductOwnerNotificationDto productOwnerNotificationDto=null;
			Connection connection=null;


			//Create Connection Object
			connection=DbUtil.getConnection();
			//create Dao class obj
			productOwnerNotificationDao=new ProductOwnerDaoImpl();
			return productOwnerNotificationDao.getNotificationsClick(connection);
		}//method(-)
		public List<ProductOwnerNotificationDto> getNotificationBuy() throws DatabaseException {
			ProductOwnerDaoI productOwnerNotificationDao=null;
			ProductOwnerNotificationDto productOwnerNotificationDto=null;
			Connection connection=null;

			//Create Connection Object
			connection=DbUtil.getConnection();
			//create Dao class obj
			productOwnerNotificationDao=new ProductOwnerDaoImpl();
			return productOwnerNotificationDao.getNotificationsBuy(connection);
		}//method(-)
		public List<ProductOwnerNotificationDto> getNotificationCart() throws DatabaseException {
			ProductOwnerDaoI productOwnerNotificationDao=null;
			ProductOwnerNotificationDto productOwnerNotificationDto=null;
			Connection connection=null;

			//Create Connection Object
			connection=DbUtil.getConnection();
			//create Dao class obj
			productOwnerNotificationDao=new ProductOwnerDaoImpl();
			return productOwnerNotificationDao.getNotificationsCart(connection);
		}//method(-)
		@Override
		public Integer getProductOwnerTotalNotificatons() throws DatabaseException {
			ProductOwnerDaoI productOwnerDaoI=null;
			//create DAO class object
			productOwnerDaoI=new ProductOwnerDaoImpl();
			//Call the DAO class method
			return productOwnerDaoI.getProductOwnetTotalNotificatons();
		}
		//Author: Rajkumar and Hemanth
}//class