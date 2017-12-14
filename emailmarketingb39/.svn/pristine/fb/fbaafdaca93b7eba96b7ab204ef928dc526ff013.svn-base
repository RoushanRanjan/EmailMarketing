package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.nacre.emailmarketing.formbean.PieChartDetails;
import com.nacre.emailmarketing.serviceI.AdminServiceImpl;


/**
 * Servlet implementation class PiechartEventory
 */
@WebServlet("/Action")
public class UserAction_ClickedOrBuyyed extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("from ajax call");
		
		 int pid=Integer.parseInt(request.getParameter("pid"));
		
ArrayList list=new ArrayList< PieChartDetails>();
		
      AdminServiceImpl adsi=new AdminServiceImpl();
		System.out.println("wel come in InventoryAction class");
		try {
			int a=1;
			list=(ArrayList) adsi.clickedViewServiceProcess(pid);
			Gson gson = new Gson();
			
			
			/*
			JsonElement element = gson.toJsonTree(list, new TypeToken<List<PieChartDetails>>() {}.getType());
		 //	JsonElement element = gson.toJsonTree(inventory, new TypeToken() {}.getType());
			JsonArray jsonArray = element.getAsJsonArray();*/
			/*System.out.println(jsonArray);*/
			
			String jsonArray = gson.toJson(list);
			response.setContentType("text/json");
			response.getWriter().print(jsonArray);
			System.out.println("from ajax at last call");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
