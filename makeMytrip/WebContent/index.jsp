<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>makeMyTrip</title>
<link rel="stylesheet" href="./CSS/style.css" />
<link rel="stylesheet" href="./CSS/popup.css" />
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
	#logoutLink:hover{
		background-color: black;
	}
	footer{
		background-color: black;
		color: white;
		height: 89px;
    	margin-left: -1px;
    	margin-right: -2px;
	}
</style>
</head>
<body>
	<div class="main-Container">
			<div class="bgImg">
				 <header>
			        <!-- Navigation bar -->
			            <div class="navbar-container">
			            	<img class="logo-mmt" src="./images/logo.png">
			
						<div class="login-registration">
							<h2 id="loginNameDetail" style="color:#2ab8ff;margin-right:10px;margin-top:18px;display: inline-block;"></h2>
							<a id ="logoutLink" style="display:none;background-color: red;color: white;padding:3px 9px;}" href="CommonController?action=logout" >logout</a>
			               <button id="logInBtn" class="logIn" onclick="popwindow.displayPop()" href="#">Login </button>
			              <!-- <button id="logOut" class="logIn" href="CommonController?action=logout" onclick="popwindow.hideLogoutBtn()">LogOut</button> -->  
							<button id="registrationBtn" class="logIn" onclick="popwindow.registrationWindow()" href="#">Register</button>
			            </div>
			            
			            <div style="clear:both"></div>
			      </div>     	           
			    </header>
		    </div>
    	<div id="popDisplayIn" class="popUp" onclick="popwindow.closeWindow()"></div>
    	<div class="formContainer" id="frcontainer">
			<form action="" >
			
				<input type="hidden" value="login" action="action">
				
				<label for="userType">Login As:</label><br>
				<input id="userTypeUser" name="userType" type="radio" value="user" checked>
				<label for="userTypeUser">User</label>
				<input id="userTypeAdmin" name="userType" type="radio" value="admin" checked>
				<label for="userTypeAdmin">Admin</label><br>
				
				<label class="labInput" for="username">Username:</label><br>
				<input class="labInput inputHovr" id="userName" name="userName" type="text" placeholder="Username" ><br /><span id="userNameErr"></span><br>
				<label class="labInput" for="password">Password:</label><br>
				<input class="labInput inputHovr" name="password" id="password" type="password" placeholder="Password" ><br><span id="userPasswordErr"></span><br>
				<button type="button" class="labInput" id="sbt" onclick="validateAjaxCode()">Log In</button>
				<button class="labInput regsbtnInput" id="registrationBtnInput" onclick="popwindow.insideLoginbtn()">Register Here</button>
				<button id="cross" class="close" onclick="popwindow.closeWindow()">X</button>
			</form>
		</div> 
		
		<div class="registrationContainer" id="registrationwindow">
			<button id="cross" class="close" onclick="popwindow.closeWindow()">X</button>
				
			<div class="registrationFormContainer">
			<h1>Registration Form</h1>
            <form id="myForm" action="CommonController" method="post">
            	<input type="hidden" value="register" name="action">
                <label for="firstName">First Name:</label><br />
                <input class="fName inputWidth" maxlength="15" type="text" id="firstName" name="firstName" onkeypress="validator.avoidNumberSpecialKay(event)" onblur="validator.validateFirstName()" onpaste="return false" oncopy="return false" ><br /><span id="firstNameErr"></span><br>
                
                <label for="lastName">Last Name:</label><br />
                <input class="lName inputWidth" maxlength="15" type="text" id="lastName" name="lastName" onkeypress="validator.avoidNumberSpecialKay(event)" onblur="validator.validateLastName()" onpaste="return false" oncopy="return false"><br /><span id="lastNameErr"></span><br>

				<label> Mobile No.:</label><br />
				<input type="text" class="mobile inputWidth" maxlength="10" id="mobileNo" name="mobileNo" onkeypress="validator.avoidAlphabetsSpeChar(event)" onblur="validator.validateMobileNo()" onpaste="return false" oncopy="return false"/><br /><span id="mobileErr"></span><br>

				<label> Email:</label><br />
				<input type="text" class="email inputWidth" id="emailId" name="email" onblur="validator.validateEmail()" onpaste="return false" oncopy="return false"/><br /><span id="EmailErr"></span><br>
				
				<label for="country" class="label">Country:</label>
				  <select name="country" id="country" class="inputWidth form-controls">
				      <option value="">Select</option>
				      <option value="India">India</option>
				  </select><br /><br />  
				  
				  <label for="state" class="label">State:</label>
					  <select name="state" id="state" class="inputWidth form-controls">
					      <option value="">Select</option>
					     
					  </select><br /><br />  
					  
				<label for="city" class="label">City:</label>
					  <select name="city" id="city" class="inputWidth form-controls">
					      <option value="">Select</option>
					     
					  </select>	<br /><br />   
				
				<label> Password:</label><br />
				<input type="password" class="password inputWidth" id="passwordField" name="password" onblur="validator.validatePassword()" onpaste="return false" oncopy="return false" /><br /><span id="passwordErr"></span><br>

				<label> Confirm Password:</label><br />
				<input type="password" class="confirmPassword inputWidth" id="confirmPasswordField" name="confirmPassword" onblur="validator.validateConfirmPassword()" onpaste="return false" oncopy="return false"/><br /><span id="confirmPasswordErr"></span><br>
                
                <input id="sBtn" type="submit" value="Register" />
            </form>

    </div>
			
		</div>
		

    <section class="formSection">
       
        <div class="form-content">
            <h1>Find the Best Deals on Flights</h1>
            <form action="CommonController" method="post">
            
            <input type="hidden" value="searchFlight" name="action">
            
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
					
                <input type="date" id="date" class="field-searchForm" name="departureDate" placeholder="Departure" required>
                
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
         <!-- <footer>
        <p>&copy; 2024 MakeMyTrip. All rights reserved.</p>
    </footer> -->
    </section>
    
    
    <div class="tileContainer">
    	<div class="tileFlight">
    		<img alt="f1" src="./images/flight1.jpg" height="270px" width="230px">
    	</div>
    	
    	<div class="tileFlight">
    		<img alt="f1" src="./images/flight2.jpg" height="270px" width="230px">
    	</div>
    	
    	<div class="tileFlight">
    		<img alt="f1" src="./images/flight3.jpg" height="270px" width="230px">
    	</div>
    	  <div style="clear:both"></div>
    	
    </div>
  	
  	<div id="footer">
    	<footer>
  			<p>&copy; 2024 MakeMyTrip. All rights reserved. | <a href="#">Terms of Service</a> | <a href="#">Privacy Policy</a> | <a href="#">Cookie Policy</a> | <a href="#">Site Map</a></p>
		</footer>
    </div>

