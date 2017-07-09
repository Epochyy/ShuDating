<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="http://img.t.sinajs.cn/t5/style/css/module/base/frame.css?version=a05309c5d15974a8" type="text/css" rel="stylesheet" />
    <link href="http://img.t.sinajs.cn/t5/style/css/module/layer/layer_login_v5.css?version=a05309c5d15974a8" type="text/css" rel="stylesheet" />

    <link href="CSS/style.css" type="text/css" rel="stylesheet">
    <link href="CSS/login.css" rel="stylesheet" type="text/css">
    <script src="js/reg.js" type="text/javascript"></script>
    <script src="js/gVerify.js" type="text/javascript"></script>
    <script src="js/login.js" type="text/javascript"></script>
</head>

<body class="B_register B_reg_tel ">

<div class="W_nologin">

    <div class="z_top_container">
        <div class="z_top">
            <div class="z_header">
                <div class="z_top_nav">
                    <ul>
                        <li class="home">
                            <a class="i-link" href="index.jsp" title="首页"><span>首页</span></a>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </div>


    <form action="login" method="post" id="loginform">
        <div class="W_nologin_logo_big"></div>
        <!--图标-->
        <div class="W_nologin_main main_radius_bg">
            <div class="main_tab_line">
                <a class="W_f22 W_Yahei cur" href="javascript:void(0);">登录</a>
            </div>
            <div class="W_reg_info clearfix" id="pl_account_regmobile">
                <div class="W_reg_form">
                    <div class="info_list clearfix" node-type="mobilesea_wrapper">
                        <div class="tit">
                            用户名：
                        </div>
                        <div class="inp">

                            <input type="text" name="user.username" class="W_input" value="" autocomplete="on">

                        </div>
                    </div>

                    <div class="info_list clearfix">
                        <div class="tit">
                            密码：
                        </div>
                        <div class="inp">
                            <input node-type="password" action-data="" action-type="text_copy" name="user.password" type="password" class="W_input" value="" />
                        </div>
                    </div>

                    <div class="info_list clearfix">
                        <div class="info_submit clearfix">
                            <div class="inp">
                                <a action-type="btn_submit" class="W_btn_big" suda-uatrack="key=tblog_register_page&value=register_now_button" href="javascript:void(0);" refake-type="submit" node-type="btn_submit" onclick="document.getElementById('loginform').submit();return false"><span>登录</span></a>
                            </div>
                        </div>
                    </div>

    </form>
    <div class="W_reg_sidebar">
        <p class="p1 line">
            没有注册？<a href="register.jsp">点我注册»</a>
            <a href="/resetpwd" class="mima">忘记密码？</a>
        </p>

    </div>
</div>
</div>

</div>
<!--注册登录footer-->
<div class="nologin_footer clearfix">
    <div class="left_link">
        <em class="company_name">@夏季课程项目</em>
    </div>

</div>

</body>
</html>
