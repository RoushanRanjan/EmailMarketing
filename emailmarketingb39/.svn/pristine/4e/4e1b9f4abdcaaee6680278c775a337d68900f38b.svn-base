package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.Operation;
import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.ServiceDto;
import com.nacre.emailmarketing.serviceI.AdminServiceImpl;


@WebServlet("/AdminNotificationCheck")
public class AdminNotificationCheck extends HttpServlet {

			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AdminServiceImpl adminServiceImpl = null;
		Map< Integer,String> map = null;
		Gson g = null;
		PrintWriter rk = null;
		List list = null;
		Object object = null;
		ProductDto productDto = null;
		ServiceDto serviceDto = null;
		Operation operation = null;
		OperationtypeDto operationtypeDto = null;
		RegisterDto registerDto = null;
		MailListDto mailListDto = null;
		HttpSession httpSession = null;
		
		String value = null;
		int cN ;
		adminServiceImpl = new AdminServiceImpl();
		
		cN = adminServiceImpl.countNotification();
		System.out.println(cN);
		/*httpSession = request.getSession();
		
		request.setAttribute("ncN",cN);
		request.getRequestDispatcher("UI/Admin/Notification.jsp").forward(request, response); */
	 value = request.getParameter("linkId");
		System.out.println(value);
		if(value!=null) {
	 map = adminServiceImpl.adminNotification(Integer.parseInt(value));
		}
	 g = new Gson();
		String out=g.toJson(map);
		System.out.println(out);
		rk = response.getWriter();
		response.setContentType("text/json");
		rk.print(out);
	
		
		   
	}

}
