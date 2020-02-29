package com.github.shopapp.controller;

import com.github.shopapp.model.orders.OrdersDaoImp;
import com.github.shopapp.model.user.BasicUserDaoImp;
import com.github.shopapp.utility.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    private Resources resources;
    @Autowired
    private BasicUserDaoImp basicUserDaoImp;
    @Autowired
    private OrdersDaoImp ordersDaoImp;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView modelAndView = new ModelAndView("adminPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("users", basicUserDaoImp.getFullList());

        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete/{username}", method = RequestMethod.GET)
    public ModelAndView adminDeleteUser(@PathVariable String username, Principal principal){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin");
        if(username.equals(principal.getName())) return modelAndView;
        basicUserDaoImp.delete(basicUserDaoImp.getByUsername(username));
        return modelAndView;
    }

}
