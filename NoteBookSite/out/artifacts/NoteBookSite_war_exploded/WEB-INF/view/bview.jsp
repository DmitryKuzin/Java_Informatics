<%@ page import="core.Note" %>
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/15/2015
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%
  Note currentNote= (Note) request.getAttribute("viewNote");
  Note cN=(Note) request.getAttribute("cN");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Notes</title>

  <!-- Bootstrap -->
  <link href="WEB-INF/resources/css/bootstrap.css" rel="stylesheet">
  <link href="WEB-INF/resources/css/style.css" rel="stylesheet">
  <link href="WEB-INF/resources/css/font-awesome.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<a href="/WEB-INF/view/index.html">link to html page</a>
<div class="container">
  <div class="row">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a href="#" class="navbar-brand">Address Book</a>
        </div>

        <form action="" class="navbar-form navbar-right">
          <button type="submit" class="btn btn-primary">
            <i class="fa fa-sign-out">Sign out</i>
          </button>
        </form>
      </div>
    </div>
  </div>
</div>
<div class="container" id="content">
  <div class="row">
    <div class="col-lg-12 layout" >
      <div class="row">
        <div class="notes col-lg-6">
          <form id="search-form">
            <input type="text" class="search-input" id="search" placeholder="Search Notes">
            <span class="search-icon"><i class="fa fa-search"></i></span>
            <button type="submit" class="search-button search-icon" tabindex="-1"></button>
          </form>
          <hr>
          <div id="accordion" class="pannel-group">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a href="#collapse-7" data-parent="#accordion" data-toggle="collapse">Васильев Василий Васильевич</a>
                </h4>
              </div>
              <div id="collapse-7" class="pannel-collapse collapse">
                <div class="pannel-body">phone:1(111)11-11-11 email:vasya@mail.com</div>
              </div>
            </div>

            <div class="panel panel-primary">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a href="#collapse-8" data-parent="#accordion" data-toggle="collapse">Иванов Иван Иванович</a>
                </h4>
              </div>
              <div id="collapse-8" class="pannel-collapse collapse">
                <div class="pannel-body">phone:1(111)11-11-11 email:ivanov@mail.com</div>
              </div>
            </div>
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a href="#collapse-9" data-parent="#accordion" data-toggle="collapse">Петров Петр Петрович</a>
                </h4>
              </div>
              <div id="collapse-9" class="pannel-collapse collapse">
                <div class="pannel-body">phone:1(111)11-11-11 email:petrov@mail.com</div>
              </div>
            </div>
          </div>
        </div>
        <div class="notes col-lg-6 hidden-sm" id="note-view">
          <h4 id="nv-name">Vasya
            <%--<%=currentNote.getFIO()%>--%>
          </h4>
          <hr>
          <div class="row">
            <div class="col-lg-6">
              <div class="thumbnail">
                <img src="http://placehold.it/200x300" alt="">
              </div>
            </div>
            <div class="col-lg-6 white-font">
              <h4>phone:</h4>
              <%--<p><%=currentNote.getPhone()%></p>--%>
                <hr>
                <h4>email:</h4>
              <%--<p><%=currentNote.getEmail()%></p>--%>
                  <hr>
                <h4>birth:</h4><p>
              <%--<%=currentNote.getBirthday()%></p>--%>
                  <hr>
                  <h4>address:</h4><p>
              <%--<%=currentNote.getAddress()%></p>--%>
                    <hr>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}WEB-INF/resources/js/js/bootstrap.js"></script>
</body>
</html>
