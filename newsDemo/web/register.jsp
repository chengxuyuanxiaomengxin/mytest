<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript"></script>
     <script language="javascript">
            function check(){
            //alert("进入验证方法check()");
            //获取表单中账号username的指
            var id_username = document.getElementById("id_username").value;
            //获取表单中密码pwd的数据
            var id_upwd = document.getElementById("id_upwd").value;
            if (id_username==null || id_username==""){//判定数据是否为空
            //提示账号为空，返回注册
            //alert("账号为空,请返回重新注册");
            document.getElementById("usernameError").innerHTML="账号不能为空";
            document.getElementById("id_username").focus();
            return false;
        }
            if (id_upwd==null || id_upwd==""){
            //alert("密码为空，返回重新注册");
            document.getElementById("upwdError").innerHTML="密码不能为空";
            document.getElementById("id_upwd").focus();

            return false;
        }
            alert("通过空值验证")
            return true;
        }
            function jqueryCheck(){
            var id_username= $("#id_username").val();
            var id_upwd= $("#id_upwd").val();
            if (id_username == "" || id_username== null){
                $("#usernameError").html("账号不能为空");
                $("#upwdError").html("");
                $("#id_username").focus();//聚焦到此控件

                return false;
            }if (id_upwd == "" || id_upwd== null){
                $("#usernameError").html("");
                $("#upwdError").html("密码不能为空");

                $("#id_upwd").focus();//聚焦到此控件
                return false;
            }
            alert("空值校验通过");
            return true;

        }

        function focusOnLogin(){
            // var login_username = document.getElementById("username");
            // login_username.focus();
            $("#id_username").focus();

        }
        var xhr;//声明XMLHttpRequest对象变量
        function createXHR(){
            try{
                return  new XMLHttpRequest();
            }catch (e) {
                return new ActiveXObject("Microsoft.XMLHTTP")
            }
        }

        function checkRegName(regName){


            $.ajax({


                url: "CheckRegNameServlet",//servlet的url地址
                type: "get",//提交/访问servlet的方式
                data: {regName},//传入servlet
                dataType:"text",
                success:function (data){//servlet成功返回值data
                    if (data==0){//返回值结果若为0，则无此用户，提示可以注册

                       // alert("callback()---0");
                        document.getElementById("loginNameCheck").innerHTML
                            = "<font style='color: green'>用户名可以注册(jquery的)</font>";
                        //document.getElementById("regBtn").disabled = false;//注册按钮可用
                        $("#regBtn").attr("disabled",false);//按钮可用
                       // document.getElementById("regForm").style.visibility="hidden";
                    } else if (data == 1) {
                        //alert("callback()---1");
                        document.getElementById("loginNameCheck").innerHTML
                            = "<font style='color: red'>用户名已经存在</font>";
                        //document.getElementById("regBtn").disabled = true;//注册按钮不可用
                        $("#regBtn").attr("disabled",true);//按钮不可用
                    }else {
                        alert("数据有误！");
                    }
                }
            })



           /** // alert("进入checkRegName()")
            xhr = createXHR();//xhr赋值
            xhr.onreadystatechange = callback;//当xhr状态改变，调用回调函数callback
            //查询数据库，获取结果。用到open()方法
            xhr.open("get","CheckRegNameServlet?regName="+regName,true);
            //发送给后台，让后台执行
            xhr.send(null);*/


         /*   $.get(
                "CheckRegNameServlet",
                {regName},
                function (data) {
                    if (data == 0) {
                        alert("callback()---0");
                        document.getElementById("loginNameCheck").innerHTML
                            = "<font style='color: green'>用户名可以注册</font>";
                        document.getElementById("regBtn").disabled = false;
                    } else if (data == 1) {
                        alert("callback()---1");
                        document.getElementById("loginNameCheck").innerHTML
                            = "<font style='color: red'>用户名已经存在</font>";
                        document.getElementById("regBtn").disabled = true;
                    }else {
                        alert("数据有误！");
                    }
                }
            )*/



        //     function callback(){
        //     if (xhr.readyState==4 && xhr.status==200){
        //         var res = xhr.responseText;
        //         if (res == 0){
        //             alert("callback()---0");
        //             document.getElementById("loginNameCheck").
        //                 innerHtml="<font style='color: green'>用户名可以注册</font>";
        //             document.getElementById("regBtn").disabled=false;
        //         }else {
        //             document.getElementById("loginNameCheck").
        //                 innerHtml="<font style='color: red'>用户名已经存在</font>";
        //             document.getElementById('regBtn').disabled=true;
        //
        //         }
        //     }
        // }


        function callback() {//回调函数，获取servlet的返回值，根据返回值进行页面的异步更新
            if (xhr.readyState == 4 && xhr.status == 200) {//是否执行成功
                var res = xhr.responseText;//获取open方法中servlet的返回值
                // xhr.responseXML
                // xhr.responseURL
                // xhr.JSON.
                if (res == 0) {//
                    document.getElementById("loginNameCheck").innerHTML
                        = "<font style='color: green'>用户名可以注册</font>";
                    document.getElementById("regBtn").disabled = false;
                } else {
                    document.getElementById("loginNameCheck").innerHTML
                        = "<font style='color: red'>用户名已经存在</font>";
                    document.getElementById("regBtn").disabled = true;
                }
            }
            }
        }
    </script>
</head>
<body onload="focusOnLogin()">
<div id="header">

    <div id="nav">
        <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
        <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
        <!--mainnav end-->
    </div>
</div>
<div id="container">
    <div class="main">
        <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
        <div class="content">
            <form action="RegisterServlet" method="post" onsubmit="return jqueryCheck()">
                <label> 用户名 </label>
                <input onblur="checkRegName(this.value)" id="id_username" name="username" placeholder="请输入账号" class="login_input" />
                <span id="loginNameCheck"></span>
                <label id="usernameError"style="color: aqua"> </label>
                <br><br><label> 密&#160;&#160;&#160;码 </label>
                <input type="password" id="id_upwd" name="upwd" placeholder="请输入密码" class="login_input" />
                <label id="upwdError" style="color: aqua"> </label>
                <br><br><input type="submit" class="login_sub" value="注册" id="regBtn"/>
                <input type="button" class="login_sub" value="返回" onclick="javascrtpt:window.location.href='index.jsp'" />
            </form>
        </div>
        <%--        <%@include file="index-elements/index_rightbar.html"%>--%>
    </div>
</div>
<%@include file="index-elements/index_bottom.html"%>
</body>
</html>
