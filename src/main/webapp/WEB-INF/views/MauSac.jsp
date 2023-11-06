<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>

<div class="row">
<div class="col-5">
    <form:form action="/mau-sac/add" modelAttribute="mausac">
        <form:input cssStyle="display: none" path="id"/>
        <form:input cssStyle="display: none" path="ma"/>
        <label>
            Tên:
            <br/>
            <form:input  path="ten"/>
        </label>
        <br/>
        <p><form:errors path="ten"/></p>
        <br/>
        <form:button class="btn btn-primary">Save</form:button>
        <form:button formaction="/mau-sac/update" class="btn btn-primary">update</form:button>
    </form:form>
</div>
<div class="col-7">
    <div style="display: flex">
        <a style="padding: 10px" href="/mau-sac/hien-thi?p=0">|&lt;</a>
        <a style="padding: 10px"
           href="/mau-sac/hien-thi?p=${page.number - 1 < 0 ? page.totalPages -1 : page.number - 1}">
            &lt;&lt;</a>
        <a style="padding: 10px"
           href="/mau-sac/hien-thi?p=${page.number + 1 > page.totalPages - 1  ? 0 : page.number + 1}">
            &gt;&gt;</a>
        <a style="padding: 10px" href="/mau-sac/hien-thi?p=${page.totalPages -1}">&gt;|</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mau" items="${page.content}" varStatus="i">
            <tr>
                <th scope="col">${i.index}</th>
                <th scope="col">${mau.ma}</th>
                <th scope="col">${mau.ten}</th>
                <th scope="col">
                    <a href="/mau-sac/delete/${mau.id}" type="button" class="btn btn-primary">Xóa</a>
                    <a href="/mau-sac/detail/${mau.id}" type="button" class="btn btn-primary">Detail</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>


