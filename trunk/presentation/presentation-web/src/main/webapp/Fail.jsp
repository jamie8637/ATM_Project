<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<title>Insert title here</title>
</head>
<body>

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
    
<div class="container" style="margin-top: 50px !important;">
<div class="jumbotron">
<div class="alert alert-danger">
        <strong>We're Sorry. </strong> <p>${cookie.failureMessage.value }</p>
      </div>
      </div>
      </div>
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