<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ảnh</th>
            <th scope="col">Tên</th>
            <th scope="col">NSX</th>
            <th scope="col">Số lương</th>
            <th scope="col">Năm bảo hành</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Đơn Giá</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="gh" items="${listGH}" varStatus="i">
            <tr>
                <th scope="col">${i.index}</th>
                <th scope="col">
                    <img width="100px" src="${gh.ctsp.anh}">
                </th>
                <th scope="col">${gh.ctsp.dong.ten} ${gh.ctsp.sanPham.ten} ${gh.ctsp.mauSac.ten}</th>
                <th scope="col">${gh.ctsp.nsx.ten}</th>
                <th scope="col">${gh.soLuong}</th>
                <th scope="col">${gh.ctsp.namBh}</th>
                <th scope="col">${gh.ctsp.moTa}</th>
                <th scope="col"><fmt:formatNumber value="${gh.ctsp.giaBan * gh.soLuong}" pattern="#,### VND"/></th>
                <th scope="col">
                    <a href="/gio-hang/delete-sp/${gh.ctsp.id}" type="button" class="btn btn-primary">Xóa</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</html>


