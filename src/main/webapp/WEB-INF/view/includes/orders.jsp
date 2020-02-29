<section class="one-third-display flex-column margin-05 display-flex-center">
                <div class="max-width padding-05 border-box display-flex-center">
                    <img src="<c:url value="/resources/svg/delivery.svg"/>" class="width-90">
                </div>
                <div class="max-width font-medium padding-025 text-center border-box">
                    Order #${orders.id}
                </div>
                <div class="max-width font-medium padding-025 text-center border-box">
                    Status: ${orders.orderStatus}
                </div>
                <div class="max-width padding-025 text-center border-box">
                    Price: ${orders.totalPrice} ${currency}
                </div>
                <div class="max-width padding-025 text-center border-box">
                    <a href="/profile/orders/${orders.id}" class="main-font-color">See full order</a>
                </div>
            </section>