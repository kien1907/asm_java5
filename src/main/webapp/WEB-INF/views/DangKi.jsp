<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        body {
            position: relative;
        }

        .register {
            width: 500px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: 1px solid black;
            text-align: center;
        }
        .error{
            color: red;
        }
    </style>
</head>
<body>
<div class="container register">
    <h2>Form Đăng Kí</h2>
    <form:form action="/addnewkh" modelAttribute="kh">
        <div class="row">
            <div class="mb-3 col-6">
                <label class="form-label">Họ</label>
                <br/>
                <form:input path="ho"/>
                <p class="error"><form:errors path="ho"/></p>
            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Tên Đệm</label>
                <br/>
                <form:input path="tenDem"/>
                <p class="error"><form:errors path="tenDem"/></p>

            </div>
        </div>
        <div class="row">
            <div class="mb-3 col-6">
                <label class="form-label">Tên</label>
                <br/>
                <form:input path="ten"/>
                <p class="error"> <form:errors path="ten"/></p>

            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Ngày Sinh</label>
                <br/>
                <form:input path="ngaySinh"/>
                <p class="error"> <form:errors path="ngaySinh"/></p>

            </div>
        </div>
        <div class="row">
            <div class="mb-3 col-6">
                <label class="form-label">Số Điện Thoại</label>
                <br/>
                <form:input path="sdt"/>
                <br/>
                <p class="error"><form:errors path="sdt"/></p>

            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Địa Chỉ</label>
                <br/>
                <form:input path="diaChi"/>
                <p class="error"><form:errors path="diaChi"/></p>

            </div>
        </div>
        <div class="row">
            <div class="mb-3 col-6">
                <label class="form-label">Thành Phố</label>
                <br/>
                <form:input path="thanhPho"/>
                <p class="error"><form:errors path="thanhPho"/></p>

            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Quốc Gia</label>
                <br/>
                <form:input path="quocGia"/>
                <p class="error"><form:errors path="quocGia"/></p>

            </div>
        </div>
        <div class="row">
            <div class="mb-3 col-6">
                <label class="form-label">Mã</label>
                <br/>
                <form:input path="ma"/>
                <p class="error"><form:errors path="ho"/></p>
            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Mật Khẩu</label>
                <br/>
                <form:password path="matKhau"/>
                <p class="error"><form:errors path="matKhau"/></p>
            </div>
        </div>
        <form:button>Add</form:button>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>