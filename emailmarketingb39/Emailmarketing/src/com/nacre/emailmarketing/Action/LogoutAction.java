package com.nacre.emailmarketing.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.util.IntegerConstants;

@WebServlet("/logoutactionurl")
public class LogoutAction extends HttpServlet {
	private static int a = IntegerConstants._ADMIN;
	private static int s = IntegerConstants._SERVICEOWNER;
	private static int p = IntegerConstants._PRODUCTOWNER;
	private static int u = IntegerConstants._USER;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = null;
		Cookie[] ck = null;
		String roleId = null;
		// get session object
		session = req.getSession(false);
		// get cookies
		ck = req.getCookies();
		try {
			if (session != null) {
				if (ck != null) {
					for (Cookie cookie : ck) {
						if (cookie.getName().equals("roleid")) {
							roleId = cookie.getValue();
							System.out.println("roleId:" + roleId);
						} // if
					} // for
					if ( roleId!=null ) {
						System.out.println("uri");
						for (int i = 0; i < ck.length; i++) {
							ck[i].setMaxAge(0);
							ck[i].setValue(null);
							res.addCookie(ck[i]);
						} // for
						res.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
						res.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
						res.setHeader("Cache-Control","must-revalidate"); //Directs caches not to store the page under any circumstance
						res.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
						res.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
						rd=req.getRequestDispatcher("./UI/common/Welcome_page.jsp");
						rd.forward(req, res);
						System.out.println("session" + session);
						System.out.println("ck" + ck);
					} // if
				} else {
					System.out.println("ck");
					res.sendRedirect("./UI/common/Welcome_page.jsp");
				} // else
			} else {
				System.out.println("session");
				res.sendRedirect("./UI/common/Welcome_page.jsp");
			} // sessionelse
		} catch (Exception e) {
			rd = req.getRequestDispatcher("./UI/authentication/error.jsp");
			rd.forward(req, res);
		} //
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class
