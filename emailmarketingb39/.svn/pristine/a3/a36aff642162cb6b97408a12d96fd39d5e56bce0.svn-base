//Author: Satyajeet and Amit
package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nacre.emailmarketing.dto.InsertProductDto;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
import com.nacre.emailmarketing.util.ImageUtil;

@WebServlet("/insertProductAction")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class InsertProductAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String pName=null;
	Integer quantity=0;
	Integer price=0;
	String pType=null;
	Integer firstService=0;
	Integer secondService=0;
	Integer thirdService=0;
	Part part=null;
	HttpSession session=null;
	InsertProductDto dto=null;
	ArrayList<Integer> list=null;
	PrintWriter pw=res.getWriter();
	//Get the Data
	pName=req.getParameter("pName");
	quantity=Integer.parseInt(req.getParameter("quantity"));
	price=Integer.parseInt(req.getParameter("price"));
	pType=req.getParameter("pType");
	if(req.getParameter("first").equals("")){
		firstService=0;
	}else{
		firstService=Integer.parseInt(req.getParameter("first"));
	}	
	if(req.getParameter("first").equals("")){
		firstService=0;
	}else{
		secondService=Integer.parseInt(req.getParameter("second"));
	}
	if(req.getParameter("first").equals("")){
		firstService=0;
	}else{
		thirdService=Integer.parseInt(req.getParameter("third"));
	}	
	part=req.getPart("image");
	
	/*System.out.println(pName);
	System.out.println(quantity);
	System.out.println(price);
	System.out.println(pType);
	
	System.out.println(part.getSubmittedFileName());
*/	
	System.out.println(firstService);
	System.out.println(secondService);
	System.out.println(thirdService);
	//List class object
	list=new ArrayList<>();
	list.add(firstService);
	list.add(secondService);
	list.add(thirdService);
		
		//Create DTO class object and Set the value
		dto=new InsertProductDto();
		dto.setProductName(pName.toUpperCase());
		dto.setImage(ImageUtil.encodeImage(part.getInputStream()));
		dto.setProductPrice(price);
		dto.setProductType(pType.toUpperCase());
		dto.setQuantity(quantity);
		//Create Session object
		session=req.getSession(false);
		dto.setRegisterId((int)(session.getAttribute("registerid")));
		//dto.setRegisterId(3);
		dto.setServices(list);
		dto.setImageName(part.getSubmittedFileName());
		
		//Create Service class object
		ProductOwnerServiceI service=new ProductOwnerServiceImpl();
		pw.print(service.insertProduct(dto));
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
