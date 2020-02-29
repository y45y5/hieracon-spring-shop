<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Cart</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

    <section class="max-width display-flex-right">
        <div class="display-flex-center">
            Total price: ${totalPrice} ${currency}
        </div>
        <form method="POST" action="/profile/cartconfirm" class="display-flex-center">
            <input type="submit" value="Place order" class="gradient-button select-anim margin-05">
        </form>
    </section>

    <section class="max-width display-flex-center border-box flex-wrap">
        <c:choose>
            <c:when test="${not empty products}">
                <c:forEach items="${products}" var="products">
                    <jsp:directive.include file = "includes/otherProductInCart.jsp" />
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div class="text-center max-width font-big">
                You don't have anything in cart yet.
                </div>
            </c:otherwise>
         </c:choose>
    </section>

    </div>

<section class="fill"></section>

</body>
</html>