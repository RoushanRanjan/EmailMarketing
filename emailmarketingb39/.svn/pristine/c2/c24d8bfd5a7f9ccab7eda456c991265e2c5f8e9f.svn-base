//Author: Satyajeet and Amit
package com.nacre.emailmarketing.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.OwnerInformationWithProductDTO;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
@WebServlet("/viewProductForProductOwner")
public class ViewProductForProductOwnerAction extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=null;
		Integer registerId=0;
		RequestDispatcher rd=null;
		OwnerInformationWithProductDTO listDto=null;
		Integer pageNo=0;
		//Get the registration id from session
		session=req.getSession(false);
		registerId=(Integer) session.getAttribute("registerid");
	
		//When we are deleting to getting the current page
		pageNo=Integer.parseInt(req.getParameter("pageNo"));
		System.out.println(pageNo);
		ProductOwnerServiceI service=new ProductOwnerServiceImpl();
		try {
			listDto=service.getProductDetials(registerId, pageNo);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(listDto.get(1).getImage());
		req.setAttribute("listDto", listDto);
		rd=req.getRequestDispatcher("/UI/ProductOwner/viewProductForProductOwner.jsp");
		rd.forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
