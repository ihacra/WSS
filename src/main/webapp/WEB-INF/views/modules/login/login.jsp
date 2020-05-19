<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<title>用户登录</title>
<script>
    // 表单验证
    window.addEventListener('load', function() {
        verification(document.getElementById('inputForm'));
    }, false);
    $(document).ready(function() {
    	// 随机展示图片
    	var rand = parseInt(Math.random() * 4 + 1);
    	$("#zs").attr("src", "/image/login/myx_" + rand + ".webp")
    	// 根据登录名变更图像
        $("#loginName").bind("input propertychange", function(event) {
        	var name = $("#loginName").val();
            if (name === "xiaoxinxin") {
            	$("#tx").attr("src", "/image/login/xinxin.jpg");
            } else if (name == "xiaohanhan") {
            	$("#tx").attr("src", "/image/login/hanhan.jpg");
            } else {
            	$("#tx").attr("src", "/image/login/aiqing_9470DC.png");
            }
    	});
    });
</script>
</head>
<body>
    <sys:background></sys:background>
    <sys:message content="${message}"></sys:message>
    <div class="login_main">
        <div class="login_left">
            <img id="zs" alt="图片" src="/image/login/myx_1.webp">
        </div>
        <div class="login_right">
            <div class="login_img">
                <img id="tx" alt="头像" src="/image/login/aiqing_9470DC.png">
            </div>
            <c:if test="${pageContext.request.queryString != 'register'}">
	            <form id="inputForm" action="/login/login" method="post" novalidate>
	                <div class="form-group">
	                    <input id="loginName" name="loginName" type="text" placeholder="请输入用户名" maxlength="15" class="form-control" required />
	                    <div class="invalid-feedback">请输入用户名</div>
	                </div>
	                <div class="form-group">
	                    <input name="password" type="password" placeholder="请输入密码" maxlength="15" class="form-control" required />
	                    <div class="invalid-feedback">请输入密码</div>
	                </div>
	                <div class="form-group" style="margin-top: 2em">
	                    <input style="width: 100%;" class="btn btn-primary" type="submit" value="登 录" />
	                </div>
	                <div class="form-group">
	                	<div style="color: #CDA3E3; float: left">还没有账号？</div>
		                <div style="font-weight: bold; cursor: pointer; float: left"><a href="/login?register">注册</a></div>
		            </div>
	            </form>
	        </c:if>
	        <c:if test="${pageContext.request.queryString == 'register'}">
                <script>document.title="用户注册"</script>
	            <form id="inputForm" action="/login/register" method="post" novalidate>
	                <div class="form-group">
	                    <input name="name" type="text" placeholder="请输入姓名" maxlength="15" class="form-control" required />
	                    <div class="invalid-feedback">请输入姓名</div>
	                </div>
	                <div class="form-group">
	                    <input name="loginName" type="text" placeholder="请输入用户名" maxlength="15" class="form-control" required />
	                    <div class="invalid-feedback">请输入用户名</div>
	                </div>
	                <div class="form-group">
	                    <input name="password" type="password" placeholder="请输入密码" maxlength="15" class="form-control" required />
	                    <div class="invalid-feedback">请输入密码</div>
	                </div>
	                <div class="form-group" style="margin-top: 2em">
	                    <input style="width: 100%;" class="btn btn-primary" type="submit" value="注 册" />
	                </div>
	                <div class="form-group">
	                    <div style="color: #CDA3E3; float: left">已有账号，</div>
	                    <div style="font-weight: bold; cursor: pointer; float: left"><a href="/login">登录</a></div>
	                </div>
	            </form>
	        </c:if>
        </div>
    </div>
</body>
</html>
