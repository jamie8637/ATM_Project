<%@page import="com.presentation.service.BankSystemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="atm.business.api.model.*, atm.business.api.services.*, atm.web.model.*"%>
 <%
if(session.getAttribute("isLoggedIn") !=  "logged in")
	response.sendRedirect("index.html?name=" + session.getId());
%>
 <%

 BankUser user = new BankUser();
 BankingSystem system =  BankingSystem.getInstance();
 BankSystemService.connect();
 
 session.setAttribute("accountBalance", system.getBalance(session.getAttribute("cardNumber").toString()));
  %>  
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


<title>Account Balance</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/docs.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/offcanvas.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="LoginSuccess.jsp">Online Banking
					System</a>
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
			</div>
			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.navbar -->
	<div class="jumbotron" style="background-color: #C96E6E !important;">
		<h1>View Account Balance</h1>
		<p class="lead" style="text-align: center;">View your Account Balance</p>
		
	</div>
	<div class="container">
	<div class="bs-example bs-example-form" autocomplete="off">
	<div class="panel-group" id="accordion">
  <div class="panel panel-default" >
    <div class="panel-heading" style="background-color: #C96E6E !important;">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
         Checking Account
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
      <div class="panel-body">
       <table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Name on Account</th>
            <th>Card Number</th>
            <th>Balance</th>
            </tr>
        </thead>
        <tbody>
          <tr class="active">
            <td>1</td>
            <td><%= session.getAttribute("accountUserName").toString() %></td>
            <td><%= session.getAttribute("cardNumber").toString() %></td>
            <td><%= session.getAttribute("accountBalance").toString() %></td>
        
       </tr>
        </tbody>
      </table>
      </div>
    </div>
  </div>
  <div class="panel panel-default" >
    <div class="panel-heading" style="background-color: #C96E6E !important;">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
          Savings Account
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse">
      <div class="panel-body">
       <table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Name on Account</th>
            <th>Card Number</th>
            <th>Balance</th>
            </tr>
        </thead>
        <tbody>
          <tr class="active">
            <td>1</td>
            <td>John Smith</td>
            <td>1234567890</td>
            <td>$1,234.00</td>
          </tr>
       </tbody>
      </table>
      </div>
    </div>
  </div>
</div>
</div>
</div>
 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
   <script src="javascript/bootstrap.min.js"></script>
    <script src="javascript/offcanvas.js"></script>
</body>
</html>