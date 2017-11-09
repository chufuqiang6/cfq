<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<head>
<title>这是一个测试</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/sources/js/commonjs/jquery-1.9.1.min.js"></script>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/sources/bootstrap/css/bootstrap.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="${pageContext.request.contextPath}/sources/bootstrap/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/sources/js/jquery_video_js/css/video-js.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/sources/js/jquery_video_js/js/video.min.js"></script>
<script
	src="${pageContext.request.contextPath}/sources/js/echars/echarts.min.js"></script>
<style type="text/css">
.video-js .vjs-big-play-button {
	top: 172px ! important;
	left: 260px ! important;
}
</style>
</head>
<body>

	<script type="text/javascript">
// 		function submit() {
// 			var userName = $("#userName").val();
// 			var passWord = $("#passWord").val();
// 			$.ajax({
<%-- 				url:"<%=basePath%>madmin/page/validateLogin.do", --%>
// 				data:{userName:userName,passWord:passWord},
// 				dataType:'json',
// 				type:'post',
// 				success:function(data){
// 					if(data){
<%-- 					window.location.href="<%=basePath%>page/index.do"; --%>
// 					}else{
// 						alert("用户名或密码不正确！");
// 					}
// 				}
// 			});
// // 		    window.location.href="/madmin/page/validateLogin.do?userName="+userName+"&passWord="+passWord;
// 		}
		$(function() {
			// 	  var myPlayer = _V_("video_test");
			// 	  myPlayer.play();
			var myChart = echarts.init(document.getElementById('main'));

			// 指定图表的配置项和数据
			var option = {
				title : {
					text : '示例图'
				},
				tooltip : {},
				legend : {
					data : [ '销量' ]
				},
				xAxis : {
					data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
				},
				yAxis : {

				},
				series : [ {
					name : '销量',
					type : 'bar',
					data : [ 5, 20, 36, 10, 10, 20 ]
				} ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		});
	</script>
	<div class="container" style="padding-top: 50px">
		<div class="row">
		<form action="<%=basePath%>madmin/page/validateLogin.do" method = 'post'>
			<div class="col-md-3">
				<div class="input-group">
					<div class="row">
						<div class="col-md-4" align="center">
							<p>用户名：</p>
						</div>
						<div class="col-md-8">
							<input name="userName" type="text" class="form-control" placeholder="用户名">
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="input-group">
					<div class="row">
						<div class="col-md-4" align="center">
							<p>密码：</p>
						</div>
						<div class="col-md-8">
							<input name="passWord" type="password" class="form-control" placeholder="密码" >
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
			<input type="submit" value="登录">  
			</div>
			</form>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<video id="video_test" class="video-js vjs-default-skin" controls
					preload="auto" width="640" height="400" poster="" data-setup=”{}”>
					<source
						src="${pageContext.request.contextPath}/sources/film/film_test_1.mp4"
						type="video/mp4">
				</video>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div id="main" style="width: 600px; height: 400px;"></div>
			</div>
		</div>
	</div>
</body>
</html>