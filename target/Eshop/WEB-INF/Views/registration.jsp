<jsp:include page="header.jsp" />

<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!------ Include the above in your HEAD tag ---------->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<style>
.registration-container{
    margin-top: 5%;
    margin-bottom: 5%;
}
.registration-form{
    padding: 2%;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.registration-form h3{
    text-align: center;
    color: #333;
}

.registration-container form{
    padding: 8%;
}
.btnSubmit
{
    width: 50%;
    border-radius: 1rem;
    padding: 1.5%;
    border: none;
    cursor: pointer;
}
.registration-form .btnSubmit{
    font-weight: 600;
    color: #fff;
    background-color: #0062cc;
}

.registration-form .ForgetPwd,.Register{
    color: #0062cc;
    font-weight: 600;
    text-decoration: none;
}


</style>

<script>
/* function validateForm() {
    
    if( $("#fname").val() == "" ) {
       alert( "Please provide first name!" );
       document.myForm.Name.focus() ;
       return false;
    }
    if(  $("#lname").val() == "" ) {
       alert( "Please provide your last name!" );
       document.myForm.EMail.focus() ;
       return false;
    }
    if(  $("#email").val() == "" ) {
        alert( "Please provide your Email!" );
        document.myForm.EMail.focus() ;
        return false;
     }
    
    if(  $("#phone").val() == "" ) {
        alert( "Please provide your phone!" );
        document.myForm.EMail.focus() ;
        return false;
     }
    
    if(  $("#address").val() == "" ) {
        alert( "Please provide your address!" );
        document.myForm.EMail.focus() ;
        return false;
     }
    if(  $("#password").val() == "" ) {
        alert( "Please provide your password!" );
        document.myForm.EMail.focus() ;
        return false;
     }
    
    
  
    return( true );
 } */
$(document).ready(function() {
	
	$("#registration-form").validate({
		
				  rules: {
				    // simple rule, converted to {required:true}
				    fname: "required",
				    lname: "required",
				    phone: "required",
				    address: "required",
				    password: "required",
				    confirm: "required",
				    
				    // compound rule
				    email: {
				      required: true,
				      email: true
				    }
				  },
				  submitHandler: function(form) {
					    // do other things for a valid form
					    form.submit();
					  }
				});
	});





</script>




<div class="container registration-container">
	<div class="row ">
		<div class="col-md-offset-3 col-md-6 registration-form">
			<h3>Sign Up</h3>


			<form class="form-horizontal" id="registration-form"  method="post" action="user/createUser">

				<div class="form-group">
					<label for="fname" class="cols-sm-2 control-label">First Name</label>



					<input type="text" class="form-control" name="fname" id="fname"
						placeholder="Enter your first Name" />

				</div>
				
				<div class="form-group">
					<label for="lname" class="cols-sm-2 control-label">Last Name</label>



					<input type="text" class="form-control" name="lname" id="lname"
						placeholder="Enter your Last Name" />

				</div>

				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label">Your
						Email</label> <input type="text" class="form-control" name="email"
						id="email" placeholder="Enter your Email" />

				</div>
				
				<div class="form-group">
					<label for="phone" class="cols-sm-2 control-label">Your
						phone</label> <input type="text" class="form-control" name="phone"
						id="phone" placeholder="Enter your phone number" />

				</div>
				<div class="form-group">
					<label for="address" class="cols-sm-2 control-label">Your
						address</label> <input type="text" class="form-control" name="address"
						id="address" placeholder="Enter your address" />

				</div>
				
			
				<div class="form-group">
					<label for="password" class="cols-sm-2 control-label">Password</label>
					<input type="password" class="form-control" name="password"
						id="password" placeholder="Enter your Password" />

				</div>
				<div class="form-group">
					<label for="confirm" class="cols-sm-2 control-label">Confirm
						Password</label> <input type="password" class="form-control"
						name="confirm" id="confirm" placeholder="Confirm your Password" />

				</div>
				<div class="form-group ">
					<input type="submit" class="submit btn btn-primary btn-lg btn-block login-button" type="submit" value="Submit">
						
				</div>
				<div class="login-register">
					<a href="login">Login</a>
				</div>
			</form>



		</div>
	</div>
</div>