package com.nacre.emailmarketing.Action;
 
//wasik & junaid Servlet
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nacre.emailmarketing.dao.ServiceOwnerDaoI;
import com.nacre.emailmarketing.daoI.ServiceOwnerDaoImpl;
import com.nacre.emailmarketing.dto.ServiceDto;
 @WebServlet("/service")
public class ServiceAction extends HttpServlet 
{
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
  		PrintWriter out=response.getWriter();
  		HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
  		ServiceOwnerDaoI sod=new ServiceOwnerDaoImpl();
  	 	//get data from the page
  	 	String id = request.getParameter("id");
	 	String action = request.getParameter("action");
		String action1=request.getParameter("email");
		List<ServiceDto> sd = new ArrayList<ServiceDto>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		  	if (action != null) {
				try {
					if (action.equals("list"))
					{
					// featch data from the services table
						sd = sod.getAllServices();
						
					//add to the json object
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Records", sd);
				 	// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
 					response.getWriter().print(jsonArray);
					}
  				else if (action.equals("delete")) {
  				 	// delete record from the services table
					 if (request.getParameter("serviceId") != null) {
						int serviceId = Integer.parseInt(request.getParameter("serviceId"));
						sod.deleteService(serviceId);
 						// Return in the format required by jTable  
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					 	}
  				 		}
					}
					catch (Exception ex) {
						ex.printStackTrace();
						JSONROOT.put("Result", "ERROR");
						JSONROOT.put("Message", ex.getMessage());
						String error = gson.toJson(JSONROOT);
						response.getWriter().print(error);
					 	}
		 			}
				} */
 	
   	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
 	
  		PrintWriter out=response.getWriter();
  		HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
		
		ServiceOwnerDaoI sod=new ServiceOwnerDaoImpl();
			 
		//System.out.println("from servlet");
		String id = request.getParameter("id");
	
		String action = request.getParameter("action");
		String action1=request.getParameter("email");
		System.out.println("......service...");
			List<ServiceDto> sd = new ArrayList<ServiceDto>();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response.setContentType("application/json");
			
		 	if (action != null) {
				try {
					if (action.equals("list"))
					{
						// Fetch Data from Student Table
						sd = sod.getAllServices();

						//System.out.println("from servlet"+ sd.toString());
						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Records", sd);
					//	out.println(sd);
					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);


					response.getWriter().print(jsonArray);
					}
  				else if (action.equals("delete")) {
					// Delete record
					if (request.getParameter("serviceId") != null) {
						int serviceId = Integer.parseInt(request.getParameter("serviceId"));
						sod.deleteService(serviceId);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					 
					}
  				 }
					}
					catch (Exception ex) {
						ex.printStackTrace();
						JSONROOT.put("Result", "ERROR");
						JSONROOT.put("Message", ex.getMessage());
						String error = gson.toJson(JSONROOT);
						response.getWriter().print(error);
					
						}
		
  		/*	 if(action1.equals("abc"))
  				{
  					// select emails
  					 System.out.println("from the update");
  					if (request.getParameter("serviceId") != null) {
						int serviceId = Integer.parseInt(request.getParameter("serviceId"));
						sod.getAllmails(serviceId);
						JSONROOT.put("Result", "OK");
						JSONROOT.put("Records", sd);
						String jsonArray = gson.toJson(JSONROOT);


						response.getWriter().print(jsonArray);

  					
  					}
									
  				}	 	
*/ 				}
	
		 	  	}
		 
 	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
 	}
 	
}

	/*	private HashMap<String,Object> jsonRoot=new HashMap<String, Object>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		List<ServiceDto> service= new ArrayList<ServiceDto>();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		
		if(action!=null)
		{
		try{
			if (action.equals("list")) {
				// Fetch Data from Service Table
				service = dao.getAllService();
				
				// Return in the format required by jTable plugin
				jsonRoot.put("Result", "OK");
				jsonRoot.put("Records", service);

				// Convert Java Object to Json
				String jsonArray = gson.toJson(jsonRoot);

				response.getWriter().print(jsonArray);
			}
			 else if (action.equals("delete")) {
					// Delete record
					if (request.getParameter("serviceId") != null) {
						int serviceId = Integer.parseInt(request.getParameter("serviceId"));
						dao.deleteService(serviceId);

						// Return in the format required by jTable plugin
						jsonRoot.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(jsonRoot);
						response.getWriter().print(jsonArray);
					}

			
			
				else if(action.equals("create")   ||  action.equals("update")   )
				{
						ServiceDto serviceDto= new ServiceDto(); 
						if (request.getParameter("studentId") != null) {
							int serviceId = Integer.parseInt(request.getParameter("serviceId"));
							serviceDto.setServiceId(serviceId);
						}
						if (request.getParameter("name") != null) {
							String name = request.getParameter("name");
							serviceDto.setServiceName(name);
						}

						if (request.getParameter("sDate") != null) {
							java.util.Date date = DateUtil.getUtilDateFromStringDate(request.getParameter("sDate"));
							serviceDto.setServiceDate(date);
						}
				} else if (action.equals("update")) {
							// Update existing record
							dao.updateStudent(student);
						}
		}
		}
		catch(Exception e)
		{
			jsonRoot.put("Result", "ERROR");
			jsonRoot.put("Message", e.getMessage());
			String error = gson.toJson(jsonRoot);
			response.getWriter().print(error);
			}
		}
		
	
*/	

