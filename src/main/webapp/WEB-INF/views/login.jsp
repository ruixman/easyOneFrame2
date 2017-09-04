<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.5
Version: 3.3.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8"/>
<title> 登录</title>
<%@include file="common/header.jsp" %>
<link href="${ctx}/assets/admin/pages/css/login.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
body {
	margin: 0px;
	background-color:#0068AC;
}
-->
</style></head>

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
<div class="menu-toggler sidebar-toggler">
</div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGO -->
<div class="logo">
	<a href="${ctx}/index.shtml">
	<img src="${ctx}/assets/admin/layout/img/pic_hd.jpg" height="130" width="400"  alt=""/>
	</a>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content" >
	<!-- BEGIN LOGIN FORM -->
	<form class="login-form" action="login" method="post">
		<h3 class="form-title">登录</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			
			<span>	请输入用户名和密码 </span>
		</div>
	
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">用户名</label>
			<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username" value="1"/>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">密码</label>
			<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password" value=""/>
		</div>
		<%--<div class="form-group">--%>
			<%--<label class="control-label visible-ie8 visible-ie9">验证码：</label>--%>
			<%--<input type="text" name="registration_code" class="form-control form-control-solid placeholder-no-fix"/>--%>
			<%--<img id="id_img" src="${pageContext.request.contextPath}/dxpt_auth_img.jpg" align="absmiddle" onclick="reloadimg()" height="30px" width="90px" alt="请单击刷新图片" />--%>
		<%--</div>--%>
		
		<div class="form-actions">
			<button type="submit" class="btn btn-success uppercase">进入</button>
			<!-- 
			<label class="rememberme check">
			<input type="checkbox" name="remember" value="1"/>记住登录 </label>
			 <a href="javascript:;" id="forget-password" class="forget-password">忘记密码?</a> -->
		</div>
		<!--
		<div class="login-options">
			<h4>Or login with</h4>
			<ul class="social-icons">
				<li>
					<a class="social-icon-color facebook" data-original-title="facebook" href="javascript:;"></a>
				</li>
				<li>
					<a class="social-icon-color twitter" data-original-title="Twitter" href="javascript:;"></a>
				</li>
				<li>
					<a class="social-icon-color googleplus" data-original-title="Goole Plus" href="javascript:;"></a>
				</li>
				<li>
					<a class="social-icon-color linkedin" data-original-title="Linkedin" href="javascript:;"></a>
				</li>
			</ul>
		</div>
		-->
		<!--
		<div class="create-account">
			<p>
				<a href="javascript:;" id="register-btn" class="uppercase">Create an account</a>
			</p>
		</div>
		-->
	</form>
	<!-- END LOGIN FORM -->
	<!-- BEGIN FORGOT PASSWORD FORM -->
	<form class="forget-form" action="" method="post">
		<h3>忘记密码 ?</h3>
		<p>
			 请输入您的手机号码。
		</p>
		<div class="form-group">
			<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="手机号码" name="tel"/>
		</div>
		<div class="form-actions">
			<button type="button" id="back-btn" class="btn btn-default">返回</button>
			<button type="submit" class="btn btn-success uppercase pull-right">提交</button>
		</div>
	</form>
	<!-- END FORGOT PASSWORD FORM -->
</div>
<!-- BEGIN FOOTER -->
<div class="copyright">
	
</div>
<!-- END FOOTER -->


<%@include file="common/import-js-core.jspf" %>
<script src="${ctx}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/admin/pages/scripts/login.js" type="text/javascript"></script>


<script>
        jQuery(document).ready(function() {
        	Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Login.init();
			Demo.init(); // init demo features
       // Ecommerce.init();
        });
        
    	<c:if test="${errMsg!=null}">
    		$('.alert-danger', $('.login-form')).html('${errMsg}').show();    	
    	</c:if>
    	
    	function reloadimg() {
    		//alert($("#id_img"));
    		$("#id_img").attr("src", "${pageContext.request.contextPath}/dxpt_auth_img.jpg?" + Math.random());
    	}              
    </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>