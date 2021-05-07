<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Касса</title>
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
<h3>Перейти к этапу выбора товаров?</h3>

<form action="${pageContext.request.contextPath}/product/allproduct" method="get">
    <input type="submit" value="Список продуктов">
</form>
<form action="${pageContext.request.contextPath}/product/buyproduct" method="get">
    <input type="submit" value="В кассу">
</form>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>
