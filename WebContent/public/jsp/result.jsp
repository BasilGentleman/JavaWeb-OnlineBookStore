<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>结果页</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
</head>
<body>
<jsp:include page="/public/jsp/navbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
	        <div class="panel panel-info" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>${msg}</b></div>
                <div class="panel-body">
		        	<div class="col-sm-offset-3 col-sm-6">
		        		<%-- <img src='img/${imgStyle}.png' height='50%' width='70%'> --%>
		        		<%-- <p><label class="label label-${level}" style="margin-left: 110px;">${operate}</label></p> --%>
		        		<a href="#" class="btn btn-info" style="margin-left: 110px;">${msg}</a>
		        	</div>
	        	</div>
        	</div>
        </div>
    </div>
</div>
	
	<jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>
</html>