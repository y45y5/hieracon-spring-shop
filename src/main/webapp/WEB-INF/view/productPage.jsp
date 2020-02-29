<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | ${product.productName}</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

        <section class="max-width display-flex-center border-box">
            <div class="width-90 display-flex-center">
                <div class="width-50 border-box display-flex-center">
                    <img src="<c:url value="/resources/svg/${product.imageName}"/>" class="width-90 margin-05">
                </div>
                <div class="width-50 flex-column display-flex-center">
                    <div class="max-width font-big padding-05 border-box">
                        ${product.productName}
                    </div>
                    <div class="max-width padding-05 border-box">
                        ${product.aboutProduct}
                    </div>
                    <div class="max-width padding-05 border-box display-flex-space-between">
                        <span>${product.price} ${currency}</span>
                        <c:if test="${empty pageContext.request.userPrincipal}">
                            <a href="/login" class="gradient-button display-flex-center text-decoration-none">Login to add to cart</a>
                        </c:if>
                        <c:if test="${not empty pageContext.request.userPrincipal}">
                            <form method="POST" action="<c:url value="/profile/addtocart/${product.id}"/>">
                                <input type="submit" value="Add to cart" class="gradient-button select-anim margin-05">
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </section>

        <section class="max-width display-flex-center border-box">

                    <c:forEach items="${products}" var="products" begin="0" end="2">
                        <jsp:directive.include file = "includes/otherProduct.jsp" />
                    </c:forEach>

        </section>

    </div>
<section class="fill"></section>
</body>
</html>