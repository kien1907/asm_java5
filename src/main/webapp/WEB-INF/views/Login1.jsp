<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<body>
<div>
    <ul class="nav justify-content-end">
        <li class="nav-item login">
            <p class="nav-link active">Đăng nhập</p>
            <div class="LoginAndRegister">
                <div class="arrow-up"></div>
                <form:form action="/login"  modelAttribute="acc">
                    <div class="mb-3">
                        <label class="form-label">Mã</label>
                        <br/>
                        <form:input path="ma"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Mật Khẩu</label>
                        <br/>
                        <form:input path="matKhau"/>
                    </div>
                    <form:button>Add</form:button>
                </form:form>
                <a href="/register">Chưa Có Tài Khoản</a>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
