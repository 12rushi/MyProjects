package bean.input;

public class SearchFlightData {
	
	private String fromCity;
	private String toCity;
	private String departureDate;
	private int travaller;
	private String classType;
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
	
	public int getTravaller() {
		return travaller;
	}
	public void setTravaller(int travaller) {
		this.travaller = travaller;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	
}
