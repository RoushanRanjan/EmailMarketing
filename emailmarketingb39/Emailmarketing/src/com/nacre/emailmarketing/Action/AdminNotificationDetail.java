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

import com.google.gson.Gson;
import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.dto.Operation;
import com.nacre.emailmarketing.dto.OperationtypeDto;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.dto.ServiceDto;
import com.nacre.emailmarketing.serviceI.AdminServiceImpl;


@WebServlet("/AdminNotificationDetail")
public class AdminNotificationDetail extends HttpServlet {

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
		String Productowner = null;
		adminServiceImpl = new AdminServiceImpl();
		String out = null;
	
		 String  value =request.getParameter("linkId");
			
		String key = request.getParameter("key");
		System.out.println("second"+value+"   "+key);
		if( value!=null) {
			object=adminServiceImpl.NotificationDetail(Integer.parseInt(value), Integer.parseInt(key));
		
			System.out.println("<<<<<<<<<,"+object);
			if(value.equals("1")) {
				list = new ArrayList();
				System.out.println("hiiiiiiiiiiiii product" );
				
				list.add(0,((ProductDto) object).getProductName());
				registerDto = ((ProductDto) object).getRegisterDto();
				Productowner = registerDto.getFname()+"  "+registerDto.getLname();
				list.add(1, Productowner);
				list.add(2, ((ProductDto) object).getProductPrice());
				list.add(3, ((ProductDto) object).getProductType());
				System.out.println(list);
			}
			else if(value.equals("2")) {
				list = new ArrayList();
				System.out.println("hiiiiiiiiiiiii service " );
				list.add(0, ((ServiceDto) object).getServiceName());
				registerDto = ((ServiceDto) object).getRegisterDto();
				Productowner = registerDto.getFname()+"  "+registerDto.getLname();
				list.add(1, Productowner);
				list.add(2, ((ServiceDto) object).getServiceDate());
				System.out.println(list);
				
			}
			else if(value.equals("3")) { 
				
				list = new ArrayList();
				System.out.println("hiiiiiiiiiiiii  operation " );
				 mailListDto = ((Operation) object).getMailListDto();
				list.add(0, mailListDto.getMails());
				productDto = ((Operation) object).getProductDto();
				list.add(1, productDto.getProductName());
				list.add(2, ((Operation) object).getOperationDate());
				
				System.out.println("object : "+object);
				operationtypeDto = ((Operation) object).getOpDto();
				System.out.println(operationtypeDto);
				list.add(3, operationtypeDto.getOperation());
				System.out.println(list);
				
			}
		}
		g = new Gson();
		out=g.toJson(list);
		System.out.println(out);
		rk = response.getWriter();
		response.setContentType("text/json");
		rk.print(out);
			
		if(out != null) {
			adminServiceImpl.changeStatusType(Integer.parseInt(value), Integer.parseInt(key));
		}
		
	}

}
