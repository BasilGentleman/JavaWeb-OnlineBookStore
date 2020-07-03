<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<!--  导航栏  -->
    <jsp:include page="/public/jsp/navbar.jsp"></jsp:include>

	<div class="container ">
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<div class="panel panel-info" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>个人信息</b></div>
                 <div class="panel-body">
                    <div class="col-sm-2 border">
                      <a href="https://basil.gold"><img src="${pageContext.request.contextPath}/public/img/mao.png" width="220px" height="220px" alt=""></a>  
                    </div>
                    <div class="col-sm-10" style="margin-top: 3%;">
                    	 <form class="form-horizontal" action="/BookStore/updateInfo" method="post">
	                    	<div class="form-group">
	                                <label for="username" class="col-sm-3 control-label">用户名</label>
	                                <div class="col-sm-3">
	                                    <input type="text" class="form-control" id="usernam" name="username" placeholder="${user.getUsername() }" readonly="readonly" required autofocus>
	                                </div>
	                            </div>
                    		<div class="form-group">
	                                <label for="nickName" class="col-sm-3 control-label">昵称</label>
	                                <div class="col-sm-3">
	                                    <input type="text" class="form-control" id="nickname" name="name" placeholder="${user.getName() }" required autofocus>
	                                </div>
	                            </div>
                    		<div class="form-group">
	                                <label for="email" class="col-sm-3 control-label">邮箱</label>
	                                <div class="col-sm-3">
	                                    <input type="email" class="form-control" id="email" name="email" placeholder="${user.getEmail() }" readonly="readonly" required autofocus>
	                                </div>
	                            </div>
	                            
	                         <div class="form-group">
	                                <label for="sex" class="col-sm-3 control-label">性别</label>
	                                 <div class="col-sm-3"  style="margin-top: 4px">
	                                 			<input type="radio"  id="sex" name="sex" value="男" <c:if test="${user.getSex() =='男' }"> checked="checked"</c:if>  required autofocus /> 男
	                                    		<input type="radio"  id="sex" name="sex" value="女" <c:if test="${user.getSex() =='女' }"> checked="checked"</c:if> required autofocus /> 女
	                                </div>
	                            </div>
	                            
	                            
                          <div class="form-group">
                                <label for="phone" class="col-sm-3 control-label">手机号</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="phone" name="phone" placeholder="${user.getPhone() }"  required autofocus>
                                </div>
                            </div>
                            
                            
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-4">
                                    <button type="submit" class="btn  btn-primary">修改</button><span></span>
                                      <button type="reset" class="btn  btn-danger">重置</button>
                                      <button type="button" class="btn  btn-warning" onclick="update()">修改密码</button>
                                </div>
                            </div>
                    </form>
                    </div>
                </div>
			</div>
		</div>
	</div>
	<jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
function update() {
	window.open("${pageContext.request.contextPath}/public/jsp/update.jsp","更改密码","width=630px,height=300px,toolbar=no,resizable=no,top=350,left=500")
	
}

</script>
</html>