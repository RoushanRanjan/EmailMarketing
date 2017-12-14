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

import com.nacre.emailmarketing.dto.Operation;
import com.nacre.emailmarketing.dto.ProductDto;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.UserServiceI;
import com.nacre.emailmarketing.serviceI.UserServiceImpl;
@WebServlet("/product")
public class ProductAction extends HttpServlet {
	int productId=125;
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDto pdto=null;
		HttpSession ses=null;
		RequestDispatcher rd=null;
		pdto=new ProductDto();
		pdto.setProductId(productId);
		System.out.println(pdto.getProductId());
		Operation op=new Operation();
		op.setProductId(productId);
	//	resp.getOutputStream().write(b);
		
		UserServiceI ui=new UserServiceImpl();
		try {
			
			ProductDto dto=ui.productInfo(pdto);
			
			ses=req.getSession();
			ses.setAttribute("DTO", dto);
			rd=req.getRequestDispatcher("UI/User/product.jsp");
			rd.forward(req, resp);
		} catch (SQLException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
