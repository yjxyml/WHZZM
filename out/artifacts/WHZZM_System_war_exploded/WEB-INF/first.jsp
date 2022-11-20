<%-- Created by IntelliJ IDEA. User: 用尽心意 Date: 2022/11/13 Time: 17:19 To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="https://elasticsearch.cn/static/css/default/img/favicon.ico?v=20151125" rel="shortcut icon"
        type="image/x-icon" />

    <script src="https://elasticsearch.cn/static/js/aw_template.js?v=20151125"
        type="text/javascript"></script>

    <link href="https://elasticsearch.cn/static/css/default/common.css?v=16?v=20151125" rel="stylesheet"
        type="text/css" />
    <style>
        .aw-logo a:hover {
            color: red;
        }
    </style>
</head>

<body>
    <div class="aw-top-menu-wrap">
        <div class="container">
            <div class="aw-logo hidden-xs">
                <a href="index.do" style="font-size: 30px;width:190px;height: 50px;line-height:30px;display:inline-block;margin-left: -20px; text-decoration: none;">WHZZM论坛</a>
            </div>
            <div class="aw-search-box hidden-xs hidden-sm">
                <form class="navbar-search" action="" id="global_serach_form" method="post">
                    <input class="form-control search-query" type="text" placeholder="搜索问题、话题或人" style="margin-left: 100px;" autocomplete="off" name="q" id="aw-search-query" />
                </form>
            </div>
            <div class="aw-user-nav">
                <a class="aw-user-name hidden-xs" href="user.do" rel="nofollow">
                    <img src="${sessionScope.user.file}">
                </a>
                <a class="login btn btn-small btn-primary" href="index.do" style="display: inline-block;margin-left: 10px">
                    退出
                </a>
            </div>`
        </div>
    </div>
    <div class="aw-container-wrap">
        <div class="container category">
            <div class="row">
                <div class="col-sm-12">
                    <ul class="list">
                        <c:forEach items="${requestScope.zones}" var="zone">
                            <c:if test="${zone.id == 0}">
                                <li class="active">
                                    <a href="">${zone.name}</a>
                                </li>
                            </c:if>
                            <c:if test="${!(zone.id == 0)}">
                                <li>
                                    <a href="">${zone.name}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row" style="background: white">
                <div class="aw-content-warp clearfix">
                    <div class="col-sm-12 col-md-9 aw-main-content">

                    </div>
                    <ul class="nav nav-tabs aw-nav-tabs active hidden-xs">
                        <li>
                            <a href="hotTopics.do?id=1">
                                <span>热门</span>
                            </a>
                        </li>
                        <li>
                            <a href="recommend.do?id=1">
                                <span>推荐</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="index2.do?id=1">
                                <span>最新</span>
                            </a>
                        </li>
                        <h2>
                            发现
                        </h2>
                    </ul>
                    <div class="aw-mod aw-explore-list">
                        <div class="mod-body">
                            <div class="aw-common-list">
                                <c:forEach items="${requestScope.messages}" var="message">
                                    <div class="aw-item active" data-topic-id>
                                        <a class="aw-user-name hidden-xs" href="" rel="nofollow">
                                            <img src="${message.img}">
                                        </a>
                                        <div class="aw-question-content">
                                            <h4>
                                                <a href="">${message.content}</a>
                                            </h4>
                                            <a href="" class="pull-right text-color-999">回复</a>
                                            <p>
                                                <a class="aw-question-tags" href="">${message.title}</a>
                                                •
                                                <a class="aw-user-name" href="">${message.author}</a>
                                                <span>发起了问题•${message.attention}人关注•${message.reply}个回复•${message.date}</span>
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>