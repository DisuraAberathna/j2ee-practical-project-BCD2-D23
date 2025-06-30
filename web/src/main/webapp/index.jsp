<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/26/2025
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<main>
    <h1>Home</h1>

    <c:if test="${empty pageContext.request.userPrincipal}">
        <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
        <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
    </c:if>
    <c:if test="${not empty pageContext.request.userPrincipal}">
        <a href="${pageContext.request.contextPath}/logout">Log Out</a>
    </c:if>
</main>
</body>
</html>
