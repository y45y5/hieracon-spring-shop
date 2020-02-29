package com.github.shopapp.model.product;

import com.github.shopapp.model.orders.Orders;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "price")
    private int price;
    @Column(name = "imageName")
    private String imageName;
    @Column(name = "aboutProduct", length = 750)
    private String aboutProduct;
    @ManyToMany(mappedBy = "products")
    private List<Orders> orders = new ArrayList<>();

    public Product(){

    }

    public Product(String productName, Integer price, String aboutProduct, String imageName){
        this.productName = productName;
        this.price = price;
        this.aboutProduct = aboutProduct;
        this.imageName = imageName;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public int getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getAboutProduct() {
        return aboutProduct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAboutProduct(String aboutProduct) {
        this.aboutProduct = aboutProduct;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
