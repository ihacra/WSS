<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html xmlns:svg="http://www.w3.org/2000/svg">
<div class="header">
	<div class="container2">
		<div class="h-show">
			<a href="/">${fns:getUser().name}</a>
		</div>
		<div class="h-img">
			<img alt="头像" src="/image/sys/icon32x32.png">
		</div>
		<ul class="h-menu">
			<li><a href="/">首页</a></li>
			<li><a href="/">纪念日</a></li>
			<li><a class="h-dropdown" href="/">系统设置</a>
			</li>
		</ul>
	</div>
</div>
<div style="height: 4em"></div>
