//Author: Satyajeet and Amit
package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.emailmarketing.dto.ServiceDTOForProductOwnerHomePage;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;

@WebServlet("/showServiceOwnerDetailsForProductOwnerHomePage")
public class ShowServiceOwnerDetailsForProductOwnerHomePage extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ProductOwnerServiceI service=null;
		List<ServiceDTOForProductOwnerHomePage> listDto=null;
		RequestDispatcher rd=null;
		
		// Set refresh, autoload time as 5 seconds
	      res.setIntHeader("Refresh", 5);
	 
	      
		//Create Service class object
		service=new ProductOwnerServiceImpl();
		try {
			listDto=service.getServiceDetails();
			req.setAttribute("listDto", listDto);
			rd=req.getRequestDispatcher("/UI/ProductOwner/productOwnerHomePage.jsp");
			rd.forward(req, res);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
