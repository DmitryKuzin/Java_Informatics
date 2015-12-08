<%@ page import="lib.Page" %>
<%--
  Created by IntelliJ IDEA.
  User: kuzin
  Date: 30.10.2015
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="footer">

  <p align="center" id="footer_name"><c:out value="${page.getFooter().getFooter()}"/></p>

  <%--<p align="center" id="footer_name">ITIS Kazan 2015г.</p>--%>
</div>
