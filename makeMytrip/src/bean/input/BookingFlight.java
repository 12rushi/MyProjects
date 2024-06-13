package bean.input;

public class BookingFlight {
	private int bookinkId;
	private String flightName;
	private String fromCity;
	private String toCity;
	private String departureDate;
	private int travaller ;
	private String classType;
	private int price;
	private String time;
	private int userId;
	private int flightId;
	public int getBookinkId() {
		return bookinkId;
	}
	public void setBookinkId(int bookinkId) {
		this.bookinkId = bookinkId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getTravaller() {
		return travaller;
	}
	public void setTravaller(int travaller) {
		this.travaller = travaller;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	
}
