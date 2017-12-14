package com.nacre.emailmarketing.daoI;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.nacre.emailmarketing.dao.ProductOwnerDaoI;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dbutil.SQLQueryConstants;
import com.nacre.emailmarketing.dto.InsertProductDto;
import com.nacre.emailmarketing.dto.OwnerInformationWithProductDTO;
import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.dto.ProductOwnerNotificationDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.SendMailDTO;
import com.nacre.emailmarketing.dto.ServiceDTOForProductOwnerHomePage;
import com.nacre.emailmarketing.dto.UserOperationDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.util.IntegerConstants;
import com.nacre.emailmarketing.util.SaveImageUtil;
import com.nacre.emailmarketing.util.StringConstants;

public class ProductOwnerDaoImpl implements ProductOwnerDaoI {
	//Author: Satyajeet and Amit
		@Override
		public OwnerInformationWithProductDTO getProductDetials(Integer registerId,Integer startNo, Integer endNo, Connection con) throws DatabaseException {
			PreparedStatement ps=null,ps1=null;
			ResultSet rs=null,rs1=null;
			ProductDTOForProductOwner dto=null;
			List<ProductDTOForProductOwner> listDto=null;
			Integer totalPage=0;
			String ownerName=null;
			OwnerInformationWithProductDTO ownerDto=null;
			//Create PreparedStatement object
			try {
			  if(con!=null){
				  ps1=con.prepareStatement(SQLQueryConstants.GET_TOTAL_PAGE);
			  }
			  if(ps1!=null){
				  ps1.setInt(1, registerId);
				  rs1=ps1.executeQuery();
			  }
			  if(rs1!=null){
				  if(rs1.next()){
					  System.out.println(rs1.getInt(1));
					  totalPage=rs1.getInt(1)/16;
					  if(rs1.getInt(1)%16!=0){
						  totalPage+=1; 
					  }
				  }
			  }
			  System.out.println("Total Page"+totalPage);
			  if(con!=null){	
				ps=con.prepareStatement(SQLQueryConstants.GET_PROUDCT_DETAILS_FOR_PRODUCT_OWNER);
			  }
			  if(ps!=null){
				  ps.setInt(1, registerId);
				  ps.setInt(2, startNo);
				  ps.setInt(3, endNo);
				  rs=ps.executeQuery();
			  }
			  listDto=new ArrayList<>();
			  if(rs!=null){
				  while(rs.next()){
					  dto=new ProductDTOForProductOwner();
					  ownerName=rs.getString(1)+" "+rs.getString(2);
					  dto.setProductId(rs.getInt(3));
					  dto.setProudctName(rs.getString(4));
					 // Blob blob=rs.getBlob(2);
					 // dto.setImage(ImageUtil.encodeImage(blob.getBytes(1, (int)(blob.length()))));
					  dto.setImage(rs.getString(5));
					  dto.setPirce(rs.getInt(6));
					  dto.setProductType(rs.getString(7));
					  dto.setQuantity(rs.getInt(8));
					  listDto.add(dto);
				  }
			  }
			  //Set the value to OwnerDTP
			  ownerDto=new OwnerInformationWithProductDTO();
			  ownerDto.setOwnerName(ownerName);
			  ownerDto.setTatolPage(totalPage);
			  ownerDto.setListProductDto(listDto);
			  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DatabaseException();
			}
			
			return ownerDto;
		}
		
