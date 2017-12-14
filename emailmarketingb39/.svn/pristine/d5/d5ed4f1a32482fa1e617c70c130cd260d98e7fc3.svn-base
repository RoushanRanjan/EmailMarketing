package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nacre.emailmarketing.dao.ServiceOwnerDaoI;
import com.nacre.emailmarketing.daoI.ServiceOwnerDaoImpl;
import com.nacre.emailmarketing.dto.ServiceDto;
 
//wasik & junaid Servlet

@WebServlet("/abc")

public class emails extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;
		ServiceOwnerDaoI sod=new ServiceOwnerDaoImpl();
		String action=request.getParameter("serviceId");
		String action1=request.getParameter("email");
		System.out.println("emails;;;;;;");
		out=response.getWriter();
  		//create hashmap object
		HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
		//create list object
		List<ServiceDto> sd = new ArrayList<ServiceDto>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		System.out.println(action1);
		if(action1.equals("abc"))
			{
		 
				//get all the emails from dao impl class
			System.out.println("from the update");
				if (request.getParameter("serviceId") != null) {
					try
					{
					int serviceId = Integer.parseInt(request.getParameter("serviceId"));
					sd=sod.getAllmails(serviceId);
					System.out.println(sd);
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", sod.getAllmails(serviceId));
					String jsonArray = gson.toJson(JSONROOT);
					System.out.println(JSONROOT+".........");
 					response.getWriter().print(jsonArray);
					}
					catch (Exception ex) {
						ex.printStackTrace();
						JSONROOT.put("Result", "ERROR");
						JSONROOT.put("Message", ex.getMessage());
						String error = gson.toJson(JSONROOT);
						response.getWriter().print(error);
					
					}
			 	}
			}	 	
  		}
 	}
