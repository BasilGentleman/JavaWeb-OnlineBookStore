<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<div class="navbar navbar-default " rel="stylesheett">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand " href="#">网上书城</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav" id="mytab">
                    <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
                    <li><a href="#">推荐</a></li>
                    <li><a href="/BookStore/category">分类</a></li>
                    <li><a href="${pageContext.request.contextPath}/public/jsp/about.jsp">关于</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                	<c:if test="${empty user }">
                	<%-- 	<a href="${pageContext.request.contextPath}/public/jsp/login.jsp" type="button" class="btn btn-default">登录</a> --%>
                		<a href="/BookStore/login" type="button" class="btn btn-default">登录</a>
                   		<a href="${pageContext.request.contextPath}/public/jsp/register.jsp" type="button" class="btn btn-default" >注册</a>
                	</c:if>
                    <c:if test="${!empty user }">
                    	<a href="${pageContext.request.contextPath}/client/jsp/user.jsp"role="button" class="glyphicon glyphicon-user ">${user.getUsername()}</a>
						<a href="/BookStore/showShopCart" class="glyphicon glyphicon-shopping-cart">我的购物车</a>
						<a href="/BookStore/showOrders" class="glyphicon glyphicon-bookmark">我的订单</a>
						<a href="/BookStore/loginOut" class="glyphicon glyphicon-log-out">退出</a>
				
                    </c:if>
                </form>
                <form class="navbar-form navbar-right" role="search" action="/BookStore/search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="请输入书名" name="book_name" />
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>

            </div>
        </div>

    </div>
</body>
</html>