		@Override
		public SendMailDTO insertProductData(InsertProductDto dto, Connection con) throws DatabaseException {
			PreparedStatement ps=null;
			PreparedStatement ps1=null;
			Integer productId=0;
			ResultSet rs=null,rs1=null;
			SendMailDTO sendMailDto=null;
			Map<Integer, String> getMailsAndMailId=null;
			Map<Integer, Map<Integer, String>> getMailsFromServiceId=null;
			ArrayList<Integer> service=null;
			try{
				//Create PreparedStatement object
				if(con!=null){
					ps=con.prepareStatement(SQLQueryConstants.INSERT_PRODCUT_INFORMATION, PreparedStatement.RETURN_GENERATED_KEYS);
				}
				//Set the value to Query parameter and execute it
				if(ps!=null){
					ps.setString(1, dto.getProductName());
					//ps.setBlob(2, new ByteArrayInputStream(ImageUtil.decodeImage(dto.getImage())), (ImageUtil.decodeImage(dto.getImage())).length);
					ps.setString(2, dto.getImage());
					ps.setInt(3, dto.getProductPrice());
					ps.setString(4, dto.getProductType());
					ps.setInt(5, dto.getRegisterId());
					ps.setInt(6, dto.getQuantity());
					ps.setInt(7, IntegerConstants._UNREAD);
					ps.executeUpdate();
				}
				//Get the GeneratedKey
				if(ps!=null){
					rs=ps.getGeneratedKeys();
				}
				if(rs!=null){
					if(rs.next()){
						productId=rs.getInt(1);
					}
				}
				//save the image to the image folder
			//	SaveImageUtil.saveImage(dto.getImageName(), productId);
				SaveImageUtil.saveImageFromBase64(dto.getImage(), productId);
				//Create SendMailDto class object
				sendMailDto=new SendMailDTO();
				sendMailDto.setProductId(productId);
				sendMailDto.setImageName(dto.getImageName());
				sendMailDto.setProductName(dto.getProductName());
				sendMailDto.setProductType(dto.getProductType());
				sendMailDto.setPrice(dto.getProductPrice());
				//Create Map object
				getMailsFromServiceId=new TreeMap<>();
				//Create PreapredStatement for getting the mails
				if(con!=null){
					ps=con.prepareStatement(SQLQueryConstants.GET_MAILID_MAILS);
				}
				//Get the ServiceArrayList
				service=dto.getServices();
				//Execute the query
				for(Integer serviceId:service){
					if(ps!=null){
						ps.setInt(1, serviceId);
						rs1=ps.executeQuery();
					}
					getMailsAndMailId=new TreeMap<>();
					while(rs1.next()){
						getMailsAndMailId.put(rs1.getInt(1), rs1.getString(2));
					}
					getMailsFromServiceId.put(serviceId, getMailsAndMailId);
				}
				sendMailDto.setMailListwithServiceId(getMailsFromServiceId);
			}catch(SQLException se){
				se.printStackTrace();
				throw new DatabaseException();
			}	
			return sendMailDto;
		}

		@Override
		public Integer deleteProduct(Integer productId, Connection con) throws DatabaseException {
			PreparedStatement ps=null;
			try {
				if(con!=null){
					//Create PreparedStatement object
					ps=con.prepareStatement(SQLQueryConstants.DELETE_PRODUCT);
				}	
				//Set the query param and execute it
				if(ps!=null){
					ps.setInt(1, productId);
					ps.executeUpdate();
				}
		
			} catch (SQLException e) {
					e.printStackTrace();
				    throw new DatabaseException();
			}
			try{
				(new File(StringConstants.IMAGE_PATH+"\\"+productId+".png")).delete();
			}catch(Exception e){
				return 1;
			}
			
			return 1;
		}

		@Override
		public ProductDTOForProductOwner featchProductDetailsForUpdateProduct(Integer productId, Connection con) throws DatabaseException {
			PreparedStatement ps=null;
			ResultSet rs=null;
			ProductDTOForProductOwner dto=null;
			try{
				//Get the Prepared Statement
				if(con!=null){
					ps=con.prepareStatement(SQLQueryConstants.FEATCH_PRODUCT_FOR_UPDATE_PRODUCT);
				}
				//Set the value to query and execute
				if(ps!=null){
					ps.setInt(1, productId);
					rs=ps.executeQuery();
				}
				//Create DTO class object
				dto=new ProductDTOForProductOwner();
				if(rs!=null){
					if(rs.next()){
						dto.setProductId(rs.getInt(1));
						dto.setProudctName(rs.getString(2));
						dto.setImage(rs.getString(3));
						dto.setPirce(rs.getInt(4));
						dto.setProductType(rs.getString(5));
						dto.setQuantity(rs.getInt(6));
					}
				}
			}catch(SQLException se){
				se.printStackTrace();
				throw new DatabaseException();
			}	
			return dto;
		}