</div>
    

<script src="./js/app.js"></script>
 <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script type="text/javascript">


	var today = new Date().toISOString().split('T')[0];
	document.getElementById("date").setAttribute("min",today);

		function validateAjaxCode()
		{
			let emailId = document.getElementById("userName").value;
			let password = document.getElementById("password").value;
			
				console.log(emailId + emailId);
				var userType = $('input[name="userType"]:checked').val();
				var action = $('input[name="action"]').val();
				
				if(emailId === " " || password === " " || !userType){
					alert("fill all the field");
				}
				else{
					$.ajax({
						url:'CommonController',
						method:'POST',
						data:{"action":"login","userName":emailId,"password":password,"userType":userType},
						success:function(response){
								console.log(response);
								isLogin=true;
								
								alert("successfully ogin validation");
								console.log(userType+"ajax");
								
								if(userType === "admin") {
									window.location.href = './jsp/adminPanel.jsp';
									//document.getElementById("loginNameDetail").innerHTML=response;
									
								} 
								else{
									/*document.getElementById("popDisplayIn").style.display="none";
									document.getElementById("frcontainer").style.display="none";
									document.getElementById("logInBtn").style.display="none";
									//document.getElementById("logOut").style.display="block";
									document.getElementById("registrationBtn").style.display="none";
									document.getElementById("logoutLink").style.display="inline-block";
									var userName = document.getElementById("userName").value="";
									var password = document.getElementById("password").value="";
									document.getElementById("loginNameDetail").innerHTML=response;*/
									window.location.href = './jsp/userLogin.jsp';
								}
								
									    
									  
						
						},
						error:function(xhr,status,error){
							alert('user credential not matched');
						}
					});
					
				}
				
				
		}
		
		
		
		function getState() {
		       
	        console.log("inside get state ajax");
	       
	        var country = document.getElementById("country").value;
	        $.ajax({
	                 url: "CommonController",
	                 type: "POST",
	                 data: { "country": country ,"action": "getStateAction" },
	                 success: function(response) {
	                response = response.replace(/^\[|\]$/g, "");
	                     var states = response.split(",");
	                   
	                   
	                     var stateDropdown = document.getElementById("state");
	                     stateDropdown.innerHTML ="";
	                     
	                     
	                     for (var i = 0; i < states.length; i++) {
	                         var option = document.createElement("option");
	                         option.text = states[i];
	                         stateDropdown.add(option);
	                     }
	                 },
	                 error: function(xhr, status, error) {
	                     console.error("Error fetching states:", error);
	                 }
	             });
	        }

	        document.getElementById("country").addEventListener('change', getState);
	   
	        function getCity() {
	       
	        console.log("inside get city ajax");
	       
	        var state = document.getElementById("state").value;
	        $.ajax({
	                 url: "CommonController",
	                 type: "POST",
	                 data: { "state": state ,"action": "getCityAction" },
	                 success: function(response) {
	                response = response.replace(/^\[|\]$/g, "");
	                     var cities = response.split(",");
	                   
	                   
	                     var cityDropDown = document.getElementById("city");
	                     cityDropDown.innerHTML ="";
	                     
	                     
	                     for (var i = 0; i < cities.length; i++) {
	                         var option = document.createElement("option");
	                         option.text = cities[i];
	                         cityDropDown.add(option);
	                     }
	                 },
	                 error: function(xhr, status, error) {
	                     console.error("Error fetching states:", error);
	                 }
	             });
	        }

	        document.getElementById("state").addEventListener('change', getCity);

</script>

</body>
</html>