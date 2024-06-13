<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/style.css" />
<style>
	
	.main-Container1{
		height:951px;
		width:1000px;
		border:2px solid black;
		margin: auto;
		
	}

	#flightData {
		   margin-top: 34px;
    display: inline-block;
    margin-left: 734px;

	}
	#flightData a{
		background-color: green;
    font-size: 25px;
    color: white;
    text-decoration: none;
    padding: 6px;

	}
	.formContainer{
       width: 400px;
    height: 341px;
    border: 7px solid #5ea3ff;
    padding: 35px 35px;
    position: fixed;
    background-color: #ffffff;
    z-index: 2;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
}

.logOutLink{
	    margin-left: 886px;
    font-size: 25px;
    background-color: #86d4ff;
    text-decoration: none;
    padding: 5px;
}

#addFlight{
	    height: 36px;
    background-color: red;
    font-size: large;
    border-radius: 12px;
    margin-left: 10px;
    cursor:pointer;
}

#footer{
	width: 1000px;
    margin-top: 296px;
    padding-left: 0px;

}

</style>
</head>
<body>

<div class="main-Container1">
	 <header>
        <!-- Navigation bar -->
            <div class="navbar-container">
            	<img class="logo-mmt" src="../images/logo.png">
      		</div>     	           
    </header> 
    			
	             
	<h1 class="panelName" style="color:red">admin panel</h1><a class="logOutLink" href="../index.jsp">LogOut</a>
		<div id="flightData">
	           <a  href="../CommonController?action=displayAllData">Display all flights data</a>
	  	</div>
		
		<div class="panelInfoContainer">
			 <form action="../CommonController" method="post">
			 		<input type="hidden" value="addFlights" name="action">
			 		 <select class="adminPanelForm" name="flightName" id="flightName" required>
						<option value="">select flight</option>
						<option value="IndiGo">IndiGo</option>
						<option value="Air India">Air India</option>
						<option value="Vistara">Vistara</option>
						<option value="SpiceJet">SpiceJet </option>
					</select>  
	            
	                <select class="adminPanelForm" name="fromCity" id="from" required>
						<option value="">From</option>
						<option value="mumbai">Mumbai</option>
						<option value="pune">Pune</option>
						<option value="nagpur">Nagpur</option>
						<option value="Delhi">Delhi</option>
						<option value="hyderabad">hyderabad </option>
					</select>
					
					 <select class="adminPanelForm" name="toCity" id="to" required>
						<option value="">To</option>
						<option value="Bangalore">Bangalore</option>
						<option value="Chennai">Chennai</option>
						<option value="Kolkata">Kolkata</option>
						<option value="Lucknow">Lucknow</option>
						<option value="Jaipur">Jaipur</option>
					</select>
					
					<input type="date" class="field-searchForm" name="departureDate" placeholder="Departure" required>
					
					<select class="adminPanelForm" name="class" id="class" required>
						<option value="">Class</option>
						<option value="Economy">Economy</option>
						<option value="Business">Business</option>
					</select>
						
					<input type="text" class="adminPanelForm " id="addSeats " name="addSeats" placeholder="addSeats" required/>
					
						
	                <input type="text" class="adminPanelForm" id="addPrice " name="addPrice" placeholder="addPrice" required>
	                
					<input type="text" class="adminPanelForm" id="addTime " name="addTime" placeholder="addTime" required>
					
					<input type="text" class="adminPanelForm" id="addFlightId  " name="addFlightId" placeholder="addFlightId" required>
					
	                <button type="submit" id="addFlight">Add flight data</button>
	                
	            </form><br><br>
	            
	            
         </div>    
        
        		<div id="footer">
    				<%@ include file="footer.jsp" %>
    			</div>
        
</div>   
</body>
</html>