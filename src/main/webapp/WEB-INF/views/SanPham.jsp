<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<body>
<div>
    <form action="/quan-ly/san-pham/add" method="post" enctype="multipart/form-data">
        chọn File:
        <input type="file" name="file">
        <button>gửi</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ảnh</th>
            <th scope="col">Tên</th>
            <th scope="col">Số lương</th>
            <th scope="col">Năm bảo hành</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Gia bán</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ctsp" items="${listctsp}" varStatus="i">
            <tr>
                <th scope="col">${i.index}</th>
                <th scope="col">
                    <img width="100px" src="${ctsp.anh}">
                </th>
                <th scope="col">${ctsp.sanPham.ten} ${ctsp.mauSac.ten} ${ctsp.dong.ten}</th>
                <th scope="col">${ctsp.soLuongTon}</th>
                <th scope="col">${ctsp.namBh}</th>
                <th scope="col">${ctsp.moTa}</th>
                <th scope="col"><fmt:formatNumber value="${ctsp.giaBan}" pattern="#,### VND"/></th>
                <th scope="col">${ctsp.giaNhap}</th>
                <th scope="col">Action</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
