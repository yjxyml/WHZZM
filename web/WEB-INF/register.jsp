<%-- Created by IntelliJ IDEA. User: 用尽心意 Date: 2022/11/1 Time: 18:00 To change this template use File | Settings | File
    Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
        }

        .container {
            height: 100%;
            background-image: linear-gradient(to right, #A0FE65, #F6CEEC);
        }

        .login-wrapper {
            background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }

        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }

        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }

        .input-item:placeholder {
            text-transform: uppercase;
        }

        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #A0FE65, #F6CEEC);
            color: #fff;
        }

        .msg {
            text-align: center;
            line-height: 88px;
        }

        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="login-wrapper">
            <div class="header">注册</div>
            <div class="form-wrapper">
                <input type="text" name="username" placeholder="username" class="input-item">
                <input type="password" name="password" placeholder="password" class="input-item">
                <input type="text" name="phone" placeholder="phone" class="input-item">
                <div class="btn">注册</div>
            </div>
        </div>
    </div>
    <div style="text-align: center; font-size: 24px; color: red ; position: absolute; margin-top: 500px; margin-left: 700px">
        <c:if test="${requestScope.errors != ''}">
            <c:forEach items="${requestScope.errors.getMap()}" var="map">
                <c:if test="${map.value == 'name is null'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == 'pw is null'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == 'phone is null'}">
                    ${map.value}
                </c:if>
                <c:if
                    test="${map.value == 'pw is null' && map.value == 'name is null' && map.value == 'phone is null'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == '注册失败'}">
                    ${map.value}
                </c:if>
                <br>
            </c:forEach>
        </c:if>
    </div>
    </div>

</body>

</html>