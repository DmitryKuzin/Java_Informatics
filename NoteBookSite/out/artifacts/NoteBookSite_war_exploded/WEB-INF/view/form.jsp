<%@ page import="java.util.TreeSet" %>
<%@ page import="java.util.List" %>
<%@ page import="core.Note" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="core.ConsoleNoteBook" %>
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/11/2015
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  ConsoleNoteBook consoleNoteBook= (ConsoleNoteBook) session.getAttribute("consoleNoteBook");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link href="../../resources/css/style.css" rel="stylesheet">
  <link href="../../resources/css/font-awesome.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>


<div class="container">
  <div class="row">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a href="#" class="navbar-brand">Address Book</a>
        </div>

        <form action="/add" class="navbar-form navbar-right hidden-xs">
          <button type="submit" class="btn btn-primary">
            <%--swith add to sign-out--%>
            <i class="fa fa-sign-out ">Add</i>
          </button>
        </form>
      </div>
    </div>
  </div>
</div>
<div class="container" id="content">
  <div class="row">
    <div class="col-lg-12 layout" >
      <div>
        <div class="notes col-lg-4" id="kostil">
          <form id="search-form">
            <input type="text" class="search-input" id="search" placeholder="Search Notes">
            <span class="search-icon"><i class="fa fa-search"></i></span>
            <button type="submit" class="search-button search-icon" tabindex="-1"></button>
          </form>
          <hr>
          <c:set var="notebook" scope="page" value="${consoleNoteBook}"/>
          <c:forEach items="${notebook.getKeys()}" var="i">
          <hr>
          <h4><c:out value="${i}"/></h4>
          <hr>
          <c:forEach items="${notebook.getFirst(i)}" var="j">
          <div id="accordion" class="pannel-group">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h4 class="panel-title">
                  <a href="#collapse-<c:out value="${j.hashCode()}"/>" data-parent="#accordion" data-toggle="collapse"><c:out value="${j.getFIO()}"/></a>
                </h4>
              </div>
              <div id="collapse-<c:out value="${j.hashCode()}"/>" class="pannel-collapse collapse">
                <div class="pannel-body">phone:<c:out value="${j.getPhone()}"/> email:<c:out value="${j.getEmail()}"/></div>
              </div>
            </div>

            </c:forEach>

            </c:forEach>
          </div>
        </div>
        <div class="notes col-lg-6 hidden-md hidden-sm hidden-xs" id="note-view">
          <h4 id="nv-name">New Note</h4>
          <hr>
          <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/add" method="post">
            <div class="form-group">
              <label for="firstName" class="col-sm-3 control-label white-font">Full Name</label>
              <div class="col-sm-9">
                <input type="text" id="firstName" name="FIO" placeholder="Full Name" class="form-control" autofocus>
              </div>
            </div>
            <div class="form-group">
              <label for="number" class="col-sm-3 control-label white-font">phone</label>
              <div class="col-sm-9">
                <input type="text" id="number" name="Number" placeholder="Phone number" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label for="birthDate" class="col-sm-3 control-label white-font">Date of Birth</label>
              <div class="col-sm-9">
                <input type="date" id="birthDate" name="Birth" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label for="email" class="col-sm-3 control-label white-font">Email</label>
              <div class="col-sm-9">
                <input type="email" id="email" name="Email" placeholder="Email" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label for="address" class="col-sm-3 control-label white-font">Address</label>
              <div class="col-sm-9">
                <input type="text" name="work" id="address" placeholder="Flat, Street, District, City Postal code, Country" class="form-control">
              </div>
            </div>
            <button type="submit" class="btn btn-primary">
              <i>Add</i>
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/js/bootstrap.js"></script>
</body>
</html>
