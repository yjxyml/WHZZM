<%-- Created by IntelliJ IDEA. User: 用尽心意 Date: 2022/11/13 Time: 19:21 To change this template use File | Settings |
    File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>category-2</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="https://elasticsearch.cn/static/css/default/img/favicon.ico?v=20151125" rel="shortcut icon"
        type="image/x-icon" />

    <script src="https://elasticsearch.cn/static/js/aw_template.js?v=20151125" type="text/javascript"></script>

    <link href="https://elasticsearch.cn/static/css/default/common.css?v=16?v=20151125" rel="stylesheet"
        type="text/css" />

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .aw-logo a:hover {
            color: red;
        }

        .a1 {
            background-color: white;
            width: 80%;
            height: 1500px;
            margin-top: 20px;
            margin-left: 200px;
        }
    </style>
</head>

<body>
    <div class="aw-top-menu-wrap">
        <div class="container">
            <div class="aw-logo hidden-xs">
                <a style="font-size: 30px;width:190px;height: 50px;line-height:30px;display:inline-block;margin-left: -100px; text-decoration: none;">WHZZM论坛</a>
            </div>
            <div class="aw-search-box hidden-xs hidden-sm">
                <form class="navbar-search" action="" id="global_serach_form" method="post">
                    <input class="form-control search-query" type="text" placeholder="搜索问题、话题或人" autocomplete="off" name="q" id="aw-search-query" />
                </form>
            </div>
            <div class="aw-top-nav navbar">
                <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">
                    <ul class="nav navbar-nav">

                    </ul>
                </nav>
            </div>
            <div class="aw-user-nav">
                <a class="login btn btn-small btn-primary" href="login.do">登录</a>
                <a class="login btn btn-small btn-primary" href="showRegister.do">注册</a>
            </div>
        </div>
        <div>

        </div>
    </div>
    <div class="a1">
        <div class="container" style="margin-left: 100px">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h3>
                        标题
                    </h3>
                </div>
            </div>
        </div>
        <div style="margin-left: 100px">
            <a class="aw-question-tags">js</a>
            | 作者 xxx
            | 当前阅读数 <span>1</span>
        </div>
        <br>
        <br>
        <div style="margin-left: 100px">
            作者：<a href="#">xxx</a> <br><br>
            更多阅读请参阅 <a>xxx博客</a>
        </div>
        <br>
        <div style="margin-left: 100px">美丽的风景</div>
        <div style="margin-left: 100px">
            <img src="img/1.jpg" style="width: 600px; height: 400px">
        </div>
        <br>
        <br>
        <div style="margin-left: 100px">
            555555
        </div>
        <div style="margin-left: 100px">
            <h3>主要内容</h3>
        </div>
        <div style="margin-left: 100px">
            <h4>副标题</h4>
            <br>
            <span>...............</span>
            <br>
        </div>
        <br>
        <div style="margin-left: 100px; width: 600px; height: 400px; ">
            <pre style="background-color: #708090;color: white">
                4444
            </pre>
        </div>
        <div style="margin-left: 100px">
            <br>
            <br>
            <div style="color: black">
                <span>xx天前</span>
                <a>
                    <i class="icon icon-comment">...</i>
                    添加评论
                </a>
            </div>
            <br>
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <h3 style="color: black">
                            <span>0</span> 回复
                        </h3>
                    </div>
                </div>
            </div>
        </div>
        <div
            style="border-left-style: solid; width: 300px;height: 1500px; margin-left: 800px; margin-top: -1420px; border-left-color: black">
            <div style="margin-left: 30px">发起人：<span>xxx</span></div>
            <br>
            <div style="margin-left: 30px">
                <img src="img/2.png" width="50px" height="50px">
                <span>xxx</span><br>
                <br>
                <span>擅长话题：</span>
                <a href="#">
                    <i class="icon icon-tag">
                        javaweb
                    </i>
                </a>
                <a href="#">
                    <i class="icon icon-tag">
                        js
                    </i>
                </a>
            </div>
            <br>
            <div style="margin-left: 30px; margin-top: 100px">
                推荐活动：
                <div class="activity-detail-title"><br>
                    <a>xxx 中国开发者大会 2022</a><br><br>
                    <span class="activity-detail-base">无锡</span>
                    <span class="dot">12-31 周六</span>
                    <span class="activity-state">报名中</span>
                </div>
            </div>
            <br>
            <br>
            <div style="margin-left: 30px; position: fixed; bottom: 0">
                <h4>目录</h4>
                <span>
                    ~<a>主要功能</a><br>
                    &nbsp;&nbsp;&nbsp;~<a>xxx</a><br>
                    ~<a>性能</a><br>
                    &nbsp;~<a>xxx</a><br>
                    &nbsp;&nbsp;&nbsp;~<a>xxx</a>
                </span>
            </div>
        </div>
    </div>
</body>

</html>