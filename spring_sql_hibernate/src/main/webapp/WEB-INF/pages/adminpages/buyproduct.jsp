<%@ page import="kasyan.service.GetProductService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    GetProductService getProductService = new GetProductService();
    double totalPrise = getProductService.totalPrise();
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
<h1>Выберите </h1>

<h3 align="right"><a href="${pageContext.request.contextPath}/exportexcel" title="Экспортировать в excel">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></h3>

<table class="table" align="center">
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категория</b></th>
        <th colspan="2" align="center"><b> название</b></th>
        <th colspan="2" width="100" align="center"><b> цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> скидка, %</b></th>
        <th colspan="2" width="100" align="center"><b> конечная цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> наличие, кг(шт)</b></th>
        <td>Выбор количества товара</td>

    </tr>
    <%@include file="sortelement.jsp"%>
    <c:forEach var="product" items="${product}">
        <tr>
            <td colspan="2" align="center"><c:out value="${product.getId()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getCategory()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getName()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getPrice()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getDiscount()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getActualPrice()}"/></td>
            <td colspan="2" align="center"><c:out value="${product.getTotalVolume()}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/product/buyproduct?id=${product.getId()}&totalVolume=${product.getTotalVolume()}"
                      title="добавить"
                      method="post"><label><input size="10" name="quantity" placeholder="...а, кг(шт)"
                                                  type="text"></label> <input type="image"
                                                                              src="${pageContext.request.contextPath}/download/xls/add.png"
                                                                              width="20" height="20"
                                                                              alt="Добавить новый продукт"
                                                                              value="добавить">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
    <tr>
        <th colspan="2"></th>
        <th colspan="2"></th>
        <th colspan="2"></th>
        <th colspan="2"></th>
        <th colspan="2">Итого:</th>
        <th colspan="2"><b><%=totalPrise%>
        </b></th>
        <th colspan="2"><b> BYN </b></th>
        <th>
            <a href="${pageContext.request.contextPath}/product/endbuyproduct" title="Оформить покупку">
                <input type="image" src="${pageContext.request.contextPath}/download/xls/kassa.png"
                       width="80" height="80" alt="Оформить покупку" value="Оформить покупку"></a>
        </th>
        <th></th>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp" %>
<br>
<br>
</body>
</html>