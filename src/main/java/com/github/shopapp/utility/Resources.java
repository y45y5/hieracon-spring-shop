package com.github.shopapp.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("resources.properties")
public class Resources {

    @Value("${resources.css.url}")
    private String stylesheet;

    @Value("${resources.currency}")
    private String currency;

    @Value("${resources.js.url}")
    private String javascript;

    @Value("${resources.login.error}")
    private String loginError;

    @Value("${resources.register.empty.error}")
    private String registerEmptyError;

    @Value("${resources.register.invalid.error}")
    private String registerInvalidError;

    @Value("${resources.login.account.created}")
    private String loginAccountCreated;

    public String getLoginAccountCreated() {
        return loginAccountCreated;
    }

    public String getRegisterInvalidError() {
        return registerInvalidError;
    }

    public String getRegisterEmptyError() {
        return registerEmptyError;
    }

    public String getLoginError() {
        return loginError;
    }

    public String getStylesheet() {
        return stylesheet;
    }

    public String getCurrency() {
        return currency;
    }

    public String getJavascript() {
        return javascript;
    }
}
