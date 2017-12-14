package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.emailmarketing.dbutil.DbUtil;

@WebServlet("/MailDropDownAction")
public class MailDropDownAction extends HttpServlet{

	private Connection con=null;
	private PreparedStatement ps=null;
	private  static final String
		GET_SEVICE_LIST="SELECT serviceid,servicename FROM tbl_service";

	  public void init(){
		  
	  }//init()

  public void doGet(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException
	{
	  PrintWriter pw=null;
	  //String user=null;
	  ResultSet rs=null;
	  int result=0;
	  //general settings
	   pw=res.getWriter();
	  res.setContentType("application/json");
	  try{
		  
		  
		 /* Connection*/ con=DbUtil.getConnection();
	  //read form data
		  //user=req.getParameter("user");
	  //write jdbc code.
		  //System.out.println(user);
		  // set value to Query param
		  //ps.setString(1,user);
		  //execute the Query
		  
		/*  PreparedStatement ps3=null;*/
			ps = con.prepareStatement(GET_SEVICE_LIST);
		
		 rs=ps.executeQuery();
			
			/*if(rs3.next())
			{
				serviceId=rs3.getInt(1);
			}
		  
		  rs=ps.executeQuery(GET_SEVICE_LIST);
		  //processs the ResultSet
		 */
		  Map map=new TreeMap<String,Integer>();
		  
		  while(rs.next()){
			  System.out.println(rs.getInt(1)+rs.getString(2));
			  map.put(rs.getString(2),rs.getInt(1));
			
		  }
		 Gson gson=new Gson();
		 String str=gson.toJson(map);
		  pw.print(str);
		 
		 
		  //close ResultSet
		   rs.close();
	  }
	  catch(Exception  e){
		  e.printStackTrace();
		 
	  }
}//doGet(-,-)

public void doPost(HttpServletRequest  req,HttpServletResponse res)throws ServletException,IOException
{
	doGet(req,res);
}//doPost(-,-)

public void destroy(){
	//close jdbc objs
	try{
	 if(ps!=null)
		 ps.close();
	}
	catch(SQLException se){
		 se.printStackTrace();
	}
	try{
		if(con!=null)
			 con.close();
	}
	catch(SQLException se){
		se.printStackTrace();
	}
  }//destroy()
	
	
}
