<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Register</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

        <section class="bottom-border width-50 margin-auto display-flex-center">
            <form action="<c:url value="/registerAction"/>" class="width-90 flex-column display-flex-center" method="POST">
                <img src="<c:url value="/resources/svg/logo.svg"/>" class="form-logo">
                <label class="width-90">Username</label>
                <input type="text" name="username" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                <label class="width-90">Password</label>
                <input type="password" name="password" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                <label class="width-90">Repeat password</label>
                <input type="password" name="repeatPassword" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                <label class="width-90">E-mail address</label>
                <input type="text" name="email" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                <div class="error max-width text-center">${errorMessage}</div>
                <div class="width-90 margin-05 display-flex-space-between border-box">
                    <a href="/login" class="text-decoration-underline main-font-color">Log in</a>
                    <input type="submit" value="Register" class="gradient-button select-anim margin-05">
                </div>
            </form>
        </section>

        <section class="width-50 margin-auto border-box padding-05">
            <div>1. Username and password must contain only designated characters. ([A-Z] & [0-9])</div>
            <div>2. Username and password must be at least 5 characters long.</div>
            <div>3. Username and password can be 14 max characters long.</div>
            <div>4. Passwords must match.</div>
            <div>5. Email address must be in valid format. (example@example)</div>
        </section>

    </div>

    <section class="fill"></section>

</body>
</html>