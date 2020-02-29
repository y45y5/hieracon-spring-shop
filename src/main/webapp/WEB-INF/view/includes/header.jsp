<header class="display-flex-center position-fixed max-width main-background">
        <section class="width-90 bottom-border display-flex-space-between">
            <a href="/" class="margin-05"><img src="<c:url value="/resources/svg/logo.svg"/>" class="header-logo"></a>
            <nav class="margin-05 width-50 user-select-none display-flex-space-between">
                <c:choose>
                    <c:when test="${not empty pageContext.request.userPrincipal}">
                        <a href="<c:url value="/logout" />">Log out</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value="/login" />">Log in</a>
                    </c:otherwise>
                </c:choose>
                <a href="/search">Search</a>
                <a href="/profile/orders">Orders</a>
                <a href="/profile/cart">Cart</a>
            </nav>
        </section>
</header>