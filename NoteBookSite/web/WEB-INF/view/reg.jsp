<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/18/2015
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Bootstrap 101 Template</title>

  <!-- Bootstrap -->
  <link href="../../resources/css/bootstrap.css" rel="stylesheet">
  <link href="../../resources/css/style1.css" rel="stylesheet">
  <link href="../../resources/css/font-awesome.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div id="content" class="container">
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
<div class="container">
  <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/registration" method="post">
    <h2>Registration Form</h2>
    <div class="form-group">
      <label for="firstName" class="col-sm-3 control-label">Full Name</label>
      <div class="col-sm-9">
        <input type="text" name="fullName" id="firstName" placeholder="Full Name" class="form-control" autofocus>
        <span class="help-block">Last Name, First Name, eg.: Smith, Harry</span>
      </div>
    </div>
    <div class="form-group">
      <label for="email" class="col-sm-3 control-label">Email</label>
      <div class="col-sm-9">
        <input type="email" name="email" id="email" placeholder="Email" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-sm-3 control-label">Password</label>
      <div class="col-sm-9">
        <input type="password" name="password" id="password" placeholder="Password" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
      <div class="col-sm-9">
        <input type="date" name="birth" id="birthDate" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label for="country" class="col-sm-3 control-label">Country</label>
      <div class="col-sm-9">
        <select id="country" name="country" class="form-control">
          <option>Russian Federation</option>
          <option>Afghanistan</option>
          <option>Bahamas</option>
          <option>Cambodia</option>
          <option>Denmark</option>
          <option>Ecuador</option>
          <option>Fiji</option>
          <option>Gabon</option>
          <option>Haiti</option>
          <option>United Kingdom</option>
          <option>USA</option>
        </select>
      </div>
    </div> <!-- /.form-group -->
    <div class="form-group">
      <label class="control-label col-sm-3">Gender</label>
      <div class="col-sm-6">
        <div class="row">
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="femaleRadio" value="Female">Female
            </label>
          </div>
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="maleRadio" value="Male">Male
            </label>
          </div>
          <div class="col-sm-4">
            <label class="radio-inline">
              <input type="radio" name="gender" id="uncknownRadio" value="Unknown">Unknown
            </label>
          </div>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-9 col-sm-offset-3">
        <button type="submit" class="btn btn-primary btn-block">Register</button>
      </div>
    </div>
  </form> <!-- /form -->
</div> <!-- ./container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/js/bootstrap.js"></script>
</body>
</html>
