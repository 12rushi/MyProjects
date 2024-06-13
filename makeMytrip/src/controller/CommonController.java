package controller;

import helper.CommonHelper;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.action.CommonActionBean;


public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommonController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("CommonActionBean");
//		rd.forward(request, response);
		System.out.println("inside controller");
//		System.out.println(request.getParameter("firstName")+"contoller****");
	
	String url = request.getParameter("action");
	System.out.println(url);
	
		if(url.equals("register")){
			CommonActionBean.addUserDetails(request,response);
			
		}
		else if (url.equals("login")){
			
			if(request.getParameter("userType").equals("admin")){
				System.out.println("Admin sign in");
				CommonActionBean.loginCredentialAdmin(request, response);
			}
			else{
				System.out.println("user sign in");
				CommonActionBean.loginCredential(request,response);
			}
			
		}
		else if (url.equals("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		else if (url.equals("searchFlight")){
			CommonActionBean.searchFlights(request,response);
		}
		else if (url.equals("searchUserFlight")){
			CommonActionBean.searchFlightsUser(request,response);
		}
		else if (url.equals("addFlights")){
			CommonActionBean.addFlightsDetails(request,response);
		}
		else if (url.equals("displayAllData")){
			CommonActionBean.displayAllDataInfo(request,response);
		}
		else if (url.equals("bookTicket")){
			CommonActionBean.bookFlightTicket(request,response);
		}
		else if (url.equals("addBookTicketToDb")){
			System.out.println("inside controller addBookTicket");
			CommonActionBean.addBookTickettoDb(request,response);
		}
		else if (url.equals("updateBookTicket")){
			System.out.println("inside controller updateBookTicket");
			CommonActionBean.updateTicket(request,response);
		}
		else if (url.equals("summary")){
			System.out.println("inside controller summary");
			CommonActionBean.bookingSummary(request,response);
		}
		else if(url.equals("getStateAction"))
		   {
		    String country = request.getParameter("country");
		    System.out.println(country);
		    CommonHelper commonHelper = new CommonHelper();
		    List<String> states = null;
		   
		    states = commonHelper.getState(country);
		    HttpSession session = request.getSession();
		    session.setAttribute("getState", states);
		   
		    System.out.println("get the state");
		   
		    response.setStatus(200);
		    response.getWriter().write(states.toString());
		   }

		else if(url.equals("getCityAction"))
		   {
		    String state = request.getParameter("state");
		    System.out.println(state);
		    CommonHelper commonHelper = new CommonHelper();
		    List<String> cities = null;
		   
		    cities = commonHelper.getCity(state);
		    HttpSession session = request.getSession();
		    session.setAttribute("getcity", cities);
		   
		    System.out.println("get the city");
		   
		    response.setStatus(200);
		    response.getWriter().write(cities.toString());
		   }
	
		else{
			System.out.println("null value ");
		}
	}
}
