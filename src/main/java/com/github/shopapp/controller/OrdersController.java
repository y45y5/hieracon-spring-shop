package com.github.shopapp.controller;

import com.github.shopapp.model.orders.Orders;
import com.github.shopapp.model.orders.Status;
import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.user.BasicUser;
import com.github.shopapp.model.user.BasicUserDaoImp;
import com.github.shopapp.utility.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private Resources resources;
    @Autowired
    private BasicUserDaoImp basicUserDaoImp;

    @RequestMapping(value = "/profile/orders", method = RequestMethod.GET)
    public ModelAndView ordersPage(Principal principal){
        ModelAndView modelAndView = new ModelAndView("ordersPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("currency", resources.getCurrency());

        BasicUser basicUser = basicUserDaoImp.getByUsername(principal.getName());
        List<Orders> orders = new ArrayList<>();
        for (Orders order : basicUser.getOrders())
            if(!order.getOrderStatus().equals(Status.IN_CART.toString())) orders.add(order);
        modelAndView.addObject("orders", orders);

        return modelAndView;
    }

    @RequestMapping(value = "/profile/orders/{orderId}", method = RequestMethod.GET)
    public ModelAndView oneOrderPage(@PathVariable int orderId, Principal principal){
        ModelAndView modelAndView = new ModelAndView("oneOrderPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("currency", resources.getCurrency());

        BasicUser basicUser = basicUserDaoImp.getByUsername(principal.getName());
        for(Orders order : basicUser.getOrders()){
            if(order.getId() == orderId) {
                List<Product> products = order.getProducts();
                Collections.reverse(products);
                modelAndView.addObject("products", products);
                return modelAndView;
            }
        }
        modelAndView.setViewName("redirect:/profile/orders");
        return modelAndView;
    }

}
