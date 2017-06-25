<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%User me=(User)session.getAttribute("user");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'changeuserinfo.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="CSS/info.css" rel=stylesheet type="text/css">
    <link href="CSS/base.css" rel="stylesheet" type="text/css">



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
    <style type="text/css">
        .security-right {
            min-height: 832px!important;
        }

        .security-list li a {
            background-position: -87px -975px;
        }

        .security-list li a {
            background-position: -87px -1231px;
        }

    </style>
    <div class="security-left">
        <ul class="security-list">
            <li class="f-list" style="cursor: default;"><a href="#" class="first-level" style="color: #99a2aa;cursor: default;">个人中心</a>
                <ul class="child-list">
                    <li>
                        <a href="shownews" id="home" title="首页">
                            <i class="al-sy"></i>
                            <span>我的动态</span>
                        </a>
                    </li>

                    <li>
                        <a href="ShowUserInfo.jsp" id="setting">
                            <i class="al-info"></i>
                            <span>我的信息</span>
                        </a>
                    </li>
                    <li>
                        <a href="showfnews" id="setting">
                            <i class="al-info"></i>
                            <span>好友动态</span>
                        </a>
                    </li>


                </ul>
            </li>

        </ul>
    </div>


    <%User user1=(User)session.getAttribute("user"); %>
    <form action="changeuserinfo" method="post" id="submitform" enctype="multipart/form-data">
        <div class="security-right">

            <div class="sr-t">
                <span class="tit-b"></span><span class="acc-sec">我的信息</span>
            </div>
            <div class="sr-b">
                <ul>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                交友意向：
                            </p>
                            <div class="sbi-m">
                                <div class="">

                                    <select name="user.sexlike" >
                                        <option value='保密'>保密</option>
                                        <option value='男'>男</option>
                                        <option value='女'>女</option>
                                        <option value='男女均可'>男女均可</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>


                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                个性签名：
                            </p>
                            <div class="sbi-m">
                                <textarea name="user.motto" id="" height="20px" cols="30" rows="10" class="my-sign"><%=user1.getMotto()%></textarea>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                恋人画相：
                            </p>
                            <div class="sbi-m">
                                <textarea name="user.requirement"  cols="20" rows="10" class="my-sign"><%=user1.getRequirement() %></textarea>
                            </div>

                        </div>
                    </li>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                头像：
                            </p>
                            <div class="">
                                <input type="file" name="upload" />
                            </div>
                        </div>
                    </li>


                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                电话：
                            </p>
                            <div class="sbi-m">
                                <input name="user.phone"  class="my-sign" value="<%=user1.getPhone() %>"/>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                QQ：
                            </p>
                            <div class="sbi-m">
                                <input name="user.qq"  class="my-sign" value="<%=user1.getQq() %>"/>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                个人标签：
                            </p>
                            <div>
                                文学青年
                                <input name="user.label1" type="radio" value="1" checked/>是 
                                <input name="user.label1" type="radio" value="0"/>否
                            </div>
                            <div class="sbi-a">
                                影视音乐
                                <input name="user.label2" type="radio" value="1" checked/>是 
                                <input name="user.label2" type="radio" value="0"/>否
                            </div>
                            <div class="sbi-a">
                                体育健身
                                <input name="user.label3" type="radio" value="1" checked/>是 
                                <input name="user.label3" type="radio" value="0"/>否
                            </div>
                            <div class="sbi-a">
                                游戏娱乐
                                <input name="user.label4" type="radio" value="1" checked/>是 
                                <input name="user.label4" type="radio" value="0"/>否 
                            </div>
                            <div class="sbi-a">
                                美食专家
                                <input name="user.label5" type="radio" value="1" checked/>是 
                                <input name="user.label5" type="radio" value="0"/>否
                            </div>
                            <div class="sbi-a">
                                二 次 元
                                <input name="user.label6" type="radio" value="1" checked/>是 
                                <input name="user.label6" type="radio" value="0"/>否
                            </div>
                            <div class="sbi-a">
                                学霸无双
                                <input name="user.label7" type="radio" value="1" checked/>是 
                                <input name="user.label7" type="radio" value="0"/>否
                            </div>
                        </div>


                    </li>
                </ul>
            </div>



            <input type="submit" class="sb-save" value="保存" style="position: absolute;bottom:80px;display: block;">
        </div>
    </form>
</div>
<script type="text/javascript">
    /*打开页面时，性别默认值为保密*/
    seajs.use("site-setting", function() {
        window.rec_rp = window.rec_rp || function() {
                (rec_rp.q = rec_rp.q || []).push(arguments)
            };
        $.getScript('//data.bilibili.com/rec.js', function() {
            rec_rp("event", "setting_index_show", true);
            $('[rec-linkid]').on('click', function() {
                var id = $(this).attr('rec-linkid');
                rec_rp('event', id);
            });
        });
    });

</script>

<div class="footer">
    <div class="footer-wrp">
        <div class="footer-cnt clearfix">
            <em>@Java EE课程项目</em>
        </div>
    </div>
</div>




</body>
</html>
