<%@ page import="lib.Cart" %>
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 10/22/2015
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<% Cart cart= (Cart) request.getAttribute("cart");%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<a href="/shop">back to shop</a>
<h3>Confirm book purchase</h3>
<hr>
<c:forEach items="${cart.getSales()}" var="i">
  (<c:out value="${i.getISBN()}"/>)<c:out value="${i.getAuthor().getFIO()}"/>-<c:out value="${i.getName()}"/>:<c:out value="${i.getPrice().setScale(2).toString()}"/>(<c:out value="${cart.getCurrency().toString()}"/>)<form action="/cart" method="post" style="    padding-left: 122px;
  margin-right: -100px;
  margin-bottom: -18px;
  padding-top: 7px;">
  <input type="hidden" name="deleteISBN" value="<c:out value="${i.getISBN()}"/>">
  <input type="hidden" name="from" value="cart">
  <input type="submit" value="delete"></form>

  <form action="/cart" method="post" style="margin-top: -20px; margin-bottom: 11px;">
    <input type="hidden" name="from" value="cart">
    <input type="hidden" name="countISBN" value="<c:out value="${i.getISBN()}"/>">
    <input type="number" name="count" style="width:52px;" value="<c:out value="${i.getCount()}"/>">
    <input type="submit" value="change">
  </form>
  <hr>
</c:forEach>
<h3>TOTAL:<c:out value="${cart.getSum().setScale(2).toString()}"/> (<c:out value="${cart.getCurrency().toString()}"/>)</h3>
<button type="submit" value="Confirm">Confirm</button>
</body>
</html>
