package com.github.shopapp.controller;

import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
import com.github.shopapp.model.user.BasicRoleDaoImp;
import com.github.shopapp.model.user.BasicUser;
import com.github.shopapp.model.user.BasicUserDaoImp;
import com.github.shopapp.utility.Resources;
import com.github.shopapp.utility.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private Resources resources;
    @Autowired
    private Validator validator;
    @Autowired
    private BasicUserDaoImp basicUserDaoImp;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage(@RequestParam(value = "emptyError", required = false) String emptyError,
                                     @RequestParam(value = "invalidError", required = false) String invalidError){
        ModelAndView modelAndView = new ModelAndView("registerPage");
        modelAndView.addObject("stylesheet", resources.getStylesheet());
        if(emptyError!=null) modelAndView.addObject("errorMessage", resources.getRegisterEmptyError());
        if(invalidError!=null) modelAndView.addObject("errorMessage", resources.getRegisterInvalidError());

        return modelAndView;
    }

    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public ModelAndView registerAction(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "repeatPassword") String repeatPassword,
            @RequestParam(name = "email") String email) {
        ModelAndView modelAndView = new ModelAndView("redirect:/register");

        if (!username.isEmpty() && !password.isEmpty() && !repeatPassword.isEmpty() && !email.isEmpty()){
            if (validator.checkUsername(username) && validator.checkEmail(email) && validator.checkPassword(password, repeatPassword)) {
                BasicRoleDaoImp basicRoleDaoImp = new BasicRoleDaoImp();
                ProductDaoImp productDaoImp = new ProductDaoImp();
                BasicUser basicUser = new BasicUser(username, new BCryptPasswordEncoder().encode(password), true, email, basicRoleDaoImp.getFullList().get(0));

                Product product = productDaoImp.getFullList().get(0);
                basicUser.addProduct(product);
                basicUserDaoImp.save(basicUser);
                basicUser.getCartOrder().getProducts().remove(product);
                basicUserDaoImp.update(basicUser);

                modelAndView.setViewName("redirect:/login?accountCreated");
            } else modelAndView.setViewName("redirect:/register?invalidError");
        } else modelAndView.setViewName("redirect:/register?emptyError");
        return modelAndView;
    }

}
