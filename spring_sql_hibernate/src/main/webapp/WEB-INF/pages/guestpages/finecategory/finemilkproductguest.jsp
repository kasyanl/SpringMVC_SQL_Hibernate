<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="../../header.jsp" %>
<%@include file="../navguest.jsp" %>
<h1>Продукты категории MILK_PRODUCT:</h1>
<h3 align="right"><a href="${pageContext.request.contextPath}/product/exportexcel/milkguest">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></h3>
    <table class="table" align="center">
        <tr>
            <th width="100" align="center"><b> ID</b></th>
            <th><b> категория</b></th>
            <th><b> название</b></th>
            <th width="100" align="center"><b> цена, BYN</b></th>
            <th width="100" align="center"><b> скидка, %</b></th>
            <th width="100" align="center"><b> конечная цена, BYN</b></th>
            <th width="100" align="center"><b> наличие, кг(шт)</b></th>
        </tr>
        <c:forEach var="product" items="${product}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.discount}"/></td>
                <td><c:out value="${product.actualPrice}"/></td>
                <td><c:out value="${product.totalVolume}"/></td>
            </tr>
        </c:forEach>
        <tr>
            <th width="100" align="center"><b> ID</b></th>
            <th><b> категория</b></th>
            <th><b> название</b></th>
            <th width="100" align="center"><b> цена, BYN</b></th>
            <th width="100" align="center"><b> скидка, %</b></th>
            <th width="100" align="center"><b> конечная цена, BYN</b></th>
            <th width="100" align="center"><b> наличие, кг(шт)</b></th>
        </tr>
    </table>
<br>
<a href="${pageContext.request.contextPath}/selectcategorybyreadguest">Back</a>
<br>
<br>
<%@include file="../../footer.jsp" %>
<br>
<br>
</body>
</html>