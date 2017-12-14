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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.nacre.emailmarketing.dao.UserDaoI;
import com.nacre.emailmarketing.daoI.UserDaoImpl;
import com.nacre.emailmarketing.dto.Datadto;
import com.nacre.emailmarketing.exception.DatabaseException;
@WebServlet("/CartData")
public class CartData extends HttpServlet {
	public CartData() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Datadto> dto=new ArrayList<Datadto>();
		/*Integer loginid2=0;
		RequestDispatcher rd = null;
		HttpSession ses;
		ses=req.getSession(false);
		loginid2 = (Integer) ses.getAttribute("loginid");
		System.out.println("from add to cart..."+loginid2);
		if(loginid2==null)
		{
			System.out.println("from if add to cart..."+loginid2);
			rd=req.getRequestDispatcher("UI/User/login.jsp");
			rd.forward(req, resp);
		}
		else
		{*/
		try {
			
			ArrayList<Datadto> productList=null;
			UserDaoI dao=new UserDaoImpl();
			
			//productList=dao.getAllCartProducts();
			dto=dao.getAllCartProducts();
			System.out.println(dto);
			Gson gson=new Gson();
			JsonElement element=gson.toJsonTree(dto, new TypeToken<List<Datadto>>() {}.getType());
			JsonArray jsonArray=element.getAsJsonArray();
			resp.setContentType("application/json");
			resp.getWriter().print(jsonArray);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		//}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
