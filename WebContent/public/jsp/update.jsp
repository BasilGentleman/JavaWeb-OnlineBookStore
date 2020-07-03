<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>

<body>
<div align="center">
	<form class="form-horizontal" action="/BookStore/updatePassword" method="post">
      	<div class="form-group">
                  <label for="username" class="col-sm-3 control-label">用户名</label>
                  <div class="col-sm-3">
                      <input type="text" class="form-control" id="usernam" name="username" placeholder="${user.getUsername() }" readonly="readonly" required autofocus>
                  </div>
              </div>
     		<div class="form-group">
                  <label for="nickName" class="col-sm-3 control-label">原密码</label>
                  <div class="col-sm-3">
                      <input type="password" class="form-control" id="oldp" name="oldp" required autofocus>
                  </div>
              </div>
     		<div class="form-group">
                  <label for="email" class="col-sm-3 control-label">新密码</label>
                  <div class="col-sm-3">
                      <input type="password" class="form-control" id="newp" name="newp"required autofocus>
                  </div>
              </div>
             
             <div class="form-group">
                 <div class="col-sm-offset-3 col-sm-4">
                     <button type="submit" class="btn  btn-primary">修改</button><span></span>
                       <button type="reset" class="btn  btn-danger">重置</button>
                 </div>
             </div>
     </form>

</div>
</body>

</html>