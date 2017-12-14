package com.nacre.emailmarketing.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.emailmarketing.exception.DatabaseException;
import com.nacre.emailmarketing.formbean.PieChartDetails;
import com.nacre.emailmarketing.formbean.ServiceDetailsDto;
import com.nacre.emailmarketing.formbean.TrackingDto;
import com.nacre.emailmarketing.serviceI.AdminServiceImpl;
 // This class  holding the control to show the pie chart
// Using the annotation 
@WebServlet("/tracking")
public class UserTracking extends HttpServlet {
      // implements the doPost() and call the doGet()
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		Map map= new HashMap();
		 // creating local variable 
		 int a=0;
		 // creating RequestDispatcher for forwarding the request
		 RequestDispatcher rd=null;
		// For storing the values creating List object
		List<PieChartDetails> resultantMap=null;
		  // read the name based on the clicked value and transfer the control 
		String option=null;
		String service=null;
		// reading the form data and also reading service name because i have to know no of user on the 
		// basis of service
		option=req.getParameter("name");
		service=req.getParameter("serviceName");
		// create the TrackingDto class object 
		  // setting the values
		// transfer the control on the basis of requirement
		if("Clicked_User".equals(option)){
			System.out.println("clicked view");
		       a=1;
			// pass the control to the serviceI
			try {
				/*resultantMap=new AdminServiceImpl().clickedViewServiceProcess(a);
				System.out.println(resultantMap);
				// set the Map into Request Attribute
				
				req.setAttribute("services",resultantMap);
				// transfer the control to the Jsp page 
				 * 
				 */
				req.setAttribute("val",a);
				rd=req.getRequestDispatcher("/UI/Admin/BarChart.jsp");
				rd.forward(req, res);
			} /*catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// transfer the control to the jsp page to show pie chart
        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  */
			catch (ServletException e) {
			// Regarding the ServletException
				System.out.println("Request Error"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// Regarding to the Url Exception
			System.out.println("URL NOT Entered "+e.getMessage());
			e.printStackTrace();
		}
			
			
		} else if("Buyyed_User".equals(option)){
			System.out.println("Buyyed_User");
			// logic to get the Buyyed User details
			a=2;
			// pass the control to the serviceI
			try {
				/*resultantMap=new AdminServiceImpl().clickedViewServiceProcess(a);
				System.out.println(resultantMap);
				// set the Map into Request Attribute
				
				req.setAttribute("services",resultantMap);
				// transfer the control to the Jsp page 
				 * 
				 */
				req.setAttribute("val",a);
				rd=req.getRequestDispatcher("/UI/Admin/BarChart.jsp");
				rd.forward(req, res);
			} /*catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// transfer the control to the jsp page to show pie chart
        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  */
			catch (ServletException e) {
			// Regarding the ServletException
				System.out.println("Request Error"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// Regarding to the Url Exception
			System.out.println("URL NOT Entered "+e.getMessage());
			e.printStackTrace();
		}			
		}
	}
	// implements 
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		// call to the doGet()
		doGet(req,res);
	}
}
