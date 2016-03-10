<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
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
    

    <title>Main Menu</title>
  
  <!--  <script type="text/javascript">
  	function success(){
  		alert("Login Successful!");
  	}
  </script> --!>
   <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/carousel.css" rel="stylesheet">
	<link href="css/docs.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	
<!-- Custom styles for this template -->

    <link href="css/offcanvas.css" rel="stylesheet">
   <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
 </head>
 <body onload="success()" >
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
    
<div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active">
          <img data-src="holder.js/900x500/auto/#777:#7a7a7a/">
          <div class="container">
    
            <div class="carousel-caption">
              <h1>Hello, <%= session.getAttribute("accountUserName")%>!</h1>
              <p>Thank you for using our online banking system. There are a number of features and services that are offered 
            online. Please take full advantage of the services offered to you and feel free to click the Help link to speak 
            with a customer service technician</p>
              <p><a class="btn btn-lg btn-primary"  data-toggle="modal" data-target="#myModal">Online Assistance</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img data-src="holder.js/900x500/auto/#666:#6a6a6a/">
          <div class="container">
            <div class="carousel-caption">
              <h1>Apply For Loan</h1>
              <p>We offer great loans with a competitive interest rate for our members. Take advantage of the low interest and apply today!</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img data-src="holder.js/900x500/auto/#555:#5a5a5a/">
          <div class="container">
            <div class="carousel-caption">
              <h1>Thinking of Investing?</h1>
              <p>We have a qualified staff of investment advisors than can assist you in making the best investment decisions for your situation.
              Don't wait to secure your future.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Make Appointment</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div><!-- /.carousel -->
     
    <div class="container">
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9">
          <div class="row">
            <div class="col-sm-6 col-md-4">
   		 <div class="thumbnail thumbnail-border-styles" style="border-color: #428bca !important;">
   		   <p class="pull-right visible-xs" >
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
      	<span class="glyphicon glyphicon-download-alt" style="color: #C19A6B "></span>
      	<div class="caption">
              <h2>Withdraw</h2>
              <p>Click here to withdraw funds from your account</p>
              <p><a class="btn btn-link" href="Withdrawl.jsp" role="button">Withdraw &raquo;</a></p>
            </div><!--/span-->
            </div>
            </div>
           <div class="col-sm-6 col-md-4">
    <div class="thumbnail thumbnail-border-styles" style="border-color:#428bca !important;">
<span class="glyphicon glyphicon-open" style="color: #69C444; "></span>
      <div class="caption">
              <h2>Deposit</h2>
              <p>Click here to deposit funds to your account </p>
              <p><a class="btn btn-link" role="button" href="Deposit.jsp" >Deposit &raquo;</a></p>
            </div><!--/span-->
            </div>
            </div>
           <div class="col-sm-6 col-md-4">
    <div class="thumbnail thumbnail-border-styles" style="border-color:#428bca !important;" >
     <span class="glyphicon glyphicon-search" style="color: #C96E6E;" ></span>
      <div class="caption">
              <h2>Balance</h2>
              <p>Click here to view your account balance of your accounts</p>
              <p><a class="btn btn-link" href="ViewBalance.jsp" role="button">View Balance &raquo;</a></p>
            </div><!--/span-->
           </div><!--/row-->
        </div><!--/span-->
               <div class="col-sm-6 col-sm-4">
    <div class="thumbnail thumbnail-border-styles" style="border-color:#428bca !important;" >
     <span class="glyphicon glyphicon-plus" style="color:  #FFCC33;" ></span>
      <div class="caption">
              <h2>Create Customer</h2>
              <p>Click here to Create a new customer</p>
              <p><a class="btn btn-link" href="CreateCustomer.jsp" role="button">Create Customer &raquo;</a></p>
            </div><!--/span-->
           </div><!--/row-->
        </div><!--/span-->
          <div class="col-sm-6 col-sm-4">
    <div class="thumbnail thumbnail-border-styles" style="border-color:#428bca !important;" >
     <span class="glyphicon glyphicon-new-window" style="color: #003366;" ></span>
      <div class="caption">
              <h2>Create Account</h2>
              <p>Click here to Create a new Account</p>
              <p><a class="btn btn-link" href="CreateAccount.jsp" role="button">Create Account &raquo;</a></p>
            </div><!--/span-->
           </div><!--/row-->
        </div><!--/span-->
        </div>
        </div>
          <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
          <div class="list-group">
            <a href="#" class="list-group-item active">FAQs</a>
            <a href="#" class="list-group-item">Forums</a>
            <a href="#" class="list-group-item">View Account History</a>
            <a href="#" class="list-group-item">Edit Personal Information</a>
             <a href="#" class="list-group-item">Change Security Questions</a>
            <a href="#" class="list-group-item">Get Online Support</a>
            <a href="#" class="list-group-item">Add New Account</a>
            <a href="#" class="list-group-item">Apply For a Loan</a>
            
            </div>
        </div><!--/span-->
      </div><!--/row-->
      <hr>
      <footer>
        <p>&copy; Company 2013</p>
      </footer>
    </div><!--/.container-->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="javascript/jquery.backgroundPosition.js"></script>
   <script src="javascript/bootstrap.min.js"></script>
   <script src="javascript/offcanvas.js"></script>
    <script src="javascript/modernizr-1.5.min.js"></script>
    
    
 </body>
</html>