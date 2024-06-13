package helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import ajaxhandler.AjaxHandler;
import bean.input.AddFlightData;
import bean.input.Admin;
import bean.input.BookingFlight;
import bean.input.LoginBean;
import bean.input.OutputSearchBean;
import bean.input.OutputSummaryBean;
import bean.input.SearchFlightData;
import bean.input.UserInputBean;
import impl.Implementation;

public class CommonHelper {
	boolean status;
	Implementation imple = new Implementation();
	
	public boolean addUser(UserInputBean userBean){
		System.out.println("helper"+userBean.getFirstName());
		
		if(userBean.getFirstName().equals("")){
			return false;
		}
		return imple.saveUser(userBean);
	}
	
	
	public boolean addFlights(AddFlightData addFlight){
		
		if(addFlight.getFlightName().equals("")){
			return false;
		}
		return imple.saveFlightsData(addFlight) ;
	}


	public ArrayList<AddFlightData> getAllFlightData() throws SQLException{
		// TODO Auto-generated method stub
		return Dao.getAllFlightData();
	}
	
	
	public int verifyLogin(LoginBean login){
		if(login.getEmailId().isEmpty()){
			return 0;
		}
		
		AjaxHandler handler = new AjaxHandler();
		return handler.checkLogin(login.getEmailId(), login.getPassword());
	}
	
	public boolean verifyLoginAdmin(Admin admin){
		if(admin.getAdminName().isEmpty()){
			return false;
		}
		
		AjaxHandler handler = new AjaxHandler();
		return handler.checkLoginAdmin(admin.getAdminName(), admin.getAdminPassword());
	}





	public ArrayList<OutputSearchBean> getSearchData(SearchFlightData sFlightData)  throws SQLException{
		return Dao.getSearchFlightData(sFlightData);
	}

	public ArrayList<OutputSearchBean> getSearchUserData(SearchFlightData sFlightData) throws SQLException{
	
		return Dao.getSearchFlightUserData(sFlightData);
	}



	public BookingFlight bookFlight(int flightId) {
		System.out.println("inside helper : "+flightId);
		return Dao.bookTicket(flightId);
	}


	public boolean addFlightDB(BookingFlight bookFlight) {
		System.out.println("helper"+bookFlight.getFlightId());
		
		if(bookFlight.getFlightName().equals("")){
			return false;
		}
		return imple.saveFlightDB(bookFlight);
	}


	public boolean updateTicket(OutputSearchBean flightDataObj,int travaller ) {
		if(travaller==0){
			return false;
		}
		return imple.updateTravaller(flightDataObj,travaller);
	}


	public ArrayList<OutputSummaryBean> getSummaryData(int userId) throws SQLException{
		return Dao.getSummaryData(userId);
	}


	public List<String> getState(String country) {
		System.out.println("get state helper");
		return Dao.getState(country);
		}

		public List<String> getCity(String state) {

		System.out.println("get city helper");
		return Dao.getCity(state);
		}


	






	
	
	
}
