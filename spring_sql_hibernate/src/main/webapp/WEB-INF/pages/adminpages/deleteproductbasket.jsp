<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Удаление продукта</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h2>Удаление продукта</h2>
<h3>Продукт удален из корзины!!</h3>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>
