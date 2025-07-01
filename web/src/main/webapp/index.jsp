<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.disuraaberathna.practical.core.service.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.disuraaberathna.practical.core.model.Product" %>
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

    <%
        try {
            InitialContext ic = new InitialContext();
            ProductService productService = (ProductService) ic.lookup("com.disuraaberathna.practical.core.service.ProductService");
            List<Product> products = productService.getAllProducts();
            pageContext.setAttribute("products", products);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    %>

    <table>
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td><a href="${pageContext.request.contextPath}/admin/delete-product?=id${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</main>
</body>
</html>
