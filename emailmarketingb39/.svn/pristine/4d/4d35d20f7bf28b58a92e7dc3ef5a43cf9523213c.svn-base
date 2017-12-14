package com.nacre.emailmarketing.Action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.service.AuthenticationServiceI;
import com.nacre.emailmarketing.serviceI.AuthenticatiionServiceImpl;


@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie ck[]=null;
		String loginId=null;
		String prepassword = request.getParameter("prepassword");
		String newpassword = request.getParameter("newpassword");
		
		ck = request.getCookies();
		if (ck != null) {
			for (Cookie cok : ck) {
				if (cok.getName().equals("loginid")) {
					loginId=cok.getValue();
					System.out.println("isLoggedIn"+loginId);
				}//if
			}//for
		}//if(ck!=null)

		if (prepassword != null) {
			LoginDto ldto = new LoginDto();

			ldto.setLoginId(Integer.parseInt(loginId));
			ldto.setPassword(newpassword);

			/*
			 * ldto.setPassword(newpassword);
			 */
			/*
			 * HttpSession session= request.getSession(false); loginId=(int)
			 * session.getAttribute("id");
			 * 
			 */

		AuthenticationServiceI  service = new AuthenticatiionServiceImpl();

			if (newpassword == null) {
				String message = service.findPre_Password(prepassword, ldto);
				response.getWriter().write(message);

			} else {

				String password = service.find_changePassword(ldto);

				request.setAttribute("message", "your password changed successfully");
				rd=getServletContext().getRequestDispatcher("/UI/authentication/changePassword.jsp");
				rd.forward(request,response);

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}