package com.nacre.emailmarketing.dbutil;

/**
 * This class contains declaration of all the sql query constants , which are
 * going to be used in Data Access Object classes.
 * 
 * @version 1.0.0 9th July 2014
 * @author Nacre Batch 19 Java
 * 
 */
public class SQLQueryConstants {
	/*......................viewServices.............wasik&junaid .............................start..............*/
	public static final String serviceQuery="select * from tbl_service";
 	public static final String DeleteService="delete from tbl_service where tbl_service.serviceid=?;";
 	public static final String emails="select tbl_maillist.mailid ,tbl_maillist.mails  from  tbl_maillist ,tbl_service where tbl_service.serviceid=tbl_maillist.tbl_service_serviceid and tbl_service.serviceid=?";
 	/*......................viewServices.............wasik&junaid .............................end.............*/
 	
 	
 	
 	/*...........productOwenerNotification..................Rajkumar & HemanthRao.......................start...................*/
	public static final String GET_NOTIFICATIONS_CLICK="SELECT productname,producttype,operationdate,mails from tbl_operation INNER JOIN tbl_product on tbl_product_productid=productid INNER JOIN tbl_maillist on tbl_maillist_mailid=mailid where tbl_operationtype_operationtypeId=1;";
	public static final String GET_NOTIFICATIONS_BUY="select p.productname,o.operationDate,r.fname,r.lname,r.contact_no,m.mails,a.address from tbl_operation o INNER JOIN tbl_maillist m on o.tbl_maillist_mailid=m.mailid inner join tbl_usermail u on u.tbl_maillist_mailid=m.mailid INNER JOIN tbl_login l on u.tbl_login_loginid=l.loginid INNER join tbl_register r on l.loginid=r.loginid INNER join tbl_product p on o.tbl_product_productid=p.productid INNER JOIN tbl_addrss a on a.addressid=r.addressid where o.tbl_operationtype_operationtypeId=2";
	public static final String GET_NOTIFICATIONS_CART="select p.productname,o.operationDate,r.fname,r.lname,r.contact_no,m.mails,a.address from tbl_operation o INNER JOIN tbl_maillist m on o.tbl_maillist_mailid=m.mailid inner join tbl_usermail u on u.tbl_maillist_mailid=m.mailid INNER JOIN tbl_login l on u.tbl_login_loginid=l.loginid INNER join tbl_register r on l.loginid=r.loginid INNER join tbl_product p on o.tbl_product_productid=p.productid INNER JOIN tbl_addrss a on a.addressid=r.addressid where o.tbl_operationtype_operationtypeId=3";
	public static final String GET_PRODUCTOWNER_TOTAL_NOTIFICATONS="SELECT COUNT(*) FROM TBL_OPERATION;";
	/*...........productOwenerNotification..................Rajkumar & HemanthRao.......................end..................*/
	
	
	
 
	 
	 
	 
	 
	/*..............View_productDetails................riyaz&rohit.............start..................*/
	public static final String INSERT_OPERATION_TABLE = "INSERT INTO tbl_operation(operationDate, tbl_operationtype_operationtypeId,tbl_product_productid,tbl_maillist_mailid,statusId) VALUES(?,?,?,?,?)";
	public static final String GET_OPERATIONTYPE_ID = "SELECT operationtypeid FROM tbl_operationtype where operation=? ";
	public static final String GET_SYSDATE = "SELECT SYSDATE FROM DUAL";
	public static final String GET_PRODUCT_DETAILS = "SELECT productname,image,productprice,producttype,quantity FROM tbl_product WHERE PRODUCTID=?";
	public static final String GET_MAIL_ID="SELECT mailid from tbl_maillist where mails=?";
	public static final String GET_STATUS_ID="SELECT statusId from tbl_status where status=?";
	/*..............View_productDetails................riyaz&rohit.............end..................*/
	
	
	
