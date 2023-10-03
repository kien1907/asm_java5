<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        .fiter > button {
            margin: 0 15px 0 0;
            display: flex;
            align-items: center;
        }
        .card{
            border: none;
            text-decoration: none;
        }
        .card:hover{
            border: 0.3px solid darkgray;
            transition: all 0.3s ease-in-out;
            cursor: pointer;
        }
        .card img:hover{
            transform: scale(1.05);
        }
        .wrappaercontaier{
            margin-top: 30px;
        }
        .nav{
            /*flex-direction: row-reverse;*/
            /*text-align: right;*/
        }
        .login{

        }
        .LoginAndRegister{
            position: absolute;
            display: none;
            z-index: 4;
            right: 20px;
            background-color: white;
            width: 270px;
            text-align: center;
            border: 1px solid black;
            top: 40px;
        }
        .login:hover .LoginAndRegister{
            display: block;
        }
        .arrow-up {
            position: absolute;
            top: -6px;
            right: 40px;
            width: 0;
            height: 0;
            border-left: 5px solid transparent;
            border-right: 5px solid transparent;

            border-bottom: 5px solid black;
        }
    </style>
</head>
<body>
<nav>
    <jsp:include page="${login}"/>
<%--    <%@include file="Login1.jsp"%>--%>
</nav>
<div class="container wrappaercontaier">
    <header class="row">
        <div class="col-8">
            <div id="carouselExampleIndicators" class="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                            aria-label="Slide 4"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4"
                            aria-label="Slide 5"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://cdn.tgdd.vn/2023/08/banner/v25-800-200-800x200.png" class="d-block w-100"
                             alt="...">
                    </div>
                    <div class="carousel-item active">
                        <img src="https://cdn.tgdd.vn/2023/09/banner/IP15-1200-300-1200x300.png" class="d-block w-100"
                             alt="...">
                    </div>
                    <div class="carousel-item active">
                        <img src="https://cdn.tgdd.vn/2023/08/banner/SP-800-200-800x200.png" class="d-block w-100"
                             alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn.tgdd.vn/2023/09/banner/xahang-1200-300-1200x300.png" class="d-block w-100"
                             alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn.tgdd.vn/2023/09/banner/z5-800-200-800x200-1.png" class="d-block w-100"
                             alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <div class="col-4">
            <img src="https://cdn.tgdd.vn/2023/08/banner/sticky-s21fe-390x97.png">
            <img src="https://cdn.tgdd.vn/2023/08/banner/a58-390-97-390x97.png" style="margin-top: 20px">
        </div>
    </header>
    <div class="content row" style="margin-top: 30px">
        <div class="fiter col-3" >
            <div class="row">
                <form:form action="" method="get" modelAttribute="filter">
                    <div class="hang">
                        <h4>Nhà Sản Xuất</h4>
                        <c:forEach var="nsx" items="${listNSX}">
                            <label class="col-4">
                                <form:checkbox  path="listIdNSX" value="${nsx.id}"/> ${nsx.ten}
                            </label>
                        </c:forEach>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="products col-9">
            <div class="row">
                <c:forEach var="spct" items="${listCTSP}">
                    <a class="card col-4" href="/detailsp/${spct.id}"  style="width: 19.7rem;">
                        <img src="${spct.anh}" class="card-img-top" style="margin-top: 10px" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${spct.sanPham.ten}</h5>
                            <h6 class="card-title" style="color: red"><ftm:formatNumber value="${spct.giaBan}" pattern="#,### VND"/></h6>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>