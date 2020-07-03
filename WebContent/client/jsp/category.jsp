<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>类别</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<!--  导航栏  -->
    <jsp:include page="/public/jsp/navbar.jsp"></jsp:include>
    <div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
            <ol class="breadcrumb" style="margin-top: 10px;">
            	<c:forEach items="${categorys}" var="category">
            		<li><a href="/BookStore/category?category=${category}">${category}</a></li>
            	</c:forEach>
                
            </ol>
        </div>
        <div class="col-sm-12 col-md-12">
            <div class="col-sm-12 col-md-12">
        	<c:forEach items="${booklist}" var="book">
	            <div class="col-sm-3">
	                <div class="thumbnail">
	            <%--  <a href="item.do?bid=${book.getBid()}"><img src="${pageContext.request.contextPath}${book.imgurl}" alt="${book.name}"></a> --%>
	                    <a ><img src="${pageContext.request.contextPath}${book.imgurl}" alt="${book.name}" style="width: 200px; height: 200px;"></a>
	                    <div class="caption">
	                         <div>现 价：¥ 
	                         	<span style="color: #c9302c;font-size: 20px" id="price">
									<fmt:formatNumber type="number" value=" ${book.getPrice()}" pattern="0.00" maxFractionDigits="2"/>
									</span>
							</div>
                        	<div>定 价：<s class="bg-danger">￥ ${book.getPrice()}</s></div>
	                        <h5 style="color: gray;">已售：${book.sales }</h5>
<%-- 	                        <h4 style="color: #c9302c">¥${book.price * book.getDiscount() * 0.1}</h4> --%>
	                        <!-- <h6>已有评价 <label class="label label-info">9140个</label></h6> -->
	                      <%--   <h5><a href="item.do?bid=${book.getBid()}">${book.name}</a></h5> --%>
	                         <h5><a href="/BookStore/bookInfo?bookid=${book.id}">${book.name}</a></h5>
	                        <!-- <button class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-star-empty"></span>关注</button> -->
	                        <%-- <a href="cart.do?bid=${book.getBid()}" class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车</a><br> --%>
	                        <!-- <a  class="btn btn-default" style="color: #c9302c" onclick="addCart()"><span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车</a><br> -->
	                      <%--   <span>${book.getAuthor()}</span><br>
	                        <span>${book.getPublishing()}</span><br>
	                        <span>${book.getPublishTime()}</span> --%>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
    
    
    
     <jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>

</html>