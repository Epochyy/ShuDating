<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="http://img.t.sinajs.cn/t5/style/css/module/base/frame.css?version=a05309c5d15974a8" type="text/css" rel="stylesheet" />
    <link href="http://img.t.sinajs.cn/t5/style/css/module/layer/layer_login_v5.css?version=a05309c5d15974a8" type="text/css" rel="stylesheet" />
    <script src="js/jquery-3.2.0.min.js"></script>
    <link href="CSS/style.css" type="text/css" rel="stylesheet">

    <script src="js/reg.js" type="text/javascript"></script>
    <script src="js/gVerify.js" type="text/javascript"></script>
    <script type="text/javascript">
        var $CONFIG = {};
        $CONFIG['lang'] = "zh-cn";

    </script>

    <!--/注册登录header-->
    <title>注册</title>
</head>

<body class="B_register B_reg_tel ">

<div class="W_nologin">
    <div class="W_header_line"></div>
    <div class="W_nologin_logo_big"></div>
    <!--图标-->
    <div class="W_nologin_main main_radius_bg">
        <div class="main_tab_line">
            <a class="W_f22 W_Yahei cur" href="javascript:void(0);">个人注册</a>
        </div>
        <form action="register" method="post" id="registerform" enctype="multipart/form-data">
            <div class="W_reg_info clearfix" id="pl_account_regmobile">
                <div class="W_reg_form">
                    <div class="info_list clearfix" node-type="mobilesea_wrapper">
                        <div class="tit">
                            <i>*</i>用户名：
                        </div>
                        <div class="inp">
                            <div class="flag_tel clearfix">

                                <input type="text" name="user.username" class="W_input reg_user" value="" autocomplete="on" placeholder="4-8位用户名" maxlength="8">
                                <span class="user_hint"></span>
                            </div>

                        </div>
                        <div class="tips" node-type="mobilesea_tip">
                        </div>
                    </div>

                    <div class="info_list clearfix">
                        <div class="tit">
                            <i>*</i>设置密码：
                        </div>
                        <div class="inp">
                            <input  action-type="text_copy" name="user.password" placeholder="6-16位密码" type="password" class="W_input reg_password" value="" />
                            <span class="password_hint"></span>
                        </div>
                        <div node-type="password_tip" class="tips">
                        </div>
                    </div>
                    <div class="info_list clearfix">
                        <div class="tit">
                            <i>*</i>确认密码：
                        </div>
                        <div class="inp">
                            <input  action-type="text_copy"  type="password" class="W_input reg_confirm" value="" />
                            <span class="confirm_hint"></span>
                        </div>
                        <div node-type="password_tip" class="tips">
                        </div>
                    </div>
                    <div class="info_list clearfix">
                        <div class="tit">
                            <i>*</i>真实姓名：
                        </div>
                        <div class="inp">
                            <input action-data="" action-type="text_copy" name="user.realname" type="text" class="W_input" value="" />
                        </div>
                        <div node-type="rname_tip" class="tips">
                        </div>
                    </div>
                    <div class="info_list clearfix">
                        <div class="tit">
                            <i>*</i>年龄：
                        </div>
                        <div class="inp">
                            <input action-data="" action-type="text_copy" name="user.age" type="text" class="W_input" value="" />
                        </div>
                        <div node-type="rname_tip" class="tips">
                        </div>
                    </div>
                    <div class="info_list clearfix">
                        <div class="tit"><i>*</i>性别：</div>
                        <div class="inp choose">
                            <select name="user.gender" class="select">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="info_list clearfix">
                        <div class="tit"><i>*</i>性取向/交友意向：</div>
                        <div class="inp choose">
                            <select name="user.sexlike" class="select">
                                <option value="保密">保密</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                                <option value="男女均可">男女均可</option>
                            </select>
                        </div>
                    </div>
                    <div class="info_list clearfix">
                        <div class="tit">
                            联系方式：
                        </div>
                        <div class="inp">
                            <div class="flag_tel clearfix">
                                <input type="hidden" name="zone" value="" node-type="mobilesea_selectvalue" />
                                <div class="W_input foreign_tel"><span class="tel_forenum" node-type="mobilesea_txt">0086</span>
                                    <input type="text" node-type="newmobilesea" placeholder="手机号" action-type="text_copy" name="user.phone" class="tel_num reg_mobile" value="" autocomplete="off">

                                </div>
                            </div>
                            <div class="mobile_hint"></div>
                        </div>

                    </div>




                    <div class="info_list clearfix">
                        <div class="info_submit clearfix">
                            <div class="inp">

                                <a action-type="btn_submit" class="W_btn_big red_button" suda-uatrack="key=tblog_register_page&value=register_now_button" href="javascript:void(0);" refake-type="submit" node-type="btn_submit" onclick="document.getElementById('registerform').submit();return false"><span>注册</span></a>

                            </div>
                        </div>
                    </div>



                    <meta name="keywords" content="">
                    <meta name="description" content="">
                    <style type="text/css">


                    </style>



                    <div class="con4">
                        <canvas id="cvs" width="150" height="150"></canvas>

                        <div class="#">
                            <a class="W_btn_upload" href="javascript:void(0);">
                                <span class="btn upload">上传头像<input type="file" name="upload" class="upload_pic" id="upload" /></span></a>
                        </div>

                    </div>

                    <script>
                        //获取上传按钮
                        var input1 = document.getElementById("upload");

                        if (typeof FileReader === 'undefined') {
                            //result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
                            input1.setAttribute('disabled', 'disabled');
                        } else {
                            input1.addEventListener('change', readFile, false);
                            /*input1.addEventListener('change',function (e){
                             console.log(this.files);//上传的文件列表
                             },false); */
                        }

                        function readFile() {
                            var file = this.files[0]; //获取上传文件列表中第一个文件
                            if (!/image\/\w+/.test(file.type)) {
                                //图片文件的type值为image/png或image/jpg
                                alert("文件必须为图片！");
                                return false;
                            }
                            // console.log(file);
                            var reader = new FileReader(); //实例一个文件对象
                            reader.readAsDataURL(file); //把上传的文件转换成url
                            //当文件读取成功便可以调取上传的接口
                            reader.onload = function(e) {
                                // console.log(this.result);//文件路径
                                // console.log(e.target.result);//文件路径
                                /*var data = e.target.result.split(',');
                                 var tp = (file.type == 'image/png')? 'png': 'jpg';
                                 var imgUrl = data[1];//图片的url，去掉(data:image/png;base64,)
                                 //需要上传到服务器的在这里可以进行ajax请求
                                 // console.log(imgUrl);
                                 // 创建一个 Image 对象
                                 var image = new Image();
                                 // 创建一个 Image 对象
                                 // image.src = imgUrl;
                                 image.src = e.target.result;
                                 image.onload = function(){
                                 document.body.appendChild(image);
                                 }*/

                                var image = new Image();
                                // 设置src属性
                                image.src = e.target.result;
                                var max = 200;
                                // 绑定load事件处理器，加载完成后执行，避免同步问题
                                image.onload = function() {
                                    // 获取 canvas DOM 对象
                                    var canvas = document.getElementById("cvs");
                                    // 如果高度超标 宽度等比例缩放 *=
                                    /*if(image.height > max) {
                                     image.width *= max / image.height;
                                     image.height = max;
                                     } */
                                    // 获取 canvas的 2d 环境对象,
                                    var ctx = canvas.getContext("2d");
                                    // canvas清屏
                                    ctx.clearRect(0, 0, canvas.width, canvas.height);
                                    // 重置canvas宽高
                                    /*canvas.width = image.width;
                                     canvas.height = image.height;
                                     if (canvas.width>max) {canvas.width = max;}*/
                                    // 将图像绘制到canvas上
                                    // ctx.drawImage(image, 0, 0, image.width, image.height);
                                    ctx.drawImage(image, 0, 0, 200, 200);
                                    // 注意，此时image没有加入到dom之中
                                };
                            }
                        };

                    </script>

                    <div class="W_reg_sidebar">
                        <p class="p1 line">
                            已有帐号，<a href="Login.jsp">直接登录»</a>
                        </p>

                    </div>
                </div>
            </div>
        </form>

        <script src="js/JavaScript.js"></script>

    </div>
    <!--注册登录footer-->
    <div class="nologin_footer clearfix">
        <div class="left_link">
            <em class="company_name">@夏季课程项目</em>
        </div>
        <!-- SUDA_CODE_START -->
        <noscript>
            <img width="0" height="0" src="http://beacon.sina.com.cn/a.gif?noScript" border="0" alt=""/>
        </noscript>

        <script type='text/javascript' charset="utf-8">
            (function() {
                var doc = document,
                    wa = doc.createElement('script'),
                    s = doc.getElementsByTagName('script')[0];
                wa.type = 'text/javascript';
                wa.charset = 'utf-8';
                wa.async = true;
                wa.src = 'http://js.t.sinajs.cn/open/analytics/js/suda.js?version=a05309c5d15974a8';
                s.parentNode.insertBefore(wa, s);
            })();

        </script>
        <!-- SUDA_CODE_END -->
        <!--/注册登录footer-->
    </div>

</body>
</html>
