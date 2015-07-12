<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2015/7/9
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta content="target-densitydpi=320,width=640,user-scalable=no" name="viewport">
  <meta content="yes" name="apple-mobile-web-app-capable" />
  <meta content="black" name="apple-mobile-web-app-status-bar-style" />
  <meta content="telephone=no" name="format-detection" />
  <title>书虫书苑</title>
</head>
<body>
<%@include file="../commons/common.jsp" %>
<%@include file="../commons/header.jsp" %>
<div class="box box-index" id="oneBook_page">
  <c if test="${oneBook.hot}==1">
    <span class="glyphicon glyphicon-fire" style="color: rgb(255, 140, 60);padding-top:10px;padding-bottom:10px">本周推荐图书</span>
  </c>
  <div class="titleName"><a href="/classify?type=${oneBook.classify_id}"><span style="color: rgb(113, 245, 60);padding-bottom:10px" class="glyphicon glyphicon-th-large"></span>${oneBook.classify_name}</a></div>
  <div class="titleName"><span style="color: rgb(250, 201, 60);" class="glyphicon glyphicon-book"></span>${oneBook.name}</div>
  <div><a class="image-container" href="#"><img src="../../../${oneBook.path}"></a></div>
<div class="abstract"><i class="glyphicon glyphicon-pushpin" style="color:aqua"></i>内容推荐</div>
<div class="describe">${oneBook.describe}</div>
<div class="price"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;${oneBook.price}元<span style="float:right">武汉-北京&nbsp;&nbsp;免运费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div>
<div style="font-size: 28px;background-color:#f6ffa8">发货时间:一周七天节假日不休</div>
<div style="font-size: 28px;background-color:#b2ffeb">书苑福利:</div>
<div style="font-size: 25px">现在购买该套书的顾客均随书赠送资料(和书本配套资料地址发邮箱-拍下请留言备注邮箱),希望赠送的资料对亲们考试有帮助哦！</div>
<div class="home">
   <div>
     <a href="#" class="glyphicon glyphicon-book">书虫书苑的店</a>
     <a class="detail" href="/">进入店铺<i class="glyphicon glyphicon-chevron-right"></i></a>
   </div>
  <div>
    <a href="#" ><i class="glyphicon glyphicon-heart-empty" style="color: #9CF700;"></i><span>企业认证</span></a>
    <a href="#" style="float:right"><i class="glyphicon glyphicon-heart" style="color: #9CF700;"></i><span>担保交易</span></a>
  </div>
</div>
<div class="list"><span style="color: #FAC93C;" class="glyphicon glyphicon-th-list"></span>
  &nbsp;目录结构<br>
  <span class="listpre">${oneBook.prelist}</span>
  <span class="listpro" style="display:none">${oneBook.list}</span>
</div>
<div class="seemorelist" style="margin-bottom:10px"><a type="button" class="btn3" onclick="showList()">
  <i class="glyphicon glyphicon-chevron-down" id="showList">查看更多目录</i>
  </a></div>
  <div class="buybtn">
    <button type="button" class="btn1" onclick="buyit()">立即购买</button>
    <button type="button" class="btn2">加入购物车</button>
  </div>
</div>

<%@include file="../commons/footer.jsp" %>
<script src="../../../js/oneBook.js"></script>
</body>
</html>