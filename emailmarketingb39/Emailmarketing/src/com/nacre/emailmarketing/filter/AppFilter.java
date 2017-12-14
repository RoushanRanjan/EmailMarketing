package com.nacre.emailmarketing.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.util.IntegerConstants;

@WebFilter("/*")
public class AppFilter implements Filter {
	private static int a = IntegerConstants._ADMIN;
	private static int s = IntegerConstants._SERVICEOWNER;
	private static int p = IntegerConstants._PRODUCTOWNER;
	private static int u = IntegerConstants._USER;

	@Override
	public void destroy() {
	}// constructor

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = null, password = null,vstatus = null;
		Cookie cookie1 = null, cookie2 = null;
		boolean signin=false;
		Cookie ck[] = null;
		List<String> errsList = null;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String sc=httpRequest.getServletPath();
		String path = httpRequest.getContextPath();
		RequestDispatcher rd = null;
		boolean isloginCookieAvailable = false;
		HttpSession session = null;
		//get session object
		session=httpRequest.getSession(false);
		String roleid = null,logid=null,isLoggedIn="false";
		try{
		ck = httpRequest.getCookies();
		if (ck != null) {
			if(session==null){
			System.out.println("if Chk cook");
			for (Cookie cok : ck) {
				if (cok.getName().equals("isLoggedInValue")) {
					System.out.println("Cook available 1");
					isLoggedIn=cok.getValue();
					System.out.println("isLoggedIn"+isLoggedIn);
				}//if
			}//for
			}//	if(session==null)
			if(session!=null){
				System.out.println("else Chk cook");
				for (Cookie cok : ck) {
					System.out.println(cok+"cok");
					if (cok.getName().equals("isLoggedInValue")) {
						System.out.println("Cook available 1");
						isLoggedIn=cok.getValue();
						System.out.println("isLoggedIn"+isLoggedIn);
					}//if
					}//for
				}//	if(session!=null)
		}//if
		String uri = httpRequest.getRequestURI();
		if (uri.contains("JS") || uri.contains("CSS") || uri.contains("IMAGES")|| uri.contains("assests") 
				||uri.contains("/Emailmarketing/UI/authentication/ForgotPassword.jsp") 
				||uri.contains(path+"/UI/authentication/ForgotDisplay.jsp") 
				||uri.contains(path+"/UI/common/")
				||uri.contains("/Emailmarketing/AuthenticationAction")
				||uri.contains("/Emailmarketing/operationtypeAction")
				||uri.contains("/Emailmarketing/loginactionurl")
				||uri.contains("/Emailmarketing/viewNewArival")
				||uri.contains("/Emailmarketing/logoutactionurl")
				||uri.contains("/Emailmarketing/servlet2")
				||uri.contains("/Emailmarketing/servlet2")
				||uri.contains("/Emailmarketing/AdminNotificationCheck")
				||uri.contains("/Emailmarketing/AdminNotificationDetail")
				||uri.contains("/Emailmarketing/BuyUpdate")
				||uri.contains("/Emailmarketing/CartData")
				||uri.contains("/Emailmarketing/ChangePassword")
				||uri.contains("/Emailmarketing/CityAction")
				||uri.contains("/Emailmarketing/CountryAction")
				||uri.contains("/Emailmarketing/deleteProduct")
				||uri.contains("/Emailmarketing/abc")
				||uri.contains("/Emailmarketing/featchProduct")
				||uri.contains("/Emailmarketing/insertProductAction")
				||uri.contains("/Emailmarketing/LoginServlet")
				||uri.contains("/Emailmarketing/MailDropDownAction")
				||uri.contains("/Emailmarketing/MailListAction")
				||uri.contains("/Emailmarketing/product")
				||uri.contains("/Emailmarketing/ProductOwnerNotificationBuyServlet")
				||uri.contains("/Emailmarketing/ProductOwnerNotificationCartServlet")
				||uri.contains("/Emailmarketing/ProductOwnerNotificationClickServlet")
				||uri.contains("/Emailmarketing/ProductOwnerNotificationServlet")
				||uri.contains("/Emailmarketing/ProductOwnerRegister")
				||uri.contains("/Emailmarketing/ServiceOwnerRegister")
				||uri.contains("/Emailmarketing/ProductOwnerTotalNotificationsServlet")
				||uri.contains("/Emailmarketing/viewProduct")
				||uri.contains("/Emailmarketing/service")
				||uri.contains("/Emailmarketing/showServiceOwnerDetailsForProductOwnerHomePage")
				||uri.contains("/Emailmarketing/showServicesForPorductOwnerAction")
				||uri.contains("/Emailmarketing/StateAction")
				||uri.contains("/Emailmarketing/updateProductAction")
				||uri.contains("/Emailmarketing/Action")
				||uri.contains("/Emailmarketing/UserRegister")
				||uri.contains("/Emailmarketing/tracking")
				||uri.contains("/Emailmarketing/buytracking")
				||uri.contains("/Emailmarketing/clicktracking")
				||uri.contains("/Emailmarketing/useService")
				||uri.contains("/Emailmarketing/viewProductForProductOwner")
				||uri.contains(path+"/UI/User/")){
			System.out.println("uri no security:" + uri);
			System.out.println("CSS AND JS");
			chain.doFilter(request, response);
		} else if (uri.contains(path+"/UI/authentication/login.jsp")
				||uri.contains(path+"/UI/common/")) {
			System.out.println("uri:" + uri);
			System.out.println("uri login .jsp");
			if (ck != null) {
				System.out.println("Chk cook");
				for (Cookie cok : ck) {
					if (cok.getName().equals("loginid")) {
						isloginCookieAvailable = true;
						System.out.println("Cook available 1");
						logid=cok.getValue();
						System.out.println("logid:"+logid);
					} else if (cok.getName().equals("roleid")) {
						roleid =cok.getValue();
						System.out.println("roleid:"+roleid);
					} // elseif
				} // for (Cookie cok : ck)
				if (isloginCookieAvailable) {
					System.out.println("Cook available welcome 1");
					chain.doFilter(request, response);
					/*System.out.println("true or false:"+roleid != null && roleid.equals("1"));
					if (roleid != null && roleid.equals("1")) {
						System.out.println("uri1:" + uri);
						if(uri.contains(path+"/UI/Admin/")
							||uri.contains("/UI/authentication/changePassword.jsp")){
							System.out.println("chain");
							chain.doFilter(request, response);
						}else if(isLoggedIn.equals("true")){
							System.out.println("else true");
							httpResponse.sendRedirect(path+"/UI/Admin/Admin_Home_page.jsp");
						}//else
						} else if (roleid != null && roleid.equals("2")) {
						System.out.println("uri2:" + uri);
						if(uri.contains(path+"/UI/ProductOwner/")){
							System.out.println("chain");
							chain.doFilter(request, response);
						}else if(isLoggedIn.equals("true")){
							System.out.println("else true");
					httpResponse.sendRedirect(path+"/UI/ServiceOwner/Service_Owner_Home_Page.jsp");
						}//else
							} else if (roleid != null && roleid.equals("3")) {
						System.out.println("uri3:" + uri);
						if(uri.contains(path+"/UI/ServiceOwner/")){
							System.out.println("chain");
							chain.doFilter(request, response);
						}else if(isLoggedIn.equals("true")){
							System.out.println("else true");
						httpResponse.sendRedirect("showServiceOwnerDetailsForProductOwnerHomePage");
						}//else
						} else if (roleid != null && roleid.equals("4")) {
						System.out.println("uri4:" + uri);
						httpResponse.sendRedirect(path+"/UI/User/User_Home_page.jsp");
					} // uriif
*/				} else {
					System.out.println("Cook not available login .jsp");
					System.out.println("urick1.1:" + uri);
					chain.doFilter(request, response);
				} // if(isloginCookieAvailable)else
			} else {
				System.out.println("no Cook available login .jsp");
				System.out.println("urick1.2:" + uri);
				chain.doFilter(httpRequest, httpResponse);
			} // if(ck!=null)else
		} else if (isLoggedIn.equals("true")) {
			System.out.println("session1:"+session);
			System.out.println("Session  available");
				if (ck != null) {
					System.out.println("Cook available 2");
					for (Cookie cok : ck) {
						if (cok.getName().equals("loginid")) {
							isloginCookieAvailable = true;
							System.out.println("Cook found 1");
							logid =cok.getValue();
							System.out.println("logId:" + logid);
						} else if (cok.getName().equals("roleid")) {
							roleid = cok.getValue();
						} // elseif
					} // for
					if (isloginCookieAvailable) {
						System.out.println("Cook available proceed 1");
						System.out.println("uri:" + uri);
						if (roleid != null && roleid.equals("1")) {
							System.out.println("uri1:" + uri);
							if(uri.contains(path+"/UI/Admin/")
								||uri.contains("/UI/authentication/changePassword.jsp")){
								System.out.println("chain");
								chain.doFilter(request, response);
							}else if(isLoggedIn.equals("true")){
								System.out.println("else true");
								httpResponse.sendRedirect(path+"/UI/Admin/Admin_Home_page.jsp");
							}//else
							} else if (roleid != null && roleid.equals("2")) {
							System.out.println("uri2:" + uri);
							if(uri.contains(path+"/UI/ServiceOwner/")
								||uri.contains("/UI/authentication/changePassword.jsp")){
								System.out.println("chain");
								chain.doFilter(request, response);
							}else if(isLoggedIn.equals("true")){
								System.out.println("else true");
						httpResponse.sendRedirect(path+"/UI/ServiceOwner/Service_Owner_Home_Page.jsp");
							}//else
								} else if (roleid != null && roleid.equals("3")) {
							System.out.println("uri3:" + uri);
							if(uri.contains(path+"/UI/ProductOwner/")
								||uri.contains("/UI/authentication/changePassword.jsp")){
								System.out.println("chain");
								chain.doFilter(request, response);
							}else if(isLoggedIn.equals("true")){
								System.out.println("else true");
							httpResponse.sendRedirect("showServiceOwnerDetailsForProductOwnerHomePage");
							}//else
							}/* else if (roleid != null && roleid.equals("4")) {
							System.out.println("uri4:" + uri);
							if(uri.contains(path+"/UI/User/")
									||uri.contains("/UI/authentication/changePassword.jsp")){
									System.out.println("chain");
									chain.doFilter(request, response);
								}else if(isLoggedIn.equals("true")){
									System.out.println("else true");
								httpResponse.sendRedirect(path+"/UI/User/User_Home_page.jsp");
								}//elseif
							} // uriif
					*/	} else {
						System.out.println("Cook not available not to proceed 1");
						System.out.println("uri:" + uri);
						httpResponse.sendRedirect(path+"/UI/authentication/login.jsp");
					} // if(isloginCookieAvailable)else
				} else {
					System.out.println("uri:" + uri);
					httpResponse.sendRedirect(path+"/UI/authentication/login.jsp");
				} // if(ck!=null)else
		} else {
			System.out.println("sess");
			System.out.println("session2:"+session);
			if (ck != null) {
				System.out.println("Cook available 3");
				for (Cookie cok : ck) {
					if (cok.getName().equals("loginid")) {
						isloginCookieAvailable = true;
						logid = cok.getValue();
						System.out.println("logId:" + logid);
					System.out.println("Cook found 2");
					} else if (cok.getName().equals("roleid")) {
						System.out.println("roleid:" + cok.getValue());
						roleid = cok.getValue();
					} // elseif
				} // for
				if (isloginCookieAvailable) {
					System.out.println("Cook available proceed 2");
					System.out.println("urin1:" + uri);
					if (roleid != null && roleid.equals("1")) {
						System.out.println("uri1:" + uri);
						if(uri.contains(path+"/UI/Admin/")
							||uri.contains("/UI/authentication/changePassword.jsp")){
							System.out.println("chain");
							chain.doFilter(request, response);
						}else if(isLoggedIn.equals("true")){
							System.out.println("else true");
							httpResponse.sendRedirect(path+"/UI/Admin/Admin_Home_page.jsp");
						}//else
						} else if (roleid != null && roleid.equals("2")) {
						System.out.println("uri2:" + uri);
						if(uri.contains(path+"/UI/ServiceOwner/")
						||uri.contains("/UI/authentication/changePassword.jsp")){
							System.out.println("chain");
							chain.doFilter(request, response);
						}else if(isLoggedIn.equals("true")){
							System.out.println("else true");
					httpResponse.sendRedirect(path+"/UI/ServiceOwner/Service_Owner_Home_Page.jsp");
						}//else
							} else if (roleid != null && roleid.equals("3")) {
						System.out.println("uri3:" + uri);
						if(uri.contains(path+"/UI/ProductOwner/")
							||uri.contains("/UI/authentication/changePassword.jsp")){
							System.out.println("chain");
							chain.doFilter(request, response);
						}else if(isLoggedIn.equals("true")){
							System.out.println("else true");
						httpResponse.sendRedirect("showServiceOwnerDetailsForProductOwnerHomePage");
						}//else
						}/* else if (roleid != null && roleid.equals("4")) {
						System.out.println("uri4:" + uri);
						if(uri.contains(path+"/UI/User/")
								||uri.contains("/UI/authentication/changePassword.jsp")){
								System.out.println("chain");
								chain.doFilter(request, response);
							}else if(isLoggedIn.equals("true")){
								System.out.println("else true");
							httpResponse.sendRedirect(path+"/UI/User/User_Home_page.jsp");
							}//elseif
					} // uriif
					*/} else {
					System.out.println("Cook not available not to proceed 2");
					System.out.println("urin2:" + uri);
					httpResponse.sendRedirect(path+"/UI/authentication/login.jsp");
					} // else
			} else {
				System.out.println("urin3:" + uri);
				if(session==null){
				httpResponse.sendRedirect(path+"/UI/common/Welcome_page.jsp");
				}//if
			} // if(ck!=null)else
		} // else
		}//try
		catch (Exception e) {
			e.printStackTrace();
			rd=httpRequest.getRequestDispatcher(path+"/UI/authentication/error.jsp");
			rd.forward(request, response);
		}//catch
	}// doFilter(-,-,-)

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}// init(-)
}// class
