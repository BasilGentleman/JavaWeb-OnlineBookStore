<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${book.getName()}</title>
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
        <!-- 书籍详细信息 -->
        <div class="col-sm-12 col-md-12" style="margin-top: 10px;">
            <div class="row">
                <div class="col-sm-5">
                    <div class="thumbnail">
                      <%--   <img src="upload/${book.getImgUrlBig()}" alt="..."> --%>
                      <img alt="" src="${pageContext.request.contextPath}${book.getImgurl()}">
                    </div>
                </div>
                <div class="col-sm-7">
                    <blockquote>
                        <h4>${book.getName()}</h4>
                        <%-- <small><label class="label label-success">${book.getAuthor() }</label> 著</small> --%>
                    </blockquote>
                    <div class="well">
                     <div>现 价：
	                         	¥<span style="color: #c9302c;font-size: 20px" id="price">
									<fmt:formatNumber type="number" value=" ${book.getPrice()}" pattern="0.00" maxFractionDigits="2"/>
									</span>
							</div>
                       
                        <div>定 价：<s class="bg-danger"  >￥ ${book.price}</s></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            购买数量：
                            <div class="btn-group">
                                <button  class="btn btn-default disabled" onclick="reduce()"><i class="glyphicon glyphicon-arrow-down"></i></button>
                                <a class="btn btn-default disabled" id="amount">1</a>
                                <button  class="btn btn-default" onclick="add()"><i class="glyphicon glyphicon-arrow-up"></i></button>
                            </div>
                        </div>
                        <div class="col-sm-7" onclick="addCart()">
                            <a class="btn btn-danger"><i class="glyphicon glyphicon-shopping-cart"></i> 加入购物车</a>
                        </div>
                    </div>
                    <br>
                    温馨提示：支持7天无理由退货
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-12">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#intro" data-toggle="tab" aria-expanded="true">商品介绍</a></li>
                <li><a href="#evel" data-toggle="tab" aria-expanded="true">管理员评论</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane" id="evel">
                    <div class="col-sm-12">　</div>
                    <div class="col-sm-12">这书好，推荐看</div>
                </div>
                <div class="tab-pane fade active in" id="intro">
                    <div class="col-sm-12">　</div>
                    <div class="col-sm-3">出版社：未知</div>
                    <div class="col-sm-3">ISBN：未知</div>
                    <div class="col-sm-3">版次：未知</div>
                    <div class="col-sm-3">包装：平装</div>
                    <div class="col-sm-3">开本：16</div>
                    <div class="col-sm-3">开出版时间：未知</div>
                    <div class="col-sm-3">页数：未知</div>
                </div>
            </div>
        </div>
        
        <div class="col-sm-12 col-md-12">
            <div class="panel panel-info">
                <div class="panel-heading">编辑推荐</div>
                <div class="panel-body">
                    <p>超级畅销书全新升级，第1版两年内印刷近10次</p>
                    <p>${book.getDescription() }</p>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">内容简介</div>
                <div class="panel-body">
                    <p>${book.getDescription() }</p>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">作者简介</div>
                <div class="panel-body">
                    <p><b>神秘人</b>--这个人很懒什么都没留下。</p>
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-md-12">
		    <h4 class="text-danger">正品行货</h4>
		    	商城所售商品不提供发票
		    <h4 class="text-danger">全国联保</h4>
		    	商城所售商品均不享受全国联保
		    <hr>
		    注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
		</div>
    </div>
</div>
	
	 <jsp:include page="/public/jsp/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function addCart() {
		//获取数量
		var amount =$("#amount")[0].innerText;
		//获取单个金额
		var price =$("#price")[0].innerText;
		var money = amount*price;
		var id = ${book.id}
		/* //发起ajax请求
		$.ajax({
			url:"bookCart",
			data:{
				amount:amount,
				money:money,
				id:id
			},
			success:function(data) {
				 	 
				 location.href="${pageContext.request.contextPath}/client/jsp/cart.jsp";
				
			}
		}) */
		
		//转发
		location.href="bookCart?id="+id+"&amount="+amount+"&money="+money;
		
		
	}


</script>
</html>