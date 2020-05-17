<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<div class="header">
	<div class="container2">
		<div class="h-show" onclick="window.location.href='/'">
			${fns:getUser().name}
		</div>
		<div class="h-img">
			<img alt="头像" src="/image/sys/icon32x32.png">
		</div>
		<ul class="h-menu">
			<li>首页</li>
			<li>纪念日</li>
			<li>系统设置</li>
		</ul>
	</div>
</div>
<div style="height: 4em"></div>
