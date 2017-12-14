package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.AddressDto;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;

@WebServlet("/UserRegister")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class UserRegister extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=null,/*password=null,password1=null,*/address=null,firstName=null,lastName=null,companyName=null;
		Long contactNumber=0L;
		int cityId=0,addressId=0,registerId=0;
		int roleId=0,loginId=0;
		PrintWriter printWriter=null;
		LoginDto loginDto=null;
		AddressDto addressDto=null;
		RegisterDto registerDto=null;
		UserServiceI userServiceI=null;
		HttpSession ses=request.getSession();
		try {
			//Create PrintWriter obj
			printWriter=response.getWriter();
			//Set content type
			response.setContentType("Text/Html");
			//Read form Data
			firstName=request.getParameter("fname").toUpperCase();
			lastName=request.getParameter("lname").toUpperCase();
			emailId=request.getParameter("email").toUpperCase();
			/*password=request.getParameter("pwd");
			password1=request.getParameter("repwd");*/
			contactNumber=Long.parseLong(request.getParameter("mobileno"));
			companyName=request.getParameter("cname");
			address=request.getParameter("location").toUpperCase();
			cityId=Integer.parseInt(request.getParameter("city"));
	//		System.out.println(firstName+" "+lastName+" "+emailId+" "+contactNumber+" "+address+" "+cityId);
			//Create LoginDto Obj
			loginDto=new LoginDto();
			//Strore Details to LoginDto obn
			loginDto.setUserName(emailId);
			loginDto.setPassword("**************");
			//Create AddressDto obj
			addressDto=new AddressDto();
			//Strore Details to AddressDto obj
			addressDto.setAddress(address);
			addressDto.setCityId(cityId);
			//Create RegisterDto obj
			registerDto=new RegisterDto();
			//Strore Details to RegisterDto obj
			registerDto.setProductId((Integer)ses.getAttribute("productId"));
			registerDto.setMailId((Integer)ses.getAttribute("mailId"));
			registerDto.setFname(firstName);
			registerDto.setLname(lastName);
			registerDto.setCompanyName(companyName);
			registerDto.setContactno(contactNumber);
			registerDto.setLdto(loginDto);
			registerDto.setAddressDto(addressDto);
			//create Service Obj
			userServiceI=new UserServiceImpl();
			printWriter.print(userServiceI.registerUserDetails(registerDto));
		}catch (NumberFormatException e) {
			e.printStackTrace();
			printWriter.print(0);
		}
		catch (Exception e) {
			e.printStackTrace();
			printWriter.print(0);
		}//try-catch
		//Close Connections
		finally{
			
		}
	}//DoGet(-,-)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//DoPost(-,-)
}//Class