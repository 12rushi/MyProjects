
var popwindow = new Popwindow();

function Popwindow(){

		this.closeWindow = closeWindow;
		this.displayPop = displayPop;
		this.registrationWindow = registrationWindow;
		this.insideLoginbtn = insideLoginbtn;
		
		this.validateUsernamePassword = validateUsernamePassword;
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
			document.getElementById("novalue").style.display="none";
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
			document.getElementById("novalue").style.display="none";
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

		function validateUsernamePassword(){
				
				var userName = document.getElementById("userName").value;
				var password = document.getElementById("password").value;

				let regUsername = /^(rushikesh)$/;
				let regPassword = /^(rs@12)$/;

				if(regUsername.test(userName) && regPassword.test(password)){
					//alert("loggIn successful");
					document.getElementById("popDisplayIn").style.display="none";
					document.getElementById("frcontainer").style.display="none";
					document.getElementById("logInBtn").style.display="none";
					document.getElementById("logOut").style.display="block";
					document.getElementById("registrationBtn").style.display="none";
					var userName = document.getElementById("userName").value="";
					var password = document.getElementById("password").value="";
					var userNameErr = document.getElementById("userNameErr").value="";
					var userPasswordErr = document.getElementById("userPasswordErr").value="";
				}
				else{
					//alert("Incorrect username password");
					var userPasswordErr = document.getElementById("userPasswordErr").value="Incorrect username password";
				}		
		};

		function hideLogoutBtn(){
			document.getElementById("logOut").style.display="none";
			document.getElementById("logInBtn").style.display="block";
			document.getElementById("registrationBtn").style.display="block";
		}
};




			


/*-----------------------------for registration form-------------------*/


var validator = new Validator()

