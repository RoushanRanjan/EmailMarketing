package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;

/**
 * Servlet implementation class BuyUpdate
 */
@WebServlet("/BuyUpdate")
public class BuyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int operationid=0;
    String operation;
    RequestDispatcher rd=null;
    
    public BuyUpdate() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation=request.getParameter("operationid");
		System.out.println("operation:"+operation);
		operationid=Integer.parseInt(request.getParameter("operationid"));
		System.out.println("operationId:"+operationid);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			UserServiceI ui=new UserServiceImpl();
			boolean result=ui.buyProductfromCart(operationid);
			if(result==true)
			{	/*System.out.println("successfully buy from cart");
			rd=request.getRequestDispatcher("product");
			rd.forward(request,response);*/
				PrintWriter pw=response.getWriter();
				pw.print("Product Buy suceesfully");
			}
			else
				System.out.println("Not buy from cart");
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
