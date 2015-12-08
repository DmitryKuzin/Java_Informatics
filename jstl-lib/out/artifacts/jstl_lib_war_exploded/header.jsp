
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 30.10.2015
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar">
  <c:forEach items="${page.getHeader().getLi()}" var="s">
    <ul>
      <li><a href="#"><c:out value="${s}"/></a></li>
    </ul>
  </c:forEach>

  <%--<ul>--%>
    <%--<li><a href="#"> </a></li>--%>
    <%--<li><a href="#">Статья</a></li>--%>
    <%--<li><a href="#">О нас</a></li>--%>
    <%--<li><a href="#">Контакты</a></li>--%>
    <%--<li><a href="#">Помощь</a></li>--%>
  <%--</ul>--%>
</div>
