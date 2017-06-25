<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"  %>
<%@ page import="model.*"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%User me=(User)session.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="CSS/info.css" rel=stylesheet type="text/css">
    <link href="CSS/base.css" rel="stylesheet" type="text/css">
    <link href="CSS/friend.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="CSS/chat.css" media="screen" type="text/css" />
    <link href="CSS/search.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .chat_receiver{
            float:right;
        }
        .chat_post{
            float:left;
        }
    </style>
    <title>Message</title>
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
    <div class="security-top">
        <ul class="security-list">
            <li class="f-list" style="cursor: default;"><a href="#" class="first-level" style="color: #99a2aa;cursor: default;">对话框</a>
            </li>
        </ul>
    </div>
    <div>
        <ul class="chat-thread">
            <!--对话部分-->
            <%
                ArrayList a1=(ArrayList)session.getAttribute("historymessage");
                User u=(User)session.getAttribute("user");
                User friend=(User)session.getAttribute("friend");
                int uid=u.getId();
                if(a1.size()==0)
                {
                    out.print("没有历史记录！");
                }
                else{
                    Iterator iter=a1.iterator(); //迭代器iter
                    while(iter.hasNext()){
                        Mail mail=(Mail)iter.next();
                        if(mail.getReceiver()==uid)
                        {
            %>

            <li class="chat_post">
                <br><%=friend.getUsername() %>:&nbsp;&nbsp;<%=mail.getTime() %>
                <br><%=mail.getMail() %>
            </li>


            <%
            }
            else if(mail.getSender()==uid)
            {
            %>

            <li class="chat_receiver">
                <br><%=u.getUsername() %>:&nbsp;&nbsp;<%=mail.getTime() %>
                <br><%=mail.getMail() %>
            </li>

            <%
                        }
                    }
                }
            %>
        </ul>
    </div>


    <div class="security-bottom">
        <ul class="security-list">
            <li class="f-list" style="cursor: default;">
                <a href="#" class="first-level" style="color: #99a2aa;cursor: default;">给他留个言吧</a>
            </li>
        </ul>
    </div>
    <form action="sendmessage" method="post" id="messageform">
        <div class="dialog">
            <textarea rows="8" cols="50" name="mail.mail" class="dialog"></textarea><br><br>
            <div class="dia-btn">
                <a href="" onclick="document.getElementById('messageform').submit();return false;">发送</a>
                <input type="reset" value="重置"><br><br>
            </div>

        </div>


    </form>
</div>


<div class="footer">
    <div class="footer-wrp">
        <div class="footer-cnt clearfix">
            <em>@Java EE课程项目</em>
        </div>
    </div>
</div>


</form>
</body>
</html>