<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/2/2025
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unauthorized</title>
</head>
<body>
${requestScope['jakarta.servlet.error.status_code']}
${requestScope['jakarta.servlet.error.message']}
</body>
</html>
