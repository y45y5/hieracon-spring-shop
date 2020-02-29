package com.github.shopapp.controller;

import com.github.shopapp.exceptions.ProductNotFoundException;
import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
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

@Controller
public class CartController {

    @Autowired
    private Resources resources;
    @Autowired
    private BasicUserDaoImp basicUserDaoImp;
    @Autowired
    private ProductDaoImp productDaoImp;

    @RequestMapping(value = "profile/cart", method = RequestMethod.GET)
    public ModelAndView cartPage(Principal principal){
        ModelAndView modelAndView = new ModelAndView("cartPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        modelAndView.addObject("currency", resources.getCurrency());
        BasicUser basicUser = basicUserDaoImp.getByUsername(principal.getName());

        modelAndView.addObject("products", basicUser.getCartOrder().getProducts());
        int totalPrice = 0;
        for (Product product : basicUser.getCartOrder().getProducts())
            totalPrice += product.getPrice();
        modelAndView.addObject("totalPrice", totalPrice);

        return modelAndView;
    }

    @RequestMapping(value = "/profile/cartconfirm", method = RequestMethod.POST)
    public ModelAndView confirmCart(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("redirect:/profile/orders");
        BasicUser basicUser = basicUserDaoImp.getByUsername(principal.getName());
        if(basicUser.getCartOrder().getProducts().isEmpty()) {
            modelAndView.setViewName("redirect:/profile/cart");
            return modelAndView;
        }
        basicUser.moveOrderFromCart();
        basicUserDaoImp.update(basicUser);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/addtocart/{productId}", method = RequestMethod.POST)
    public ModelAndView addToCart(@PathVariable int productId, Principal principal) throws ProductNotFoundException {
        ModelAndView modelAndView = new ModelAndView("redirect:/product/{productId}");
        BasicUser basicUser = basicUserDaoImp.getByUsername(principal.getName());
        basicUser.addProduct(productDaoImp.getProductById(productId));
        basicUserDaoImp.update(basicUser);
        return modelAndView;
    }

    @RequestMapping(value = "/profile/delete/{productId}", method = RequestMethod.POST)
    public ModelAndView deleteFromCart(@PathVariable int productId, Principal principal) throws ProductNotFoundException{
        ModelAndView modelAndView = new ModelAndView("redirect:/profile/cart");
        BasicUser basicUser = basicUserDaoImp.getByUsername(principal.getName());
        for(Product product : basicUser.getCartOrder().getProducts()){
            if(product.getId() == productId){
                basicUser.getCartOrder().getProducts().remove(product);
                break;
            }
        }
        basicUserDaoImp.update(basicUser);

        return modelAndView;
    }

}
