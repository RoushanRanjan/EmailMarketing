package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.AddressDto;
import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.dto.RegisterDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;

@WebServlet("/ProductOwnerRegister")
public class ProductOwnerRegister extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=null,password=null,password1=null,address=null,firstName=null,lastName=null,companyName=null;
		Long contactNumber=0L;
		int cityId=0,addressId=0,registerId=0;
		int roleId=0,loginId=0;
		PrintWriter printWriter=null;
		LoginDto loginDto=null;
		AddressDto addressDto=null;
		RegisterDto registerDto=null;
		ProductOwnerServiceI productOwnerServiceI=null;
		try {
			//Create PrintWriter obj
			printWriter=response.getWriter();
			//Set content type
			response.setContentType("Text/Html");
			//Read form Data
			firstName=request.getParameter("fname");
			lastName=request.getParameter("lname");
			emailId=request.getParameter("email");
			password=request.getParameter("pwd");
			password1=request.getParameter("repwd");
			contactNumber=Long.parseLong(request.getParameter("mobileno"));
			companyName=request.getParameter("cname");
			address=request.getParameter("location");
			cityId=Integer.parseInt(request.getParameter("city"));
			//Create LoginDto Obj
			loginDto=new LoginDto();
			//Strore Details to LoginDto obn
			loginDto.setUserName(emailId);
			loginDto.setPassword(password);
			//Create AddressDto obj
			addressDto=new AddressDto();
			//Strore Details to AddressDto obj
			addressDto.setAddress(address);
			addressDto.setCityId(cityId);
			//Create RegisterDto obj
			registerDto=new RegisterDto();
			//Strore Details to RegisterDto obj
			registerDto.setFname(firstName);
			registerDto.setLname(lastName);
			registerDto.setCompanyName(companyName);
			registerDto.setContactno(contactNumber);
			registerDto.setLdto(loginDto);
			registerDto.setAddressDto(addressDto);
			//create Service Obj
			productOwnerServiceI=new ProductOwnerServiceImpl();
				if(productOwnerServiceI.registerProductOwnerDetails(registerDto)){
					printWriter.println("<h1 style='text-align:center;'>Registration Success</h1>");
				    request.getRequestDispatcher("/UI/common/Welcome_page.jsp").include(request, response);
				}else{
					printWriter.println("<h1 style='text-align:center;'>Registration Fail</h1>");
					request.getRequestDispatcher("/UI/common/TechnicalProblem.jsp").forward(request,response);
					request.getRequestDispatcher("/UI/User/UserRegistration.jsp").include(request, response);
				}//if-else
		}catch (NumberFormatException e) {
			e.printStackTrace();
			printWriter.println("<h1 style='text-align:center;'>Registration Fail</h1>");
			request.getRequestDispatcher("/UI/common/TechnicalProblem.jsp").forward(request,response);
			request.getRequestDispatcher("/UI/User/UserRegistration.jsp").include(request, response);
		}
		catch (DatabaseException e) {
			e.printStackTrace();
			printWriter.println("<h1 style='text-align:center;'>Registration Fail</h1>");
			request.getRequestDispatcher("/UI/common/TechnicalProblem.jsp").forward(request,response);
			request.getRequestDispatcher("/UI/User/UserRegistration.jsp").include(request, response);
		}//try-catch
		//Close Connections
		finally{
			
		}
	}//DoGet(-,-)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}//DoPost(-,-)
}//Class