<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h3>Покупка завершена. Нажмите на значок, для скачивания чека</h3>
<a href="${pageContext.request.contextPath}/download/xls/check.xls" title="Сохранить">
  <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
         width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a>
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
