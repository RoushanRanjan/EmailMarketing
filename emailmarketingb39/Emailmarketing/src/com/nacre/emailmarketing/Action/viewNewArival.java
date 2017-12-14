package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.newArivalDto;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;
import com.nacre.emailmarketing.util.ImageUtil;

@WebServlet("/viewNewArival")
//@MultipartConfig
public class viewNewArival extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public viewNewArival() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hiii");
//		response.setContentType("image/jpeg");  
		PrintWriter out = response.getWriter(); 
				
		try
		{
			ProductDto pd=new ProductDto();
			UserServiceImpl service=new UserServiceImpl();
			List result;
			result = service.checkNewArival(pd);
			
			HttpSession session=request.getSession();
			session.setAttribute("list", result);
			
		
			RequestDispatcher rd=request.getRequestDispatcher("/UI/User/viewNewArival.jsp");
			rd.forward(request, response);
	   
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
