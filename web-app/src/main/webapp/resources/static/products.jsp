<%@include file="include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<p1>Products</p1>
<p>
<ul>
    <c:forEach items="${itemList}" var="item">
        <li>
            <a href="${item.name}">${item.name}</a>
            <br/>price = ${item.unitPrice}
        </li>
    </c:forEach>
</ul>

</body>
</html>
