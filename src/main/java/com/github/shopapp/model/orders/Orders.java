package com.github.shopapp.model.orders;

import com.github.shopapp.model.product.Product;
import com.github.shopapp.model.product.ProductDaoImp;
import com.github.shopapp.model.user.BasicUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "orderStatus")
    private String orderStatus;
    @Column(name = "totalPrice")
    private int totalPrice;
    @ManyToMany(mappedBy = "orders")
    private List<BasicUser> users = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "ORDERS_PRODUCTS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products = new ArrayList<Product>();

    public Orders(){

    }

    public Orders(Status status){
        this.orderStatus = status.toString();
    }

    public void moveFromCart(){
        ProductDaoImp productDaoImp = new ProductDaoImp();

        this.orderStatus = Status.IN_PROGRESS.toString();
        setTotalPrice();
        Product product = productDaoImp.getFullList().get(0);
        products.add(product);
        products.remove(product);
    }

    public void completeOrder(){
        this.orderStatus = Status.COMPLETED.toString();
    }

    public void addNewProduct(Product product){
        products.add(product);
    }

    public void setTotalPrice() {
        int totalPrice = 0;
        for (Product product : products)
            totalPrice += product.getPrice();
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public List<BasicUser> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setUsers(List<BasicUser> users) {
        this.users = users;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
