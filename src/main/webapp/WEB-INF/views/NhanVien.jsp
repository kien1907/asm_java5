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
    <form:form action="/nhan-vien/add" modelAttribute="nhanvien">
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
                Giới Tính:
                <br/>
                <form:radiobutton  path="gioiTinh" value="Nam"/> Nam
                <form:radiobutton path="gioiTinh" value="Nu"/> Nữ
            </label>
            <br/>
            <p><form:errors path="tenDem"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Ngày Sinh:
                <br/>
                <input name="ngaySinh" value="${nv.ngaySinh}" type="date">
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
                Của Hàng:
                <br/>
                <select name="idCuaHang">
                    <c:forEach var="ch" items="${listch}">
                    <option <c:if test="${nv.cuaHang.id == ch.id}">selected</c:if> value="${ch.id}"> ${ch.ten} </option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                Chức vụ:
                <br/>
                <select name="idChucVu">
                    <c:forEach var="cv" items="${listcv}">
                        <option <c:if test="${nv.chucVu.id == cv.id}">selected</c:if> value="${cv.id}"> ${cv.ten} </option>
                    </c:forEach>
                </select>
            </label>
        </div>
        <br/>
        <form:checkbox path="trangThai" value="1"/> đã nghỉ
        <br/>
        <form:button class="btn btn-primary">Save</form:button>
        <form:button formaction="/nhan-vien/update" class="btn btn-primary">update</form:button>
    </form:form>
</div>
<div class="col-8">
    <div style="display: flex">
        <a style="padding: 10px" href="/nhan-vien/hien-thi?p=0">|&lt;</a>
        <a style="padding: 10px"
           href="/nhan-vien/hien-thi?p=${page.number - 1 < 0 ? page.totalPages -1 : page.number - 1}">
            &lt;&lt;</a>
        <a style="padding: 10px"
           href="/nhan-vien/hien-thi?p=${page.number + 1 > page.totalPages - 1  ? 0 : page.number + 1}">
            &gt;&gt;</a>
        <a style="padding: 10px" href="/nhan-vien/hien-thi?p=${page.totalPages -1}">&gt;|</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Họ</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Tên</th>
            <th scope="col">Giới Tính</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SDT</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Của Hàng </th>
            <th scope="col">Chức Vụ</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nhanvien" items="${page.content}" varStatus="i">
            <tr>
                <th scope="col">${i.index}</th>
                <th scope="col">${nhanvien.ma}</th>
                <th scope="col">${nhanvien.ho}</th>
                <th scope="col">${nhanvien.tenDem}</th>
                <th scope="col">${nhanvien.ten}</th>
                <th scope="col">${nhanvien.gioiTinh}</th>
                <th scope="col">${nhanvien.ngaySinh}</th>
                <th scope="col">${nhanvien.diaChi}</th>
                <th scope="col">${nhanvien.sdt}</th>
                <th scope="col">${nhanvien.matKhau}</th>
                <th scope="col">${nhanvien.cuaHang.ten}</th>
                <th scope="col">${nhanvien.chucVu.ten}</th>
                <th scope="col">${nhanvien.trangThai == 0 ? "Đang làm":"Đã nghỉ"}</th>
                <th scope="col">
                    <a href="/nhan-vien/delete/${nhanvien.id}" type="button" class="btn btn-primary">Xóa</a>
                    <a href="/nhan-vien/detail/${nhanvien.id}" type="button" class="btn btn-primary">Detail</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>


