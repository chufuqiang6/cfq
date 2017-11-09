<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>这是一个首页</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/sources/js/commonjs/jquery-1.9.1.min.js"></script>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/sources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/sources/bootstrap/css/bootstrap-theme.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="${pageContext.request.contextPath}/sources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function exportTable() {
		location.href = "/page/export/excel";
	}
</script>
<script type="text/javascript">
	//   这里定义每页能打印多少行   
	//模拟数据   
	function prepare() {
		var ar = new Array()
		for (var i = parseInt(linesPerPage.value); i < (show.children.length - 1); i += parseInt(linesPerPage.value)) {
			var tr = show.insertBefore(show.firstChild.cloneNode(true),
					show.children[i]);
			tr.className = "onlyPrint"
			ar[ar.length] = tr;
		}
		preView();
		for (var i = ar.length - 1; i > -1; i--)
			show.deleteRow(ar[i].rowIndex)
	}
	function pageSetup() {
		try {
			WB.ExecWB(8, 1)
		} catch (e) {
			alert("您的浏览器不支持此功能")
		}
	}
	function preView() {
		try {
			WB.ExecWB(7, 1)
		} catch (e) {
			alert("您的浏览器不支持此功能")
		}
	}
	
	function importFilm(){
		$("#upload").submit();
	}
	
	
	function jsonTest(){
		$.ajax({
			url:"${pageContext.request.contextPath}/madmin/page/jsonTest.do",
			type:'post',
			dataType:'json',
			success:function(data){
				alert(data.id);
			}
		});
	}
</script>
</head>
<body>
	<a style="font-size: 20pt;"> 欢迎进入首页</a>
	<a onclick="jsonTest()"> json测试</a>
	<center class=onlyShow>
		设定每页打印 <input id=linesPerPage size=4 value=10>行
		<button onclick='pageSetup()'>页面设置</button>
		<button onClick='prepare()'>打印预览</button>
	</center>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-primary" href="/page/export/excel">导出 &raquo;</a>
				</p>
			</div>
			<div class="col-md-3">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-info" href="#" onclick='pageSetup()'>页面设置
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-3">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</p>
				<p>
					<a class="btn btn-success" onClick='prepare()'>打印 预览&raquo;</a>
				</p>
			</div>
			<div class="col-md-3">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa justo sit amet risus.</p>
				<p>
					<a class="btn btn-success" onclick="importFilm()">导入视频&raquo;</a>
					<form id="upload" method="post" action="/file/getFile" enctype="multipart/form-data">
					<input type="file" name="file"/>
					</form>
				</p>
			</div>
		</div>
	</div>
	<OBJECT classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0
		id=WB width=0 VIEWASTEXT></OBJECT>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table" id=show>
					<caption>用户信息列表</caption>
					<thead>
						<tr>
							<th>ID</th>
							<th>用户名</th>
							<th>密码</th>
							<th>修改人</th>
							<th>修改日期</th>
							<th>新增人</th>
							<th>新增日期</th>
						</tr>
					</thead>
					<tbody>
						<tr class="active">
							<td>1</td>
							<td>好人理查德</td>
							<td>123121</td>
							<td>张明敏</td>
							<td>2015-12-12</td>
							<td>李白</td>
							<td>1425-1-1</td>
						</tr>
						<tr class="success">
							<td>2</td>
							<td>好人理查德</td>
							<td>123121</td>
							<td>张明敏</td>
							<td>2015-12-12</td>
							<td>李白</td>
							<td>1425-1-1</td>
						</tr>
						<tr class="warning">
							<td>3</td>
							<td>好人理查德</td>
							<td>123121</td>
							<td>张明敏</td>
							<td>2015-12-12</td>
							<td>李白</td>
							<td>1425-1-1</td>
						</tr>
						<tr class="danger">
							<td>4</td>
							<td>好人理查德</td>
							<td>123121</td>
							<td>张明敏</td>
							<td>2015-12-12</td>
							<td>李白</td>
							<td>1425-1-1</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>