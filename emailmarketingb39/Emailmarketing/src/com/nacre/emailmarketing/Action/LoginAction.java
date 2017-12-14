package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.service.AuthenticationServiceI;
import com.nacre.emailmarketing.serviceI.AuthenticatiionServiceImpl;
import com.nacre.emailmarketing.util.IntegerConstants;

@WebServlet("/loginactionurl")
public class LoginAction extends HttpServlet {
	private static	int a= IntegerConstants._ADMIN;
	private static	int s=IntegerConstants._SERVICEOWNER;
	private static	int p=IntegerConstants._PRODUCTOWNER;
	private static	int u=IntegerConstants._USER;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		System.out.println("LOGIN ACTION");
		String password = null, username = null;
		RequestDispatcher rd = null;
		PrintWriter pw = null;
		AuthenticationServiceI service = null;
		HttpSession session = req.getSession();
		String isLoggedIn=null;
		boolean singin=false;
		Cookie ck[]=null;
		LoginDto dto = null;
		List<Integer> list = null;
		Cookie cookie1 = null, cookie2 = null, cookie3 = null,cookie4=null;
		// general settings
		pw = res.getWriter();
		res.setContentType("text/json");
		// read form data
		username = req.getParameter("username");
		password = req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		singin =Boolean.parseBoolean(req.getParameter("stay"));
		System.out.println("signin:"+singin);
		
		// create Dto object
		dto = new LoginDto();
		dto.setUserName(username);
		dto.setPassword(password);
		// create List Object
		list = new ArrayList<>();
		// create Service class object
		service = new AuthenticatiionServiceImpl();
		try {
			list = service.checkLoginService(dto);
			if (list.get(0) == 0) {
				pw.println("{\"err\":\"Invalid username or password\"}");
				/*System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			msg="Invalid username or password";
			session.setAttribute("LERR", msg);*/	

		//	res.sendRedirect(req.getContextPath()+"/UI/authentication/login.jsp");
			
		} else {
				// create Session object
				session=req.getSession(true);
				session.setMaxInactiveInterval(10800);
				System.out.println(session+"session");
				System.out.println("list:"+list);
				session.setAttribute("loginid", list.get(0));
				session.setAttribute("roleid", list.get(1));
				session.setAttribute("registerid", list.get(2));
				isLoggedIn="true";
				// create cookie object
				cookie1 = new Cookie("loginid", list.get(0).toString());
				cookie2 = new Cookie("roleid", list.get(1).toString());
				cookie3 = new Cookie("registerid", list.get(2).toString());
				cookie4 = new Cookie("isLoggedInValue",isLoggedIn);
		
				
			//	res.addHeader("Set-Cookie", "loginid=content;Path=/;expires=Wed, 07-Nov-2012 14:52:08 GMT;");
				//res.addHeader("Set-Cookie", cookieString2);
				
				if (singin) {
					cookie1.setMaxAge(10800);
					cookie2.setMaxAge(10800);
					cookie3.setMaxAge(10800);
					cookie4.setMaxAge(10800);
				}//if
				res.addCookie(cookie1);
				res.addCookie(cookie2);
				res.addCookie(cookie3);
				res.addCookie(cookie4);
				ck=req.getCookies();
				for (Cookie cok : ck) {
					System.out.println(cok+"cok");
					if (cok.getName().equals("isLoggedInValue")) {
						System.out.println("Cook available 1");
						isLoggedIn=cok.getValue();
						System.out.println("isLoggedIn"+isLoggedIn);
					}//if
					}//for
				System.out.println(cookie1);
				System.out.println(cookie2);
				System.out.println(cookie3);
				System.out.println(cookie4);
				
				System.out.println("isLoggedIn:"+isLoggedIn);
				
				if (list.get(1) == a) {
					pw.println("{\"url\":\"UI/Admin/Admin_Home_page.jsp\"}");
				//	res.sendRedirect(req.getContextPath()+"/UI/Admin/Admin_Home_page.jsp");
				} else if (list.get(1) == s) {
					pw.print("{\"url\":\"UI/ServiceOwner/Service_Owner_Home_Page.jsp\"}");

		//			res.sendRedirect(req.getContextPath()+"/UI/ServiceOwner/Service_Owner_Home_Page.jsp");
				} else if (list.get(1) == p) {
					pw.println("{\"url\":\"showServiceOwnerDetailsForProductOwnerHomePage\"}");

	/*				res.sendRedirect(req.getContextPath()+"/showServiceOwnerDetailsForProductOwnerHomePage/productowner");	
	*/			} else if (list.get(1) == u) {
						pw.println("{\"url\":\"UI/User/User_Home_page.jsp\"}");
/*						res.sendRedirect(req.getContextPath()+"/UI/User/User_Home_page.jsp");
*/
					} // elseif
		/*		else{
					msg="Invalid ROLE PLEASE TRY LATER";
					session.setAttribute("LERR", msg);
								
					
					res.sendRedirect(req.getContextPath()+"/UI/authentication/login.jsp");
					
				}
		*/	} // else
		} // try
		catch (Exception e) {
			e.printStackTrace();

	/*		msg="Invalid username or password";
		session.setAttribute("LERR", msg);
	*/res.sendRedirect(req.getContextPath()+"/UI/authentication/error.jsp");
		
		} // catch
		
		
			// close stream
		pw.close();
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class

