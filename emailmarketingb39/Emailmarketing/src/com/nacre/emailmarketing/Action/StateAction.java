package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;
@WebServlet(asyncSupported = true, urlPatterns = { "/StateAction" })
public class StateAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stateId=0;
		PrintWriter printWriter=null;
		UserServiceI userServiceI=null;
		Map<String,Integer> map=null;
		Gson gson=null;
		String output=null;
		try {
			//Create PrintWriter Obj
			printWriter=response.getWriter();
			//Set content type
			response.setContentType("Text/html");
			stateId=Integer.parseInt(request.getParameter("name"));
			userServiceI=new UserServiceImpl();
			map=userServiceI.getState(stateId);
			gson=new Gson();
			output=gson.toJson(map);
			printWriter.print(output);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//doGet(-,-)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}///DoPost(-,-)
}//class