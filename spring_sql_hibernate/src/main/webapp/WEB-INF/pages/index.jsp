<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Добро пожаловать</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">

<%@include file="header.jsp" %>
<h2>Добро пожаловать в Систему учета продуктов.
    <br>Для работы с базой данных введите логин и пароль, либо войдите как гость (доступна возможность только просмотра)
</h2>

<form action="${pageContext.request.contextPath}/person/startlogin" method="post">
    <label><input name="login" placeholder="Логин" type="text"></label> <br/>
    <label><input name="password" placeholder="Пароль" type="text"></label> <br/>
    <input type="submit" value=Войти>
</form>
<h4><a href="${pageContext.request.contextPath}/contentguest">Зайти как ГОСТЬ</a></h4>
<br>

<div id="map" style="height: 400px"></div>
<script src="http://api-maps.yandex.ru/2.1/?load=package.full&lang=ru-RU" type="text/javascript"></script>
<script type="text/javascript">
    var myMap;
    ymaps.ready(init); // Ожидание загрузки API с сервера Яндекса
    function init() {
        myMap = new ymaps.Map("map", {
            center: [53.902284, 27.561831], // Координаты центра карты
            zoom: 13
            // controls: ['smallMapDefaultSet']// Zoom
        }, {
            searchControlProvider: 'yandex#search'
        }),
            // Создаем геообъект с типом геометрии "Точка".
            myGeoObject = new ymaps.GeoObject({
                // Описание геометрии.
                geometry: {
                    type: "Point",
                    coordinates: [53.902284, 27.561831]
                },
                // Свойства.
                properties: {
                    // Контент метки.
                    iconContent: 'Октябрьская площадь',
                    hintContent: 'нулевой километр Беларуси'
                }
            }, {
                // Опции.
                // Иконка метки будет растягиваться под размер ее содержимого.
                preset: 'islands#blackStretchyIcon',
                // Метку можно перемещать.
                draggable: false
            }),
            // myPieChart = new ymaps.Placemark([
            //     53.902284, 27.561831
            // ], {
            //     // Данные для построения диаграммы.
            //     data: [
            //         {weight: 8, color: '#0E4779'},
            //         {weight: 6, color: '#1E98FF'},
            //         {weight: 4, color: '#82CDFF'}
            //     ],
            //     iconCaption: "Диаграмма"
            // }, {
            //     // Зададим произвольный макет метки.
            //     iconLayout: 'default#pieChart',
            //     // Радиус диаграммы в пикселях.
            //     iconPieChartRadius: 30,
            //     // Радиус центральной части макета.
            //     iconPieChartCoreRadius: 10,
            //     // Стиль заливки центральной части.
            //     iconPieChartCoreFillStyle: '#ffffff',
            //     // Cтиль линий-разделителей секторов и внешней обводки диаграммы.
            //     iconPieChartStrokeStyle: '#ffffff',
            //     // Ширина линий-разделителей секторов и внешней обводки диаграммы.
            //     iconPieChartStrokeWidth: 3,
            //     // Максимальная ширина подписи метки.
            //     iconPieChartCaptionMaxWidth: 200
            // });

            myMap.geoObjects
                .add(myGeoObject)
                // .add(myPieChart)
                // .add(new ymaps.Placemark([55.684758, 37.738521], {
                //     balloonContent: 'цвет <strong>воды пляжа бонди</strong>'
                // }, {
                //     preset: 'islands#icon',
                //     iconColor: '#0095b6'
                // }))
                // .add(new ymaps.Placemark([55.833436, 37.715175], {
                //     balloonContent: '<strong>серобуромалиновый</strong> цвет'
                // }, {
                //     preset: 'islands#dotIcon',
                //     iconColor: '#735184'
                // }))
                // .add(new ymaps.Placemark([55.687086, 37.529789], {
                //     balloonContent: 'цвет <strong>влюбленной жабы</strong>'
                // }, {
                //     preset: 'islands#circleIcon',
                //     iconColor: '#3caa3c'
                // }))
                // .add(new ymaps.Placemark([55.782392, 37.614924], {
                //     balloonContent: 'цвет <strong>детской неожиданности</strong>'
                // }, {
                //     preset: 'islands#circleDotIcon',
                //     iconColor: 'yellow'
                // }))
                // .add(new ymaps.Placemark([55.642063, 37.656123], {
                //     balloonContent: 'цвет <strong>красный</strong>'
                // }, {
                //     preset: 'islands#redSportIcon'
                // }))
                .add(new ymaps.Placemark([53.895881, 27.556109], {
                    balloonContent: 'МСХП',
                    iconCaption: 'Работа'
                }, {
                    preset: 'islands#governmentCircleIcon',
                    iconColor: '#3b5998'
                }));
        // .add(new ymaps.Placemark([55.694843, 37.435023], {
        //     balloonContent: 'цвет <strong>носика Гены</strong>',
        //     iconCaption: 'Очень длиннный, но невероятно интересный текст'
        // }, {
        //     preset: 'islands#greenDotIconWithCaption'
        // }))
        // .add(new ymaps.Placemark([55.790139, 37.814052], {
        //     balloonContent: 'цвет <strong>голубой</strong>',
        //     iconCaption: 'Очень длиннный, но невероятно интересный текст'
        // }, {
        //     preset: 'islands#blueCircleDotIconWithCaption',
        //     iconCaptionMaxWidth: '50'
        // }));

    }
</script>

<br>
<%@include file="footer.jsp" %>
<br>
<br>
</body>
</html>