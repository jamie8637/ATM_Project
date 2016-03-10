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


<title>Withdraw</title>
</script>
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
	<div class="jumbotron" style="background-color: #C19A6B;">
		<h1>Withdraw</h1>
		<p class="lead" style="text-align: center;">Withdraw funds to your account and have immediate
			access to your money!</p>
		
	</div>
	<div class="container">
	<form method="POST" action="Withdraw.do">
	<div class="bs-example bs-example-form" autocomplete="off">
		
			<div class="panel" style="background-color: #C19A6B !important;">
				<div class="panel-heading">
					<h3>Enter Amount to Withdraw</h3>
				</div>
				<div class="input-group-lg">
					<span class="input-group-addon">$</span> <input type="text" name="txtAmount"
						class="form-control">
				</div>
			</div>
			<div row>
			<div tabindex="-1" class="modal fade" id="myModal" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel" style="display: none;">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header" style="text-align: center;background-color: #C19A6B">
            <button class="close" aria-hidden="true" type="button" data-dismiss="modal">�</button>
            <h4 class="modal-title" id="myModalLabel">Confirm Withdraw</h4>
            <img src="images/withdraw.jpg" width="100px"/>
          </div>
          <div class="modal-body">
           Do you wish to confirm deposit?
           (Click Confirm withdraw to proceed/Click close to return to withdraw screen)
          </div>
          <div class="modal-footer" style="background-color: #C19A6B">
            <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
            <button class="btn btn-primary" type="submit">Confirm Withdraw</button>
          </div>

        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div>
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Submit Withdraw
      </button>
	</div>
		</div>
	</form>
	  <hr>
      <footer>
        <p>&copy; Company 2013</p>
      </footer>
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