<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Spring MVC</title>
        <link rel = "stylesheet" type = "text/css" href = "<c:url value = '/resources/style.css' />" >
    </head>

    <body>
        <c:forEach items="${messageList}" var = "message">
            <li id = "message_<c:out value = "message.id"/>">
                <div class = "message">
                    <c:out value = "${message.message}" />
                </div>
                <div>
                    <span class = "messageTime"><c:out value = "${message.time}" /></span>
                    <span class = "messageLocation">
                        (<c:out value = "${message.latitude}" />,
                        <c:out value = "${message.longitude}" />)</span>
                </div>
            </li>
        </c:forEach>
    </body>
</html>