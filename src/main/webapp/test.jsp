<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'test.jsp' starting page</title>

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

</head>

<body>
<div class="z_top_container">
    <div class="z_top">
        <div class="z_header">
            <div class="z_top_nav">
                <ul>
                    <li class="home">
                        <a class="i-link" href="#" title="首页"><span>首页</span></a>
                    </li>

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
                        <a href="index.html" id="home" title="首页">
                            <i class="al-sy"></i>
                            <span>首<b class="nbsp"></b>页</span>
                        </a>
                    </li>

                    <li>
                        <a href="info.html" id="setting">
                            <i class="al-info"></i>
                            <span>我的信息</span>
                        </a>
                    </li>
                    <li>
                        <a href="protrait.html" id="face">
                            <i class="al-tx"></i>
                            <span>我的头像</span>
                        </a>
                    </li>


                </ul>
            </li>

        </ul>
    </div>


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
                                用户名：
                            </p>
                            <div class="sbi-m">

                            </div>

                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                真实姓名：
                            </p>
                            <div class="sbi-m">
                                <span></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                性别：
                            </p>
                            <div class="sbi-m">
                                <span></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                年龄：
                            </p>
                            <div class="sbi-m">
                                <span></span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                交友意向：
                            </p>
                            <div class="sbi-m">
                                <select name="user.sexlike" class="select">
                                    <option value="保密">保密</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                    <option value="男女均可">男女均可</option>
                                </select>
                            </div>
                        </div>
                    </li>


                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                个性签名：
                            </p>
                            <div class="sbi-m">
                                <textarea name="sign user.motto" id="" cols="30" rows="10" class="my-sign"></textarea>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                恋人画相：
                            </p>
                            <div class="sbi-m">
                                <textarea name="sign user.requirement"  cols="30" rows="10" class="my-sign"></textarea>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                电话：
                            </p>
                            <div class="sbi-m">
                                <input name="sign user.requirement"  class="my-sign" value=""/>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                电话：
                            </p>
                            <input type="hidden" name="gender" id="select_sex" value="保密" />
                            <div class="sbi-m">
                                <ul class="sex" id="sex_ul">
                                    <li class="blue" data-sex="男">男</li>
                                    <li data-sex="女">女</li>
                                    <li data-sex="保密">保密</li>
                                </ul>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                交友目的：
                            </p>
                            <div class="sbi-m">
                                <div class="control-btn-select">
                                    <span>--请选择--</span><em></em>
                                    <select name='datingtype' id='datingtype' class='enumselect'>
                                        <option value='0' selected='selected'>--请选择--</option>
                                        <option value='1'>网友</option>
                                        <option value='2'>恋人</option>
                                        <option value='3'>玩伴</option>
                                        <option value='4'>共同兴趣</option>
                                        <option value='5'>男性朋友</option>
                                        <option value='6'>女性朋友</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="sb-info">
                            <p class="sbi-l">
                                爱好：
                            </p>
                            <div class="sbi-m">
                                <div class="control-btn-select">
                                    <span>--请选择--</span><em></em>
                                    <select name='marital' id='marital' class='enumselect'>
                                        <option value='0' selected='selected'>--请选择--</option>
                                        <option value='1'>未婚</option>
                                        <option value='2'>已婚</option>
                                        <option value='3'>离异</option>
                                        <option value='4'>丧偶</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="sb-line">
            </div>
            <a action-type="btn_submit" class="W_btn_big" suda-uatrack="key=tblog_register_page&value=register_now_button" href="javascript:void(0);" refake-type="submit" node-type="btn_submit" onclick="document.getElementById('submitform').submit();return false"><span>提交</span></a>

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
