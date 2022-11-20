<%--
  Created by IntelliJ IDEA.
  User: 用尽心意
  Date: 2022/11/13
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="https://elasticsearch.cn/static/css/default/img/favicon.ico?v=20151125" rel="shortcut icon" type="image/x-icon" />

    <script src="https://elasticsearch.cn/static/js/aw_template.js?v=20151125" type="text/javascript"></script>

    <link href="https://elasticsearch.cn/static/css/default/common.css?v=16?v=20151125" rel="stylesheet" type="text/css" />
    <style>
        .touxiang{
            margin-left: 700px;
        }
        .nicheng{
            margin-top: -150px;
            margin-left: 200px;
        }
        .jie{
            margin-top: 50px;
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
        <%--            <div class="aw-top-nav navbar">--%>
        <%--                <nav role="navigation" class="collapse navbar-collapse bs-navbar-collapse">--%>
        <%--                    <ul class="nav navbar-nav">--%>
        <%--                        <li><a href="" class="active">发现</a></li>--%>
        <%--                        <li><a href="">分享</a></li>--%>
        <%--                        <li><a href="">文章</a></li>--%>
        <%--                        <li><a href="">活动</a></li>--%>
        <%--                        <li><a href="">下载</a></li>--%>
        <%--                    </ul>--%>
        <%--                </nav>--%>
        <%--            </div>--%>
        <div class="aw-user-nav">
            <a class="login btn btn-small btn-primary" href="login.do">发起</a>

        </div>
    </div>
</div>
<div class="jie">
    <div class="container">
        <div class="row" style="background: white">
            <div class="aw-content-warp clearfix">
                <div class="col-sm-12 col-md-9 aw-main-content">

                </div>
                <div class="bian">
                    <ul class="nav nav-tabs aw-nav-tabs active hidden-xs">
                        <li>
                            <a>
                                <span>基本资料</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span>账户绑定</span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span>申请认证</span>
                            </a>
                        </li>

                        <h2>
                            用户设置
                        </h2>
                    </ul>
                </div>
                <div class="jiben1">
                    <div class="contentBox">
                        <div class="formBox">
                            <div id="setting-profile" class="setting-wrap setting-profile">
                                <div class="cb"></div>
                                <p class="rlf-tip-wrap errorHint color-red" ></p>
                            </div>
                        </div>
                        <div>
                            <div class="contentBox">
                                <div class="formBox">
                                    <div class="setting-wrap setting-profile">

                                        <div class="touxiang">  <div class="wlfg-wrap clearfix ">
                                            <label class="label-name">头像：</label>
                                            <div class="rlf-group">
                                                <img class="fl avator-img" id="js-portrait" src="1.jpg" data-portrait="58492fe600012e8e01800180" width="100" height="100">
                                                <br>
                                                <br>
                                                <br>
                                                <div class="fl ml20 pr">
                                                    <div><input type="button" hidefocus="true" value="换一换" class="js-avator-try avator-try"></div>
                                                    <div id="avator-btns" class="avator-btn-inner">
                                                        <!--div class="avator-btn-snswrap">
                                                            <span class="l-sns-btn l-sns-weibo" data-sns="weibo">从新浪微博同步头像</span>
                                                        </div !-->

                                                        <br>
                                                        <br>

                                                        <div class="avator-btn-wrap">
                                                            <form target="uploadtarget" action="postpic" method="post" enctype="multipart/form-data">
                                                                <a href="javascript:void(0)" hidefocus="true" class="avator-btn-fake">上传头像</a>
                                                                <input class="hide" type="file" title="上传头像" name="fileField" id="upload" accept="image/*">
                                                                <input class="hide" type="hidden" name="type" value="1">
                                                            </form>
                                                            <iframe src="about:blank" id="uploadtarget" name="uploadtarget" frameborder="0" style="display:none;"></iframe>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="cb"></div>
                                                <p class="rlf-tip-wrap errorHint color-red" ></p>
                                            </div>
                                        </div>
                                        </div>
                                    </div>
                                    <div class="nicheng">
                                        <form id="profile" >

                                            <div class="wlfg-wrap clearfix">
                                                <label class="label-name" for="nick" >昵称：</label>
                                                <br>
                                                <br>
                                                <div class="rlf-group">
                                                    <input type="text" name="nickname" id="nick"  autocomplete="off"  data-validate="require-nick"  class="moco-form-control" value="Sequin_YF" placeholder="请输入昵称."/>
                                                    <p class="rlf-tip-wrap errorHint color-red" ></p>
                                                </div>
                                            </div>



                                            <!--div class="wlfg-wrap clearfix">
                                                <label class="label-name" for="job">职位：</label>
                                                <div class="rlf-group">
                                                    <select class="moco-form-control rlf-select" name="job" hidefocus="true" id="job" data-validate="require-select">
                                                        <option value="">请选择职位</option>
                                                        <option value="13" >学生</option>
                                                        <option value="1" >页面重构设计</option>
                                                        <option value="6" >Web前端工程师</option>
                                                        <option value="5" >JS工程师</option>
                                                        <option value="8" >PHP开发工程师</option>
                                                        <option value="11" >JAVA开发工程师</option>
                                                        <option value="7" >移动开发工程师</option>
                                                        <option value="9" >软件测试工程师</option>
                                                        <option value="10" >Linux系统工程师</option>
                                                        <option value="2" >交互设计师</option>
                                                        <option value="3" >产品经理</option>
                                                        <option value="15" >数据库工程师</option>
                                                        <option value="4" >UI设计师</option>
                                                        <option value="17" >CG影视动画师</option>
                                                        <option value="16" >全栈工程师</option>
                                                    </select>
                                                    <p class="rlf-tip-wrap errorHint color-red"></p>
                                                </div>
                                            </div!-->
                                            <br>

                                            <div class="wlfg-wrap clearfix">
                                                <label class="label-name" for="province-select">城市：</label>
                                                <br>
                                                <br>

                                                <div class="rlf-group profile-address">
                                                    <select id="province-select" class='moco-form-control' hidefocus="true">
                                                        <option value="0">选择省份</option>
                                                        <option value="1">北京</option>
                                                        <option value="2">天津</option>
                                                        <option value="3">河北</option>
                                                        <option value="4">山西</option>
                                                        <option value="5">内蒙古</option>
                                                        <option value="6">辽宁</option>
                                                        <option value="7">吉林</option>
                                                        <option value="8">黑龙江</option>
                                                        <option value="9">上海</option>
                                                        <option value="10">江苏</option>
                                                        <option value="11">浙江</option>
                                                        <option value="12">安徽</option>
                                                        <option value="13">福建</option>
                                                        <option value="14">江西</option>
                                                        <option value="15">山东</option>
                                                        <option value="16">河南</option>
                                                        <option value="17">湖北</option>
                                                        <option value="18">湖南</option>
                                                        <option value="19">广东</option>
                                                        <option value="20">海南</option>
                                                        <option value="21">广西</option>
                                                        <option value="22">甘肃</option>
                                                        <option value="23">陕西</option>
                                                        <option value="24">新疆</option>
                                                        <option value="25">青海</option>
                                                        <option value="26">宁夏</option>
                                                        <option value="27">重庆</option>
                                                        <option value="28">四川</option>
                                                        <option value="29">贵州</option>
                                                        <option value="30">云南</option>
                                                        <option value="31">西藏</option>
                                                        <option value="32">台湾</option>
                                                        <option value="33">澳门</option>
                                                        <option value="34">香港</option>
                                                        <option value="100">其他</option>
                                                    </select>
                                                    <div class="cb"></div>
                                                    <p class="rlf-tip-wrap errorHint color-red"></p>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="wlfg-wrap clearfix">
                                                <label class="label-name h16 lh16" >性别：</label>
                                                <br>
                                                <br>
                                                <div class="rlf-group rlf-radio-group">
                                                    <label  class="lh16"><input type="radio" hidefocus="true" value="0"   name="sex">保密</label>
                                                    <label  class="lh16"><input type="radio" hidefocus="true" value="1"  name="sex">男</label>
                                                    <label  class="lh16"><input type="radio" hidefocus="true" value="2" checked="checked" name="sex">女</label>
                                                    <p class="rlf-tip-wrap errorHint color-red"></p>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="wlfg-wrap clearfix">
                                                <label class="label-name" for="aboutme">个性签名：</label>
                                                <br>
                                                <br>

                                                <div class="rlf-group">
                                                    <div class="pr">
                                                        <textarea name="aboutme"  id="aboutme"  rows="5" class="noresize js-sign moco-form-control"></textarea>
                                                        <br>
                                                        <br>
                                                        <p class="numCanInput js-numCanInput ">还可以输入128个字符</p>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="wlfg-wrap clearfix">
                                                <label class="label-name"></label>
                                                <div class="rlf-group">
                                                    <input type="submit" value="保存">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <br>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
