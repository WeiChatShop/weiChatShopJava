<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2015/7/7
  Time: 6:56
  首页,展示图书的分类
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
  <script src="../../../js/index.js"></script>
</head>
<body>
<%@include file="../commons/common.jsp" %>
<%@include file="../commons/header.jsp" %>
<div class="box box-index">
  <div id="welcome">
    <span class="glyphicon glyphicon-tree-conifer" style="color: rgb(255, 140, 60);"></span>欢迎来到书虫书苑,作为有理想的凡人,
      你有责任为自己的未来买一本实用的工具书,本店拥有全网最好的技术书籍,和最有情怀的文学艺术作品,祝您登上人生巅峰<span class="glyphicon glyphicon-tower" style="color: rgb(255, 140, 60);"></span>
  </div>
  <div id="computer" style="padding-top:10px;padding-bottom: 10px">
    <a class="glyphicon glyphicon-phone" id="comTitle">计算机图书</a>
    <a class="detail" href="/classify?type=1">查看详细<i class="glyphicon glyphicon-chevron-right"></i></a>
  </div>
    <div id="computerBook" class="carousel slide">
      <ol class="carousel-indicators" id="computerLi">
      </ol>
      <!-- Carousel items -->
      <div class="carousel-inner" id="computerItem">
      </div>
      <!-- Carousel nav -->
      <a class="carousel-control left" href="#computerBook" data-slide="prev">&lsaquo;</a>
      <a class="carousel-control right" href="#computerBook" data-slide="next">&rsaquo;</a>
    </div>
  <div id="art" style="padding-top:10px;padding-bottom: 10px">
    <a class="glyphicon glyphicon-book" id="artTitle">文学艺术图书</a>
    <a class="detail" href="/classify?type=2">查看详细<i class="glyphicon glyphicon-chevron-right"></i></a>
  </div>
  <div id="artBook" class="carousel slide">
      <ol class="carousel-indicators" id="artBookLi">
      </ol>
      <!-- Carousel items -->
      <div class="carousel-inner" id="artBookItem">
      </div>
      <!-- Carousel nav -->
      <a class="carousel-control left" href="#artBook" data-slide="prev">&lsaquo;</a>
      <a class="carousel-control right" href="#artBook" data-slide="next">&rsaquo;</a>
    </div>
  <%@include file="../commons/footer.jsp" %>
</div>
</body>
</html>
