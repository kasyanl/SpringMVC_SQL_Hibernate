<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="header.jsp"%>
<h4>Логин и/или пароль не верен. Пожалуйста, повторите попытку</h4>

<form action="${pageContext.request.contextPath}/person/startlogin" method="post">
    <label><input name="login" placeholder="Логин" type="text"></label> <br/>
    <label><input name="password" placeholder="Пароль" type="text"></label> <br/>
    <input type="submit" value=Войти>
</form>
<br>
<br>
<h4><a href="${pageContext.request.contextPath}/contentguest">Зайти как ГОСТЬ</a></h4>
<br>
<br>
<%@include file="footer.jsp"%>
<br>
<br>
</body>
</html>
