<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<style>
    .box{
        padding: 10px;
    }
    .box>label{
        margin: 10px;
    }
</style>

<div class="row">
<div class="col-4">
    <form:form action="/khach-hang/add" modelAttribute="khachhang">
        <form:input cssStyle="display: none" path="id"/>
        <form:input cssStyle="display: none" path="ma"/>
        <div class="box" style="display:flex;">
            <label>
                Họ:
                <br/>
                <form:input  path="ho"/>
            </label>
            <br/>
            <p><form:errors path="ho"/></p>
            <br/>
            <label>
                Tên Đệm:
                <br/>
                <form:input  path="tenDem"/>
            </label>
            <br/>
            <p><form:errors path="tenDem"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Tên:
                <br/>
                <form:input  path="ten"/>
            </label>
            <br/>
            <p><form:errors path="ten"/></p>
            <br/>
            <label>
            </label>
            <br/>
            <p><form:errors path="tenDem"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Ngày Sinh:
                <br/>
                <input name="ngaySinh" value="${kh.ngaySinh}" type="date">
            </label>
            <br/>
            <label>
                Địa Chỉ:
                <br/>
                <form:input  path="diaChi"/>
            </label>
            <br/>
            <p><form:errors path="diaChi"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Số Điện Thoại:
                <br/>
                <form:input  path="sdt"/>
            </label>
            <br/>
            <p><form:errors path="sdt"/></p>
            <br/>
            <label>
                Mật Khẩu:
                <br/>
                <form:input  path="matKhau"/>
            </label>
            <br/>
            <p><form:errors path="matKhau"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Thành Phố:
                <form:input  path="thanhPho"/>
            </label>
            <br/>
            <p><form:errors path="thanhPho"/></p>
            <label>
                Quốc Gia:
                <form:input  path="quocGia"/>
                <br/>
            </label>
            <br/>
            <p><form:errors path="quocGia"/></p>
        </div>
        <br/>
        <form:button class="btn btn-primary">Save</form:button>
        <form:button formaction="/khach-hang/update" class="btn btn-primary">update</form:button>
    </form:form>
</div>
<div class="col-8">
    <div style="display: flex">
        <a style="padding: 10px" href="/khach-hang/hien-thi?p=0">|&lt;</a>
        <a style="padding: 10px"
           href="/khach-hang/hien-thi?p=${page.number - 1 < 0 ? page.totalPages -1 : page.number - 1}">
            &lt;&lt;</a>
        <a style="padding: 10px"
           href="/khach-hang/hien-thi?p=${page.number + 1 > page.totalPages - 1  ? 0 : page.number + 1}">
            &gt;&gt;</a>
        <a style="padding: 10px" href="/khach-hang/hien-thi?p=${page.totalPages -1}">&gt;|</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Họ</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
            <th scope="col">SDT</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="kh" items="${page.content}" varStatus="i">
            <tr>
                <th scope="col">${i.index}</th>
                <th scope="col">${kh.ma}</th>
                <th scope="col">${kh.ho}</th>
                <th scope="col">${kh.tenDem}</th>
                <th scope="col">${kh.ten}</th>
                <th scope="col">${kh.ngaySinh}</th>
                <th scope="col">${kh.diaChi}</th>
                <th scope="col">${kh.thanhPho}</th>
                <th scope="col">${kh.quocGia}</th>
                <th scope="col">${kh.sdt}</th>
                <th scope="col">${kh.matKhau}</th>
                <th scope="col">
                    <a href="/khach-hang/delete/${kh.id}" type="button" class="btn btn-primary">Xóa</a>
                    <a href="/khach-hang/detail/${kh.id}" type="button" class="btn btn-primary">Detail</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>


