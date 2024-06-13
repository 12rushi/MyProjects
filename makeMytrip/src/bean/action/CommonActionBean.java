package bean.action;

import helper.CommonHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestDelegate;

import bean.input.AddFlightData;
import bean.input.Admin;
import bean.input.BookingFlight;
import bean.input.LoginBean;
import bean.input.OutputActionBean;
import bean.input.OutputSearchBean;
import bean.input.OutputSummaryBean;
import bean.input.SearchFlightData;
import bean.input.UserInputBean;


public class CommonActionBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommonActionBean() {
        super();
    }


	public static void addUserDetails(HttpServletRequest request,
			HttpServletResponse response) {
			
		UserInputBean userBean = new UserInputBean();
		
		userBean.setFirstName(request.getParameter("firstName"));
		userBean.setLastName(request.getParameter("lastName"));
		userBean.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
		userBean.setEmail(request.getParameter("email"));
		userBean.setPassword(request.getParameter("password"));
		
		System.out.println("commonAction"+userBean.getLastName());
		
		CommonHelper helper = new CommonHelper();
		
		if(helper.addUser(userBean)){
			response.setStatus(200);
			try {
				response.sendRedirect("./index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			response.setStatus(400);
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		
		
	}



	public static void addFlightsDetails(HttpServletRequest request,
			HttpServletResponse response) {
		
		AddFlightData addFlight = new AddFlightData();
		
		System.out.println(request.getParameter("addPrice"));
		
		addFlight.setFlightName(request.getParameter("flightName"));
		addFlight.setFromCity(request.getParameter("fromCity"));
		addFlight.setToCity(request.getParameter("toCity"));
		addFlight.setDepartureDate(request.getParameter("departureDate"));
		addFlight.setClassType(request.getParameter("class"));
		addFlight.setAvailableSeats(Integer.parseInt(request.getParameter("addSeats")));
		addFlight.setPrice(Integer.parseInt(request.getParameter("addPrice")));
		addFlight.setTime(request.getParameter("addTime"));
		addFlight.setFlightId(Integer.parseInt(request.getParameter("addFlightId")));
		
		System.out.println("commonAction"+addFlight.getFlightName());
		
		CommonHelper helper = new CommonHelper();
		
		if(helper.addFlights(addFlight)){
			response.setStatus(200);
			try {
				response.sendRedirect("jsp/adminPanel.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{ 
			response.setStatus(400);
		}
			
		 
	}



	public static void displayAllDataInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside dispplayDataInfo common action bean");
		CommonHelper helper = new CommonHelper();
		ArrayList<AddFlightData> flightData = null;
		
		try{
			flightData=helper.getAllFlightData();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("flightData", flightData);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/flightsPanel.jsp");
		rd.forward(request, response);
		
	}



	public static void loginCredential(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			
			String emailId = request.getParameter("userName");
			String password = request.getParameter("password");
			
			OutputActionBean opActionBean = new OutputActionBean();
			LoginBean loginBean = opActionBean.userLogin(request);
			CommonHelper commonHelper = new CommonHelper();
			
			int verifyId=commonHelper.verifyLogin(loginBean);
			
			if(verifyId>0){
				response.setStatus(200);
			}
			else{
				response.setStatus(400);
			}
			System.out.println("userId**"+verifyId);
			HttpSession session = request.getSession();
			session.setAttribute("email", loginBean.getEmailId());
			
			session.setAttribute("userId", verifyId);
			
			response.getWriter().write(session.getAttribute("email").toString());
			
		
	}
	
	public static void loginCredentialAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			
			String emailId = request.getParameter("userName");
			String password = request.getParameter("password");
			
			OutputActionBean opActionBean = new OutputActionBean();
			Admin admin = opActionBean.userAdmin(request);
			CommonHelper commonHelper = new CommonHelper();
			
			if(commonHelper.verifyLoginAdmin(admin)){
				response.setStatus(200);
				System.out.println("status code 200");
			}
			else{
				response.setStatus(400);
				System.out.println("status code 400");
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("email", admin.getAdminName());
			System.out.println("*/*/*"+admin.getAdminName());
			///response.sendRedirect("/jsp/userLogin.jsp");
			
			response.getWriter().write(session.getAttribute("email").toString());
			
		
	}

	public static void searchFlights(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside dispplayDataInfo common action bean");
		SearchFlightData sFlightData = new SearchFlightData();
		CommonHelper helper = new CommonHelper();
		ArrayList<OutputSearchBean> searchData = null;
		
		sFlightData.setFromCity(request.getParameter("fromCity"));
		sFlightData.setToCity(request.getParameter("toCity"));
		sFlightData.setDepartureDate(request.getParameter("departureDate"));
		sFlightData.setTravaller(Integer.parseInt(request.getParameter("travaller")));
		sFlightData.setClassType(request.getParameter("class"));
		
		
		System.out.println(sFlightData.getFromCity()+"  "+sFlightData.getToCity()+" "+sFlightData.getDepartureDate()+" "+sFlightData.getClassType());
		System.out.println("----------------");
		
		
			try {
				searchData = helper.getSearchData(sFlightData);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			HttpSession session = request.getSession();
			session.setAttribute("searchData", searchData);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/searchInfo.jsp");
			rd.forward(request, response);
		
		
	} 



	public static void bookFlightTicket(HttpServletRequest request,
			HttpServletResponse response) {
			int flightId = Integer.parseInt(request.getParameter("flightId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			int availSeats = Integer.parseInt(request.getParameter("availableSeats"));
			
			
			HttpSession session = request.getSession();
			session.setAttribute("seatsAvailable", availSeats);
			session.setAttribute("fId", flightId);
			
			SearchFlightData sData = new SearchFlightData();
			int travaller = sData.getTravaller();
			
			int availableSeats = (int) session.getAttribute("seatsAvailable");
			int flightID = (int) session.getAttribute("fId");
			System.out.println("availableSeats>>>>>"+availableSeats);
			
			OutputSearchBean sBeanObject = new OutputSearchBean();
			AddFlightData fData = new AddFlightData();
			CommonHelper helper = new CommonHelper();
			
			System.out.println("inside bookflightticket method in commonactionbean");
			System.out.println(flightId);
			BookingFlight flightBook = new BookingFlight();
			
			flightBook =helper.bookFlight(flightId);
			System.out.println(flightBook.getFlightId()+"*****"+flightBook.getFlightName());
			try {
				response.sendRedirect("CommonController?action=addBookTicketToDb" +
					    "&flightName=" + flightBook.getFlightName() +
					    "&fromCity=" + flightBook.getFromCity() +
					    "&toCity=" + flightBook.getToCity() +
					    "&departureDate=" + flightBook.getDepartureDate() +
					    "&class=" + flightBook.getClassType() +
					    "&price=" + flightBook.getPrice() +
					    "&time=" + flightBook.getTime() +
					    "&flightId=" + flightBook.getFlightId() +
					    "&userId="+ userId +
					    "&travaller="+travaller +
					    "&availableSeats="+availableSeats);
				
				System.out.println("travaller>>"+travaller);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
	}



	public static void addBookTickettoDb(HttpServletRequest request,
			HttpServletResponse response) {
		
					HttpSession session = request.getSession();
					int noOfTravaller  = (int) session.getAttribute("noOfTravaller");
					
					BookingFlight bookFlight = new BookingFlight();
					
					System.out.println(request.getParameter("flightName"));
					
					bookFlight.setFlightName(request.getParameter("flightName"));
					bookFlight.setFromCity(request.getParameter("fromCity"));
					bookFlight.setToCity(request.getParameter("toCity"));
					bookFlight.setDepartureDate(request.getParameter("departureDate"));
					bookFlight.setClassType(request.getParameter("class"));
					bookFlight.setPrice(Integer.parseInt(request.getParameter("price")));
					bookFlight.setTime(request.getParameter("time"));
					bookFlight.setFlightId(Integer.parseInt(request.getParameter("flightId")));
					bookFlight.setUserId(Integer.parseInt(request.getParameter("userId")));
					bookFlight.setTravaller(noOfTravaller);
					
					System.out.println("**Travaller**"+bookFlight.getTravaller());
					
					System.out.println("commonAction*****"+bookFlight.getFlightName()+"***");
					
					
					
					CommonHelper helper = new CommonHelper();
					
					if(helper.addFlightDB(bookFlight)){
						
						//response.setStatus(200);
						try {
							//HttpSession session = request.getSession();
							session.setAttribute("searchData", bookFlight);
							/**/	
							response.sendRedirect("CommonController?action=updateBookTicket" +
								    "&travaller="+noOfTravaller 
								    );
						/**/
							/*RequestDispatcher rd = request.getRequestDispatcher("jsp/bookTicket.jsp");
							try {
								rd.forward(request, response);
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
							//response.sendRedirect("jsp/bookTicket.jsp");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else{
						response.setStatus(400);
					}
	}


	public static void searchFlightsUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("inside searchFlightsUser ");
		
		SearchFlightData sFlightData = new SearchFlightData();
		CommonHelper helper = new CommonHelper();
		ArrayList<OutputSearchBean> searchData = null;
		
		sFlightData.setFromCity(request.getParameter("fromCity"));
		sFlightData.setToCity(request.getParameter("toCity"));
		sFlightData.setDepartureDate(request.getParameter("departureDate"));
		sFlightData.setTravaller(Integer.parseInt(request.getParameter("travaller")));
		sFlightData.setClassType(request.getParameter("class"));
		
		System.out.println("travllr=="+sFlightData.getTravaller());
		int noOfTravaller = sFlightData.getTravaller();
		
		HttpSession session = request.getSession();
		session.setAttribute("noOfTravaller", noOfTravaller);
		
		
		System.out.println(sFlightData.getTravaller()+"**//**"+sFlightData.getFromCity()+"  "+sFlightData.getToCity()+" "+sFlightData.getDepartureDate()+" "+sFlightData.getClassType());
		System.out.println("----------------");
		
		
			try {
				searchData = helper.getSearchUserData(sFlightData);
				//searchData.get(0).getAvailableSeats();
				session.setAttribute("obj", searchData.get(0));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//HttpSession session = request.getSession();
			session.setAttribute("searchData", searchData);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/searchFlightUser.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


	public static void updateTicket(HttpServletRequest request,
			HttpServletResponse response) {
		//AddFlightData flightDataObj = new AddFlightData();
		
		HttpSession session = request.getSession();
		OutputSearchBean flightDataObj =  (OutputSearchBean) session.getAttribute("obj");
		
		int availSeats = (int) session.getAttribute("seatsAvailable");
		int flightID =  (int) session.getAttribute("fId");
		
		System.out.println(">>seatsAvailable>>"+availSeats);
		System.out.println(">>flightID>>"+flightID);
		
		flightDataObj.setAvailableSeats(availSeats);
		flightDataObj.setFlightId(flightID);
		System.out.println("updateTicket**>>>>**"+flightDataObj.getAvailableSeats());
		
		int travaller = Integer.parseInt(request.getParameter("travaller"));
		//int availSeats = Integer.parseInt(request.getParameter("availableSeats"));
		//System.out.println("update availSear**=="+availSeats);
		CommonHelper helper = new CommonHelper();
		if(helper.updateTicket(flightDataObj,travaller)){
			response.setStatus(200);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bookTicket.jsp");
			try {
				try {
					rd.forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{ 
			response.setStatus(400);
		}
	}


	public static void bookingSummary(HttpServletRequest request,
			HttpServletResponse response) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		CommonHelper helper = new CommonHelper();
		ArrayList<OutputSummaryBean> summaryData = null;
				
			try {
				summaryData = helper.getSummaryData(userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			HttpSession session = request.getSession();
			session.setAttribute("summaryData", summaryData);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bookingSummary.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	


	
	
	





}