	/*..............Add/edit/view/product/chooseServices............Satyajeet&Amit.............start...............*/
		public static String GET_SERVICE_OWNER_FOR_PRODUCT_OWNER="SELECT SERVICEID, SERVICENAME FROM TBL_SERVICE";
		public static String INSERT_PRODCUT_INFORMATION="INSERT INTO TBL_PRODUCT(PRODUCTNAME, IMAGE, PRODUCTPRICE, PRODUCTTYPE, OWNER_REGISTERID, QUANTITY, STATUSID) VALUES (?,?,?,?,?,?,?)";
		public static String GET_MAILID_MAILS="SELECT MAILID, MAILS FROM TBL_MAILLIST WHERE TBL_SERVICE_SERVICEID=?";
		public static String GET_PROUDCT_DETAILS_FOR_PRODUCT_OWNER="SELECT FNAME, LNAME, PRODUCTID,PRODUCTNAME, IMAGE, PRODUCTPRICE, PRODUCTTYPE, QUANTITY FROM TBL_PRODUCT INNER JOIN TBL_REGISTER ON REGISTERID=OWNER_REGISTERID WHERE OWNER_REGISTERID=? ORDER BY PRODUCTID DESC LIMIT ?,?";
		public static String GET_TOTAL_PAGE="SELECT COUNT(*) FROM TBL_PRODUCT WHERE OWNER_REGISTERID=?";
		public static String DELETE_PRODUCT="DELETE FROM TBL_PRODUCT WHERE PRODUCTID=?";
		public static String FEATCH_PRODUCT_FOR_UPDATE_PRODUCT="SELECT PRODUCTID,PRODUCTNAME, IMAGE, PRODUCTPRICE, PRODUCTTYPE, QUANTITY FROM TBL_PRODUCT WHERE PRODUCTID=?";
		public static String UPDATE_PRODUCT="UPDATE TBL_PRODUCT SET PRODUCTNAME=?, IMAGE=?, PRODUCTPRICE=?, PRODUCTTYPE=?, QUANTITY=? WHERE PRODUCTID=?";
		public static String GET_PRODUCT_DETAISL_FROM_PRODUCTID_FOR_MAIL="SELECT PRODUCTNAME, PRODUCTPRICE, PRODUCTTYPE FROM TBL_PRODUCT WHERE PRODUCTID=?";
		public static String UPDATE_PRODUCT_WITHOUT_IMAGE="UPDATE TBL_PRODUCT SET PRODUCTNAME=?, PRODUCTPRICE=?, PRODUCTTYPE=?, QUANTITY=? WHERE PRODUCTID=?";	
		public static String GET_SERVICE_INFORMATION="SELECT SERVICENAME, COMPANYNAME, FNAME, LNAME, COUNT(*) FROM TBL_SERVICE INNER JOIN TBL_REGISTER ON REGISTERID=TBL_REGISTER_REGISTERID INNER JOIN TBL_MAILLIST ON SERVICEID=TBL_SERVICE_SERVICEID GROUP BY TBL_SERVICE_SERVICEID ORDER BY RAND() LIMIT 4";
		/*..............Addproduct/chooseServices............Satyajeet&Amit.............end...............*/



/*.................login................varaprasad.................start........*/

public static final String CHECK_LOGIN_DETAILS = "SELECT COUNT(*),LOGINID,TBL_ROLE_ROLEID FROM TBL_LOGIN WHERE USERNAME=? AND PASSWORD=?";
	public static final String GET_REGISTERID = "SELECT REGISTERID FROM TBL_REGISTER WHERE LOGINID=?";
	public static final String GET_PASSWORD="SELECT PASSWORD FROM TBL_LOGIN WHERE USERNAME=?";

/*.................login................varaprasad.................end........*/

 
	/*..................userTracking..............harish......................start.........................*/

