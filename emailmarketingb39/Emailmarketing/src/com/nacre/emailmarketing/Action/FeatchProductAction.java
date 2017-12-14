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

import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;

@WebServlet("/featchProduct")
public class FeatchProductAction extends HttpServlet{
 @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=res.getWriter();
	Integer productId=0;
	ProductOwnerServiceI service=null;
	RequestDispatcher rd=null;
	//Get the ProductID
	productId=Integer.parseInt(req.getParameter("productId"));
	service=new ProductOwnerServiceImpl(); 
	try {
		ProductDTOForProductOwner dto=service.fetchProductForUpdate(productId);
		req.setAttribute("dto", dto);
		rd=req.getRequestDispatcher("/UI/ProductOwner/updateProduct.jsp");
		rd.forward(req, res);
	} catch (DatabaseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
}
 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req,res);
 	}
}
