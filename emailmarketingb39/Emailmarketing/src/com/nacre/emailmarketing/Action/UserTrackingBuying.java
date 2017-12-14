package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.emailmarketing.dto.UserOperationDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
// This class  holding the control to show the pie chart
// Using the annotation 

@WebServlet("/buytracking")
public class UserTrackingBuying extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		Integer  registerid  ;
		// creating local variable
		int operationtypeid = 0;
		String option = null;

		RequestDispatcher rd = null;
		HttpSession session = null;

		List<UserOperationDto> plist1 = null;
		List<UserOperationDto> plist2 = null;
		List<UserOperationDto> plist = null;
		// creating session Object
		session = request.getSession();
		//getting Registration id From Session
		registerid = (Integer) session.getAttribute("registerid");

		// getting req parameters
		option = request.getParameter("pid");

		System.out.println(option);
		
		if ("Buyed_User".equals(option)) {
			System.out.println("Buyed view");
			operationtypeid =1;
			System.out.println(registerid);
			ProductOwnerServiceI svps = new ProductOwnerServiceImpl();
			try {
				plist1 = svps.get_ProductOwnerName_OPerationTypecount(operationtypeid, registerid);

				plist2 = svps.get_ServiceName_OperationType(operationtypeid, registerid);

				System.out.println("plist1 is   ---------" + plist1);
				System.out.println("plist2 is   ---------" + plist2);

				plist = new ArrayList<UserOperationDto>();
				plist.addAll(plist1);
				plist.addAll(plist2);

				// response.getWriter().println("Performance DTO list : ");
				System.out.println("list of Operations : " + plist);
				response.setContentType("text/json");
				Gson g = new Gson();
				String js = g.toJson(plist);
				System.out.println(js);

				response.getWriter().print(js);

			}// try
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
