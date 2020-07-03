
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索 - ${parameter}</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
</head>
<body>	

<!--  导航栏  -->
    <jsp:include page="/public/jsp/navbar.jsp"></jsp:include>
	<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
            <ol class="breadcrumb" style="margin-top: 10px;">
                <li><a href="#">${parameter}</a></li>
            </ol>
        </div>
        <div class="col-sm-12 col-md-12">
            <div class="panel panel-success">
                <div class="panel-heading">　</div>
                <!-- <div class="panel-body">
                    <div class="bs-callout bs-callout-info" id="callout-scrollspy-needs-nav"></div>
                </div> -->
                <div class="table table-responsive">
                    <table class="table table-striped table-condensed">
                    
                        <tr>
                            <th><label class="label label-success">出版社：</label></th>
                            <c:forEach items="${publishs}" var="publish">
                            	<td align="left"><label class="control-label"><a href="#">${publish}</a></label></td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th><label class="label label-success">价格：</label></th>
                            <c:forEach items="${priceRanges}" var="priceRange">
                            	<td align="left"><label class="control-label"><a href="#">${priceRange}</a></label></td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th><label class="label label-success">折扣：</label></th>
                            <c:forEach items="${discounts}" var="discount">
                            	<td align="left"><label class="control-label"><a href="#">${discount}</a></label></td>
                            </c:forEach>
                            <td align="left" colspan="2"></td>
                        </tr>
                    </table>
                    <div style="text-align:center;margin-right:10px;border-top:1px dashed  #999;line-height:30px;">
                        <div class="text-warning">对书籍进行进一步筛选</div>
                    </div> 
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-12">
        	<c:forEach items="${booklist}" var="book">
	            <div class="col-sm-3">
	                <div class="thumbnail">
	            <%--  <a href="item.do?bid=${book.getBid()}"><img src="${pageContext.request.contextPath}${book.imgurl}" alt="${book.name}"></a> --%>
	                    <a ><img src="${pageContext.request.contextPath}${book.imgurl}" alt="${book.name}" style="width: 200px; height: 200px;"></a>
	                    <div class="caption">
	                        <h4 style="color: #c9302c">¥${book.price}</h4> 
	                        <h5 style="color: gray;">已售：${book.sales }</h5>
<%-- 	                        <h4 style="color: #c9302c">¥${book.price * book.getDiscount() * 0.1}</h4> --%>
	                        <!-- <h6>已有评价 <label class="label label-info">9140个</label></h6> -->
	                      <%--   <h5><a href="item.do?bid=${book.getBid()}">${book.name}</a></h5> --%>
	                        <h5><a href="/BookStore/bookInfo?bookid=${book.id}">${book.name}</a></h5>
	                        <!-- <button class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-star-empty"></span>关注</button> -->
	                        <%-- <a href="cart.do?bid=${book.getBid()}" class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车</a><br> --%>
	                      <!--   <a  class="btn btn-default" style="color: #c9302c"><span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车</a><br> -->
	                      <%--   <span>${book.getAuthor()}</span><br>
	                        <span>${book.getPublishing()}</span><br>
	                        <span>${book.getPublishTime()}</span> --%>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
        </div>

        
        
      <!--   <div class="col-sm-offset-4 col-sm-6">
            <ul class="pagination pagination-sm">
                <li class="first disabled"><a href="/BookStore/search?id=0"><span class="glyphicon glyphicon-step-backward"></span>首页</a></li>
                <li class="prev disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span> 上一页</a></li>
                <li class="active"><a href="/BookStore/search?id=1">1</a></li>
                <li><a href="/BookStore/search?id=2">2</a></li>
                <li><a href="/BookStore/search?id=3">3</a></li>
                <li><a href="/BookStore/search?id=4">4</a></li>
                <li><a href="/BookStore/search?id=5">5</a></li>
                <li class="next"><a href="/BookStore/search?id=">下一页 <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                <li class="last"><a href="#">尾页 <span class="glyphicon glyphicon-step-forward"></span></a></li>
            </ul>
        </div> -->
        
    </div>
</div>
<a class="btn btn-default" href="#" role="button" style="position:fixed;right:0;bottom:0">
回到顶部
</a>
<jsp:include page="/public/jsp/footer.jsp" />

</body>
</html>