<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<div id="signupbox">
    <form class="signup" action="<c:url value="/signup"/>" method="post">
        <h1>Registration page</h1>
        <p>
            <label for="logReg">Login</label>
            <input type="text" id="logReg" name="login" placeholder="login or email" required>
        </p>
        <p>
            <label for="passReg">Password</label>
            <input type="password" id="passReg" name='password' placeholder="Password" required>
        </p>

        <p>
            <input type="submit" value="Register">
        </p>
        <div>
            <div style="border-top: 1px solid#7d7a87; padding-top:15px; font-size:85%">
                Have account?
                <a href="<c:url value="/resources/views/index.jsp"/>"> Sign In </a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
