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
    <span class="glyphicon glyphicon-fire" style="color: rgb(255, 140, 60);">本周推荐图书</span>
  </c>
  <div class="titleName"><a href="/classify?type=${oneBook.classify_id}"><span style="color: rgb(113, 245, 60);" class="glyphicon glyphicon-th-large"></span>${oneBook.classify_name}</a></div>
  <div class="titleName"><span style="color: rgb(250, 201, 60);" class="glyphicon glyphicon-book"></span>${oneBook.name}</div>
  <div><a class="image-container" href="#"><img src="../../../${oneBook.path}"></a></div>
<div class="describe">${oneBook.describe}</div>
<div class="list"><span style="color: #FAC93C;" class="glyphicon glyphicon-th-list"></span>目录结构<br>${oneBook.list}</div>
</div>
</body>
</html>