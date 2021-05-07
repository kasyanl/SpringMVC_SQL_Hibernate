<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <style>
        body {
            margin: 0;
        }

        header {
            display: block;
            background: url(${pageContext.request.contextPath}/download/xls/header.jpg) repeat-x;
            /* Градиент */
        }

        .header-bg {
            background: url(${pageContext.request.contextPath}/download/xls/header.jpg) repeat-x center bottom;
            height: 200px;
            text-align: center;
        }

        .header-bg img {
            position: relative;
            top: 40px;
        }
    </style>
    <title></title>
</head>
<body>
<header>
    <div class="header-bg"></div>
</header>

</body>
</html>
