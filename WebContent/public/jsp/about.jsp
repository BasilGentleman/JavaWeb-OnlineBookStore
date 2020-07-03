<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>关于</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
  <jsp:include page="/public/jsp/navbar.jsp"></jsp:include>
  <div class="container ">
  	<div class="row">
			<div class="col-sm-12 col-md-12">
				<div class="panel panel-info" style="margin-top: 10px">
					<div class="panel-body">
                    <div class="col-sm-2 border">
                      <a href="https://basil.gold"><img src="${pageContext.request.contextPath}/public/img/mao.png" width="220px" height="220px" alt=""></a>  
                    </div>
                    <div class="col-sm-10 " style="margin-top: 3%; text-align: center;">
                    	<p> A Chinese college student，live in Shanwei,China</p>
                    	<p> Email：<a href="mailto:basil1999@foxmail.com">basil1999@foxmail.com</a></p>
                    	<p> Blog：<a href="https://www.basil.gold">https://www.basil.gold</a></p>
                    </div>
				</div>
			</div>
		</div>
  
  </div>
  
  
  <jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>
</html>