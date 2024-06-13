<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.input.BookingFlight"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style>
	
	.main-Container{
		height:951px;
		width:1000px;
		border:2px solid black;
		margin: auto;
		
	}
	.navbar-container{
		position: relative;
	}
	
	.logo-mmt{
		height: 109px;
		padding-left:20px;
		position:absolute;
		top: -23px;
    	left: 30px;
	}
	
	.booking{
		margin-top: 144px;
    text-align: center;
    color: red;
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

table{
		border-collapse: collapse;
    margin: auto;
    margin-top: 145px;
    width: 919px;
    /* height: 49px; */
    font-size: 20px;
	}
	tr,th,td{
		text-align:center;
		margin:3px;
		padding:5px;
	}
	tr:nth-child(even) {background-color: #f2f2f2;}
	.bookLink{
		text-decoration:none;
		color:green;
	}
	#homePage{
		text-decoration: none;
    background-color: #59b4ff;
    color: black;
    font-size: 24px;
    padding: 2px 5px 2px 5px;
    margin-left: 856px;
	}
	
	#homePage:hover{
		 background-color: #449ce5;
		 
	}
	
	#footer{
		    margin-top: 465px;
    		margin-left: -1px;
    		margin-right: -2px;
		}

</style>
</head>
<body>
	<div class="main-Container">
		 
	    	<div class="booking">
	    		<h1>Booking Successful</h1> 
	    	</div>		
	    	<a id="homePage" href ="jsp/userLogin.jsp" >home page</a>
	    	<%
	    	BookingFlight flight = new BookingFlight();
	    	flight = (BookingFlight)session.getAttribute("searchData");
	    	%>
      		     	<table>
			      		   <tr>
								<th class="th">flightId</th>
								<th class="th">flightNam</th>
								<th class="th">fromCity</th>
								<th class="th">toCity </th>
								<th class="th">departureDate</th>
								<th class="th">price</th>
								<th class="th">Time</th>
							</tr>
      		     	
      		     	<tr>
						<td><%= flight.getFlightId() %></td>
						<td><%= flight.getFlightName()%></td>
						<td><%= flight.getFromCity()%></td>
						<td><%= flight.getToCity()%></td>
						<td><%= flight.getDepartureDate()%></td>
						<td><%= flight.getPrice()%></td>
						<td><%= flight.getTime()%></td>
						
					</tr>
				
				
					</table>
      		     
      		     	 <div id="footer">
    					<%@ include file="footer.jsp" %>
    				</div>
      		     
      		     </div>   
	
		   	
        
	</div>  
</body>
</html>