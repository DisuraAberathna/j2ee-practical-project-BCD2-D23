<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/2/2025
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>500</h1>
<%--<%--%>
<%--    out.write(exception.getMessage());--%>
<%--%>--%>
${requestScope['jakarta.servlet.error.status_code']}
${requestScope['jakarta.servlet.error.message']}
</body>
</html>
