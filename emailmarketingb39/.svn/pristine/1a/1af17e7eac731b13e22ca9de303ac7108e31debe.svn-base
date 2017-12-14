package com.nacre.emailmarketing.dbutil;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.nacre.emailmarketing.exception.DatabaseException;






/**
 * This class contains all the utility methods for database connection.
 * 
 * @version 1.0.0 9th July 2014
 * @author Nacre Batch 19 Java
 */
public class DbUtil {

	/*
	 * Database user name.
	 */
	private static String UNAME;

	/*
	 * Database password.
	 */
	private static String PWD;

	/*
	 * Database driver class name i.e com.mysql.jdbc.Driver .
	 */
	private static String DRIVER;

	/*
	 * Database connection url name i.e jdbc:mysql://hostname:3306/schemaname .
	 */
	private static String URL;

	/*
	 * log4j logger will be used for logging purposes.
	 */
	// private static Logger dblogger = Logger.getLogger();

	/*
	 * static block to load database connection parameters from
	 * database.properties file.
	 */
	static {
		Properties p = new Properties();
		try {
			p.load(DbUtil.class.getClassLoader().getResourceAsStream(DBConstants.PROP_PATH_MYSQL));
			UNAME = p.getProperty(DBConstants.PROP_USERNAME);
			PWD = p.getProperty(DBConstants.PROP_PASSWORD);
			URL = p.getProperty(DBConstants.PROP_URL);
			DRIVER = p.getProperty(DBConstants.PROP_DRIVER);
			
			Class.forName(DRIVER);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// dblogger.error(DBConstants.DRIVER_LOAD_ERR_MSG);
		} catch (IOException e) {
			// dblogger.error(DBConstants.PROP_LOAD_ERR_MSG);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws DatabaseException {
		Connection connection=null;
		try {
			System.out.println(URL);
			System.out.println(UNAME);
			System.out.println(PWD);
			connection=DriverManager.getConnection(URL,UNAME,PWD);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Not able to connect to database now plz try after some time");
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws DatabaseException {
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DatabaseException("Not able to connect to database now plz try after some time");
			}
	}
	
	/*public static void main(String[] args) throws DatabaseException {
		Connection con=getConnection();
		System.out.println(con);
		
	}*/
	
}
