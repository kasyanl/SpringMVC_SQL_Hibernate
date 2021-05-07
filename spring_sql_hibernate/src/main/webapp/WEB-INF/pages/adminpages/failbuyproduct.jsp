<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Экспорт данных</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp" %>
<%@include file="nav.jsp" %>
<h3>Список покупок очищен. Для продолжения работы выберите соответствующий пункт</h3>

<br>
<br>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp" %>
<br>
<br>
</body>
</html>
