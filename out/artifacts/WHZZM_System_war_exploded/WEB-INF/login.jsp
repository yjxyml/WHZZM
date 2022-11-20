<%@ page import="java.util.Map" %>
    <%-- Created by IntelliJ IDEA. User: 用尽心意 Date: 2022/11/1 Time: 21:52 To change this template use File | Settings |
        File Templates. --%>
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
            background-image: linear-gradient(to right, #FDEB71, #ABDCFF);
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
            background-image: linear-gradient(to right,#ABDCFF , #FDEB71);
            color: #fff;
            border: 1px solid white;
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
            <div class="header">用户登录</div>
            <div class="form-wrapper">
                <form action="login.do" method="post">
                    <input type="text" name="user" placeholder="username" class="input-item">
                    <input type="password" name="pw" placeholder="password" class="input-item">
                    <button type="submit" class="btn">登录</button>
                </form>
            </div>
            <div class="msg">
                忘记密码?
                <a href="showRegister.do">注册</a>
            </div>
        </div>
    </div>

    <div style="text-align: center; font-size: 24px; color: red">
        <c:if test="${requestScope.errors != ''}">
            <c:forEach items="${requestScope.errors.getMap()}" var="map">
                <c:if test="${map.value == 'name is null'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == 'pw is null'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == 'pw is null' && map.value == 'name is null'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == '账号密码错误'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == '权限错误，你是游客'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == '权限错误，你是用户'}">
                    ${map.value}
                </c:if>
                <c:if test="${map.value == '权限错误，你是管理员'}">
                    ${map.value}
                </c:if>
                <br>
            </c:forEach>
        </c:if>
    </div>
</body>

</html>