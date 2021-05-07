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
<%@include file="../../header.jsp"%>
<%@include file="../navguest.jsp"%>
<h3>Список список категории <b>MILK_PRODUCT</b> успешно сформирован. Нажмите на значок, для скачивания</h3>
<a href="${pageContext.request.contextPath}/download/xls/productlist.xls" title="Сохранить">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
<br>
<br>
<a href="${pageContext.request.contextPath}/contentguest">Back</a>
<br>
<br>
<%@include file="../../footer.jsp"%>
<br>
<br>
</body>
</html>