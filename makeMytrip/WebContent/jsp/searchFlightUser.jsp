<%@page import="bean.input.OutputSearchBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/style.css" />
<style>

	.main-Container1{
		height:911px;
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
	
	.bookLink:hover{
		color:green;
	}
	
	#footer{
		margin-top: 496px;
    margin-left: -1px;
    margin-right: -2px;
	}
</style>
</head>
<body>
		<div class="main-Container1">	  	
	  	 	
			<div>
      		     <h1 style="color:red">Available Flights</h1>
      		     	
      		     	<table>
			      		   <tr>
			      		   		<th class="th">flightId</th>
								<th class="th">flightName</th>
								<th class="th">fromCity</th>
								<th class="th">toCity</th>
								<th class="th">departureDate </th>
								<th class="th">class</th>
								<th class="th">availableSeats </th>
								<th class="th">Price(Rs)</th>
								<th class="th">Time</th>
							</tr>
      		     
      		     	<%
      		     	ArrayList searchData = (ArrayList)session.getAttribute("searchData");
      		     	
      		     	Iterator iterator = searchData.iterator();
      		     	
      		     	
      		     	
      		     	while(iterator.hasNext()){
      		     		OutputSearchBean searchBeanObj = (OutputSearchBean) iterator.next();
      		     	
      		     	%>
      		     	
      		     	<tr>
      		     		<td><%= searchBeanObj.getFlightId() %></td>
						<td><%= searchBeanObj.getFlightName() %></td>
						<td><%= searchBeanObj.getFromCity()%></td>
						<td><%= searchBeanObj.getToCity()%></td>
						<td><%= searchBeanObj.getDepartureDate()%></td>
						<td><%= searchBeanObj.getClassType()%></td>
						<td><%= searchBeanObj.getAvailableSeats()%></td>
						<td><%= searchBeanObj.getPrice()%></td>
						<td><%= searchBeanObj.getTime()%></td>
						 
						<td><a class="bookLink" href="CommonController?action=bookTicket&flightId=<%=searchBeanObj.getFlightId()%>&userId=<%=session.getAttribute("userId")%>&availableSeats=<%= searchBeanObj.getAvailableSeats()%>">Book</a></td>	
				</tr>
				<%
      		     	}
				%>
				
					</table>
      		     
      		     </div>
      		     
      		     <div id="footer">
    				<%@ include file="footer.jsp" %>
    			</div>
      		     
   	</div>
</body>
</html>