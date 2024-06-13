<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/style.css" />
<link rel="stylesheet" href="../CSS/popup.css" />
<style>
	.form-content{
		text-align: center;
    background-color: white;
    height: 240px;
    width: 925px;
    margin: auto;
    margin-top: -298px;
    border: 2px solid #3f82f9;
    position: relative;
    border-radius: 9px;
	}
	.hvr{
		background-color: red;color: white;padding:3px 9px;
	}
	.hvr:hover{
		background-color: #ff8080;
    	color: white;
	}
	
	#footer{
    height: 160px;
    width: 997px;
    margin-top: 447px;
    margin-left: 2px;
	}
</style>
</head>
<body>
	 <!--<h1>user login page</h1>
	<p><%=session.getAttribute("email")%></p>-->  
	<% 
		String user = session.getAttribute("email").toString();
	%>
	
<div class="main-Container">
	<div class="bgImg">
	 <header>
        <!-- Navigation bar -->
            <div class="navbar-container">
            	<img class="logo-mmt" src="../images/logo.png">

			<div class="login-registration">
				
				<h2 id="loginNameDetail" style="color:#2ab8ff;margin-right:10px;margin-top:18px;display: inline-block;"><%=session.getAttribute("email")%></h2>
				<a class="hvr" href="../CommonController?action=summary&userId=<%=session.getAttribute("userId")%>" >Booking history</a>
				<a class="hvr" id ="logoutLink"  href="../CommonController?action=logout" >logout</a>
              <!-- <button id="logOut" class="logIn" href="CommonController?action=logout" onclick="popwindow.hideLogoutBtn()">LogOut</button> -->  
            </div>
            
            <div style="clear:both"></div>
      </div>     	           
    </header>
    	
	</div>	
		
		

    <section class="formSection">
       
        <div class="form-content">
            <h1>Find the Best Deals on Flights</h1>
            <form action="../CommonController" method="post">
            
            <input type="hidden" value="searchUserFlight" name="action">
            
                <select class="field-searchForm" name="fromCity" id="from" required>
					<option value="">From</option>
					<option value="mumbai">Mumbai</option>
					<option value="pune">Pune</option>
					<option value="nagpur">Nagpur</option>
					<option value="Delhi">Delhi</option>
					<option value="hyderabad">hyderabad </option>
				</select>
				 
				 <select class="field-searchForm" name="toCity" id="to" required>
					<option value="">To</option>
					<option value="Bangalore">Bangalore</option>
					<option value="Chennai">Chennai</option>
					<option value="Kolkata">Kolkata</option>
					<option value="Lucknow">Lucknow</option>
					<option value="Jaipur">Jaipur</option>
				</select>
					
                <input type="date" id ="date" class="field-searchForm" name="departureDate" placeholder="Departure" required>
                
                 <select class="field-searchForm" name="travaller" id="travaller" required>
					<option value="">travaller</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			
				<select class="field-searchForm" name="class" id="class" required>
					<option value="">Class</option>
					<option value="Economy">Economy</option>
					<option value="Business">Business</option>
				</select>
				
                <button type="submit" id="flight-search">Search</button>
            </form>
        </div>
    	
    	<div id="footer">
    		<%@ include file="footer.jsp" %>
    	</div>
    </section>
		
		
</div>	

	<script type="text/javascript">
		var today = new Date().toISOString().split('T')[0];
		document.getElementById("date").setAttribute("min",today);
	</script>
</body>
</html>