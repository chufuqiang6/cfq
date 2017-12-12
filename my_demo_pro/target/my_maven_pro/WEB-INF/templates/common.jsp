<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" href="<%=basePath%>sources/js/jPlayer/jplayer.flat.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>sources/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>sources/css/animate.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>sources/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>sources/css/simple-line-icons.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>sources/css/font.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath%>sources/css/app.css" type="text/css" /> 

<!-- / footer111111	 -->
<script src="<%=basePath%>sources/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%=basePath%>sources/js/bootstrap.js"></script>
<!-- App -->
<script src="<%=basePath%>sources/js/app.js"></script>  
<script src="<%=basePath%>sources/js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>sources/js/app.plugin.js"></script>
<script type="/text/javascript" src="<%=basePath%>sources/js/jPlayer/jquery.jplayer.min.js"></script>
<script type="/text/javascript" src="<%=basePath%>sources/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
<script type="/text/javascript" src="<%=basePath%>sources/js/jPlayer/demo.js"></script> 