//Author: Satyajeet and Amit
package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;

@WebServlet("/showServicesForPorductOwnerAction")
public class ShowServicesForPorductOwnerAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Inside Show service");
		ProductOwnerServiceI service=null;	
		Map<String,Integer> map=null;
		Gson g=null;
		String out=null;
		PrintWriter pw=res.getWriter();
		//Create Service class object
		service=new ProductOwnerServiceImpl();
		try {
			map=service.getServiceOnwerDetails();
			//Create Gson class object
			g=new Gson();
			//Get the String object from GSon and map
			out=g.toJson(map);
			System.out.println(out);
			//Send the Sting object to Response
			pw.print(out);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
