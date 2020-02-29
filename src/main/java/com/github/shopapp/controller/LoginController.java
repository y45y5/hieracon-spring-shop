package com.github.shopapp.controller;

import com.github.shopapp.utility.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private Resources resources;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "accountCreated", required = false) String accountCreated){
        ModelAndView modelAndView = new ModelAndView("loginPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        if(error != null) modelAndView.addObject("errorMessage", resources.getLoginError());
        if(accountCreated != null) modelAndView.addObject("errorMessage", resources.getLoginAccountCreated());

        return modelAndView;
    }

}
