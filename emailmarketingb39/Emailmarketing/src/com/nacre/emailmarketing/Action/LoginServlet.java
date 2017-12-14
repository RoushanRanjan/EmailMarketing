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
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     int result=0;  
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        //request.getRequestDispatcher("link.html").include(request, response);  
	       HttpSession ses;   
	       RequestDispatcher rd;
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        LoginDto dto=new LoginDto();
	        dto.setUserName(name);
	        dto.setPassword(password);
	        UserServiceI ui=new UserServiceImpl();
	        try {
				result=ui.login(dto);
				if(result!=0)
				{
					
					System.out.println("Login succesfully");
					ses=request.getSession();
					ses.setAttribute("loginid", result);
					response.sendRedirect("product");
					/*rd=request.getRequestDispatcher("product");
					rd.forward(request, response);*/
				}
				else
				{
					
				}
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