	public static final String get_ProductOwnerName_OPerationType = "select count(tbl_operation.tbl_operationtype_operationtypeId)," 
			 +"tbl_register.fname from tbl_operation inner JOIN tbl_maillist" 
			+" ON tbl_operation.tbl_maillist_mailid=tbl_maillist.mailid "
			 +"INNER JOIN tbl_service ON tbl_service.serviceid=tbl_maillist.tbl_service_serviceid " 
			 +"INNER JOIN tbl_product on tbl_product.productid=tbl_operation.tbl_product_productid "
			 +"INNER JOIN tbl_register on tbl_register.registerId=tbl_product.owner_registerId "
			+"where  tbl_operation.tbl_operationtype_operationtypeId=? and tbl_register.registerId=?"
			+" group by tbl_register.fname"; 
	
	
	public static final String get_ServiceName_OperationType ="select count(tbl_operation.tbl_operationtype_operationtypeId), "
			+ "tbl_service.servicename from tbl_operation inner JOIN tbl_maillist ON tbl_operation.tbl_maillist_mailid=tbl_maillist.mailid "
			+ "INNER JOIN tbl_service ON tbl_service.serviceid=tbl_maillist.tbl_service_serviceid  "
			+ "INNER JOIN tbl_product on tbl_product.productid=tbl_operation.tbl_product_productid "
			+ "INNER JOIN tbl_register on tbl_register.registerId=tbl_product.owner_registerId "
			+ "where  tbl_operation.tbl_operationtype_operationtypeId=? and tbl_register.registerId=?"
			+ " group by tbl_service.servicename";
	/*..................userTracking..............harsh......................end...........*/

	/*................Registrtration.........Rajkumar&Supriya......................start............*/
		public static final String GET_COUNTRY_ALL="select countryId, country from country";
		public static final String GET_CITY_ALL="select  cityid,city from tbl_city where tbl_state_stateid=?";
		public static final String GET_STATE_ALL="select  stateId,state  from tbl_state where country_countryId=?";
		public static final String GET_ROLEID_USER="select roleid from tbl_role where roletype='User'";
		public static final String GET_ROLEID_PRODUCTOWNER="select roleid from tbl_role where roletype='PRODUCTOWNER'";
		public static final String GET_ROLEID_SERVICEOWNER="select roleid from tbl_role where roletype='SERVICEOWNER'";
		public static final String INSERT_LOGIN_DETAILS="insert into tbl_login(username,password,tbl_role_roleid) values(?,?,?)";
		public static final String INSERT_ADDRESS_DETAILS="insert into tbl_addrss(address,tbl_city_cityId) values(?,?)";
		public static final String INSERT_REGISTGER_DETAILS="insert into tbl_register(fname,lname,companyName,loginid,addressid,contact_no) values(?,?,?,?,?,?)";

		/*....................Registration..........Rajkumar&Supriya................... end...............*/
		
	/*...............changepassword...............sarita and nagamani...........start.......*/
		 public static final String SELECT_PASSWORD="SELECT PASSWORD FROM TBL_LOGIN WHERE LOGINID = ? AND PASSWORD=?";
		public static final String CHANGE_PASSWORD="UPDATE TBL_LOGIN SET PASSWORD=? WHERE  loginid=?";
		
			/*...............changepassword...............sarita&nagamani........end......*/
			
			//code by bhushan
			 public static final String INSERT_RECORDS = "INSERT INTO tbl_maillist(mails,tbl_service_serviceid) VALUES(?,?)";
	    public static final String GET_COUNT = "SELECT COUNT(*) FROM tbl_maillist";
	    public static final String GET_SERVICEID="SELECT * FROM tbl_service WHERE servicename=?";
	    public static final String ADD_SERVICE="INSERT INTO tbl_service (servicename, tbl_register_registerId, servicedate, statusId) VALUES ( ?, ?, NOW(), 1)";
		
	    //code by sagar
	  //Notification 
	    //productNotification
	    public static String _SelectProductNotification = "SELECT tbl_product.productid,tbl_product.productname"
	    		+ " FROM tbl_product WHERE tbl_product.statusId=?";
	    //ServicesNotification
	    public static String _SelectServiesNotification ="SELECT tbl_service.serviceid,tbl_service.servicename "
	    		+ "FROM tbl_service WHERE tbl_service.statusId =?";
	    //UserNotification
	    public static String _SelectUserNotification = " SELECT tbl_operation.operationid , tbl_maillist.mails "
	    		+ "FROM tbl_operation,tbl_maillist WHERE tbl_operation.tbl_maillist_mailid =tbl_maillist.mailid "
	    		+ "AND tbl_operation.statusId =?";
	    
