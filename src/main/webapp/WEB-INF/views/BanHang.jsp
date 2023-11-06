<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div class="row">
    <div class="col-7">
        <div class="hoadon">
            <p>Hóa Đơn</p>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Mã Nhân Viên</th>
                    <th scope="col">Mã Khác Khách Hàng</th>
                    <th scope="col">Ngày Tạo </th>
                    <th scope="col">Action </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageHoaDon.content}" var="hd" varStatus="i">
                    <tr>
                        <th scope="col">${i.index +1}</th>
                        <th scope="col">${hd.ma}</th>
                        <th scope="col">${hd.nhanVien.ma}</th>
                        <th scope="col">${hd.khachHang.ma}</th>
                        <th scope="col">${hd.ngayTao}</th>
                        <th scope="col">
                            <a type="button" class="btn btn-primary">Chọn</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="display: flex">
                <a style="padding: 10px" href="/hoa-don/hien-thi?p=0">|&lt;</a>
                <a style="padding: 10px"
                   href="/hoa-don/hien-thi?p=${pageHoaDon.number - 1 < 0 ? pageHoaDon.totalPages -1 : pageHoaDon.number - 1}">
                    &lt;&lt;</a>
                <a style="padding: 10px"
                   href="/hoa-don/hien-thi?p=${pageHoaDon.number + 1 > pageHoaDon.totalPages - 1  ? 0 : pageHoaDon.number + 1}">
                    &gt;&gt;</a>
                <a style="padding: 10px" href="/hoa-don/hien-thi?p=${pageHoaDond.totalPages -1}">&gt;|</a>
            </div>
        </div>
        <div class="hoadonCT">
            <p>Hóa Đơn</p>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Mã Nhân Viên</th>
                    <th scope="col">Mã Khác Khách Hàng</th>
                    <th scope="col">Ngày Tạo </th>
                    <th scope="col">Action </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageHoaDonCT}" var="hd" varStatus="i">
                    <tr>
                        <th scope="col">${i.index +1}</th>
                        <th scope="col">${hd.ma}</th>
                        <th scope="col">${hd.nhanVien.ma}</th>
                        <th scope="col">${hd.khachHang.ma}</th>
                        <th scope="col">${hd.ngayTao}</th>
                        <th scope="col">
                            <a type="button" class="btn btn-primary">Chọn</a>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="sanpham">
            <p>Sản Phẩm</p>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ảnh</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Giá Bán</th>
                    <th scope="col">Số lượng Tồn</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ctsp" items="${pagectsp}" varStatus="i">
                    <tr>
                        <th scope="col">${i.index + 1}</th>
                        <th scope="col">${ctsp.anh}</th>
                        <th scope="col">${ctsp.ma}</th>
                        <th scope="col">${ctsp.ten}</th>
                        <th scope="col">${ctsp.giaBan}</th>
                        <th scope="col">${ctsp.soLuongTon}</th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--            <div style="display: flex">--%>
<%--                <a style="padding: 10px" href="/san-pham-ct-bh/hien-thi?p=0">|&lt;</a>--%>
<%--                <a style="padding: 10px"--%>
<%--                   href="/san-pham-ct-bh/hien-thi?p=${pagectsp.number - 1 < 0 ? pagectsp.totalPages -1 : pagectsp.number - 1}">--%>
<%--                    &lt;&lt;</a>--%>
<%--                <a style="padding: 10px"--%>
<%--                   href="/san-pham-ct-bh/hien-thi?p=${pagectsp.number + 1 > pagectsp.totalPages - 1  ? 0 : pagectsp.number + 1}">--%>
<%--                    &gt;&gt;</a>--%>
<%--                <a style="padding: 10px" href="/san-pham-ct-bh/hien-thi?p=${pagectsp.totalPages -1}">&gt;|</a>--%>
<%--            </div>--%>
        </div>
    </div>
    <div class="col-5">
        <h1>Hello</h1>
    </div>
</div>





