<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Search</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

    <section class="max-width">
                <form method="POST" action="<c:url value="/search"/>" class="max-width margin-auto display-flex-center">
                    <input type="text" id="search" name="search" class="border-radius-05 margin-05 padding-05 width-90 select-anim">
                    <input type="submit" value="Search" class="gradient-button select-anim margin-05">
                </form>
                <div class="max-width margin-auto display-flex-center flex-wrap">
                    <button class="gradient-button select-anim margin-05" onClick="searchWithTag('J')">J Series</button>
                    <button class="gradient-button select-anim margin-05" onClick="searchWithTag('TITAN')">Titan</button>
                    <button class="gradient-button select-anim margin-05" onClick="searchWithTag('Q')">Q Series</button>
                    <button class="gradient-button select-anim margin-05" onClick="searchWithTag('COBALT')">Cobalt</button>
                    <button class="gradient-button select-anim margin-05" onClick="searchWithTag('NIGHT')">Night</button>
                </div>
    </section>

            <section class="max-width display-flex-center border-box flex-wrap">
                <c:forEach items="${products}" var="products">
                    <jsp:directive.include file = "includes/otherProduct.jsp" />
                </c:forEach>
            </section>

    </div>
    <section class="fill"></section>
    <script src="<c:url value="${script}"/>"></script>
</body>
</html>