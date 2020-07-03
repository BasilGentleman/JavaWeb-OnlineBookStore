<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>确认订单</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/public/img/mao.png" type="image/x-icon" />
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/cart.js"></script>
</head>
<body>
<!--  导航栏  -->
    <jsp:include page="/public/jsp/navbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12">
            <div class="panel panel-success" style="margin-top: 10px">
                <div class="panel-heading text-center"><b>确认订单</b></div>
                <div class="panel-body">
                    <div class="bs-callout bs-callout-info" id="callout-scrollspy-needs-nav"></div>
                </div>
                <div class="table table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>商品</th>
                            <th>单价（元）</th>
                            <th>数量</th>
                            <th>小计</th>
                        </tr>
                        </thead>
                        <tbody>
						<c:forEach items="${userCart}" var="item"> 
	                            <tr>
	                                <td align="left">
	                                     <img src="${pageContext.request.contextPath}${item.value.getBook().getImgurl()}" alt="">
	                                    <b>${item.value.getBook().getName()}</b> 
	                                </td>
	                                <td align="left" style="line-height:80px;">￥${item.value.getBook().getPrice() }</td>
	                                <td align="left" style="line-height:80px;">
	                                    <div class="btn-group">
	                                        <a href="#" class="btn btn-default btn-xs disabled">${item.value.getAmount()}</a>
	                                    </div>
	                                </td>
	                                <td align="left" style="line-height:80px;">
	                                	<fmt:formatNumber type="number" value=" ${item.value.getMoney() }" pattern="0.00" maxFractionDigits="2"/>
	                                </td>
	                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div style="border-top:1px dashed #999;">
                         <div class="input-group input-group-sm">
     				       <span class="input-group-addon" >收货人</span>
            						<input type="text" id="receiveName" class="form-control" placeholder="收货人姓名">
        					</div>
 							<div class="input-group input-group-sm">
     				       		<span class="input-group-addon" >手机号</span>
            						<input type="text"  id="receivePhone" class="form-control" placeholder="收货人手机号">
        					</div>
        					<div class="input-group input-group-sm">
     				       		<span class="input-group-addon" >收货地址</span>
            						<input type="text"  id="receiveAddr" class="form-control" placeholder="收货人地址">
        					</div>
                     </div>
                    <div style="border-top:1px dashed #999;">
                        <div style="line-height: 45px;">
                        	<c:if test="${!empty userCart }">
	                            <div class="col-sm-5">
	                                <a href="#"> </a>
	                            </div>
	                            <div class="col-sm-5">
	                                <div class="col-sm-6">
	                                    已选择<b class="text-danger">${totalAmount}</b>件商品
	                                </div>
	                                <div class="col-sm-6">
	                                    总价（不含运费）：<b class="text-danger">${totalMoeny }</b>
	                                </div>
	                            </div>
	                            <div class="col-sm-2" onclick="confirm()">
	                                <a href="#" type="submit" class="btn btn-danger btn-lg btn-block">确认订单</a>
	                            </div>
                        	</c:if>
                        </div>
                    </div>
                </div>
            </div>
         
        </div>
   
    </div>
</div>

<jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function confirm(){
		var receiveName = $("#receiveName")[0].value
		var receivePhone = $("#receivePhone")[0].value
		var receiveAddr = $("#receiveAddr")[0].value
		//转发
		location.href="/BookStore/order?receiveName="+receiveName+"&receivePhone="+receivePhone+"&receiveAddr="+receiveAddr;
		
	}

</script>
</html>