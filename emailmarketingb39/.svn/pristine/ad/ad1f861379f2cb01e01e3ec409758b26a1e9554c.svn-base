//Author: Satyajeet and Amit
package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nacre.emailmarketing.dto.ProductDTOForProductOwner;
import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.service.ProductOwnerServiceI;
import com.nacre.emailmarketing.serviceI.ProductOwnerServiceImpl;
import com.nacre.emailmarketing.util.ImageUtil;

@WebServlet("/updateProductAction")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class UpdateProductAction extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pName=null;
		Integer quantity=0;
		Integer price=0;
		String pType=null;
		Integer productId=0;
		
		Part part=null;
		ProductDTOForProductOwner dto=null;
		PrintWriter pw=res.getWriter();
		ProductOwnerServiceI service=null;
		//Get the Data
		pName=req.getParameter("pName");
		quantity=Integer.parseInt(req.getParameter("quantity"));
		price=Integer.parseInt(req.getParameter("price"));
		pType=req.getParameter("pType");	
		part=req.getPart("image");
		productId=Integer.parseInt(req.getParameter("pid"));
		/*System.out.println(pName);
		System.out.println(quantity);
		System.out.println(price);
		System.out.println(pType);
		System.out.println(productId);
		System.out.println(part.getSubmittedFileName());
		System.out.println(part);
		*/
		//Create DTO class object and Set the value
		dto=new ProductDTOForProductOwner();
		dto.setProudctName(pName.toUpperCase());
		dto.setPirce(price);
		dto.setProductType(pType.toUpperCase());
		dto.setQuantity(quantity);
		dto.setProductId(productId);
		if(part.getSubmittedFileName()!=null){
			dto.setImage(ImageUtil.encodeImage(part.getInputStream()));
		}else{
			dto.setImage(null);
		}	
		//Create Service class object
		service=new ProductOwnerServiceImpl();
		try {
			pw.print(service.updateProduct(dto, part.getSubmittedFileName()));
		} catch (DatabaseException e) {
			e.printStackTrace();
			pw.print(0);
		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
