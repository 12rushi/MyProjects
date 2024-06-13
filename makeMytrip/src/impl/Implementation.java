package impl;

import dao.Dao;
import bean.input.AddFlightData;
import bean.input.BookingFlight;
import bean.input.OutputSearchBean;
import bean.input.SearchFlightData;
import bean.input.UserInputBean;

public class Implementation {
	
	private static int status;
	
	public boolean saveUser(UserInputBean userBean){
		
		System.out.println("impl"+userBean.getLastName());
		status = Dao.addUser(userBean);
		if(status==1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public boolean saveFlightsData(AddFlightData addFlight){
			
			System.out.println("impl"+addFlight.getFromCity());
			status = Dao.addFlightsData(addFlight);
			if(status==1){
				return true;
			}
			else{
				return false;
			}
		}


	public boolean saveFlightDB(BookingFlight bookFlight) {
		status = Dao.addFligthDB(bookFlight);
		if(status==1){
			return true;
		}
		else{
			return false;
		}
	}


	public boolean updateTravaller(OutputSearchBean flightDataObj,int travaller) {
		status = Dao.updateAvailableSeats(flightDataObj,travaller);
		if(status==1){
			return true;
		}
		else{
			return false;
		}
	}




	/*public boolean bookTicket(int flightId) {
		status = Dao.bookTicket(flightId);
		if(status==1){
			return true;
		}
		else{
			return false;
		}
	}*/


//	public boolean searchFlightsData(SearchFlightData sFlightData) {
//		System.out.println("inside impl searchFlightData");
//		System.out.println(sFlightData.getFromCity()+"  "+sFlightData.getToCity()+" "+sFlightData.getDepartureDate()+" "+sFlightData.getClassType());
//		
//		status = Dao.searchFlightData(sFlightData);
//		if(status==1){
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
	
	
}
