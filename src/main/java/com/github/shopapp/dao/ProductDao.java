package com.github.shopapp.dao;

import com.github.shopapp.exceptions.ProductNotFoundException;
import com.github.shopapp.model.product.Product;

import java.util.List;

public interface ProductDao extends BasicDao<Product>{
    List<Product> getListByPhrase(String searchPhrase);
    Product getProductByName(String productName) throws ProductNotFoundException;
    Product getProductById(int productId) throws ProductNotFoundException;
}
