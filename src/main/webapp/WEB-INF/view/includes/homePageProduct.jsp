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
                        <a href="/product/${product.id}" class="text-decoration-underline main-font-color">See product page</a>
                    </div>
                </div>
            </div>
        </section>