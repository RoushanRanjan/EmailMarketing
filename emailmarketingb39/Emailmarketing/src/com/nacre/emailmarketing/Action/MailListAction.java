package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nacre.emailmarketing.dto.MailListDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ServiceOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ServiceOwnerServiceImpl;

@WebServlet("/MailListAction")
@MultipartConfig(maxFileSize = 16177215)
public class MailListAction extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Connection con = null;
		PrintWriter pw = response.getWriter();
		// int serviceId=1;
		int registerId=0;
		String submit = request.getParameter("sub");
		Cookie[] ck=request.getCookies();
		if (ck != null) {
			System.out.println("if Chk cook");
			for (Cookie cok : ck) {
				if (cok.getName().equals("registerid")) {
					System.out.println("Cook available 1");
					registerId=Integer.parseInt(cok.getValue());
				}//if
			}//for
			}
		if (submit.equals("Add")) {

			String serviceName = request.getParameter("serviceName");
			Part filepath = request.getPart("xfile");
			System.out.println(filepath);

			MailListDto dto = new MailListDto();
			dto.setServiceName(serviceName);
			dto.setFilepath(filepath);
			dto.setRegisterId(registerId);

			ServiceOwnerServiceI mls = new ServiceOwnerServiceImpl();

			try {
				boolean flag = mls.verifyMailList(dto);
				if (flag) {
					// HttpSession session=request.getSession();
					// session.setAttribute("user",username);
					// pw.println("Emails successfully added");

					response.sendRedirect(request.getContextPath() + "/UI/ServiceOwner/mailList.jsp?MailList_added_successfully");

					// request.getRequestDispatcher("/JSP/mailList.jsp").forward(request,
					// response);
				} else {
					// pw.println("Invalid operation !");
					// request.getRequestDispatcher("/JSP/failure.jsp").forward(request,
					// response);
					response.sendRedirect(request.getContextPath() + "/UI/ServiceOwner/mailList.jsp?(!)-MailList_already_exists");
				}
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (submit.equals("Add Email")) {
			String mails = request.getParameter("email");
			String serviceName = request.getParameter("serviceName");
			int serviceId=Integer.parseInt(serviceName);
			
			System.out.println("serviceId===" + serviceId);

			MailListDto dto = new MailListDto();
			dto.setMails(mails);
			
			dto.setServiceId(serviceId);
			

			ServiceOwnerServiceI mls = new ServiceOwnerServiceImpl();

			try {
				boolean flag = mls.verifyMailIndividual(dto);
				if (flag) {
					// HttpSession session=request.getSession();
					// session.setAttribute("user",username);
					// pw.println("Email successfully added !");
					// request.getRequestDispatcher("/JSP/mailList.jsp").forward(request,
					// response);

					response.sendRedirect(request.getContextPath() + "/UI/ServiceOwner/mailList.jsp?Email_added_successfully");

				} else {
					// pw.println("Invalid operation !");
					// request.getRequestDispatcher("/JSP/mailList.jsp").forward(request,
					// response);

					response.sendRedirect(request.getContextPath() + "/UI/ServiceOwner/mailList.jsp?(!)-Email_already_exists");
				}
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}
}
