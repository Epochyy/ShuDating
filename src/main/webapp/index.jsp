<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="entity.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="dao.DatingDaoImp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'ShowFriendNews.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
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
                <%
                    UserInfo me=(UserInfo)session.getAttribute("user");
                %>
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
                        <li class="i-link"> <a href="#"><%=me.getUsername()%>, 欢迎登录<br></a></li>
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
                        <div class="face"><img src="images/<%=me.getUsername() %>.jpg" alt="这是头像"></div>
                    </div>

                </div>

            </div>

            <div class="security-right">

                <div class="post">
                    <div class="title_area clearfix">
                        <div class="title"><span class="txt">欢迎来到交友平台</span>
                            <p class=""><em>愿你能抓住属于自己的缘分</em></p>
                        </div>
                    </div>
                    <img alt="" src="images/logo.jpg" width="600px" height="100px">

                </div>

                <div class="ct">
                    <ul class="stm-lst">
                        <%
                            DatingDaoImp d = new DatingDaoImp();
                            ArrayList al=(ArrayList) d.getLatestNews();
                            Iterator iter=al.iterator();
                            while(iter.hasNext()){
                                LoveWall ly=(LoveWall)iter.next();
                        %>
                        <li data-id="0" class="stm-lst-item">

                            <div class="frm">
                                <div class="lside">
                                    <a class="face video" target="_blank">
                                        <img src="images/<%=ly.getUsername()%>.jpg" alt="好友头像">
                                    </a>
                                </div>

                                <div class="rside">
                                    <div class="name">
                                        <s:url var="url" action="showfriendinfo">
                                            <s:param name="friends.username" ><%=ly.getUsername() %></s:param>
                                        </s:url>
                                        <s:a href="%{url}" ><%=ly.getUsername() %></s:a><span class="dt"><%=ly.getTime() %></span>
                                    </div>

                                    <div class="desc">
                                        <%=ly.getText() %>
                                    </div>
                                </div>
                            </div>

                        </li>
                        <% }%>

                    </ul>
                </div>

            </div>
            </form>
        </div>
    </div>

</div>

<div class="footer">
    <div class="footer-wrp">
        <div class="footer-cnt clearfix">
            <em>@夏季小学期项目</em>
        </div>
    </div>
</div>
</body>
</html>
