
var popwindow = new Popwindow();

function Popwindow(){

		this.closeWindow = closeWindow;
		this.displayPop = displayPop;
		this.registrationWindow = registrationWindow;
		this.insideLoginbtn = insideLoginbtn;
		
//		this.validateUsernamePassword = validateUsernamePassword;
		this.hideLogoutBtn = hideLogoutBtn;

		this.closeInfoWindow = closeInfoWindow;

		this.validateUserName = validateUserName;
		this.validateUserPassword = validateUserPassword;
		
		this.avoidNumberSpecialKay = avoidNumberSpecialKay;
		//this.avoidAlphabetsSpeChar = avoidAlphabetsSpeChar;

		function closeWindow(){
			document.getElementById("popDisplayIn").style.display="none";
			document.getElementById("frcontainer").style.display="none";
			document.getElementById("registrationwindow").style.display="none";
			
		};

		function displayPop(){
			document.getElementById("registrationwindow").style.display="none";
			document.getElementById("popDisplayIn").style.display="block";
		   document.getElementById("frcontainer").style.display="block";
		};

		function registrationWindow(){
			document.getElementById("frcontainer").style.display="none";
			document.getElementById("popDisplayIn").style.display="block";
			document.getElementById("registrationwindow").style.display="block";
			
		};

		function insideLoginbtn(){
			document.getElementById("frcontainer").style.display="none";
			document.getElementById("popDisplayIn").style.display="block";
			document.getElementById("registrationwindow").style.display="block";
		};

		function closeInfoWindow(){
			
			document.getElementById("popDisplayIn").style.display="none";
			document.getElementById("registrationwindow").style.display="none";
		};

		function validateUserName(){
			var userName = document.getElementById("userName").value;
			var userNameErr = document.getElementById("userNameErr");
			let regUsername = /^[a-zA-Z]{2,15}$/;

			if(regUsername.test(userName)){
						userNameErr.innerHTML="";	
					}
					else{
						userNameErr.innerHTML="*invalid username, username must be atleast 2 character";
					}

		};

		function validateUserPassword(){
			var password = document.getElementById("password").value;
			var userPasswordErr = document.getElementById("userPasswordErr");
			let reguserPassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[@#%$&*])/;

			if(reguserPassword.test(password)){
						userPasswordErr.innerHTML="";	
					}
					else{
						userPasswordErr.innerHTML="*Incorrect password";
					}

				};

		function avoidNumberSpecialKay(e){
					if(!(e.key >="a" && e.key <="z") && !(e.key >="A" && e.key <="Z") && !(e.key=="@") && !(e.key=="_")){
						e.preventDefault();
					}	
				};
				
				

		/*function avoidAlphabetsSpeChar(e){
			if(!(e.keyCode > 47 && e.keyCode < 58)){
				e.preventDefault();
			}	
		};*/

//		function validateUsernamePassword(){
//				
//				var userName = document.getElementById("userName").value;
//				var password = document.getElementById("password").value;
//
//				let regUsername = /^(rushikesh)$/;
//				let regPassword = /^(rs@12)$/;
//
//				if(regUsername.test(userName) && regPassword.test(password)){
//					//alert("loggIn successful");
//					document.getElementById("popDisplayIn").style.display="none";
//					document.getElementById("frcontainer").style.display="none";
//					document.getElementById("logInBtn").style.display="none";
//					document.getElementById("logOut").style.display="block";
//					document.getElementById("registrationBtn").style.display="none";
//					var userName = document.getElementById("userName").value="";
//					var password = document.getElementById("password").value="";
//					var userNameErr = document.getElementById("userNameErr").value="";
//					var userPasswordErr = document.getElementById("userPasswordErr").value="";
//				}
//				else{
//					//alert("Incorrect username password");
//					var userPasswordErr = document.getElementById("userPasswordErr").value="Incorrect username password";
//				}		
//		};

		function hideLogoutBtn(){
			document.getElementById("logInBtn").style.display="inline-block";
			document.getElementById("registrationBtn").style.display="inline-block";
			document.getElementById("logOut").style.display="none";
			document.getElementById("loginNameDetail").innerHTML="";
		}
};




			


/*-----------------------------for registration form-------------------*/

var form = document.getElementById("myForm");
	form.addEventListener("submit",function(event){
	validator.validateForm(event);
});

var validator = new Validator()

function Validator(){
			
			this.validateFirstName = validateFirstName;
			this.validateLastName  = validateLastName;
			this.validateMobileNo = validateMobileNo;
			this.validateEmail = validateEmail;
			this.validatePassword = validatePassword;
			this.validateConfirmPassword = validateConfirmPassword;


			this.avoidNumberSpecialKay = avoidNumberSpecialKay;
			this.avoidAlphabetsSpeChar = avoidAlphabetsSpeChar;

			this.validateForm = validateForm;
			
			var password;
			

			
			function avoidNumberSpecialKay(e){
					if(!(e.keyCode > 64 && e.keyCode < 123)){
						e.preventDefault();
					}	
				};

				function avoidAlphabetsSpeChar(e){
					if(!(e.keyCode > 47 && e.keyCode < 58)){
						e.preventDefault();
					}	
				};

			//for first name
			function validateFirstName(){
					var firstName = document.getElementById("firstName").value;
					var firstNameErr = document.getElementById("firstNameErr");

					let regFirstName = /^[a-zA-Z]{2,15}$/;
					if(regFirstName.test(firstName)){
						firstNameErr.innerHTML="";	
					}
					else{
						firstNameErr.innerHTML="*invalid firstname, firstname must be atleast 2 character";
						
					}

				};

				//for last name
				function validateLastName(){
					var lastName = document.getElementById("lastName").value;
					var lastNameErr = document.getElementById("lastNameErr");

					let regLastName = /^[a-zA-Z]{2,15}$/;
					if(regLastName.test(lastName)){
						lastNameErr.innerHTML="";	
					}
					else{
						lastNameErr.innerHTML="*invalid lastname, lastname must be atleast 2 character";
						
					}

				};

				

				
				

				//for mobile no	
				function validateMobileNo(){
					var mobileNo = document.getElementById("mobileNo").value;
					var mobileErr = document.getElementById("mobileErr");

					let regMobileNo = /^[6-9][0-9]{9}$/;
					if(regMobileNo.test(mobileNo)){
						mobileErr.innerHTML="";	
					}
					else{
						mobileErr.innerHTML="*invalid, mobile no. must be 10 digits ";
						
					}

				};
			

				//for email
				function validateEmail(){
					var emailId = document.getElementById("emailId").value;
					var EmailErr = document.getElementById("EmailErr");

					let regEmail = /^[a-z_][a-z0-9_]+[.]?[a-z0-9_]+@[a-z]+(.com)$/;
					if(regEmail.test(emailId)){
						EmailErr.innerHTML="";	
					}
					else{
						EmailErr.innerHTML="*invalid , email format must be (abc.poq@xyz.com)";
						
					}

				};

				//password 
				function validatePassword(){
					var passwordField = document.getElementById("passwordField").value;
					var passwordErr = document.getElementById("passwordErr");
			
					let regPassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[@#%$&*])/;
					if(regPassword.test(passwordField)){
						passwordErr.innerHTML="";
						password = passwordField;
					}
					else{
						passwordErr.innerHTML="*password must contain atleast @#%$&* and number  ";
						
					}

				};
				//confirm password
				function validateConfirmPassword(){
					var confirmPasswordField = document.getElementById("confirmPasswordField").value;
					var confirmPasswordErr = document.getElementById("confirmPasswordErr");

					if(password == confirmPasswordField){
						confirmPasswordErr.innerHTML="";	
					}
					else{
						confirmPasswordErr.innerHTML="*password mismatch ";
						
					}

				};
				

				//submit

				function validateForm(e){
					console.log("called");
					var firstName = document.getElementById("firstName").value;
					var lastName = document.getElementById("lastName").value;

					var mobileNo = document.getElementById("mobileNo").value;
					var emailId = document.getElementById("emailId").value;
					var passwordField = document.getElementById("passwordField").value;
					var confirmPasswordField = document.getElementById("confirmPasswordField").value;

		
					//console.log(coursesList);


						//------------------------------------------------------------------------------------
					let regFirstName = /^[a-zA-Z]{2,15}$/;
					let regLastName = /^[a-zA-Z]{2,15}$/
					let regMobileNo = /^[6-9][0-9]{9}$/;
					let regEmail = /^[a-z][a-z0-9]+[.]?[a-z0-9]+@[a-z]+(.com)$/;
					let regPassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[@#%$&*])/;

					
						//e.preventDefault();

							if(firstName == "" || !regFirstName.test(firstName) || lastName == "" || !regLastName.test(lastName) || mobileNo == "" || !regMobileNo.test(mobileNo) || emailId == "" || !regEmail.test(emailId) || passwordField == "" ||
								!regPassword.test(passwordField) || confirmPasswordField == "" || !(password == confirmPasswordField)){
								
								event.preventDefault();
								alert("insert all fields");
							}
							else{
								alert("Submit Succesfully");
								document.getElementById("popDisplayIn").style.display="none";
								document.getElementById("registrationwindow").style.display="none";
								
								
								window.location.href = "../index.jsp";
								console.log("after window location href ststment")
							}
							

					};
						

	
};

//function validateAjaxCode()
//{
//	let emailId = document.getElementById("userName").value;
//	let password = document.getElementById("password").value;
//	
//		console.log(emailId + emailId);
//		
//		$.ajax({
//			url:'CommonController',
//			method:'POST',
//			date:{"action":"login","userName":userName,"password":password},
//			success:function(response){
//					isLogin=true;
//					
//					alert("ajax validation");
//					window.location.href = 'index.jsp';
//			
//			},
//			error:function(xhr,status,error){
//				alert('an error occurred while processing your request');
//			}
//		});
//}

//document.getElementById("sbt").addEventListener("click",validateAjaxCode);