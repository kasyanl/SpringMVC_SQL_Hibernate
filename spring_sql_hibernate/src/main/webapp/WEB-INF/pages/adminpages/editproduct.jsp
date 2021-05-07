<%@ page import="kasyan.bean.Product" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Изменение данных.</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp"%>
<%@include file="nav.jsp"%>
<h2>Замените необходимые данные:</h2>
<% Product product = (Product) request.getAttribute("product"); %>
<form action="${pageContext.request.contextPath}/product/editproduct?id=<%=product.getId()%>" method="post">
    <label>
        категория<br>
        <select <%=product.getCategory()%> name="category">
            <option value="<%=product.getCategory()%>"><%=product.getCategory()%></option>
            <option value="FRUITS">FRUITS</option>
            <option value="BERRIES">BERRIES</option>
            <option value="VEGETABLES">VEGETABLES</option>
            <option value="MILK_PRODUCT">MILK_PRODUCT</option>
            <option value="MEAT">MEAT</option>
            <option value="ALCOHOLIC_BEVERAGES">ALCOHOLIC_BEVERAGES</option>
        </select>
    </label><br/>
    название продукта<br>
    <label><input name="name" placeholder="название" type="text" value="<%=product.getName()%>"></label> <br/>
    стоимость подукта, BYN<br>
    <label><input name="price" placeholder="цена" type="text" value="<%=product.getPrice()%>"></label> <br/>
    скидка продукта, %<br>
    <label><input name="discount" placeholder="скидка" type="text" value="<%=product.getDiscount()%>"></label> <br/>
    наличе, кг(шт)<br>
    <label><input name="totalVolume" placeholder="наличие" type="text" value="<%=product.getTotalVolume()%>"></label> <br/>
    <br>  <input type="image" src="${pageContext.request.contextPath}/download/xls/save.jpg"
                 width="50" height="50" alt="Добавить новый продукт" value="Сохранить">
</form>
<a href="${pageContext.request.contextPath}/content">Home</a>
<br>
<br>
<br>
<%@include file="../footer.jsp"%>
<br>
<br>
</html>