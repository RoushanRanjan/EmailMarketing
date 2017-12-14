package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.emailmarketing.dto.LoginDto;
import com.nacre.emailmarketing.dto.Operation;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.Operation1;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;

@WebServlet("/servlet2")
public class AddToCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = null;
		Operation1 dto = new Operation1();
		LoginDto logindto = null;
		ses = req.getSession(false);
		UserServiceI ui = null;
		RequestDispatcher rd = null;
		int count = 0;
	Integer loginid=0;
		String parameter = req.getParameter("action");
		if ("ADD_CART".equals(parameter)) {
			
			ses=req.getSession(false);
			loginid = (Integer) ses.getAttribute("loginid");
			//loginid=(int) ses.getAttribute("loginid");
			System.out.println("from add to cart..."+loginid);
			if(loginid==null || loginid==0)
			{
				System.out.println("from if add to cart..."+loginid);
				rd=req.getRequestDispatcher("UI/User/login.jsp");
				rd.forward(req, resp);
			}
			else
			{
			//	System.out.println("some mistake.........");
			
			ui = new UserServiceImpl();
			ProductDto pd = (ProductDto) ses.getAttribute("DTO");
			System.out.println(pd.getProductId() + "...........");
			System.out.println(pd.getProductName());
			dto.setProductId(pd.getProductId());
			Operation1 op;
			try {
				op = ui.addToCart(dto);
				System.out.println(op.getProductId() + "from ADDcart action");
				rd = req.getRequestDispatcher("product");
				rd.include(req, resp);
				
			} catch (DatabaseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} else if ("CHECK_CART".equals(parameter)) {
			try {
				ui = new UserServiceImpl();
				count = ui.checkCart();
				System.out.println("count from action:" + count);
				ses.setAttribute("COUNT", count);
				rd = req.getRequestDispatcher("UI/User/cartproductcount.jsp");
				rd.forward(req, resp);

			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if("BUY_PRODUCT".equals(parameter)) {
			Integer loginid1;
			ses=req.getSession(false);
			loginid1 = (Integer) ses.getAttribute("loginid");
			System.out.println("from add to cart..."+loginid1);
			if(loginid1==null || loginid1==0)
			{
				System.out.println("from if add to cart..."+loginid);
				rd=req.getRequestDispatcher("UI/User/login.jsp");
				rd.forward(req, resp);
			}
			else
			{
			ui = new UserServiceImpl();
			ProductDto pd = (ProductDto) ses.getAttribute("DTO");
			System.out.println(pd.getProductId() + "...........");
			dto.setProductId(pd.getProductId());
			ui = new UserServiceImpl();
			try {
				ui = new UserServiceImpl();
				count = ui.buyProduct(dto);
				rd = req.getRequestDispatcher("product");
				rd.include(req, resp);
				
			} catch (DatabaseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("count from action:" + count);
		}

	}
	}

}
