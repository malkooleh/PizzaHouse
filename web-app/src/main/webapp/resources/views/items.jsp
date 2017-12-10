<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Catalog Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="<c:url value="/resources/views/home.jsp"/>">Back to main menu</a>

<br/>
<br/>

<h1>Item List</h1>

<c:if test="${!empty itemList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${itemList}" var="item">
            <tr>
                <td>${item.id}</td>
                <td><a href="/itemdata/${item.id}" target="_blank">${item.name}</a></td>
                <td>${item.unitPrice}</td>
                <td><a href="<c:url value='/edit/${item.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${item.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add item</h1>

<c:url var="addAction" value="/items/add"/>

<form:form action="${addAction}" commandName="item">
    <table>
        <c:if test="${!empty item.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="unitPrice">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="unitPrice"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty item.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Item"/>"/>
                </c:if>
                <c:if test="${empty item.name}">
                    <input type="submit"
                           value="<spring:message text="Add Item"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
