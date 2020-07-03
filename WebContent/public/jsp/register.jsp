<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
</head>
</head>
<body>
<jsp:include page="/public/jsp/navbar.jsp"></jsp:include>

	<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
            <div class="panel panel-info" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>注册</b></div>
                <div class="panel-body">
                    <div class="col-sm-7">
                        <img src="${pageContext.request.contextPath}/public/img/login_baner.png" alt="">
                    </div>
                    <div class="col-sm-5" style="margin-top: 10%;">
                        <form class="form-horizontal" action="/BookStore/register" method="post">
                            <div class="form-group">
                                <label for="email" class="col-sm-3 control-label">邮箱</label>
                                
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="username" class="col-sm-3 control-label">用户名</label>
                                
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-sm-3 control-label">手机号</label>
                                
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="nickname" class="col-sm-3 control-label">昵称</label>
                                
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="nickname" name="nickname" placeholder="昵称" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-3 control-label">密码</label>

                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="密码" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="comfpassword" class="col-sm-3 control-label">确认密码</label>

                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="确认密码" required>
                                </div>
                            </div>
                            
                             <div class="form-group">
                                <label for="code" class="col-sm-3 control-label">验证码</label>

                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="checkCode" name="checkCode" placeholder="验证码" required>
                                </div>
                                <div class="col-sm-6">
                                	<a href="javascript:reloadCode();">
										<img alt="验证码" id="imagecode" src="<%= request.getContextPath()%>/imageServlet" />看不清楚，换一个</a>
                                </div>
                            </div>
                            
                            
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <label>已有帐号？<a href="login.jsp">立即登录</a></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <button type="submit" class="btn btn-lg btn-primary">立即注册</button>
                                    <button type="reset" class="btn btn-lg btn-primary" >重新填写</button>
                                </div>
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

	function reloadCode() {
		var time = new Date().getTime();
		document.getElementById("imagecode").src = "<%= request.getContextPath()%>/imageServlet?d=" + time;
	}

</script>

</html>