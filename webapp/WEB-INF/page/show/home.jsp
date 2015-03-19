<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<%@include file="/WEB-INF/page/common/head.jsp"%>
<%@include file="/WEB-INF/page/common/menu.jsp"%>
<title>社交网络</title>
<script type="text/javascript" src="/source/scripts/show/home.js"></script>
</head>
<body>
	<div id="page-body">
		<div class="content">
			<div class="slider">
				<ul class="image-slider">
					<li><span><img class="responsive-image"
							src="/source/images/slider/001.png" alt="img"></span></li>
					<li><span><img class="responsive-image"
							src="/source/images/slider/002.png" alt="img"></span></li>
					<li><span><img class="responsive-image"
							src="/source/images/slider/003.png" alt="img"></span></li>
					<li><span><img class="responsive-image"
							src="/source/images/slider/004.png" alt="img"></span></li>
					<li><span><img class="responsive-image"
							src="/source/images/slider/005.png" alt="img"></span></li>
				</ul>
			</div>

			<div class="decoration">
				<div class="deco1"></div>
				<div class="deco2"></div>
			</div>

			每日话题

			<div class="decoration">
				<div class="deco1"></div>
				<div class="deco2"></div>
			</div>

			<div class="container">
				<div class="blog-item">
					<h3 class="left-text">新闻标题</h3>
					<a href="#" class="posted-by">Admin</a> <a href="#"
						class="posted-on">22 Dec 2012</a> <a href="#" class="posted-cat">Tutorial</a>
					<img class="image-deco responsive-image"
						src="/source/images/slider/1.jpg" alt="img">
					<div class="clear"></div>
					<p class="left-text">内容简介. Lorem Ipsum has been the industry's
						standard dummy text ever since the 1500s, when an unknown printer
						took a galley of type and scrambled it to make a type specimen
						book.</p>
					<div class="share-box">
						<a href="#" class="read-more-share"></a> <a href="#"
							class="facebook-share"></a> <a href="#" class="twitter-share"></a>
					</div>
				</div>

				<div class="decoration">
					<div class="deco1"></div>
					<div class="deco2"></div>
				</div>
				
				<div class="load-page">点击加载更多</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/page/common/footer.jsp"%>
</body>
</html>