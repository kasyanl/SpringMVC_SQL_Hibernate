<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
<%@include file="../../header.jsp"%>
<%@include file="../nav.jsp"%>
<h1>Продукты категории BERRIES:</h1>
<table class="title" align="right">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/product/berriesdiscount" title="Изменить скидку для категории">
                <input type="image" src="${pageContext.request.contextPath}/download/xls/procent.png"
                       width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
        </th>
        <th>
            <a href="${pageContext.request.contextPath}/product/exportexcel/berries" title="Экспорт в Excel файл">
                <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
                       width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
        </th>
    </tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<table class="table" align="center">
    <tr>
        <th width="100" align="center"><b> ID</b></th>
        <th><b> категория</b></th>
        <th><b> название</b></th>
        <th width="100" align="center"><b> цена, BYN</b></th>
        <th width="100" align="center"><b> скидка, %</b></th>
        <th width="100" align="center"><b> конечная цена, BYN</b></th>
        <th width="100" align="center"><b> наличие, кг(шт)</b></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td><c:out value="${product.getId()}"/></td>
            <td><c:out value="${product.getCategory()}"/></td>
            <td><c:out value="${product.getName()}"/></td>
            <td><c:out value="${product.getPrice()}"/></td>
            <td><c:out value="${product.getDiscount()}"/></td>
            <td><c:out value="${product.getActualPrice()}"/></td>
            <td><c:out value="${product.getTotalVolume()}"/></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproduct?id=${product.getId()}" title="Удалить"
                   onclick="return confirm('Удалить продукт <${product.getName()}> категории <${product.getCategory()}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/del.png"
                    width="18" height="18" alt="Удалить"></a></td>
            <td><a href="${pageContext.request.contextPath}/product/editproduct?id=${product.getId()}" title="Изменить"
                   onclick="return confirm('Изменить данные <${product.getName()}> категории <${product.getCategory()}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/edit.jpg"
                    width="18" height="18" alt="Изменить"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <th><b> ID</b></th>
        <th><b> категория</b></th>
        <th><b> название</b></th>
        <th><b> цена, BYN</b></th>
        <th><b> скидка, %</b></th>
        <th><b> конечная цена, BYN</b></th>
        <th><b> наличие, кг(шт)</b></th>
        <th></th>
        <th></th>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/selectcategorybyread">Back</a>
<br>
<br>
<%@include file="../../footer.jsp" %>
<br>
<br>
</body>
</html>