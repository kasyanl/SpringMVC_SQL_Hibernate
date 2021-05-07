<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового продукта</title>
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
<h2>Добавление продукта:</h2>

<form  action="${pageContext.request.contextPath}/product/addproduct" method="post">

    категория<br><label>
    <select name="category">
        <option value="FRUITS">FRUITS</option>
        <option value="BERRIES">BERRIES</option>
        <option value="VEGETABLES">VEGETABLES</option>
        <option value="MILK_PRODUCT">MILK_PRODUCT</option>
        <option value="MEAT">MEAT</option>
        <option value="ALCOHOLIC_BEVERAGES">ALCOHOLIC_BEVERAGES</option>
    </select>
</label><br>
    <label><input name="name" placeholder="Название" type="text"></label><br/>
    <label><input name="price" placeholder="цена, BYN" type="text"></label> <br/>
    <label><input name="discount" placeholder="Скидка, %" type="text"></label> <br/>
    <label><input name="totalVolume" placeholder="Наличие, кг(шт)" type="text"></label> <br/>
    <br> <input type="image" src="${pageContext.request.contextPath}/download/xls/save.jpg"
                width="50" height="50" alt="Добавить новый продукт" value="Сохранить">
</form>
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