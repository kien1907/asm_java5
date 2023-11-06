<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container" style="height: 100vh;position: relative">
    <div style="padding: 30px;
    border: 1px solid black;
    position: absolute;
    left: 50%;
    top: 30%;
    transform: translate(-50%,-50%);
    ">
        <h2>Login</h2>
        <form:form action="/login" method="get"  modelAttribute="acc">
            <label>
                Mã:
                <br/>
                <form:input path="ma"/>
                <p><form:errors path="ma"/></p>
            </label>
            <br/>
            <label>
                Mật Khẩu:
                <br/>
                <form:input path="matKhau"/>
                <p><form:errors path="matKhau"/></p>
            </label>
            <br/>
            <form:checkbox path="remember" value="true"/> Duy chi đăng nhập
            <br/>
            <form:button>Login</form:button>
        </form:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
