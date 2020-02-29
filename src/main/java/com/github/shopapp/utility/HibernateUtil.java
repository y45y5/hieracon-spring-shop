package com.github.shopapp.utility;

import com.github.shopapp.model.orders.Orders;
import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.user.BasicRole;
import com.github.shopapp.model.user.BasicUser;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.Properties;

@Component
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try{ properties.load(new FileInputStream("src/main/resources/hibernate.properties")); }
        catch (Exception e){ e.printStackTrace(); }

        configuration.addAnnotatedClass(BasicRole.class);
        configuration.addAnnotatedClass(BasicUser.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Orders.class);

        configuration.setProperties(properties);
        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) { sessionFactory = buildSessionFactory(); }
        return sessionFactory;
    }

}
