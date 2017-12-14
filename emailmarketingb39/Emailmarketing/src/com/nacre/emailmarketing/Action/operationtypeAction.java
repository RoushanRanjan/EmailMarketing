package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.serviceI.*;
import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.serviceI.*;

@WebServlet("/operationtypeAction")
public class operationtypeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public operationtypeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hiii");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		Integer operationtypeId=Integer.parseInt(request.getParameter("name"));
		Double price=Double.parseDouble(request.getParameter("t1"));
		
		try
		{
			OperationtypeDto otd=new OperationtypeDto();
			otd.setOperationTypeId(operationtypeId);
			otd.setPrice(price);
			AdminServiceImpl service=new AdminServiceImpl();
			String result;
		
			result = service.checkUpdation(otd);
			out=response.getWriter();
			if (result=="success")
		     {//out.print("sucess.....");
		     out.println("<html>");
		     out.println("<body>");
			out.println("<h3 style='text-align:center;'>Price Added Successfully</h3>");
			out.println("<h4 style='text-align:center;'><a href='/Emailmarketing/UI/Admin/operationType.jsp'>HOME</a></h4>");
			out.println("</body>");
		     out.println("</html>");
		     
		     
				//request.getRequestDispatcher("/Emailmarketing/UI/Admin/operationType.jsp").include(request, response);
				
			/*HttpSession s=	request.getSession();
			s.setAttribute("msg", al);
			response.sendRedirect("UI/Admin/operationType.jsp");
		      	//;
*/		    
		 }
			        
		  else
			  out.println("Some error in Updation,Try again");   
		      
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
