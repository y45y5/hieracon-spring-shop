<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Orders</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

            <section class="max-width display-flex-center border-box flex-wrap">
                <c:choose>
                    <c:when test="${not empty orders}">
                        <c:forEach items="${orders}" var="orders">
                            <jsp:directive.include file = "includes/orders.jsp" />
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="text-center max-width font-big">
                            You don't have any orders yet.
                        </div>
                    </c:otherwise>
                </c:choose>
                <c:forEach items="${orders}" var="orders">
                    <jsp:directive.include file = "includes/orders.jsp" />
                </c:forEach>
            </section>

    </div>
    <section class="fill"></section>
    <script src="<c:url value="${script}"/>"></script>
</body>
</html>