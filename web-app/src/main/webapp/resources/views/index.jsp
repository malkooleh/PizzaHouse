<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Online pizzeria</title>
    <link href="<c:url value="../css/style_index.css"/>" rel="stylesheet" type="text/css">
</head>
<body class="main">

<div class="content">
    <p class="title"><span class="text"></span></p>
    <p class="title">Онлайн пиццерия</p>
    <p class="text">Добро пожаловать в онлайн пиццерию, где вы сможете найти много всего на ваш вкус.</p>
    <p class="text">Проект находится в разработке, поэтому дизайн и функционал будет постоянно дорабатываться.</p>
    <p class="text">По всем вопросам обращайтесь по адресу <a href="mailto:support@testpizzeria.com">support@testpizzeria.com</a>
    </p>
</div>

<div id="loginbox">
    <span style="float: right">
        <a href="?lang-en">en</a>
        <a href="?lang-ua">ua</a>
    </span>

    <form:form commandName="user" action="/signin" cssClass="login_form" method="post">
        <fieldset>
            <p>
                <form:label path="login"><spring:message code="Login or email"/></form:label>
                <form:input type="text" id="login" path='login' placeholder="login or email"/>
            </p>
            <p>
                <form:label path="password"><spring:message code="Password"/></form:label>
                <form:input type="password" id="password" path='password' placeholder="Password"/>
            </p>
        </fieldset>

        <footer>
                <input type="submit" class="footer"
                       value="<spring:message text="Login"/>" tabindex="4"/>
        </footer>
    </form:form>
    <div class="form-group">
        <div class="col-md-12 control">
            <div style="border-top: 1px solid#876354; padding-top:15px; font-size:85%">
                Don't have an account!
                <a href="<c:url value="/resources/views/signup.jsp"/>"><spring:message code="Sign Up Here"/></a>
            </div>
        </div>
    </div>

</div>

</body>
</html>