function Validator(){
			
			this.validateFirstName = validateFirstName;
			this.validateLastName  = validateLastName;
			this.validateAge = validateAge;
			this.validateDob = validateDob;
			this.validateGender = validateGender;
			this.validateMobileNo = validateMobileNo;
			this.validateEmail = validateEmail;
			this.validatePassword = validatePassword;
			this.validateConfirmPassword = validateConfirmPassword;
			this.validateCourse = validateCourse;
			this.validateAddress = validateAddress;
			this.validateCity = validateCity;
			this.validatePincode = validatePincode;

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

				//for age
				function validateAge(){
					var age = document.getElementById("age").value;
					var ageNameErr = document.getElementById("ageNameErr");
					let regAge = /^(1[8|9]|[2-9][0-9]|[1][0-9][0-9])$/;
					if(regAge.test(age)){
						ageNameErr.innerHTML="";
					}
					else{
						ageNameErr.innerHTML="*invalid age, age must be within (18-200)";
						
					}

				};

				//for DOB
				function validateDob(){
					var dob = document.getElementById("dob").value;
					var dobNameErr = document.getElementById("dobNameErr");
					var ageNameErr = document.getElementById("ageNameErr")
					let regDob = /^\d{2}\/\d{2}\/\d{4}$/;
					if(regDob.test(dob)){
						dobNameErr.innerHTML="";
						let splitDob = dob.split('/');
						console.log(splitDob);
						let day = parseInt(splitDob[0]);
						let month = parseInt(splitDob[1] - 1);
						let year = parseInt(splitDob[2]);

						let currentDate = new Date();
						var age = currentDate.getFullYear()-year;
						//console.log(age);
						if(age < 18){
							ageNameErr.innerHTML="*invalid age, age must be within (18-200)";
							document.getElementById("age").value = age;
							return false;
						}
						else{
						ageNameErr.innerHTML="";
						document.getElementById("age").value = age;
						return true;
						}
						//document.getElementById("age").value = age;

						if(year > 2024){
							dobNameErr.innerHTML="*year must be less than 2024";
						}
						else if(month > 12){
							dobNameErr.innerHTML="*month must be less than 12";
						}
						else if(day > 31){
							dobNameErr.innerHTML="*invalid date";
						}
					}
					else{
						dobNameErr.innerHTML="*invalid dob format (dd/mm/yy)";
						
					}

				};

				//for gender
				function validateGender(){
					var genderMale = document.getElementById("genderMale");
					var genderFemale = document.getElementById("genderFemale");
					var genderErr = document.getElementById("genderErr");

					if(!genderMale.checked && !genderFemale.checked){
						genderErr.innerHTML = "*please select gender";	
						}
						else{
							genderErr.innerHTML = "";
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
				//for course
				function validateCourse(){
					//console.log("insiide ");
					var courseHtml = document.getElementById("courseHtml");
					var courseCss = document.getElementById("courseCss");
					var courseJavascript = document.getElementById("courseJavascript");
					var courseErr = document.getElementById("courseErr");
					
					if(!courseHtml.checked && !courseCss.checked && !courseJavascript.checked){
							courseErr.innerHTML = "*please select courses";		
							
						}
						else{
							courseErr.innerHTML = "";
						}

				};

				//for address
				function validateAddress(){
					var address = document.getElementById("address").value;
					var addressErr = document.getElementById("addressErr");

					
					let regAddress = /^[a-zA-Z0-9\s]{5,30}$/;
					if(regAddress.test(address)){
						addressErr.innerHTML="";	
					}
					else{
						addressErr.innerHTML="*invalid , address must be within 5-30 character ";
						
					}
					

				};

				//for city
				function validateCity(){
					var city = document.getElementById("city");
					var cityNameErr = document.getElementById("cityNameErr");

					if(city.value === "mumbai" || city.value === "pune" || city.value === "nagpur"){
						cityNameErr.innerHTML = "";
					}
					else{
						cityNameErr.innerHTML = "*please select city";
						
					}

				};

				//for pincode
				function validatePincode(){
					var pincodeField = document.getElementById("pincodeField").value;
					var pincodeErr = document.getElementById("pincodeErr");
					let pincode = /^[1-9][0-9]{5}$/;
					if(pincode.test(pincodeField)){
						pincodeErr.innerHTML = "";
					}
					else{
						pincodeErr.innerHTML = "*pincode must be 6 digit";
					}

				};


				//submit

				function validateForm(){
					console.log("called");
					var firstName = document.getElementById("firstName").value;
					var lastName = document.getElementById("lastName").value;
					var age = document.getElementById("age").value;
					var dob = document.getElementById("dob").value;

					var gender = document.querySelector('input[name="gender"]:checked');

					var mobileNo = document.getElementById("mobileNo").value;
					var emailId = document.getElementById("emailId").value;
					var passwordField = document.getElementById("passwordField").value;
					var confirmPasswordField = document.getElementById("confirmPasswordField").value;

					var courses =document.querySelectorAll('input[name="courseName"]:checked');
					var coursesList = [];
					courses.forEach(function(item){
						coursesList.push(item.value)
					});
					
					//console.log(coursesList);

					var address = document.getElementById("address").value;
					var city = document.getElementById("city");

					var pincodeField = document.getElementById("pincodeField").value;
						//------------------------------------------------------------------------------------
					let regFirstName = /^[a-zA-Z]{2,15}$/;
					let regLastName = /^[a-zA-Z]{2,15}$/
					let regAge = /^(1[8|9]|[2-9][0-9]|[1][0-9][0-9])$/;
				    let regDob = /^\d{2}\/\d{2}\/\d{4}$/;
					let regMobileNo = /^[6-9][0-9]{9}$/;
					let regEmail = /^[a-z][a-z0-9]+[.]?[a-z0-9]+@[a-z]+(.com)$/;
					let regPassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[@#%$&*])/;
					let regAddress = /^[a-zA-Z0-9\s]{5,30}$/;
					let pincode = /^[1-9][0-9]{5}$/;
					
						event.preventDefault();

							if(firstName == "" || !regFirstName.test(firstName) || lastName == "" || !regLastName.test(lastName) ||age == "" || !regAge.test(age)|| dob == "" || 
								!regDob.test(dob) || (!gender) || mobileNo == "" || !regMobileNo.test(mobileNo) || emailId == "" || !regEmail.test(emailId) || passwordField == "" ||
								!regPassword.test(passwordField) || confirmPasswordField == "" || !(password == confirmPasswordField) || (!courses) || address == "" || 
								!regAddress.test(address) ||!(city.value === "mumbai" || city.value == "pune" || city.value === "nagpur") || pincodeField == "" || !pincode.test(pincodeField)){

								alert("Incorrect fields");
							}
							else{
								alert("Submit Succesfully");

								var array = [];
								var person;

								person = {
									firstname:firstName,
									lastname:lastName,
									ageField:age,
									dobField:dob,
									genderfield:gender.value,
									mobileno:mobileNo,
									emailid:emailId,
									course:coursesList.toString(),
									addressField:address,
									cityfield:city.value,
									pincodefield:pincodeField
								}

								//console.log(person.course);

								array.push(person);
								document.getElementById("myForm").reset();

								console.log(array);
								
								for(let i=0 ; i<array.length ;i++){
										console.log(array[i]);
										
										var table = document.getElementById("infoTable");
										table.innerHTML = table.innerHTML + `<tr>
																				<td class="td">${array[i].firstname}</td>
																				<td class="td">${array[i].lastname}</td>
																				<td class="td">${array[i].ageField}</td>
																				<td class="td">${array[i].dobField}</td>
																				<td class="td">${array[i].genderfield}</td>
																				<td class="td">${array[i].mobileno}</td>
																				<td class="td">${array[i].emailid}</td>
																				<td class="td">${array[i].course}</td>
																				<td class="td">${array[i].addressField}</td>
																				<td class="td">${array[i].cityfield}</td>
																				<td class="td">${array[i].pincodefield}</td>
																			</tr>`
								}	
								document.getElementById("popDisplayIn").style.display="none";
								document.getElementById("registrationwindow").style.display="none";
								document.getElementById("novalue").style.display="block";
								
							}
							

					};
						

	
};