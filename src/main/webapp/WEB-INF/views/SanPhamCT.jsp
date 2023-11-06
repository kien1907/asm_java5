<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div class="container">
    <form action="/san-pham/add" method="post" enctype="multipart/form-data">
        chọn File:
        <input type="file" name="file">
        <button>gửi</button>
    </form>
    <div style="display: flex">
        <a style="padding: 10px" href="/san-pham-ct/hien-thi?p=0">|&lt;</a>
        <a style="padding: 10px"
           href="/san-pham-ct/hien-thi?p=${page.number - 1 < 0 ? page.totalPages -1 : page.number - 1}">
            &lt;&lt;</a>
        <a style="padding: 10px"
           href="/san-pham-ct/hien-thi?p=${page.number + 1 > page.totalPages - 1  ? 0 : page.number + 1}">
            &gt;&gt;</a>
        <a style="padding: 10px" href="/san-pham-ct/hien-thi?p=${page.totalPages -1}">&gt;|</a>
    </div>
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
            <th scope="col">Gia bán</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ctsp" items="${page.content}" varStatus="i">
            <tr>
                <th scope="col">${i.index}</th>
                <th scope="col">
                    <img width="100px" src="${ctsp.anh}">
                </th>
                <th scope="col">${ctsp.dong.ten} ${ctsp.sanPham.ten} ${ctsp.mauSac.ten}</th>
                <th scope="col">${ctsp.nsx.ten}</th>
                <th scope="col">${ctsp.soLuongTon}</th>
                <th scope="col">${ctsp.namBh}</th>
                <th scope="col">${ctsp.moTa}</th>
                <th scope="col"><fmt:formatNumber value="${ctsp.giaBan}" pattern="#,### VND"/></th>
                <th scope="col"><fmt:formatNumber value="${ctsp.giaNhap}" pattern="#,### VND"/></th>
                <th scope="col">
                    <a href="/san-pham-ct/delete/${ctsp.id}" type="button" class="btn btn-primary">Xóa</a>
                    <a href="/san-pham-ct/detail/${ctsp.id}" type="button" class="btn btn-primary">Detail</a>
                    <a href="/san-pham-ct/add-cart/${ctsp.id}" type="button" class="btn btn-primary">Thêm Vào Giỏ Hàng</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

