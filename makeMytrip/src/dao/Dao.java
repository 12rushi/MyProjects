package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import bean.input.AddFlightData;
import bean.input.BookingFlight;
import bean.input.OutputSearchBean;
import bean.input.OutputSummaryBean;
import bean.input.SearchFlightData;
import bean.input.UserInputBean;
import utility.DBconnection;

public class Dao {
	private static String query;
	private static PreparedStatement ps;
	private static int resultSet;
	private static ResultSet rs=null;
	
	public static int addUser(UserInputBean user){
		try{
			Connection connection=DBconnection.getConnection();
			query = "insert into user(firstName,lastName,mobileNo,email,password,is_active,created_by,modified_by ) values(?,?,?,?,?,?,?,?)";
			
			ps=connection.prepareStatement(query);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setLong(3, user.getMobileNo());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setString(6, "Y");
			ps.setString(7, "0");
			ps.setString(8, null);
			
			resultSet=ps.executeUpdate();
			System.out.println("Dao resultSet"+user.getPassword());
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return resultSet;
	}
		
		public static int addFlightsData(AddFlightData addFlight){
			try{
				Connection connection=DBconnection.getConnection();
				query = "insert into adminPanel(flightName,fromCity,toCity,departureDate,class,availableSeats,price,time,fk_flight_id,is_active,created_by,modified_by) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				
				ps=connection.prepareStatement(query);
				
				ps.setString(1, addFlight.getFlightName());
				ps.setString(2, addFlight.getFromCity());
				ps.setString(3,addFlight.getToCity());
				ps.setString(4, addFlight.getDepartureDate());
				ps.setString(5, addFlight.getClassType());
				ps.setInt(6, addFlight.getAvailableSeats());
				ps.setInt(7, addFlight.getPrice());
				ps.setString(8, addFlight.getTime());
				ps.setInt(9, addFlight.getFlightId());
				ps.setString(10, "Y");
				ps.setString(11, "0");
				ps.setString(12, null);
				
				resultSet=ps.executeUpdate();

			}
			catch(Exception e){
				System.out.println(e);
			}
			return resultSet;
		}

		public static ArrayList<AddFlightData> getAllFlightData() throws SQLException{
			ArrayList<AddFlightData> flightData = new ArrayList<>();
			
			try{
				Connection connection=DBconnection.getConnection();
				query = "select flightName,fromCity,toCity,departureDate,class,availableSeats,price,time,fk_flight_id from adminPanel";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()){
					
					AddFlightData flightDataObj = new AddFlightData();
					
					flightDataObj.setFlightName(rs.getString("flightName"));
					flightDataObj.setFromCity(rs.getString("fromCity"));
					flightDataObj.setToCity(rs.getString("toCity"));
					flightDataObj.setDepartureDate(rs.getString("departureDate"));
					flightDataObj.setClassType(rs.getString("class"));
					flightDataObj.setAvailableSeats(rs.getInt("availableSeats"));
					flightDataObj.setPrice(rs.getInt("price"));
					flightDataObj.setTime(rs.getString("time"));
					flightDataObj.setFlightId(rs.getInt("fk_flight_id"));
					
					flightData.add(flightDataObj);
					
				}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			finally{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}
			
			
			return flightData;
		}

		
		public static int verifyCredentials(String emailId, String password) {
			int userId=0;
			
			boolean credentialsMatch = false;
			
			try{
				Connection connection=DBconnection.getConnection();
				query = "select email,password,user_id from user where email=?";
				ps = connection.prepareStatement(query);
			
				ps.setString(1, emailId);
				//ps.setInt(2, userId);
				
				rs = ps.executeQuery();
				
				if(rs.next()){
					if(rs.getString("email").equals(emailId) && rs.getString("password").equals(password)){
						userId = rs.getInt("user_id");
						return userId;
					}
					else{
						return 0;
					}
				}
				else{
					return 0;
					
				}
						
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			return 0;
		}

		public static boolean verifyCredentialsAdmin(String emailId,
				String password) {
			
			boolean credentialsMatch = false;
			
			try{
				Connection connection=DBconnection.getConnection();
				query = "select adminName ,adminPassword  from admin where adminName =?";
				ps = connection.prepareStatement(query);
			
				ps.setString(1, emailId);
				
				rs = ps.executeQuery();
				
				if(rs.next()){
					if(rs.getString("adminName").equals(emailId) && rs.getString("adminPassword").equals(password)){
						System.out.println("inside if admin ******");
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
					
				}
						
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			return credentialsMatch;

		}



		public static ArrayList<OutputSearchBean> getSearchFlightData(SearchFlightData sFlightData) {
			ArrayList<OutputSearchBean> outPutSearchBean = new ArrayList<>();
			try{
				Connection connection=DBconnection.getConnection();
				query = "select flightName,fromCity,toCity,departureDate,class,availableSeats,price,time,fk_flight_id from adminPanel";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()){
					 
					AddFlightData flightDataObj = new AddFlightData();
				
					
					flightDataObj.setFlightName(rs.getString("flightName"));
					flightDataObj.setFromCity(rs.getString("fromCity"));
					flightDataObj.setToCity(rs.getString("toCity"));
					flightDataObj.setDepartureDate(rs.getString("departureDate"));
					flightDataObj.setClassType(rs.getString("class"));
					flightDataObj.setAvailableSeats(rs.getInt("availableSeats"));
					flightDataObj.setPrice(rs.getInt("price"));
					flightDataObj.setTime(rs.getString("time"));
					flightDataObj.setFlightId(rs.getInt("fk_flight_id"));
					 
					if(flightDataObj.getFromCity().equals(sFlightData .getFromCity()) &&
						    flightDataObj.getToCity().equals(sFlightData.getToCity()) &&
						    flightDataObj.getDepartureDate().equals(sFlightData.getDepartureDate()) &&
						    flightDataObj.getClassType().equals(sFlightData.getClassType()))
					{
						System.out.println("get searched data");
						System.out.println(sFlightData.getFromCity()+"  "+sFlightData.getToCity()+" "+sFlightData.getDepartureDate()+" "+sFlightData.getClassType());

						
						OutputSearchBean oSearchBean = new OutputSearchBean();
						
						oSearchBean.setFlightName(rs.getString("flightName"));
						oSearchBean.setFromCity(rs.getString("fromCity"));
						oSearchBean.setToCity(rs.getString("toCity"));
						oSearchBean.setDepartureDate(rs.getString("departureDate"));
						oSearchBean.setClassType(rs.getString("class"));
						oSearchBean.setAvailableSeats(rs.getInt("availableSeats")); 
						oSearchBean.setPrice(rs.getInt("price"));
						oSearchBean.setTime(rs.getString("time"));
						oSearchBean.setFlightId(rs.getInt("fk_flight_id"));
						
						outPutSearchBean.add(oSearchBean);
						
					}
					else{
						System.out.println("error in gatting searched data");
						System.out.println("***********************");
					}
					
				}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return outPutSearchBean;
		}

		


		public static BookingFlight bookTicket(int flightId) {
			BookingFlight flightBook = new BookingFlight();
			int fId = flightId;
			System.out.println(fId+"inside DAO");
			try{
				Connection connection=DBconnection.getConnection();
				query = "select * from adminPanel where fk_flight_id = '"+fId+"'";
				
				ps=connection.prepareStatement(query);
				rs=ps.executeQuery();
				
				
				while(rs.next()){
					flightBook.setFlightName(rs.getString("flightName"));	
					flightBook.setFromCity(rs.getString("fromCity"));
					flightBook.setToCity(rs.getString("toCity"));
					flightBook.setDepartureDate(rs.getString("departureDate"));
					flightBook.setClassType(rs.getString("class"));
					flightBook.setPrice(rs.getInt("price"));
					flightBook.setTime(rs.getString("time"));
					flightBook.setFlightId(rs.getInt("fk_flight_id"));
					
				}
				System.out.println(flightBook.getFlightId()+""+flightBook.getPrice()+""+flightBook.getDepartureDate());
								
			}
			catch(Exception e){
				System.out.println(e);
			}
			return flightBook;
		}

		public static int addFligthDB(BookingFlight bookFlight) {
			System.out.println("travaller"+bookFlight.getTravaller());
			System.out.println("userId"+bookFlight.getUserId());
			
			System.out.println("totalPrice"+(bookFlight.getTravaller() * bookFlight.getPrice()));
			
			int finalPrice = (bookFlight.getTravaller()*bookFlight.getPrice());
			bookFlight.setPrice(finalPrice);
			try{
				Connection connection=DBconnection.getConnection();
				query = "insert into booking(flightName,fromCity,toCity,departure,travaller,class,price,time,fk_user_id,fk_flight_id ,is_active,created_by,modified_by ) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				ps=connection.prepareStatement(query);
				
				ps.setString(1,bookFlight.getFlightName());
				ps.setString(2,bookFlight.getFromCity());
				ps.setString(3,bookFlight.getToCity());
				ps.setString(4,bookFlight.getDepartureDate());
				ps.setInt(5, bookFlight.getTravaller());
				ps.setString(6,bookFlight.getClassType());
				ps.setInt(7,bookFlight.getPrice());
				ps.setString(8,bookFlight.getTime());
				ps.setInt(9, bookFlight.getUserId());
				ps.setInt(10,bookFlight.getFlightId());
				ps.setString(11,"Y");
				ps.setString(12,"0");
				ps.setString(13,null); 
				
				resultSet=ps.executeUpdate();
				System.out.println("Dao booking resultSet**"+bookFlight.getUserId()+bookFlight.getTravaller()+bookFlight.getFlightName());
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			return resultSet;
		}
		
		

		public static ArrayList<OutputSearchBean> getSearchFlightUserData(SearchFlightData sFlightData) {
			ArrayList<OutputSearchBean> outPutSearchBean = new ArrayList<>();
			try{
				Connection connection=DBconnection.getConnection();
				query = "select flightName,fromCity,toCity,departureDate,class,availableSeats,price,time,fk_flight_id from adminPanel";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()){
					 
					AddFlightData flightDataObj = new AddFlightData();
				
					
					flightDataObj.setFlightName(rs.getString("flightName"));
					flightDataObj.setFromCity(rs.getString("fromCity"));
					flightDataObj.setToCity(rs.getString("toCity"));
					flightDataObj.setDepartureDate(rs.getString("departureDate"));
					flightDataObj.setClassType(rs.getString("class"));
					flightDataObj.setAvailableSeats(rs.getInt("availableSeats"));
					flightDataObj.setPrice(rs.getInt("price"));
					flightDataObj.setTime(rs.getString("time"));
					flightDataObj.setFlightId(rs.getInt("fk_flight_id"));
					 
					if(flightDataObj.getFromCity().equals(sFlightData .getFromCity()) &&
						    flightDataObj.getToCity().equals(sFlightData.getToCity()) &&
						    flightDataObj.getDepartureDate().equals(sFlightData.getDepartureDate()) &&
						    flightDataObj.getClassType().equals(sFlightData.getClassType()))
					{
						System.out.println("get searched data");
						System.out.println(sFlightData.getFromCity()+"  "+sFlightData.getToCity()+" "+sFlightData.getDepartureDate()+" "+sFlightData.getClassType());

						
						OutputSearchBean oSearchBean = new OutputSearchBean();
						
						oSearchBean.setFlightName(rs.getString("flightName"));
						oSearchBean.setFromCity(rs.getString("fromCity"));
						oSearchBean.setToCity(rs.getString("toCity"));
						oSearchBean.setDepartureDate(rs.getString("departureDate"));
						oSearchBean.setClassType(rs.getString("class"));
						oSearchBean.setAvailableSeats(rs.getInt("availableSeats")); 
						oSearchBean.setPrice(rs.getInt("price"));
						oSearchBean.setTime(rs.getString("time"));
						oSearchBean.setFlightId(rs.getInt("fk_flight_id"));
						
						outPutSearchBean.add(oSearchBean);
						
						
						
					}
					else{
						System.out.println("error in gatting searched data");
						System.out.println("***********************");
					}
					
				}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return outPutSearchBean;
			
		}

		public static int updateAvailableSeats(OutputSearchBean flightDataObj,int travaller) {
			System.out.println("totalSeats=="+flightDataObj.getAvailableSeats());
			int availSeasts = (flightDataObj.getAvailableSeats() - travaller );
			flightDataObj.setAvailableSeats(availSeasts);
			System.out.println("availSeasts >>"+availSeasts);
			int flightId = flightDataObj.getFlightId();
			try{
				Connection connection=DBconnection.getConnection();
				query = "update adminPanel set availableSeats=? where fk_flight_id =?";
				
				ps=connection.prepareStatement(query);
				
				ps.setInt(1,flightDataObj.getAvailableSeats());
				ps.setInt(2,flightId);
				 
				
				resultSet=ps.executeUpdate();
				System.out.println("Dao update Seats**");
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			return resultSet;
		}

		public static ArrayList<OutputSummaryBean> getSummaryData(int userId) {
			
			ArrayList<OutputSummaryBean> summaryData = new ArrayList<>();
			System.out.println("summaryBooking userID=="+userId);
			try{
				Connection connection=DBconnection.getConnection();
				query = "select u.firstName,u.email,b.flightName,b.fromCity,b.toCity,b.departure,b.travaller,b.class,b.price,b.time,b.fk_flight_id "+
						"from user u join booking b on u.user_id = b.fk_user_id where u.user_id ='"+userId+"' ";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()){
					 
					OutputSummaryBean outputSummaryBean = new OutputSummaryBean();
				
					outputSummaryBean.setFirstName(rs.getString("firstName"));
					outputSummaryBean.setEmail(rs.getString("email"));
					outputSummaryBean.setFlightName(rs.getString("flightName"));
					outputSummaryBean.setFromCity(rs.getString("fromCity"));
					outputSummaryBean.setToCity(rs.getString("toCity"));
					outputSummaryBean.setDepartureDate(rs.getString("departure"));
					outputSummaryBean.setTravaller(rs.getInt("travaller"));
					outputSummaryBean.setClassType(rs.getString("class"));
					outputSummaryBean.setPrice(rs.getInt("price"));
					outputSummaryBean.setTime(rs.getString("time"));
					outputSummaryBean.setFlightId(rs.getInt("fk_flight_id"));
					
					summaryData.add(outputSummaryBean);
					
					System.out.println(outputSummaryBean.getFirstName()+"**"+outputSummaryBean.getFlightName());
					
				}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return summaryData;
		}
		
		
		
		public static List<String> getState(String country) {
			   List<String> states = new ArrayList<String>();
			   Connection con = null;
			   try {
				   con=DBconnection.getConnection();
				   query = "SELECT i2.place FROM India i1 JOIN India i2 ON i1.pri_id = i2.BoundedBy WHERE i1.place LIKE ?";
				   ps = con.prepareStatement(query);
				   ps.setString(1, country);
			       rs = ps.executeQuery();
			       while (rs.next())
			       {
			           states.add(rs.getString("place"));
			       }
			   }
			   catch (Exception e) {
			       e.printStackTrace();
			   }
			   finally {
			       try {
			           if (con != null) {
			               con.close();
			           }
			       } catch (SQLException e) {
			           e.printStackTrace();
			       }
			   }
			   return states;
			}




			public static List<String> getCity(String state) {

			List<String> cities = new ArrayList<String>();
			   Connection con = null;
			   try {
				   con=DBconnection.getConnection();
				   query = "SELECT i2.place FROM India i1 JOIN India i2 ON i1.pri_id = i2.BoundedBy WHERE i1.place LIKE ?";
				   ps = con.prepareStatement(query);
				   System.out.println("ff");
				   ps.setString(1,"%"+ state+"%");
			       rs = ps.executeQuery();
			       while (rs.next())
			       {
			        cities.add(rs.getString("place"));
			       }
			   }
			   catch (Exception e) {
			       e.printStackTrace();
			   }
			   finally {
			       try {
			           if (con != null) {
			               con.close();
			           }
			       } catch (SQLException e) {
			           e.printStackTrace();
			       }
			   }
			   return cities;

			}
		
		
		
}	
		
		
		
	



