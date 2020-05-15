<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>500</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/custom/custom-1.0.0.css"/>
    <style type="text/css">
        body {
            background-color: #ECECEC;
            font-family: 'Open Sans', sans-serif;
            font-size: 14px;
            color: #3c3c3c;
        }
    </style>
</head>
<body>
    <div class="error">
        <p>
            <span>5</span>
            <span>0</span>
            <span>5</span>
        </p>
        <p style="margin-top: -30px">服务器内部错误(´･ω･`)</p>
    </div>
</body>
</html>
