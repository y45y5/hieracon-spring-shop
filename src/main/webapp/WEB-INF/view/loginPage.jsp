<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Login</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

        <section class="bottom-border width-50 margin-auto display-flex-center">
            <form action="<c:url value="/login"/>" class="width-90 flex-column display-flex-center" method="POST">
                <img src="<c:url value="/resources/svg/logo.svg"/>" class="form-logo">
                <label class="width-90">Username</label>
                <input type="text" name="username" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                <label class="width-90">Password</label>
                <input type="password" name="password" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                <div class="error max-width text-center">${errorMessage}</div>
                <div class="width-90 margin-05 display-flex-space-between border-box">
                    <a href="/register" class="text-decoration-underline main-font-color">Register</a>
                    <input type="submit" value="Log in" class="gradient-button select-anim margin-05">
                </div>
            </form>
        </section>

    </div>

    <section class="fill"></section>

</body>
</html>