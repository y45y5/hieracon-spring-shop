package com.github.shopapp.controller;

import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
import com.github.shopapp.utility.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private Resources resources;
    @Autowired
    private ProductDaoImp productDaoImp;
    private List<Product> products = new ArrayList<>();

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchPage(){
        ModelAndView modelAndView = new ModelAndView("searchPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("script", resources.getJavascript());
        modelAndView.addObject("currency", resources.getCurrency());
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchAction(@RequestParam(name = "search") String searchPhrase){
        ModelAndView modelAndView = new ModelAndView("redirect:/search");
        products = new ArrayList<>();
        for(Product product : productDaoImp.getFullList())
            if(product.getProductName().toUpperCase().contains(searchPhrase.toUpperCase())) products.add(product);
        Collections.reverse(products);
        return modelAndView;
    }

}