		@Override
		public SendMailDTO sendMailToAddedServic(String[] serviceNo, Integer productId, Connection con) throws DatabaseException {
			SendMailDTO sendMailDto=null;
			Map<Integer, String> getMailsAndMailId=null;
			Map<Integer, Map<Integer, String>> getMailsFromServiceId=null;
			PreparedStatement ps=null;
			ResultSet rs=null, rs1=null;
			try{
			//Get the product Details form productId
			if(con!=null){
				ps=con.prepareStatement(SQLQueryConstants.GET_PRODUCT_DETAISL_FROM_PRODUCTID_FOR_MAIL);
			}
			if(ps!=null){
				ps.setInt(1, productId);
				rs=ps.executeQuery();
			}
			sendMailDto=new SendMailDTO();
			if(rs!=null){
				if(rs.next()){
					sendMailDto.setProductName(rs.getString(1));
					sendMailDto.setPrice(rs.getInt(2));
					sendMailDto.setProductType(rs.getString(3));
				}
			}
			sendMailDto.setProductId(productId);
			//Create Map object
			getMailsFromServiceId=new TreeMap<>();
			//Create PreapredStatement for getting the mails
			if(con!=null){
				ps=con.prepareStatement(SQLQueryConstants.GET_MAILID_MAILS);
			}
			String[] array=serviceNo[0].split(",");
			/*Converting string array to integer arraty*/
			Integer[] service=new Integer[array.length];
		    int i=0;
		    for(String str:array){
		    	service[i]=Integer.parseInt(str);//Exception in this line
		        i++;
		    }
			
			//Execute the query
			for(Integer serviceId:service){
				if(ps!=null){
					ps.setInt(1, serviceId);
					rs1=ps.executeQuery();
				}
				getMailsAndMailId=new TreeMap<>();
				while(rs1.next()){
					getMailsAndMailId.put(rs1.getInt(1), rs1.getString(2));
				}
				getMailsFromServiceId.put(serviceId, getMailsAndMailId);
			}
			sendMailDto.setMailListwithServiceId(getMailsFromServiceId);
			}catch(SQLException se){
				se.printStackTrace();
				throw new DatabaseException();
			}
			return sendMailDto;
		}

		@Override
		public Integer updateProduct(ProductDTOForProductOwner dto,String imageName, Connection con) throws DatabaseException {
			PreparedStatement ps=null;
			//Create PreparedStatement3
			try{
			if(dto.getImage()!=null){
				ps=con.prepareStatement(SQLQueryConstants.UPDATE_PRODUCT);
				ps.setString(1, dto.getProudctName());
				ps.setString(2, dto.getImage());
				ps.setInt(3, dto.getPirce());
				ps.setString(4, dto.getProductType());
				ps.setInt(5, dto.getQuantity());
				ps.setInt(6, dto.getProductId());
				ps.executeUpdate();
			//	SaveImageUtil.saveImage(imageName, dto.getProductId());
				SaveImageUtil.saveImageFromBase64(dto.getImage(), dto.getProductId());
			}else{
				ps=con.prepareStatement(SQLQueryConstants.UPDATE_PRODUCT_WITHOUT_IMAGE);
				ps.setString(1, dto.getProudctName());
				ps.setInt(2, dto.getPirce());
				ps.setString(3, dto.getProductType());
				ps.setInt(4, dto.getQuantity());
				ps.setInt(5, dto.getProductId());
				ps.executeUpdate();
			}	
			
			}catch(SQLException se){
				se.printStackTrace();
				throw new DatabaseException(); 
			}
			return 1;
		}
		
