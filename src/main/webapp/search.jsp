<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="entity.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%UserInfo me=(UserInfo)session.getAttribute("user");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'search.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="CSS/info.css" rel=stylesheet type="text/css">
    <link href="CSS/base.css" rel="stylesheet" type="text/css">
    <link href="CSS/dynamic.css" rel="stylesheet" type="text/css">
    <link href="CSS/post.css" rel="stylesheet" type="text/css">
    <link href="CSS/friend.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .listheight{
            height:100px;
            margin-left: 50px;;
        }
    </style>
</head>

<body>
<s:set name="user" value="#session['user']"/>
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
            <div class="sd l float">
                <div class="sec">
                    <div class="usr">
                        <img class="bg" src="" style="display: none">
                        <div class="info">
                            <div>
                                <div class="name"><span><s:property value="#user.username"/></span></div>

                            </div>
                        </div>
                        <div class="face"><img src="images/<%=me.getUsername() %>.jpg" alt="这是头像"></div>
                    </div>

                </div>

            </div>

            <div class="security-right">

                <div class="ckpost" style="height:120px;text-align:left;">
                    <div class="title_area clearfix">
                        <div class="title">
                            <p class=""><em>动动手指搜一搜</em></p>
                        </div>
                    </div>
                    <div class="checkbox_list">
                        <s:form action="search" method="post" theme="simple">
                            <s:checkboxlist label="#" list="{'文学青年', '影视音乐', '体育健身', '游戏娱乐', '美食专家', '二次元', '学霸无双'}" name="item"></s:checkboxlist>
                            <div class="dia-btn">
                                <input type="submit" value="搜索" >
                                <br><br>
                            </div>
                        </s:form>
                    </div>

                    <div class="s-space" style="position:relative;margin-left:-30px;">
                        <s:set name="list" value="#session['list']"/>
                        <s:iterator value="list" id="items">
                            <div class="wrapper clearfix" id="page-fans">
                                <div class="col-full">
                                    <div class="section fans" id="fans-list">
                                        <div class="content" style="position:relative;text-align:left;padding-left:5px;">
                                            <div class="list-item clearfix">
                                                <img  src="images/<s:property value="#items.username"/>.jpg" class="head_portrait" style="margin-top:0px;margin-bottom:3px;">
                                                <s:url var="url" action="showfriendinfo">
                                                    <s:param name="friends.username"  value="#items.username"></s:param>
                                                </s:url>
                                                <s:a class="title" href="%{url}"><s:property value="#items.username"/></s:a>
                                                <a class="btn_addFriend" onClick="addfriend_confirm()" href="addfriends.action?FriendName=<s:property value="#items.username"/>"> 加为好友</a><br>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </s:iterator>
                    </div>

                </div>

            </div>
        </div>

    </div>

    <script type="text/javascript">
        function addfriend_confirm() {
            event.returnValue = confirm("确认添加好友吗？");
        }

    </script>

    <div class="footer">
        <div class="footer-wrp">
            <div class="footer-cnt clearfix">
                <em>@夏季课程项目</em>
            </div>
        </div>
    </div>
</div>
</body>
</html>
