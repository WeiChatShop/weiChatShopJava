<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>支付</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
	<link rel="stylesheet" tylie="text/css" href="../../../style/reset.css?t=57">
	<link rel="stylesheet" tylie="text/css" href="../../../style/pay.css?t=57">
</head>
<body>
	<%@include file="../commons/common.jsp" %>
	<%@include file="../commons/header.jsp" %>
	<div class="buyWrap">
		<!-- 收货地址开始 -->
		<div class="addrWrap clearfix">
			<div class="imgWrap fl">
				<img src="../../../images/book/banner/map.png">
			</div>
			<div class="desc">
			<!-- 基本信息开始 -->
			<div>
				<span class="lable" id="name">
					收货人:${cart.realname}
				</span>
			</div>
			<div>
				<span class="lable" id="phone">
					电话:${cart.phone}
				</span>
			</div>
			<!-- 基本信息结束-->
			<!-- 具体地址开始 -->
			<div class="address">
				收货地址:${cart.province},${cart.detail_addr}
			</div>
			<!-- 具体地址结束 -->
			</div>
		</div>
		<!-- 收货地址结束 -->
		<!-- 商品详情开始 -->
		<div class="goodDetailWrap clearfix">
			<div class="imgWrap fl">
				<img src="../${cart.path}">
			</div>
			<div class="desc">
					<div class="descPrice">
						<!-- 商品名称开始 -->
						<span class="title" style="color:#000">
							${cart.name}
						</span>
						<!-- 商品名称结束 -->
						</div>
					<div class="descPrice1">
						<!-- 商品价格开始 -->
						<span class="price1">
							￥${cart.price}
						</span>
						<!-- 商品价格结束 -->
						<span class="num">${cart.num}</span>
						<img class="multi" src="../../../images/book/banner/multi.png">
					</div>
					<div class="descPrice1">
						<!-- 运费开始 -->
						<span style="color:#000;position: relative;">
							运费(视地区而定)
						</span>
						<span class="carriage">
							￥${cart.freight}
						</span>
						<!-- 运费结束 -->
					</div>
				</div>
			</div>
			<div class="totalWrap">
				<div style="width:100%;margin-bottom:30px">
					<span class="totalfont">
						合计
					</span>
					<span class="total">
						￥${cart.price*cart.num} + ￥${cart.freight}
					</span>
				</div>
				<div style="position:relative;width:100%;text-align:center;color: #FF6633;">
					<span >
						需付:￥${cart.should_pay}
					</span>
				</div>
		</div>
		<!-- 商品详情结束 -->
			<!-- 提交按钮开始 -->
			<div class="lableWrap">
				<span class="bugBtn">微信安全支付</span>
			</div>
			<!-- 提交按钮结束 -->
	</div>
	<%@include file="../commons/footer.jsp" %>
</body>
</html>