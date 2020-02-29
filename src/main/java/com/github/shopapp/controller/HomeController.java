package com.github.shopapp.controller;

import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
import com.github.shopapp.utility.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @Autowired
    private Resources resources;
    @Autowired
    private ProductDaoImp productDaoImp;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("homePage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("currency", resources.getCurrency());

        Product product = productDaoImp.getFullList().get(new Random().nextInt(productDaoImp.getFullList().size()));
        modelAndView.addObject("product", product);

        List<Product> products = productDaoImp.getFullList();
        Collections.shuffle(products);
        modelAndView.addObject("products", products);

        return modelAndView;
    }

}
