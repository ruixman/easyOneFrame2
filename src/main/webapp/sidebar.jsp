<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
	<li class="sidebar-toggler-wrapper">
		<div class="sidebar-toggler">
		</div>
	</li>
		
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">系统管理</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="${ctx}/sys/user/list"><i class="icon-home"></i>用户管理</a>
				</li>
				<li>
					<a href="${ctx}/#"><i class="icon-home"></i>会员审核</a>
				</li>
			
				<li>
					<a href="${ctx}/#"><i class="icon-home"></i>RR</a>
				</li>
				<!--  -->
			</ul>
		</li>	
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">栏目管理</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">

				<li>
					<a href="${ctx}/memberWithdraw/withdrawList.shtml"><i class="icon-home"></i>提现审核</a>
				</li>

			</ul>
		</li>
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">个人中心</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				
				<li>
					<a href="${ctx}/member/updatePwd.shtml"><i class="icon-home"></i>密码修改</a>
				</li>
			</ul>
		</li>

	
</ul>
<script>
$(function(){
	var _url=location.href,
		reg=/(_edit(.*?)\.)|(_add(.*?)\.)|(_product(.*?)\.)|(_detail(.*?)\.)/ig,
	_url=_url.substring(_url.lastIndexOf('/')+1,_url.lastIndexOf('#')>0?_url.lastIndexOf('#'):_url.length)||'index.shtml';
	
	_url=_url.replace(reg,".");
	$('.page-sidebar-menu li').removeClass('active');
	
	$(".page-sidebar-menu a[href$='"+_url+"']").parents('li').addClass('active').parents('li').addClass('active');
	
});
</script>