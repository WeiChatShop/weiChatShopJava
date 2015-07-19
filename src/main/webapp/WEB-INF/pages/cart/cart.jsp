<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>购物车</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
	<link rel="stylesheet" tylie="text/css" href="../../../style/reset.css?t=57">
	<link rel="stylesheet" tylie="text/css" href="../../../style/pay.css?t=57">
</head>
<body>
	<%@include file="../commons/common.jsp" %>
	<%@include file="../commons/header.jsp" %>
	<!-- 商品详情开始 -->
	<div class="goods" style="margin-top: 80px"></div>
	<!-- 商品详情结束 -->
	<script>
		$(function(){
			$.ajax({
				url: "/getCartData",
				dataType: 'json',
				type:"post",
				success: function (data) {
					if(data!=null){
						var html = "";
						for(var i=0;i<data.data.length;i++){
							var cart = data.data[i];
						 html += '<div class="goodDetailWrap clearfix" >'+
						 	'<div class="imgWrap fl"> '+
								'			<a href="/pay/'+cart.id+'"><img src="../'+cart.path+'"></a>                                       '+
								'		</div>                                                                '+
								'		<div class="desc">                                                    '+
								'			<div class="descPrice">                                           '+
								'				<!-- 商品名称开始 -->                                         '+
								'						<span class="title" style="color:#000">               '+
														cart.name+
								'						</span>                                               '+
								'				<!-- 商品名称结束 -->                                         '+
								'				<!-- 商品价格开始 -->                                         '+
								'						<span class="price">                                  '+
														'￥'+cart.price                                   +
								'						</span>                                               '+
								'				<!-- 商品价格结束 -->                                         '+
								'			</div>                                                            '+
								'                                                                             '+
								'			<div class="descPrice">                                           '+
								'						<span style="color:#000">                             '+
								'							预计三天内达到                                    '+
								'						</span>                                               '+
								'				<span class="num">'+cart.num+'</span>                          '+
								'			   <img class="multi" src="../../../images/book/banner/multi.png">'+
								'			</div>                                                            '+
								'                                                                             '+
								'			<div class="descPrice">                                           '+
								'				<!-- 运费开始 -->                                             '+
								'						<span style="color:#000;position: relative;">         '+
								'							运费(根据具体地区而定)                            '+
								'						</span>                                               '+
								'						<span class="carriage">                               '+
								'￥'+cart.freight+
								'						</span>                                               '+
								'				<!-- 运费结束 -->                                             '+
								'			</div>                                                            '+
								'		</div></div>'
						}
						$(".goods").append(html);
					}else{
						$(".goods").append("您的购物车暂无书籍,请在首页挑选心仪的书籍吧!");
					}
				}})
		})
	</script>
	<%@include file="../commons/footer.jsp" %>
</body>
</html>