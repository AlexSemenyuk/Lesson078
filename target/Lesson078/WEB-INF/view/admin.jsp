<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Blog Home - Start Bootstrap Template</title>
    <link rel="icon" type="image/x-icon" href="<c:url value="/resources/assets/favicon.ico"/>"/>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet"/>
    <style>
        #but-home.btn {
            display: block;
            margin: 30px 0 50px 0;
            width: 100%;
            /*margin-bottom: 30vh;*/
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#!">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Blog</a></li>
            </ul>
        </div>
    </div>
</nav>
<main>
    <c:set var="lang" value="${lang}"/>
    <fmt:setLocale value="${lang}"/>
    <div class="container">
        <div class="row">
            <div class="col-xl-3"></div>
            <div class="col-xl-6 text-center">
                <img src="https://d2gg9evh47fn9z.cloudfront.net/1600px_COLOURBOX9896883.jpg" width="100%" alt="">
                <form action="<c:url value="/home"/>">
                    <button class="btn btn-primary" type="submit" id="but-home">Go home page</button>
                </form>
            </div>
            <div class="col-xl-3"></div>
        </div>
</main>


<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<%--<script src="<c:url value="/resources/js/scripts.js"/>" ></script>--%>
</body>
</html>