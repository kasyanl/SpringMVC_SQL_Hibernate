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
<h3>Вход выполнен</h3>
<h4><a href="${pageContext.request.contextPath}/content">Перейти на главную страницу</a></h4>
<br>
<br>
<%@include file="footer.jsp"%>
<br>
<br>
</body>
</html>
