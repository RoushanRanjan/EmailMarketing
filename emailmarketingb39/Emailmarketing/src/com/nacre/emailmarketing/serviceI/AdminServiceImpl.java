package com.nacre.emailmarketing.serviceI;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.nacre.emailmarketing.daoI.AdminDaoImpl;
import com.nacre.emailmarketing.dbutil.DbUtil;
import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.PieChartDetails;
import com.nacre.emailmarketing.formbean.ServiceDetailsDto;
import com.nacre.emailmarketing.formbean.TrackingDto;
import com.nacre.emailmarketing.service.AdminServiceI;

public class AdminServiceImpl implements AdminServiceI {
	Connection con=null;

       
	@Override
	public String checkUpdation(OperationtypeDto otd) throws DatabaseException {
		
		System.out.println("hiiiiiiiiiiiiiiiii");
		try{
			con=DbUtil.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Integer operationtypeId=otd.getOperationTypeId();
		Double price=otd.getPrice();
	AdminDaoImpl dao=new AdminDaoImpl();
	String status=dao.checkUpdate(con,otd);
	
	System.out.println("dao close");
	return status;

	}


	@Override
	public List<PieChartDetails> clickedViewServiceProcess(int a) throws DatabaseException, SQLException {

			AdminDaoImpl admin=null;
			// create the List object
			 List<ServiceDetailsDto> serList=null;
			 List<TrackingDto> noList=null;
			// for the database process  creating the daoi class object
			// Here there is no operation to perform bussiness logic so pass the control
			admin=new AdminDaoImpl();
			// create the Map object
			List<PieChartDetails> listPie=new ArrayList();
			serList= admin.clickedViewAdminDao();
			 // add the no of clicked user in a service
			 noList= admin.no_Of_Clicked_User(a);
			 // service details array
			 ServiceDetailsDto serdt[]=new ServiceDetailsDto[serList.size()];
			 // user details array
			 TrackingDto[] tracdto=new TrackingDto[ noList.size()];
			 // comapring the id and placing the user
			 for(int i=0;i<serList.size();i++){
				 serdt[i]=serList.get(i);
			 }
			 for(int i=0;i< noList.size();i++){
				 tracdto[i]= noList.get(i);
			 }
			 System.out.println(Arrays.toString(tracdto));
			 
			 // now compare and set int the form bean
			 for(int i=0;i<serdt.length;i++){
				 int count=0;
				    for(int j=0;j<tracdto.length;j++){
				   if(serdt[i].getServiceId()==tracdto[j].getServiceId()){
					   PieChartDetails pie=new PieChartDetails();
					   pie.setServiceName(serdt[i].getServiceName());
					   pie.setUserEvent(tracdto[j].getClickOption());
					   // add to the list
					   listPie.add(pie);
					   j=tracdto.length;
					   count=count+1;
				   }//if
				    }
					   if(count==0){
					   PieChartDetails pie=new PieChartDetails();
					   pie.setServiceName(serdt[i].getServiceName());
					   pie.setUserEvent(0);
					   // add to the list
					   listPie.add(pie);
					   
					   }
					   
				   //else
				    //for
				   /* else{
				    	 PieChartDetails pie=new PieChartDetails();
						   pie.setServiceName(serdt[i].getServiceName());
						   pie.setUserEvent(0);
						   // add to the list
						   listPie.add(pie);
					   
				    	
				    }*/
			 }//for
			 // now set this map to the List collection object
			 System.out.println(listPie);
			 return listPie;
		}

	
	//code by sagar

	  AdminDaoImpl adminDaoImpl = null;
	  
	  public Map adminNotification(int type) {
			// TODO Auto-generated method stub
			adminDaoImpl = new  AdminDaoImpl();
			if(type==1) {
				System.out.println("hiiiiiiiiiiiii Service"+adminDaoImpl.productNotification() );
				return adminDaoImpl.productNotification();
			}
			else if(type==2) {
				return adminDaoImpl.servicesNotification();
			}
			else if(type==3) {
				return adminDaoImpl.userNotification();
			}
			return null;
		}
		@Override
		public Object NotificationDetail(int type, int key) {
			// TODO Auto-generated method stub
			adminDaoImpl = new  AdminDaoImpl();
			if(type==1) {
				System.out.println("hiiiiiiiiiiiii Service"+type+"  "+  key );
				return adminDaoImpl.productDetail(key);
				
			}
			else if(type==2) {
				return adminDaoImpl.serviceDetail(key);
			}
			else if(type==3) {
				System.out.println(adminDaoImpl.userDetail(key));
				return  adminDaoImpl.userDetail(key);
			}
			return null;
		}
		@Override
		public int changeStatusType(int type, int key) {
			// TODO Auto-generated method stub
			
			adminDaoImpl = new  AdminDaoImpl();
			if(type==1) {
				System.out.println("hiiiiiiiiiiiii Service"+type+"  "+  key );
				return adminDaoImpl.updateProductStatuse(key);
				
			}
			else if(type==2) {
				return adminDaoImpl.updateServiceStatuse(key);
			}
			else if(type==3) {
				System.out.println(adminDaoImpl.updateUserStatuse(key));
				return  adminDaoImpl.updateUserStatuse(key);
			}
			return 0 ;
		}
		@Override
		public int countNotification() {
			// TODO Auto-generated method stub
			int count = 0;
			adminDaoImpl = new  AdminDaoImpl();
			count = adminDaoImpl.countProduct()+adminDaoImpl.countServices()+adminDaoImpl.countOperation();
			return count;
		}
		
}
