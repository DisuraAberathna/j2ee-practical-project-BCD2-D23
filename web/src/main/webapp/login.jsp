<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/26/2025
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<main>
    <h1>Login</h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <table>
            <tr>
                <th>Email :</th>
                <td><input type="email" name="email"/></td>
            </tr>
            <tr>
                <th>Password</th>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </form>
</main>
</body>
</html>
