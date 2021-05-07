<%@ page import="kasyan.service.GetProductService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    GetProductService getProductService = new GetProductService();
    double totalPrise= getProductService.totalPrise();
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Касса</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp" %>
<h1>Проверьте, пожалуйста, список покупок</h1>

<h3 align="right"><a href="${pageContext.request.contextPath}/exportexcel" title="Экспортировать в excel">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></h3>

<table class="table" align="center">
    <tr>
        <th width="100" align="center"><b> ID</b></th>
        <th align="center"><b> название</b></th>
        <th width="100" align="center"><b> цена, BYN</b></th>
        <th idth="100" align="center"><b> количество</b></th>
        <th width="100" align="center"><b> конечная цена, BYN</b></th>
        <th width="100" align="center"><b></b></th>
    </tr>

    <c:forEach var="product" items="${product}">
        <tr>
            <td align="center"><c:out value="${product.getId()}"/></td>
            <td align="center"><c:out value="${product.getName()}"/></td>
            <td align="center"><c:out value="${product.getActualPrice()}"/></td>
            <td align="center"><c:out value="${product.getQuantity()}"/></td>
            <td align="center"><c:out value="${product.getTotalPrice()}"/></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproductbuy?id=${product.getId()}" title="Удалить"
                   onclick="return confirm('Удалить продукт <${product.getName()}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/del.png"
                    width="18" height="18" alt="Очистить корзину"></a></td>
            </td>
        </tr>
    </c:forEach>
    <tr> </tr>
    <tr> </tr>
    <tr> </tr>
    <tr> </tr>
    <tr>
        <th align="center"><b></b></th>
        <th align="center"><b></b></th>
        <th width="100" align="center"><b></b></th>
        <th>Итого:</th>
        <th><b><%=totalPrise%></b></th>
        <th><b> BYN </b></th>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/product/checkend" title="Оплатить">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/kassa.png"
           width="100" height="100" alt="Оплатить" value="Оплатить"></a>
<a href="${pageContext.request.contextPath}/product/failbuyproduct" title="Отмена">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/del.png"
           width="100" height="100" alt="Отмена" value="Отмена"></a>
<br>
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