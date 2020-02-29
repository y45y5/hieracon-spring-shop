<section class="one-third-display flex-column margin-05 display-flex-center">
                <div class="max-width padding-05 border-box display-flex-center">
                    <img src="<c:url value="/resources/svg/${products.imageName}"/>" class="width-90">
                </div>
                <div class="max-width font-medium padding-025 text-center border-box">
                    ${products.productName}
                </div>
                <div class="max-width padding-025 text-center border-box">
                    ${products.price} ${currency}
                </div>
                <div class="max-width padding-025 text-center border-box">
                    <a href="/product/${products.id}" class="main-font-color">See product page</a>
                </div>
            </section>