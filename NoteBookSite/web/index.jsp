<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/12/2015
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Address Book</title>

  <link rel="stylesheet" href="./resources/css/bootstrap.css">
  <link rel="stylesheet" href="./resources/css/style.css">
  <link rel="stylesheet" href="./resources/css/style1.css">
  <link rel="stylesheet" href="./resources/css/font-awesome.css">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container content">
  <div class="row">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a href="#" class="navbar-brand">Address Book</a>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="container content">
  <div class="row">
    <div class="col-sm-12 col-md-4 col-md-offset-4">
      <h1 class="text-center login-title">Sign in to Address Book</h1>
      <div class="account-wall">
        <img id="profile-img" class="profile-img-card" src="./resources/pictures/avatar_2x.png" />
        <form class="form-signin" action="${pageContext.request.contextPath}/sign" method="post">
          <input name="email" type="text" class="form-control" placeholder="Email" required autofocus>
          <input name="password" type="password" class="form-control" placeholder="Password" required>
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Sign in</button>
          <label class="checkbox pull-left">
            <input type="checkbox" value="remember-me">
            Remember me
          </label>
          <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
        </form>
      </div>
      <a href="${pageContext.request.contextPath}/registration" class="text-center new-account">Create an account </a>
    </div>
  </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./resources/js/bootstrap.js"></script>
</body>
</html>
