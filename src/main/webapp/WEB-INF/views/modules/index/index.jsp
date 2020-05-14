<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>SpringBoot</h1>
	<p>Index</p>
	${user.id}
	<br /> ${user.name}
	<br /> ${user.loginName}
	<br /> ${user.password}
	<br /> ${user.gender}
	<br /> ${user.nation}
	<br />
	<fmt:formatDate value="${user.birthdate}" pattern="yyyy-MM-dd" />
	<br /> ${user.address}
	<br /> ${user.email}
	<br /> ${user.mobile}
	<br /> ${user.perSign}
	<br />
	<hr>
	${user}
	<br />
</body>
</html>