//Author: Satyajeet and Amit
package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;

@WebServlet("/useService")
public class UseServiceAction extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String[] val=req.getParameterValues("data1");
		System.out.println("hiiiiiiiiiiiiiiiiiiiiii");
		ProductOwnerServiceI service=null;
		Integer productId=0;
		PrintWriter pw=res.getWriter();
		productId=Integer.parseInt(req.getParameter("productId"));
		//Get the service class object
		service=new ProductOwnerServiceImpl();
		try {
			Integer count=service.sendMail(val, productId);
			pw.print(count);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print(0);
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
			pw.print(0);
		}
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
