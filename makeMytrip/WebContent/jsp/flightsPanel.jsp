<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="bean.input.AddFlightData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/style.css" />
<style>
	
	.main-Container-flight{
		
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
	
	.flightContainer{
		border:1px solid black;
		height:700px;
		width:700px;
	}
	
	table{
		border-collapse: collapse;
	    margin: auto;
	    margin-top: 32px;
	    width: 919px;
	}
	tr,th,td{
		
		text-align:center;
		margin:3px;
		padding:5px;
	}
	tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>
	
	<div class="main-Container-flight">
	     
      		     <div flightContainer>
      		     <h1 style="color:red">All flights information</h1>
      		     	<table>
			      		   <tr>
								<th class="th">flightName</th>
								<th class="th">fromCity</th>
								<th class="th">toCity</th>
								<th class="th">departureDate </th>
								<th class="th">class</th>
								<th class="th">availableSeats </th>
								<th class="th">Price</th>
								<th class="th">Time</th>
								<th class="th">FlightId</th>
							</tr>
      		     
      		     	<%
      		     	ArrayList flightData = (ArrayList)session.getAttribute("flightData");
      		     	
      		     	Iterator iterator = flightData.iterator();
      		     	while(iterator.hasNext()){
      		     		AddFlightData flightDataObj = (AddFlightData) iterator.next();
      		     	
      		     	%>
      		     	
      		     	<tr>
						<td><%= flightDataObj.getFlightName() %></td>
						<td><%= flightDataObj.getFromCity()%></td>
						<td><%= flightDataObj.getToCity()%></td>
						<td><%= flightDataObj.getDepartureDate()%></td>
						<td><%= flightDataObj.getClassType()%></td>
						<td><%= flightDataObj.getAvailableSeats()%></td>
						<td><%= flightDataObj.getPrice()%></td>
						<td><%= flightDataObj.getTime()%></td>
						<td><%= flightDataObj.getFlightId()%></td>	
				</tr>
				<%
      		     	}
				%>
				
					</table>
      		     
      		     </div>
   
	
	
	</div>
	
</body>
</html>