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
<div>
    <jsp:include page="${login}"/>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="nav nav-underline">
                    <li class="nav-item">
                        <a class="nav-link" href="/quan-ly/san-pham/hien-thi">Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Nhân Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container wrappaercontaier">
    <jsp:include page="${page}"/>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>