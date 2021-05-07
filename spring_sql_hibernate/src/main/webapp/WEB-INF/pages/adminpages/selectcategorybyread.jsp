<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система учета продуктов</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp" %>
<h1>Выберите категориию:</h1>
<div face="arial" size="+1">
    <li><a href="${pageContext.request.contextPath}/product/finefruits">FRUITS</a>
    <li><a href="${pageContext.request.contextPath}/product/fineberries">BERRIES</a>
    <li><a href="${pageContext.request.contextPath}/product/finevegetables">VEGETABLES</a>
    <li><a href="${pageContext.request.contextPath}/product/finemilkproduct">MILK_PRODUCT</a>
    <li><a href="${pageContext.request.contextPath}/product/finemeat">MEAT</a>
    <li><a href="${pageContext.request.contextPath}/product/finealcohol">ALCOHOLIC_BEVERAGES</a>
</div>
<br>
<br>
<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp"%>
<br>
<br>
</body>
</html>