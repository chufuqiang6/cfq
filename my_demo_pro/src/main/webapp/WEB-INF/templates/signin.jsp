<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
  <title></title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<body class="bg-info dker">
<%@include file="common.jsp" %>
  <section id="content" class="m-t-lg wrapper-md animated fadeInUp">    
    <div class="container aside-xl">
      <a class="navbar-brand block" href="index.html"><span class="h1 font-bold">音乐</span></a>
      <section class="m-b-lg">
        <header class="wrapper text-center">
<!--           <strong>填写登录</strong> -->
        </header>
        <form action="<%=basePath%>madmin/page/validateLogin.do">
          <div class="form-group">
            <input type="text" name="userName" placeholder="请输入用户名" class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="form-group">
             <input type="password" name="passWord" placeholder="请输入密码" class="form-control rounded input-lg text-center no-border">
          </div>
          <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">登录</span></button>
          <div class="text-center m-t m-b"><a href="#"><small>忘记密码？</small></a></div>
          <div class="line line-dashed"></div>
          <p class="text-muted text-center"><small>还未注册？</small></p>
          <a href="signup.html" class="btn btn-lg btn-info btn-block rounded">注册</a>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder">
      <p>
        <small>褚夫强版权所有<br>&copy; 2017</small>
      </p>
    </div>
  </footer>
</body>
</html>