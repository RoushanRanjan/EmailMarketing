package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.ProductVeiwDto;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;

@WebServlet("/viewProduct")
public class ProductVeiw_Action extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("form get");

		List list = null;
		HttpSession ses=req.getSession();

		RequestDispatcher rd = null;
		// gettting data from url
		int prodId = Integer.parseInt(req.getParameter("productId"));
		int mailId = Integer.parseInt(req.getParameter("mailId"));
		System.out.println("mail from servlet::" + mailId);

		ProductVeiwDto dto = new ProductVeiwDto();
		// set DTO
		dto.setProdId(prodId);
		dto.setMailId(mailId);
		ses.setAttribute("productId", prodId);
		ses.setAttribute("mailId", mailId);
		// use Service
		UserServiceI service = new UserServiceImpl();
		try {
			list = service.findProduct(dto);

			req.setAttribute("details", list);

			// create rd obj
			rd = req.getRequestDispatcher("/UI/User/product_details.jsp");
			rd.forward(req, res);

		} catch (Exception ex) {
			ex.printStackTrace();
			req.setAttribute("error", "internal problem");
			rd = req.getRequestDispatcher("/UI/User//error.jsp");
			rd.forward(req, res);
		}

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}


}
