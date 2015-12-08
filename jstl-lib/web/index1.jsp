<%@ page import="lib.Page" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Page p= (Page) session.getAttribute("page");%>
<%--question about page class path--%>
<html lang="en">
<head>
  <%--<c:if test="${p==null}">--%>

  <%--</c:if>--%>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css">
  <title>Library</title>
</head>
<body>

<c:set var="page" value="${p}"  scope="request"/>


<c:import url="header.jsp" charEncoding="utf-8">
</c:import>

<div class="container">

  <c:import url="leftMenu.jsp" charEncoding="utf-8"/>

  <c:import url="main.jsp" charEncoding="utf-8">
  </c:import>
</div>
<c:import url="footer.jsp" charEncoding="utf-8">
</c:import>
<script src="accordion.js"></script>
<script src="jquery-1.11.3.min.js"></script>
</body>
</html>