<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>支付</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
	<link rel="stylesheet" tylie="text/css" href="reset.css?t=57">
	<link rel="stylesheet" tylie="text/css" href="../../../style/pay.css?t=57">
	<!--cdn开始-->
	<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<!--cdn开始-->
</head>
<body>
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
					收货人:赵明威
				</span>
				<span class="lable" id="phone">
					电话:15313306298
				</span>
			</div>
			<!-- 基本信息结束-->
			<!-- 具体地址开始 -->
			<div class="address">
				收货地址:北京市西城区新街口外大街普天德胜工业园区
			</div>
			<!-- 具体地址结束 -->
			</div>
		</div>
		<!-- 收货地址结束 -->
		<!-- 商品详情开始 -->
		<div class="goodDetailWrap clearfix">
			<div class="imgWrap fl">
				<img src="goods.jpg">
			</div>
			<div class="desc">
					<div class="descPrice">
						<!-- 商品名称开始 -->
						<span class="title" style="color:#000">
							java编程思想
						</span>
						<!-- 商品名称结束 -->
						<!-- 商品价格开始 -->
						<span class="price">
							￥20.00 
						</span>
						<!-- 商品价格结束 -->
					</div>

					<div class="descPrice">
						<span style="color:#000">
							预计三天内达到
						</span>
						<span class="num">3</span>
						<img class="multi" src="../../../images/book/banner/multi.png"></img>
					</div>

					<div class="descPrice">
						<!-- 运费开始 -->
						<span style="color:#000;position: relative;">
							运费(根据具体地区而定)
						</span>
						<span class="carriage">
							￥0.00
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
						￥40.00 + ￥0.00 
					</span>
				</div>
				<div style="position:relative;width:100%;text-align:center;color: #FF6633;">
					<span >
						需付:￥40.00
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
</body>
</html>