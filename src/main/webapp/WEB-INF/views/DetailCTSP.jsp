<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<style>
    .box{
        padding: 10px;
    }
    .box>label{
        margin: 10px;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"><body>
<div class="container" >
    <form:form action="/san-pham-ct/update" modelAttribute="ctsp">
        <form:input cssStyle="display: none" path="id"/>
        <form:input cssStyle="display: none" path="anh"/>
        <div class="box" style="display:flex;">
            <label>
                Sản Phảm:
                <br/>
                <select name="idSp" >
                    <c:forEach items="${listSP}" var="sp">
                        <option <c:if test="${idSP == sp.id}">selected</c:if>
                                value="${sp.id}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Dòng:
                <br/>
                <select name="idDong">
                    <c:forEach items="${listDong}" var="dong">
                        <option <c:if test="${idDong == dong.id}">selected</c:if>
                                value="${dong.id}">${dong.ten}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                Màu:
                <br/>
                <select name="idMau">
                    <c:forEach  items="${listMau}" var="mau">
                        <option <c:if test="${idMau == mau.id}">selected</c:if>
                                value="${mau.id}">${mau.ten}</option>
                    </c:forEach>
                </select>
            </label>
        </div>
        <div class="box" style="display:flex;">
            <label>
                NSX:
                <br/>
                <select name="idNsx">
                    <c:forEach items="${listNSX}" var="nsx">
                        <option <c:if test="${idNsx == nsx.id}">selected</c:if>
                                value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                Số Lượng:
                <br/>
                <form:input  path="soLuongTon"/>
            </label>
            <br/>
            <p><form:errors path="soLuongTon"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Năm Bảo Hàng:
                <br/>
                <form:input  path="namBh"/>
            </label>
            <br/>
            <p><form:errors path="namBh"/></p>
            <br/>
            <label>
                Mô tả:
                <br/>
                <form:input  path="moTa"/>
            </label>
            <br/>
            <p><form:errors path="moTa"/></p>
        </div>
        <div class="box" style="display:flex;">
            <label>
                Giá Bán:
                <br/>
                <form:input  path="giaBan"/>
            </label>
            <br/>
            <p><form:errors path="giaBan"/></p>
            <label>
                Giá Nhập:
                <br/>
                <form:input  path="giaNhap"/>
            </label>
            <br/>
            <p><form:errors path="giaNhap"/></p>
        </div>
        <br/>
        <form:button  class="btn btn-primary">update</form:button>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>



