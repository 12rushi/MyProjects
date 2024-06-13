<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="bean.input.OutputSummaryBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

	.main-Container2{
		width:1050px;
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

	#bookSummary{
		border-collapse: collapse;
    margin: auto;
    margin-top: 145px;
    width: 919px;
    /* height: 49px; */
    font-size: 17px;
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
</style>
</head>
<body>
	
	<div class="main-Container2">	  	
	  	 	
			<div>
      		     <h1 style="color:red">Booking summary</h1>
 	
      		     	<table id="bookSummary">
			      		   <tr>
			      		   		<th class="th">UserName</th>
			      		   		<th class="th">UserEmail</th>
								<th class="th">FlightName</th>
								<th class="th">FromCity</th>
								<th class="th">ToCity</th>
								<th class="th">DepartureDate </th>
								<th class="th">Travallet</th>
								<th class="th">Class</th>
								<th class="th">Price(Rs)</th>
								<th class="th">Time</th>
								<th class="th">FlightId</th>
							</tr>
      		     
      		     	<%
      		     	ArrayList summaryData = (ArrayList)session.getAttribute("summaryData");
      		     	
      		     	Iterator iterator = summaryData.iterator();
      		     	
      		     	
      		     	
      		     	while(iterator.hasNext()){
      		     		OutputSummaryBean summaryBeanObj = (OutputSummaryBean) iterator.next();
      		     	
      		     	%>
      		     	
      		     	<tr>
      		     		<td><%= summaryBeanObj.getFirstName()%></td>
						<td><%= summaryBeanObj.getEmail() %></td>
						<td><%= summaryBeanObj.getFlightName() %></td>
						<td><%= summaryBeanObj.getFromCity()%></td>
						<td><%= summaryBeanObj.getToCity()%></td>
						<td><%= summaryBeanObj.getDepartureDate()%></td>
						<td><%= summaryBeanObj.getTravaller()%></td>
						<td><%= summaryBeanObj.getClassType()%></td>
						<td><%= summaryBeanObj.getPrice()%></td>
						<td><%= summaryBeanObj.getTime()%></td>
						<td><%= summaryBeanObj.getFlightId()%></td>	
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