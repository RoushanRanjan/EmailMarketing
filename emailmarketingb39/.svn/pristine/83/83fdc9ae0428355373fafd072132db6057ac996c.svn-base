 //Author: Satyajeet and Amit 
package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;

@WebServlet("/deleteProduct")
public class DeleteProductAction extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer productId=0;
		ProductOwnerServiceI service=null;
		Integer count=0;
		PrintWriter pw=res.getWriter();
		productId=Integer.parseInt(req.getParameter("productId"));
		//Service class object
		service=new ProductOwnerServiceImpl();
		count=service.deleteProduct(productId);
		System.out.println(count);
		if(count==1){
			pw.print(1);
		}else{
			pw.print(0);
		}
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
