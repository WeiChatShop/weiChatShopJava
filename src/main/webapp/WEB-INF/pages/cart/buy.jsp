<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>立即购买</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
	<link rel="stylesheet" tylie="text/css" href="../../../style/reset.css?t=57">
	<link rel="stylesheet" tylie="text/css" href="../../../style/buy.css?t=57">
</head>
<body>
	<%@include file="../commons/common.jsp" %>
	<%@include file="../commons/header.jsp" %>
	<div class="buyWrap">
		<!-- 商品详情开始 -->
		<div class="goodDetailWrap clearfix">
			<div class="imgWrap fl">
				<img src="../${onebook.path}">
			</div>
			<div class="desc">
				<!-- 商品名称开始 -->
				<h3 class="title">
					${onebook.name}
				</h3>
				<!-- 商品名称结束 -->
				<div class="descPrice">
					<!-- 商品价格开始 -->
					<span>单价:</span>￥<span class="price" id="price">
						${onebook.price}
					</span>
					<!-- 商品价格结束 -->
					<!-- 运费开始 -->
					<span>运费:</span>
					<span class="carriage">
						${onebook.freight}
					</span>
					<!-- 运费结束 -->
				</div>
			</div>
		</div>
		<!-- 商品详情结束 -->
		<!-- 购买信息开始 -->
		<div class="bugInfoWrap">
			<!-- 购买数量开始 -->
			<div class="lableWrap">
				<span class="lable">
				商品数量:
				</span>
				<div class="inputWrap">
					<button class="btn-reduce" href="javascript:;" onclick="setNum(1)">-</button>
					<input type="text" id="num" placeholder="请填写购买数量" value="1" onchange="setNum(3)" />
					<button class="btn-add" href="javascript:;" onclick="setNum(2)">+</button>
				</div>
			</div>
			<!-- 购买数量结束 -->
			<!-- 合计开始 -->
			<div class="lableWrap">
				<span class="lable">
				合计:￥ 
				</span>
				<div class="lableWrap">
					<span class="lable" id="total">${onebook.price+onebook.freight}</span>
				</div>
			</div>
			<!-- 合计结束 -->
			<!-- 收货人开始 -->
			<div class="lableWrap">
				<span class="lable">
					收货人：
				</span>
				<div class="inputWrap">
					<input type="text" placeholder="请填写收货人姓名" />
				</div>
			</div>
			<!-- 收货人结束 -->
			<!-- 联系电话开始 -->
			<div class="lableWrap">
				<span class="lable">
					联系电话：
				</span>
				<div class="inputWrap">
					<input type="text" placeholder="请填联系电话" />
				</div>
			</div>
			<!-- 联系电话开始 -->
			<!-- 地区开始 -->
			<div class="lableWrap">
				<span class="lable">
					地区：
				</span>
				<div class="inputWrap">
					<input type="text" placeholder="请填省、市、县" />
				</div>
			</div>
			<!-- 地区结束 -->
			<!-- 详细地址开始 -->
			<div class="lableWrap">
				<span class="lable">
					详细地址：
				</span>
				<div class="inputWrap">
					<input type="text" placeholder="请填写详细地址" />
				</div>
			</div>
			<!-- 详细地址结束 -->
			<!-- 邮政编码开始 -->
			<div class="lableWrap">
				<span class="lable">
					邮政编码：
				</span>
				<div class="inputWrap">
					<input type="text" placeholder="选填" />
				</div>
			</div>
			<!-- 邮政编码开始 -->
			<!-- 其他要求开始 -->
			<div class="lableWrap">
				<span class="lable">
					其他要求：
				</span>
				<div class="inputWrap">
					<input type="text" placeholder="选填" />
				</div>
			</div>
			<!-- 其他要求结束 -->
			<!-- 提交按钮开始 -->
			<div class="lableWrap">
				<span class="bugBtn" onclick="buy(${onebook.id})">确定购买</span>
			</div>
			<!-- 提交按钮结束 -->
		</div>
		<!-- 购买信息结束 -->
	</div>
	<script type="text/javascript">
	function setNum(id){
		var num = parseInt($("#num").val());
		var price= parseInt($("#price").text());
		var carriage= parseInt($(".carriage").text());
		if(num<=0&&id==1){
			alert("数量不能小于0");
			return;
		}else{
			if(id==1){
				$("#num").val(eval(num-1));
				$("#total").text(eval((num-1)*price+carriage));
			}else if(id==2){
				$("#num").val(eval(num+1));
				$("#total").text(eval((num+1)*price+carriage));
			}else {
				$("#num").val(eval(num));
				$("#total").text(eval((num)*price+carriage));
			}
		}
	}
	</script>
</body>
</html>