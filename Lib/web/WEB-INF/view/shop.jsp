<%@ page import="java.util.TreeSet" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="lib.Library" %>
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/16/2015
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  Library lib = (Library) request.getAttribute("library");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Notebook</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/shop" method="post">
  <label>
    <br><a>Name</a>
    <input type="text" name="Name">
  </label>
    <label>
    <br><a>ISBN</a>
    <input type="text" name="ISBN">
    </label>
  <label>
      <br><a>Author</a>
    <input type="text" name="Author">
  </label>

  <label>
      <br><a>Creation date</a>
    <input type="text" name="Creation-date" value="ddMMyyyy">
  </label>
  <label>
      <br><a>Price</a>
    <input type="text" name="Price">
  </label>
  <label>
    <br><input type="submit" name="submit" value="add">
  </label>
</form>
<hr>
cart: books for
<hr>
<p>Available books</p>
    <c:set var="library" scope="page" value="${lib}"/>
  <c:if test="${library!=null}">
    <c:forEach items="${library.getAuthorsSet()}" var="i">
      <h4><c:out value="${i.getFIO()}"/> </h4>
      <ul>
      <c:forEach items="${i.getBooks()}" var="j">
        <li><c:out value="${j.getName()}"/> - <c:out value="${j.getPrice()}"/></li>
        <form action="/cart" method="post">
          <input type="hidden" name="ISBN" value="${j.getISBN()}"/>
          <input type="submit" value="Add to cart">
        </form>
      </c:forEach>
      </ul>
    </c:forEach>
  </c:if>
</body>
</html>
