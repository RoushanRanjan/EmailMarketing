package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.ProductOwnerNotificationDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
@WebServlet("/ProductOwnerNotificationServlet")
public class ProductOwnerNotificationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=null;
		ProductOwnerNotificationDto productOwnerNotificationDto=null;
		ProductOwnerServiceI productOwnerServiceI=null;
		List<ProductOwnerNotificationDto> clickList=null;
		List<ProductOwnerNotificationDto> buyList=null;
		List<ProductOwnerNotificationDto> cartList=null;
		PrintWriter printWriter=null;
		
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
			clickList=productOwnerServiceI.getNotificationClick();
			buyList=productOwnerServiceI.getNotificationBuy();
			cartList=productOwnerServiceI.getNotificationCart();
			//Set the Dto into request parameter
			if(!clickList.isEmpty())
				request.setAttribute("clickList",clickList);
			if(!buyList.isEmpty())
				request.setAttribute("buyList",buyList);
			if(!cartList.isEmpty())	
				request.setAttribute("cartList",cartList);
			request.getRequestDispatcher("/UI/ProductOwner/Product_Owner_Header.jsp").include(request, response);
			request.getRequestDispatcher("/UI/ProductOwner/productOwnerNotification.jsp").include(request, response);
		}catch (ServletException | IOException e) {
			e.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/UI/common/TechnicalProblem.jsp").forward(request,response);
		}//try-catch
		//Close Connections
		finally{
			
		}//finally
	}//DoGet(-,-)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//DoPost(-,-)
}//class