<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"  %>
<%@page import="model.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%User me=(User)session.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>好友列表</title>
    <link href="CSS/info.css" rel=stylesheet type="text/css">
    <link href="CSS/base.css" rel="stylesheet" type="text/css">
    <link href="CSS/friend.css" rel="stylesheet" type="text/css">
    <link href="CSS/search.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .s-space{
            margin: 50px;;
        }
    </style>
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
                        <a class="i-link" href="search.jsp" title="搜索"><span>搜索速配</span></a>
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
    <div class="security-top" style="height:30px;">
        <ul class="security-list">
            <li class="f-list" style="cursor: default;"><a href="#" class="first-level" style="color: #99a2aa;cursor: default;">好友列表</a>
            </li>
        </ul>
    </div>

    <div class="s-space">
        <div class="wrapper clearfix" id="page-fans">
            <div class="col-full">
                <div class="section fans" id="fans-list" page="fans">

                    <%
                        ArrayList al=(ArrayList)session.getAttribute("friendstable");
                        if(al.size()==0)
                        {
                            out.print("还没有好友哦，去加些好友再来吧~");
                        }
                        ArrayList a2=(ArrayList)session.getAttribute("mail");
                        Iterator iter1=al.iterator(); //迭代器iter


                        while(iter1.hasNext()){
                            User friend =(User)iter1.next();
                            int flag=1;
                            Iterator iter2=a2.iterator(); //迭代器iter
                            while(iter2.hasNext()){
                                flag=1;
                                Mail m=(Mail)iter2.next();
                                if(m.getSender()==friend.getId()&&m.getIfread()==0){ //0表示有未读消息
                                    flag=0;
                                    break;
                                }
                            }
                            if(flag==0)
                            {
                    %>
                    <style type="text/css">
                        .receive a{
                            color:red;
                        }
                    </style>
                    <div class="content">
                        <div class="list-item clearfix">
                            <img alt="nickname" src="<%=friend.getPhoto() %>" class="head_portrait">
                            <s:url var="url66" action="showfriendinfo">
                                <s:param name="friends.username" ><%=friend.getUsername() %></s:param>
                            </s:url>
                            <s:a href="%{url66}" class="title"><%=friend.getUsername() %>&nbsp;</s:a>

                            <span><%=friend.getGender() %>&nbsp;</span>
                            <div>
                                <div class="desc">个性签名：<%=friend.getMotto() %></div>
                                <s:url id="url" action="ShowMessage">
                                    <s:param name="friends.id"><%=friend.getId() %></s:param>
                                </s:url>
                                <div class="receive"><s:a href="%{url}">有新消息，点此查看</s:a></div>

                                <div>
                                    <s:url id="url2" action="deleteFriend">
                                        <s:param name="friends.id"><%=friend.getId() %></s:param>
                                    </s:url>
                                    <s:a href="%{url2}" onClick="delete_confirm()">删除该好友</s:a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <% }
                    else
                    {%>
                    <div class="content">
                        <div class="list-item clearfix">
                            <img alt="nickname" src="<%=friend.getPhoto() %>" class="head_portrait">
                            <a class="title" href="ShowUserInfo.jsp" target="_blank">
                                <span class="fans-name"><%=friend.getUsername() %>&nbsp;</span> </a>
                            <span><%=friend.getGender() %>&nbsp;</span>
                            <div>
                                <div class="desc">个性签名：<%=friend.getMotto() %></div>
                                <s:url id="url" action="ShowMessage">
                                    <s:param name="friends.id"><%=friend.getId() %></s:param>
                                </s:url>
                                <div><s:a href="%{url}">没有新消息，点此给他留言</s:a></div>

                                <div>
                                    <s:url id="url2" action="deleteFriend">
                                        <s:param name="friends.id"><%=friend.getId() %></s:param>
                                    </s:url>
                                    <s:a href="%{url2}" onClick="delete_confirm()">删除该好友</s:a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <% 	}
                    }

                    %>




                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        function delete_confirm() {
            event.returnValue = confirm("删除是不可恢复的，你确认要删除吗？");
        }

    </script>

</div>

<div class="footer">
    <div class="footer-wrp">
        <div class="footer-cnt clearfix">
            <em>@Java EE课程项目</em>
        </div>
    </div>
</div>




</body>
</html>
