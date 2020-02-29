package com.github.shopapp.utility;

import com.github.shopapp.model.user.BasicUser;
import com.github.shopapp.model.user.BasicUserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {

    @Autowired
    private BasicUserDaoImp basicUserDaoImp;

    public boolean checkUsername(String username){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{5,14}$");
        Matcher matcher = pattern.matcher(username);
        BasicUser otherUser = basicUserDaoImp.getByUsername(username);

        if(otherUser == null)
            return matcher.matches();
        return false;
    }

    public boolean checkPassword(String password, String repeatPassword){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{5,14}$");
        Matcher matcher = pattern.matcher(password);

        if(password.equals(repeatPassword))
            return matcher.matches();
        return false;
    }

    public boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        BasicUser otherUser = basicUserDaoImp.getByEmail(email);

        if(otherUser == null)
            return matcher.matches();
        return false;
    }

}
