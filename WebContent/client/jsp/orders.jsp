<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<body>
	<!--  导航栏  -->
    <jsp:include page="/public/jsp/navbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
        	<c:forEach items="${orders}" var="item">
				<div class="panel panel-info" style="margin-top: 10px">
			        <div class="panel-heading" role="tab" id="${item.getId()}">
			            <h4 class="panel-title">
			                <a role="button" data-toggle="collapse" href="#${order.getOrderId()}-item" aria-expanded="true" aria-controls="${item.getId()}-item"><b>下单时间：${item.getOrderTime() }</b></a>
			               <small> <a role="button" data-toggle="collapse" href="#${order.getOrderId()}-item" aria-expanded="true" aria-controls="${item.getId()}-item"><b>订单编号：${item.getOrder_id() }</b></a></small>
			            </h4>
			            
			        
			            
			        </div>
			        <div id="${item.getId()}-item" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="${item.getId()}" aria-expanded="true">
		            		<div class="table table-responsive">
			                    <table class="table table-striped">
			                        <thead>
			                        <tr>
			                            <th> </th>
			                            <th>商品</th>
			                            <th>单价（元）</th>
			                            <th>数量</th>
			                            <th>小计</th>
			                            <th>操作</th>
			                        </tr>
			                        </thead>
			                        <tbody>
										<c:forEach items="${item.getBook().getName()}" var="orderItem">
				                            <tr>
				                                <th align="left" style="line-height:80px;"> </th>
				                                <td align="left">
				                                    <img src="${pageContext.request.contextPath}${item.getBook().getImgurl()}" alt="">
				                                    <b>${item.getBook().getName()}</b>
				                                </td>
				                                <td align="left" style="line-height:80px;">${item.getBook().getPrice()*item.getNum()}</td>
				                                <td align="left" style="line-height:80px;">
				                                    <div class="btn-group">
				                                        <a href="#" class="btn btn-default btn-xs disabled">${item.getNum()}</a>
				                                    </div>
				                                </td>
				                                <td align="left" style="line-height:80px;">${item.getBook().getPrice()*item.getNum()}</td>
				                                 <td align="left" style="line-height:80px;"><a class="btn btn-danger btn-xs" href ="/BookStore/showOrders?action=delete&order_id=${item.getOrder_id()}">删除</a></td>
				                            </tr>
			                            </c:forEach>
			                        </tbody>
			                    </table>
			                    <div style="border-top:1px dashed #999;">
		                            <div class="col-sm-6" style="margin-top:2px;">
		                            	<c:choose>
			                            	<c:when test="${item.getState()eq 0}">
			                            		<div align="left" style="line-height:40px;"><a class="btn btn-danger btn-xs" href="#">待发货</a></div>
			                            	</c:when>
			                            	<c:otherwise>
			                            		<div align="left" style="line-height:40px;"><label class="label label-success">交易成功</label></div>
			                            	</c:otherwise>
			                            </c:choose>
		                            </div>
			                    </div>
		                    </div>
			        </div>
			    </div>
			</c:forEach>
        </div>
      
    </div>
</div>
 <jsp:include page="/public/jsp/footer.jsp"></jsp:include>

</body>
</html>