		@Override
		public Map<String, Integer> getServiceOnwerDetails(Connection con) throws DatabaseException {
			Statement st=null;
			ResultSet rs=null;
			Map<String, Integer> map=null;
			try{
				if(con!=null){
					//Create Statement object
					st=con.createStatement();
				}
				if(st!=null){
					//Create ResultSet object
					rs=st.executeQuery(SQLQueryConstants.GET_SERVICE_OWNER_FOR_PRODUCT_OWNER);
				}
				//Create map class object
				map=new TreeMap<>();
				if(rs!=null){
					while(rs.next()){
						map.put(rs.getString(2), rs.getInt(1));
					}
				}
			}catch(SQLException se){
				throw new DatabaseException();
			}	
			return map;
		}

		@Override
		public List<ServiceDTOForProductOwnerHomePage> getServiceDetails(Connection con) throws DatabaseException {
			PreparedStatement ps=null;
			ResultSet rs=null;
			List<ServiceDTOForProductOwnerHomePage> listDto=null;
			ServiceDTOForProductOwnerHomePage dto=null;
			try{
			//Get the PreparedStatement object
			if(con!=null){
				ps=con.prepareStatement(SQLQueryConstants.GET_SERVICE_INFORMATION);
			}
			if(ps!=null){
				ps.executeQuery();
				rs=ps.executeQuery();
			}
			listDto=new ArrayList<>();
			if(rs!=null){
				while(rs.next()){
					dto=new ServiceDTOForProductOwnerHomePage();
					dto.setServiceName(rs.getString(1));
					dto.setCompanyName(rs.getString(2));
					dto.setOwnerName(rs.getString(3)+" "+rs.getString(4));
					dto.setTotalMails(rs.getInt(5));
					listDto.add(dto);
				}
			}
			}catch(SQLException se){
				se.printStackTrace();
				throw new DatabaseException();
			}
			return listDto;
		}
		//Author: Satyajeet and Amit
		//Author: Rajkumar and Hemanth
		@Override
		public List<ProductOwnerNotificationDto> getNotificationsClick(Connection connection) throws DatabaseException {
			Statement statement=null;
			ResultSet resultSet=null;
			ProductOwnerNotificationDto productOwnerNotificationDto=null;
			List<ProductOwnerNotificationDto> list=null;
				try {
					if(connection!=null){
						//Create PreparedStatement object
						statement=connection.createStatement();
					}
					if(statement!=null){
						resultSet=statement.executeQuery(SQLQueryConstants.GET_NOTIFICATIONS_CLICK);
					}
					//Create DTO class object and store the resultSet value to the DTO
					productOwnerNotificationDto=new ProductOwnerNotificationDto();
					System.out.println("Result:"+resultSet);
					if(resultSet!=null){
						list=new ArrayList<ProductOwnerNotificationDto>();
						while(resultSet.next()){
							productOwnerNotificationDto=new ProductOwnerNotificationDto();
							productOwnerNotificationDto.setProductName(resultSet.getString(1)+" "+resultSet.getString(2));
							productOwnerNotificationDto.setProductRegisteredDate(resultSet.getDate(3));
							productOwnerNotificationDto.setMailId(resultSet.getString(4));
							list.add(productOwnerNotificationDto);
						}
					}//if
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("Database Problem");
				}//try-catch
				//close Connections
				finally {
					if(resultSet!=null){
						try {
							resultSet.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(statement!=null){
						try {
							statement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}//finally
		}//method(-,-)
		@Override
		public List<ProductOwnerNotificationDto> getNotificationsBuy(Connection connection) throws DatabaseException {
			Statement statement=null;
			ResultSet resultSet=null;
			ProductOwnerNotificationDto productOwnerNotificationDto=null;
			List<ProductOwnerNotificationDto> list=null;
				try {
					if(connection!=null){
						//Create PreparedStatement object
						statement=connection.createStatement();
					}
					if(statement!=null){
						resultSet=statement.executeQuery(SQLQueryConstants.GET_NOTIFICATIONS_BUY);
					}
					//Create DTO class object and store the resultSet value to the DTO
					productOwnerNotificationDto=new ProductOwnerNotificationDto();
					System.out.println("Result:"+resultSet);
					if(resultSet!=null){
						list=new ArrayList<ProductOwnerNotificationDto>();
						while(resultSet.next()){
							productOwnerNotificationDto=new ProductOwnerNotificationDto();
							productOwnerNotificationDto=new ProductOwnerNotificationDto();
							productOwnerNotificationDto.setProductName(resultSet.getString(1));
							productOwnerNotificationDto.setProductRegisteredDate(resultSet.getDate(2));
							productOwnerNotificationDto.setFullName(resultSet.getString(3)+" "+resultSet.getString(4));
							productOwnerNotificationDto.setContactNumber(resultSet.getLong(5));
							productOwnerNotificationDto.setMailId(resultSet.getString(6));
							productOwnerNotificationDto.setAddress(resultSet.getString(7));
							list.add(productOwnerNotificationDto);
						}
					}//if
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("Database Problem");
				}//try-catch
				//close Connections
				finally {
					if(resultSet!=null){
						try {
							resultSet.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(statement!=null){
						try {
							statement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}//finally
		}//method(-,-)
		@Override
		public List<ProductOwnerNotificationDto> getNotificationsCart(Connection connection) throws DatabaseException {
			Statement statement=null;
			ResultSet resultSet=null;
			ProductOwnerNotificationDto productOwnerNotificationDto=null;
			List<ProductOwnerNotificationDto> list=null;
				try {
					if(connection!=null){
						//Create PreparedStatement object
						statement=connection.createStatement();
					}
					if(statement!=null){
						resultSet=statement.executeQuery(SQLQueryConstants.GET_NOTIFICATIONS_CART);
					}
					//Create DTO class object and store the resultSet value to the DTO
					productOwnerNotificationDto=new ProductOwnerNotificationDto();
					System.out.println("Result:"+resultSet);
					if(resultSet!=null){
						list=new ArrayList<ProductOwnerNotificationDto>();
						while(resultSet.next()){
							productOwnerNotificationDto=new ProductOwnerNotificationDto();
							productOwnerNotificationDto=new ProductOwnerNotificationDto();
							productOwnerNotificationDto.setProductName(resultSet.getString(1));
							productOwnerNotificationDto.setProductRegisteredDate(resultSet.getDate(2));
							productOwnerNotificationDto.setFullName(resultSet.getString(3)+" "+resultSet.getString(4));
							productOwnerNotificationDto.setContactNumber(resultSet.getLong(5));
							productOwnerNotificationDto.setMailId(resultSet.getString(6));
							productOwnerNotificationDto.setAddress(resultSet.getString(7));
							list.add(productOwnerNotificationDto);
						}
					}//if
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException("Database Problem");
				}//try-catch
				//close Connections
				finally {
					if(resultSet!=null){
						try {
							resultSet.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(statement!=null){
						try {
							statement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}//finally
		}//method(-,-)
		@Override
		public Integer getProductOwnetTotalNotificatons() throws DatabaseException {
			ResultSet rs=null;
			Statement statement=null;
			Connection connection=null;
			int i=0;
			try{
				//Create connection Obj
				connection=DbUtil.getConnection();
				//Create Statement object
				if(connection!=null)
					statement=connection.createStatement();
				//Get the ResultSet object
				if(statement!=null)
					rs=statement.executeQuery(SQLQueryConstants.GET_PRODUCTOWNER_TOTAL_NOTIFICATONS);
				//Create map class obect
				//Store the resultSet class value to map and return the map
				if(rs!=null){
					while(rs.next()){
						i= rs.getInt(1);
					}//while
				}//if	
				return i;
			}catch(SQLException se){
				se.printStackTrace();
				throw new DatabaseException("Executing query Problem");
			}//try-catch
		}//method
		//Author: Rajkumar and Hemanth
		//Create Account:Rajkumar and Supriya start	
		@Override
		public int registerProductOwnerDetails(Connection connection,RegisterDto registerDto) throws DatabaseException {
			String emailId=null,password=null,address=null,firstName=null,lastName=null,companyName=null;
			Long contactNumber=0L;
			int cityId=0,addressId=0,registerId=0;
			Statement statement=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			int loginId=0;
			try{
				//get DTO Values
				emailId=registerDto.getLdto().getUserName();
				password=registerDto.getLdto().getPassword();
				address=registerDto.getAddressDto().getAddress();
				cityId=registerDto.getAddressDto().getCityId();
				firstName=registerDto.getFname();
				lastName=registerDto.getLname();
				companyName=registerDto.getCompanyName();
				//Set connection to setAutoCommit(false)
				connection.setAutoCommit(false);
				//Insert Details into Login Table
				if(connection!=null){
					preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_LOGIN_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
					preparedStatement.setString(1,emailId);
					preparedStatement.setString(2,password);
					preparedStatement.setInt(3,IntegerConstants._PRODUCTOWNER);
					preparedStatement.executeUpdate();
				}//if
				resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet!=null){
					while(resultSet.next()){
						loginId=resultSet.getInt(1);
						registerDto.setLoginId(loginId);
					}//while
				}//if
				//Insert Details into Address Table
				if(connection!=null){
					preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_ADDRESS_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
					preparedStatement.setString(1,address);
					preparedStatement.setInt(2, cityId);
					preparedStatement.executeUpdate();
				}//if
				resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet!=null){
					while(resultSet.next()){
						addressId=resultSet.getInt(1);
						registerDto.setAddressId(addressId);
					}//while
				}//if
				//Insert Details into Register Table
				if(connection!=null){
					preparedStatement=connection.prepareStatement(SQLQueryConstants.INSERT_REGISTGER_DETAILS,PreparedStatement.RETURN_GENERATED_KEYS);
					preparedStatement.setString(1,firstName);
					preparedStatement.setString(2,lastName);
					preparedStatement.setString(3,companyName);
					preparedStatement.setInt(4, loginId);
					preparedStatement.setInt(5, addressId);
					preparedStatement.setLong(6, contactNumber);
					preparedStatement.executeUpdate();
				}//if
				resultSet=preparedStatement.getGeneratedKeys();
				if(resultSet!=null){
					while(resultSet.next()){
						registerId=resultSet.getInt(1);
						registerDto.setRegisterId(registerId);
					}//while
				}//if
				if(registerId!=-1)
					connection.commit();
				else
					connection.rollback();
				return registerId;
			}catch (Exception e){ 
				try {
					e.printStackTrace();
					if(connection!=null)
						connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new DatabaseException("Rollback Not Performed");
				}//try-catch
				return -1;
			}//try-catch
			finally{
				try {
					if(resultSet!=null)
							resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(statement!=null)
							statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(preparedStatement!=null)
							preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
		}//finally
		}//registerUserDetails(-,-)
		@Override
		public Map<String, Integer> getCity(Connection connection,int cityId) {
			Map<String , Integer> map=null;
			Statement statement=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			try{
				//Get Cities from City Table
				if(connection!=null){
					preparedStatement=connection.prepareStatement(SQLQueryConstants.GET_CITY_ALL);
					preparedStatement.setInt(1,cityId);
					resultSet=preparedStatement.executeQuery();
				}
				if(resultSet!=null){
					map=new TreeMap<String,Integer>();
					while(resultSet.next()){
						map.put(resultSet.getString(2),resultSet.getInt(1));
					}//while
				}//if
			}catch (Exception e){ 
			}//try-catch
			//Close Connections
			finally{
				try {
					if(resultSet!=null)
							resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(preparedStatement!=null)
							preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(connection!=null)
							connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
		}//finally
		return map;
		}//getCity(-)
		@Override
		public Map<String, Integer> getSate(Connection connection, int stateId) {
			Map<String , Integer> map=null;
			Statement statement=null;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			try{
				//Get Cities from City Table
				if(connection!=null){
					preparedStatement=connection.prepareStatement(SQLQueryConstants.GET_STATE_ALL);
					preparedStatement.setInt(1,stateId);
					resultSet=preparedStatement.executeQuery();
				}
				if(resultSet!=null){
					map=new TreeMap<String,Integer>();
					while(resultSet.next()){
						map.put(resultSet.getString(2),resultSet.getInt(1));
					}//while
				}//if
			}catch (Exception e){ 
			}//try-catch
			//Close Connections
			finally{
				try {
					if(resultSet!=null)
							resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(preparedStatement!=null)
							preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(connection!=null)
							connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
		}//finally
		return map;
		}//getState(-)
		@Override
		public Map<String, Integer> getCountry(Connection connection) {
			Map<String , Integer> map=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try{
				//Get Country from Country Table
				if(connection!=null){
					statement=connection.createStatement();
					resultSet=statement.executeQuery(SQLQueryConstants.GET_COUNTRY_ALL);
				}
				if(resultSet!=null){
					map=new TreeMap<String,Integer>();
					while(resultSet.next()){
						map.put(resultSet.getString(2),resultSet.getInt(1));
					}//while
				}//if
			}catch (Exception e){ 
			}//try-catch
			//Close Connections
			finally{
				try {
					if(resultSet!=null)
							resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(statement!=null)
							statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
				try {
					if(connection!=null)
							connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}//try-catch
		}//finally
		return map;
		}//getCountry(-)
		//Create Account:Rajkumar and Supriya End
		//Author Harish

			public List<com.nacre.emailmarketing.dto.UserOperationDto> get_ProductOwnerName_OPerationTypecount(int operationtypeid,int registerid) throws DatabaseException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserOperationDto> operationList1 = null;
		
		UserOperationDto udto = null;
		try {

			operationList1 = new ArrayList<UserOperationDto>();
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			//Create PreparedStatement object
			ps = con.prepareStatement(SQLQueryConstants.get_ProductOwnerName_OPerationType);
			//set loginId to the query param and execute it
			if (ps != null) {
				ps.setInt(1,operationtypeid);
				ps.setInt(2,registerid);
				rs = ps.executeQuery();
			}
				while (rs.next()) {

					udto = new UserOperationDto();
					udto.setOperationtypeproductcount(rs.getInt(1));
					udto.setProductownername(rs.getString(2));
					
					System.out.println("Operationtype count based on product owner clk : " + rs.getInt(1));
					System.out.println("product owner Name: " + rs.getString(2));
					System.out.println("Register Id: " + registerid);
					operationList1.add(udto);
				}
			
			return operationList1;
		
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Database Problem");
		}
	}
	
	public List<UserOperationDto> get_ServiceName_OperationType(int operationtypeid,int registerid) throws DatabaseException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserOperationDto> operationList2 = null;
		UserOperationDto udto = null;
		try {

			operationList2 = new ArrayList<UserOperationDto>();
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			//Create PreparedStatement object
			ps = con.prepareStatement(SQLQueryConstants.get_ServiceName_OperationType);
			//set loginId to the query param and execute it
			if (ps != null) {
				ps.setInt(1,operationtypeid);
				ps.setInt(2,registerid);
				rs = ps.executeQuery();
			}
				while (rs.next()) {

					udto = new UserOperationDto();
					udto.setOperationtypeservicecount(rs.getInt(1));
					udto.setServicename(rs.getString(2));
					
					System.out.println("Operationtype count based on service name clk : " + rs.getInt(1));
					System.out.println("Service Name: " + rs.getString(2));
					System.out.println("Register Id: " + registerid);
					
					operationList2.add(udto);
				}
			
			return operationList2;
		
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Database Problem");
		}
	}
	//Author Harish

}
