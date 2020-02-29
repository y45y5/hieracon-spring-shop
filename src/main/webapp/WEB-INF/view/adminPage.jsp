<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <link href="<c:url value="${stylesheet}"/>" type="text/css" rel="stylesheet">
    <link href="<c:url value="/resources/favicon.ico"/>" rel="icon" type="image/x-icon" />
    <title>Hieracon | Admin</title>
</head>
<body class="main-background main-font-color">

<jsp:directive.include file = "includes/header.jsp" />

<section class="fill"></section>

    <div class="main-wrapper">

            <section class="max-width display-flex-center border-box flex-wrap">
                <c:forEach items="${users}" var="users">
                    <jsp:directive.include file = "includes/users.jsp" />
                </c:forEach>
            </section>

    </div>
    <section class="fill"></section>
    <script src="<c:url value="${script}"/>"></script>
</body>
</html>