<%@ page contentType="text/html;charset=UTF-8" %>
<script type="text/javascript">
    $(document).ready(function () {
        $("div.con3").hover(function () {
            $("#menu-list").show();
        }, function () {
            $("#menu-list").hide();
        });
    })
</script>
<input type="hidden" name="userId" value="${sessionScope.userid}">
<input type="hidden" name="userName" value="${sessionScope.username}">
<input type="hidden" name="userType" value="${sessionScope.usertype}">
<div class="navbar">
    <div class="container">
        <div class="con1">
            <a href="${ctx}/index/index">NCLMS</a>
        </div>
        <ul class="con2">
            <li><a id="menu_0" href="${ctx}/index/index">首页</a></li>
            <li><a id="menu_1" href="${ctx}/express/search">快递查询</a></li>
            <li><a id="menu_2" href="${ctx}/express/form">在线寄件</a></li>
            <li><a id="menu_3" href="${ctx}/freight/search">运费查询</a></li>
            <li><a id="menu_4" href="${ctx}/franchise/form">加盟合作</a></li>
            <li><a id="menu_5" href="${ctx}/about/view">关于我们</a></li>
        </ul>
        <div class="con3">
            <c:if test="${empty sessionScope.userid}">
                <a href="${ctx}/login/login">登录</a>
                <a href="${ctx}/register/register">注册</a>
            </c:if>
            <c:if test="${not empty sessionScope.userid}">
                <img src="/image/sys/tou.jpg" alt>
                <a style="padding: 0;min-width: 43px">${sessionScope.username}</a>
                <ul id="menu-list">
                    <li><a href="${ctx}/express/list">寄件列表</a></li>
                    <li><a href="${ctx}/franchise/list">加盟列表</a></li>
                    <li><a href="${ctx}/user/view">个人信息</a></li>
                    <li style="border-top: 1px solid #dddddd"><a href="${ctx}/login/out">退出登录</a></li>
                </ul>
            </c:if>
        </div>
    </div>
</div>
