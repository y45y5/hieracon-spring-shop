package com.github.shopapp.model.product;

import com.github.shopapp.dao.Dao;
import com.github.shopapp.dao.ProductDao;
import com.github.shopapp.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImp extends Dao<Product> implements ProductDao {

    @Override
    public List<Product> getListByPhrase(String searchPhrase) {
        return getObjectListByObject(Product.class, "productName", searchPhrase);
    }

    @Override
    public Product getProductByName(String productName) throws ProductNotFoundException {
        List<Product> products = getObjectListByObject(Product.class, "productName", productName);
        if(products.isEmpty()) return null;
        return products.get(0);
    }

    @Override
    public Product getProductById(int productId) throws ProductNotFoundException {
        List<Product> products = getObjectListByObject(Product.class, "id", productId);
        if(products.isEmpty()) throw new ProductNotFoundException("Product with that id don't found!");
        return products.get(0);
    }

    @Override
    public List<Product> getFullList() {
        return getObjectList(Product.class);
    }

    @Override
    public void save(Product product) {
        saveObject(product);
    }

    @Override
    public void update(Product product) {
        updateObject(product);
    }

    @Override
    public void delete(Product product) {
        deleteObject(product);
    }

}
