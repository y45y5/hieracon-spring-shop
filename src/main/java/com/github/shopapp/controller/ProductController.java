package com.github.shopapp.controller;

import com.github.shopapp.exceptions.ProductNotFoundException;
import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
import com.github.shopapp.utility.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private Resources resources;
    @Autowired
    private ProductDaoImp productDaoImp;

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ModelAndView productPage(@PathVariable int productId) throws ProductNotFoundException {
        ModelAndView modelAndView = new ModelAndView("productPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("currency", resources.getCurrency());

        Product product = productDaoImp.getProductById(productId);
        modelAndView.addObject("product", product);

        List<Product> products = productDaoImp.getFullList();
        Collections.shuffle(products);
        modelAndView.addObject("products", products);

        return modelAndView;
    }

}
