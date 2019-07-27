<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catalog</title>
</head>
<body>
<p1>Catalog</p1>
<p>
<ul>
    <c:forEach items="${categoryList}" var="category">
        <li>
            <a href="<c:url value="/items/${category.id}"/>">${category.name}</a>
        </li>
    </c:forEach>
    <a href="<c:url value="/items"/>">Show all</a>
</ul>
</body>
</html>