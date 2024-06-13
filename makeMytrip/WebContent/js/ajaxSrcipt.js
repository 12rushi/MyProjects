//$(ducument).ready(function(){
//	$("#sbt").click(function(e){
//		e.preventDefault();
//		
//		var action = $('input[name="action"]').val();
//		var email = $('#userName').val();
//		var password = $('#password').val();
//		
//		console.log("inside ajax code..")
//		
//		$.ajax({
//			url:'CommonController',
//			method:'POST',
//			date:{action:action,userName:userName,password:password},
//			success:function(response){
//				if(response === 'success'){
//					window.location.href = 'index.jsp';
//				}
//				else{
//					alert('invalid credentials');
//				}
//			},
//			error:function(xhr,status,error){
//				alert('an error occurred while processing your request');
//			}
//		});
//	});
//});

//	function validateAjaxCode()
//	{
//		let emailId = document.getElementById("userName").value;
//		let password = document.getElementById("password").value;
//		
//			console.log(emailId + emailId);
//			
//			$.ajax({
//				url:'CommonController',
//				method:'POST',
//				date:{"action":"login","userName":userName,"password":password},
//				success:function(response){
//						isLogin=true;
//						
//						alert("ajax validation");
//						window.location.href = 'index.jsp';
//				
//				},
//				error:function(xhr,status,error){
//					alert('an error occurred while processing your request');
//				}
//			});
//	}
	
	//document.getElementById("sbt").addEventListener("click",validateAjaxCode);

