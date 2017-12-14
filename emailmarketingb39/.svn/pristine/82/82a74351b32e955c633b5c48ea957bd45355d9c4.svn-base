package com.nacre.emailmarketing.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * This is a utility class for date conversion, 
 * contain methods to convert String Date to SQl Date and vice versa.
 * 
 * @version 1.0.0 31th July 2017
 * @author 
 *
 */
public class DateUtil {
	private static SimpleDateFormat dateFormat = null;
	
	public static Timestamp getCurrentTimeInTimeStampFormat(){
		Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
		return timestamp;
	}
	public static java.util.Date getUtilDateFromStringDate(String date) throws ParseException{
		SimpleDateFormat dateFormat=null;
		//Get the date fromat to tell to Date class object which format it will come
		dateFormat=new SimpleDateFormat("yyyy-MM-dd");  //mm takes minuites so takes MM 
		return dateFormat.parse(date);
	}
	public static Date getSqlFromStringDate(String doj) {
		//System.out.println("rahul");
		//System.out.println(doj);
		System.out.println("inside fun "+doj);
		String[] dateArray = doj.split("[\\-\\.\\/]");
		//System.out.println("rahul1");
		String requiredFormat = dateArray[0] + "-" + dateArray[1] + "-" + dateArray[2];

		String requiredFormat1 = dateArray[0] + "/" + dateArray[1] + "/"
				+ dateArray[2];
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		//System.out.println(requiredFormat);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		System.out.println("required form "+requiredFormat);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		try {
			//System.out.println("rahul3");
			java.util.Date date = dateFormat.parse(requiredFormat);
			@SuppressWarnings("deprecation")
			java.sql.Date date2 = new java.sql.Date(date.getYear(),
					date.getMonth(), date.getDate());
			//System.out.println("date2"+date2);
			return date2;
		} catch (ParseException e) {
			System.out.println("rahul5");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	public static Date getSqlFromStringDateNag(String doj) {
		//System.out.println("rahul");
		//System.out.println(doj);
		System.out.println("inside fun "+doj);
		String[] dateArray = doj.split("[\\-\\.\\/]");
		//System.out.println("rahul1");

		String requiredFormat1 = dateArray[0] + "/" + dateArray[1] + "/"
				+ dateArray[2];
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		try {
			java.util.Date date = dateFormat1.parse(requiredFormat1);
			@SuppressWarnings("deprecation")
			java.sql.Date date2 = new java.sql.Date(date.getYear(),
					date.getMonth(), date.getDate());
			//System.out.println("date2"+date2);
			return date2;
		} catch (ParseException e) {
			System.out.println("rahul5");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	public static String sqlDateToString(java.sql.Date inputDate) {
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String stringDate = dateFormat.format(inputDate);
		return stringDate;
	}
	public static Date stringToSqlDate(String inputDate) {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date utilDate;
		java.sql.Date sqlDate = null;
		try {
			utilDate = formater.parse(inputDate);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}
	public static Date stringToSqlDates(String inputDate) {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate;
		java.sql.Date sqlDate = null;
		try {
			utilDate = formater.parse(inputDate);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}
	public static java.util.Date getUtilDate(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}
	
	public static java.sql.Date getSqlDate(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	public static Date getSqlFromStringDateRahul(String doj) {
		//System.out.println("rahul");
		//System.out.println(doj);
		String[] dateArray = doj.split("[\\-\\.\\/]");
		//System.out.println("rahul1");
		String requiredFormat = dateArray[0] + "-" + dateArray[1] + "-" + dateArray[2];
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		try {
			//System.out.println("rahul3");
			java.util.Date date = dateFormat.parse(requiredFormat);
			@SuppressWarnings("deprecation")
			java.sql.Date date2 = new java.sql.Date(date.getYear(),
					date.getMonth(), date.getDate());
			//System.out.println("date2"+date2);
			return date2;
		} catch (ParseException e) {
			System.out.println("rahul5");
			e.printStackTrace();
		}
		return null;
	}	
}