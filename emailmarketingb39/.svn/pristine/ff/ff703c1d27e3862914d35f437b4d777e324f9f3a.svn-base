package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.emailmarketing.dto.ProductOwnerNotificationDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
@WebServlet("/ProductOwnerTotalNotificationsServlet")
public class ProductOwnerTotalNotificationsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=null;
		ProductOwnerServiceI productOwnerServiceI=null;
		PrintWriter printWriter=null;
		Integer totalNotifications=null;
		Gson g=null;
		String out=null;
		try {
			//get PrintWriter
			printWriter=response.getWriter();
			//set response content type
			response.setContentType("Text/html");
			//Get the Session object
			session=request.getSession(false);
			//Create Service class object
			productOwnerServiceI=new ProductOwnerServiceImpl();
			//call Service class method
			totalNotifications=productOwnerServiceI.getProductOwnerTotalNotificatons();
			//Set the Dto into request parameter
			if(totalNotifications!=null){
//				printWriter.println("<h3>"+totalNotifications+"</h3>");
				System.out.println("TotalNotificatios:"+totalNotifications);
				//Create Gson class object
				g=new Gson();
				//Get the String object from GSon and map
				out=g.toJson(totalNotifications);
				//Send the Sting object to Response
				printWriter.print(out);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/ProductOwner/exception.jsp").include(request,response);
		}//try-catch
		//Close Connections
		finally{
			
		}//finally
	}//DoGet(-,-)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//DoPost(-,-)
}//class