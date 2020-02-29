<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Home</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

<div class="main-wrapper">

        <jsp:directive.include file = "includes/homePageProduct.jsp" />

        <section class="max-width display-flex-center border-box">

            <c:forEach items="${products}" var="products" begin="0" end="2">
                <jsp:directive.include file = "includes/otherProduct.jsp" />
            </c:forEach>

        </section>

        <section class="max-width border-box display-flex-center">
            <div class="width-90">

                <div class="font-medium text-justify padding-05 margin-1 border-box display-flex-center">
                    <div class="width-50 display-flex-center">
                        <div class="width-90 user-select-none first-line-title">
                        High quality. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean massa nunc, tempor bibendum eros ut, maximus faucibus quam. Nam quis interdum metus. Aenean nisl nulla, volutpat sed placerat ut, eleifend sed arcu. Ut ultricies interdum velit, non fermentum felis dignissim in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                        </div>
                    </div>
                    <div class="width-50 display-flex-center">
                        <img src="<c:url value="/resources/svg/quality.svg"/>" class="width-90">
                    </div>
                </div>

                <div class="font-medium text-justify padding-05 margin-1 border-box display-flex-center">
                    <div class="width-50 display-flex-center">
                        <img src="<c:url value="/resources/svg/money.svg"/>" class="width-90">
                    </div>
                    <div class="width-50 display-flex-center">
                        <div class="width-90 user-select-none first-line-title">
                        Low prices. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean massa nunc, tempor bibendum eros ut, maximus faucibus quam. Nam quis interdum metus. Aenean nisl nulla, volutpat sed placerat ut, eleifend sed arcu. Ut ultricies interdum velit, non fermentum felis dignissim in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                        </div>
                    </div>
                </div>

                <div class="font-medium text-justify padding-05 margin-1 border-box display-flex-center">
                    <div class="width-50 display-flex-center">
                        <div class="width-90 user-select-none first-line-title">
                        Fast delivery. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean massa nunc, tempor bibendum eros ut, maximus faucibus quam. Nam quis interdum metus. Aenean nisl nulla, volutpat sed placerat ut, eleifend sed arcu. Ut ultricies interdum velit, non fermentum felis dignissim in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                        </div>
                    </div>
                    <div class="width-50 display-flex-center">
                        <img src="<c:url value="/resources/svg/delivery.svg"/>" class="width-90">
                    </div>
                </div>

            </div>
        </section>

        <section class="max-width display-flex-center border-box">

            <c:forEach items="${products}" var="products" begin="3" end="5">
                <jsp:directive.include file = "includes/otherProduct.jsp" />
            </c:forEach>

        </section>

    </div>

<section class="fill"></section>

</body>
</html>