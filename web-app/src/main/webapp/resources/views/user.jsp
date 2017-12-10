<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/views/include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>

    <script type="text/javascript">
        function addUser() {

            var name = $('#name').val();
            var positionid = $("#positions option:selected").val();
            var groupid = $("#groups option:selected").val();

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/addajax.htm",
                data: "username=" + name+"&positionid="+positionid+"&groupid="+groupid,
                success: function(response){
                    $('#info').html(response);
                    $('#name').val('');

                },
                error: function(e){
                    alert('Error: ' + e);
                }
            });
        }
        function deleteUser(id){

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/deleteajax.htm",
                data: "userid=" + id,
                success: function(response){
                    $('#info').html(response);

                },
                error: function(e){
                    alert('Error: ' + e);
                }
            });
        }
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/group/list.htm">groups</a><br/>
<h1>List users</h1>
<ul>
    <c:forEach items="${users}" var="user">
    <li>Name : <c:out value="${user.username}" />;<input type="button" value="Delete" onclick="deleteUser(${user.id})">
        </c:forEach>
</ul>

<table>
    <tr><td>Enter your name : </td><td> <input type="text" id="name"></td><td>
        <select id="positions">
            <c:forEach items="${positions}" var="pos">
                <option value="${pos.id}"><c:out value="${pos.title}" /></option>
            </c:forEach>
        </select>
    </td><td>
        <select id="groups">
            <c:forEach items="${groups}" var="group">
                <option value="${group.id}"><c:out value="${group.title}" /></option>
            </c:forEach>
        </select>
    </td></tr>
    <tr><td colspan="2"><input type="button" value="Add Users" onclick="addUser()"><br/></td></tr>
    <tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
</table>
</body>
</html>