	    //GetProductDetail
	    public static String  _GetProductDetail = " SELECT tbl_product.productname,tbl_register.fname,\r\n" + 
	    		"	    		tbl_register.lname,tbl_product.productprice,tbl_product.producttype ,tbl_role.roletype\r\n" + 
	    		"	    		FROM tbl_product , tbl_register,tbl_login,tbl_role WHERE tbl_product.owner_registerId = tbl_register.registerId \r\n" + 
	    		"				 AND tbl_register.loginid = tbl_login.loginid\r\n" + 
	    		"				 AND tbl_login.tbl_role_roleid = tbl_role.roleid\r\n" + 
	    		"	    		AND tbl_product.productid =?\r\n" + 
	    		"	    		";
	    
	    //GetServiceDetail
	    public static  String _GetServiceDetail ="SELECT tbl_service.servicename, "
	    		+ "tbl_register.fname,tbl_register.lname,"
	    		+ "tbl_service.servicedate,tbl_role.roletype FROM tbl_service,"
	    		+ "tbl_register,tbl_login,tbl_role "
	    		+ "WHERE tbl_service.tbl_register_registerId = tbl_register.registerId "
	    		+ "AND tbl_register.loginid = tbl_login.loginid AND tbl_login.tbl_role_roleid = tbl_role.roleid "
	    		+ "AND tbl_service.serviceid =?";
		//GetUserDetail
public static String _GetUserDetail ="SELECT tbl_maillist.mails,"
		+ "tbl_product.productname,tbl_operation.operationDate,tbl_operationtype.operation "
		+ "FROM tbl_operation,tbl_operationtype,tbl_maillist,"
		+ "tbl_product WHERE tbl_operation.tbl_maillist_mailid = tbl_maillist.mailid "
		+ "AND tbl_operation.tbl_product_productid=tbl_product.productid "
		+ "AND tbl_operationtype.operationtypeId = tbl_operation.tbl_operationtype_operationtypeId "
		+ "AND tbl_operation.operationid =?";

     //Update
    public static String _UpdateProductStatuse = "UPDATE tbl_product SET tbl_product.statusId = 2 "
    		+ "WHERE tbl_product.productid = ?" ;
    
      public static String _UpdateServiceStatuse ="UPDATE tbl_service SET tbl_service.statusId =2 "
      		+ " WHERE tbl_service.serviceid = ?";
      
      public static String _UpdateUserStatuse ="  UPDATE tbl_operation SET tbl_operation.statusId = 2 "
      		+ "WHERE tbl_operation.operationid = ?" ;
      		
      public static String _OperationStatusCount="SELECT COUNT(*) FROM tbl_operation WHERE tbl_operation.statusId = ?";
      public static String _ProductStatusCount="SELECT COUNT(*) FROM tbl_product WHERE tbl_product.statusId = ?";
      public static String _ServiceStatusCount="SELECT COUNT(*) FROM tbl_service WHERE tbl_service.statusId = ?;";
      
      
      /*...............bhushan...........AddingEmais...................start.........*/
      public static final String totalMailCount="SELECT SER.SERVICEID ,SER.SERVICENAME FROM tbl_service SER,tbl_maillist MAIL where "
  			+ " SER.SERVICEID=MAIL.TBL_SERVICE_SERVICEID GROUP BY SER.SERVICENAME ORDER BY SER.SERVICEID ASC";
  	// query for no of clicked user
  	 public static final String noOfClickedUser="SELECT COUNT(MAIL.MAILID),MAIL.tbl_service_serviceid FROM  tbl_maillist MAIL,tbl_operation"
  	 		+ " OP WHERE MAIL.MAILID=OP.TBL_MAILLIST_MAILID  AND OP.TBL_OPERATIONTYPE_OPERATIONTYPEID=? GROUP BY MAIL.TBL_SERVICE_SERVICEID";


     /*...............bhushan...........AddingEmais...................end.........*/      
      
}//class