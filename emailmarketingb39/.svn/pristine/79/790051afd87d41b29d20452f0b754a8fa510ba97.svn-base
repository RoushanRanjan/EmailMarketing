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

import com.nacre.emailmarketing.dao.AuthenticationDaoI;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.serviceI.AuthenticatiionServiceImpl;

@WebServlet("/AuthenticationAction")
public class AuthenticationAction extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// boolean type
		boolean flag=false;
		// create the  RequestDispatcher
		RequestDispatcher rd=null;
		//set content type
				res.setContentType("text/html");
				//print the object
				PrintWriter out=res.getWriter();
		        //String send=null;
		        String username=null;
		        AuthenticationDaoI authenticationdaoi=null;
		       //read the from data
		      //set the username
		      username=req.getParameter("text");
				//Check for submit button
		          try {
					flag=new AuthenticatiionServiceImpl().getPassword(username);
					System.out.println(flag+":flag");
				if(flag){
					 // send=req.getParameter(send);
			        rd=req.getRequestDispatcher("/UI/authentication/ForgotDisplay.jsp");
		        // send to the jsp page
					rd.forward(req, res);	
				}
				else {
					// display to the 
					res.sendRedirect("/UI/authentication/ForgotPassword.jsp");
				}
				
		          } catch (DatabaseException | SQLException e) {
						// TODO Auto-generated catch block
		      		// display to the 
						res.sendRedirect("/UI/authentication/ForgotPassword.jsp");
				//	e.printStackTrace();
					}
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
