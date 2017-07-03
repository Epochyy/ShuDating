<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="entity.*"%>
<%UserInfo me=(UserInfo) session.getAttribute("user");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'UserNews.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="CSS/info.css" rel=stylesheet type="text/css">
    <link href="CSS/base.css" rel="stylesheet" type="text/css">
    <link href="CSS/page_core.css" rel="stylesheet" type="text/css">
    <link href="CSS/dynamic.css" rel="stylesheet" type="text/css">
    <link href="CSS/search.css" rel="stylesheet" type="text/css">
    <link href="CSS/post.css" rel="stylesheet" type="text/css">

</head>

<body>
<div class="z_top_container">
    <div class="z_top">
        <div class="z_header">
            <div class="z_top_nav">
                <ul>
                    <li class="home">
                        <a class="i-link" href="showlnews" title="首页"><span>首页</span></a>
                    </li>
                    <li class="home">
                        <a class="i-link" href="ShowUserInfo.jsp" title="个人空间">个人空间</a>
                    </li>
                    <li class="home">
                        <a class="i-link" href="enterFriendTable" title="好友列表"><span>好友列表</span></a>
                    </li>
                    <li class="home">
                        <a class="i-link" href="search" title="搜索"><span>搜索速配</span></a>
                    </li>
                    <div class="out">
                        <li class="i-link"> <a href="#"><%=me.getUsername() %>, 欢迎登陆<br></a></li>
                        <li class="i-link"> <a href="esc.jsp">注销</a></li>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="security_content">
    <div class="main-inner">

        <div class="stm-ly clearfix">
            <div class="sd l float" style="">
                <div class="sec">
                    <div class="usr">
                        <img class="bg" src="" style="display: none">
                        <div class="info">
                            <div>
                                <div class="name"><span><%=me.getUsername() %></span></div>

                            </div>
                        </div>
                        <div class="face"><img src="<%=me.getPhoto() %>" alt="这是头像"></div>
                    </div>
                    <div class="sd-l">
                        <a href="ShowUserInfo.jsp">我的信息<span class="ct"></span></a>
                        <a href="shownews">我的动态<span class="ct"></span></a>
                        <a href="showfnews">好友动态<span class="ct"></span></a>
                        <a href="updateLoveWall.jsp">表白<span class="ct"></span></a>
                    </div>
                </div>

            </div>

            <div class="security-right">

                <div class="post">
                    <div class="title_area clearfix">
                        <div class="title"><span class="txt">Say your love!</span>
                            <p class=""><em>直面你</em><em>内心</em><em>的声音吧</em><em>！</em></p>
                        </div>
                    </div>
                    <form action="upLoveWall" method="post" id="newsform">
                        <div class="Pinput">
                            <textarea class="P_input" name="ly" ></textarea>
                        </div>
                        <div class="dia-btn">
                            <a suda-uatrack="key=tblog_register_page&value=register_now_button" href="javascript:void(0);" action-type="btn_submit" onclick="document.getElementById('newsform').submit();return false">发送</a>

                        </div>
                    </form>
                </div>






            </div>
            </form>
        </div>
    </div>

</div>

<div class="footer">
    <div class="footer-wrp">
        <div class="footer-cnt clearfix">
            <em>@夏季课程项目</em>
        </div>
    </div>
</div>
</body>
</html>
