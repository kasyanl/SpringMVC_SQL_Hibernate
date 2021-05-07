<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Учет продуктов</title>
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
<h1>Система учета продуктов</h1>

<table class="table" align="center">
    <tr>
        <th width="100" align="center">
            <a href="${pageContext.request.contextPath}/product/allproduct">
                <img src="${pageContext.request.contextPath}/download/xls/allproduct.jpg"
                     width="400" height="400" alt="Список всех продуктов"><h3>Список всех продуктов</h3></a></p>
        </th>
        <th width="100" align="center">
            <a href="${pageContext.request.contextPath}/product/addproduct">
                <img src="${pageContext.request.contextPath}/download/xls/add.png"
                     width="400" height="400" alt="Добавить новый продукт"><h3>Добавить новый продукт</h3></a></p>
        </th>
    </tr>
  </table>
<%@include file="../footer.jsp" %>
</body>
</html>
