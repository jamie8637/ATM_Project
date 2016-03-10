<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
if(session.getAttribute("isLoggedIn") !=  "logged in")
	response.sendRedirect("index.html?name=" + session.getId());
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

 <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/carousel.css" rel="stylesheet">
	<link href="css/docs.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	
	
<!-- Custom styles for this template -->

    <link href="css/offcanvas.css" rel="stylesheet">
    
    <script type="text/javascript" language="javascript">
 
    $(document).ready(function () {
    	// 1. prepare the validation rules and messages.
        var rules = {
            txtFirstName: {
                required: true,
                minlength: 2
            },
            textbox2: "required",
            textbox3: "required"
        };
        var messages = {
            txtFirstName: {
                required: "textbox1 is required",
                minlength: "textbox1 needs to be at least length 2"
            },
            textbox2: "textbox2 is requried",
            textbox3: "textbox3 is required"
        };
 
        // 2. Initiate the validator
        var validator
            = new jQueryValidatorWrapper("FormToValidate",
                rules, messages);
 
        // 3. Set the click event to do the validation
        $("#btnValidate").click(function () {
        	alert("Validation Success!");
        	if (!validator.validate())
                return;
 
            alert("Validation Success!");
        });

    });
    </script>
</head>
<body >
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="LoginSuccess.jsp" role="button">Online Banking System</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="LoginSuccess.jsp">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
      <li><a href="index.html">Logout</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->
    
    <div class="jumbotron" style="background-color: #003366 !important; color: white;">
		<h1>Create New Account</h1>
		<p class="lead" style="text-align: center;">Enter information below to create a new account</p>
	</div>
	
<div class="container">
<form role="form" id="FormToValidate">
<div class="form-group col-lg-6">
<label for="txtCardNumber">Card Number</label>
<input type="Text" class="form-control" id="txtCardNumber" placeholder="Enter Card Number">
<label for="txtCustomerID">Customer ID</label>
<input type="Text" class="form-control" id="txtCustomerID" placeholder="Enter Customer ID">
</div>
<div class="form-group col-lg-6">
<label for="txtPinNumber">Pin Number</label>
<input type="Text" class="form-control" id="txtPinNumber" placeholder="Enter Pin Number">
<label for="rdoAccountLocked">Lock Account</label>
<input type="checkbox" id="rdoAccountLocked">

</div>
<br />
<hr />
<div class="row">
			<div tabindex="-1" class="modal fade" id="myModal" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel" style="display: none;">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header" style="text-align: center;background-color: #003366 !important;  color: white;">
            <button class="close" aria-hidden="true" type="button" data-dismiss="modal">×</button>
            <h4 class="modal-title" id="myModalLabel">Confirm Account Creation</h4>
            <img src="images/icon_bank.jpg" width="100px"/>
          </div>
          <div class="modal-body">
           You creating a new account, is this correct?
           (Click Create Account to proceed/Click close to return to account creation screen)
          </div>
          <div class="modal-footer" style="background-color: #003366 !important;">
            <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
            <button class="btn btn-primary" type="button">Create Account</button>
          </div>

        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div>
			<button id="btnValidate" class="btn btn-primary btn-md pull-left" data-toggle="modal" data-target="#myModal" style="margin-left: 28px !important;">
        Create Account
      </button>
	</div>
		</div>
</form>
<br />
 <hr>
    <footer>
      <p>&copy; Company 2013</p>
      </footer>
</div>
 <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="javascript/jquery.validate.min.js"></script>
	<script src="additional-methods.min.js" ></script>
   <script src="javascript/bootstrap.min.js"></script>
    <script src="javascript/offcanvas.js"></script>
    
</body>
</html>