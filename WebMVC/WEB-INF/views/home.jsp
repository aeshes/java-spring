<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Spring MVC</title>
        <link rel = "stylesheet" type = "text/css" href = "<c:url value = '/resources/style.css' />" >
    </head>

    <body>
        <h1>Welcome!</h1>

        <a href = "<c:url value = '/data' />">Messages</a>
        <a href = "<c:url value = '/user/register' />">Register</a>
    </body>
</html>