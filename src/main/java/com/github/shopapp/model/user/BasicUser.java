package com.github.shopapp.model.user;

import com.github.shopapp.model.orders.Orders;
import com.github.shopapp.model.orders.Status;
import com.github.shopapp.model.product.Product;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class BasicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<BasicRole> authorities = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ORDERS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<Orders> orders = new ArrayList<>();

    public BasicUser(){

    }

    public void addNewOrder(){
        orders.add(new Orders(Status.IN_CART));
    }

    public void addProduct(Product product){
        if(orders.isEmpty()) addNewOrder();
        else if(orders.size() < 2) orders.get(0).addNewProduct(product);
        else orders.get(orders.size()-1).addNewProduct(product);
    }

    public Orders getCartOrder(){
        for (Orders order : orders)
            if(order.getOrderStatus().equals(Status.IN_CART.toString())) return order;
        return null;
    }

    public void moveOrderFromCart(){
        Orders order = getCartOrder();
        order.moveFromCart();
        addNewOrder();
    }

    public BasicUser(String username, String password, boolean enabled, String email, BasicRole basicRole){
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        Product product = new Product();
        addProduct(product);
        getCartOrder().getProducts().remove(product);
        addRole(basicRole);
    }

    public void addRole(BasicRole basicRole){
        authorities.add(basicRole);
    }

    public List<GrantedAuthority> getAllAuthorities(){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for(BasicRole basicRole : authorities) authorityList.add(new SimpleGrantedAuthority(basicRole.getRoleName()));
        return authorityList;
    }

    public String getEmail() {
        return email;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<BasicRole> getAuthorities() {
        return authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<BasicRole> authorities) {
        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void showUserInfo(){
        System.out.println("=======================");
        System.out.println("Id: " + getId());
        System.out.println("Username: " + getUsername());
        System.out.println("Encoded password: " + getPassword());
        System.out.println("Enabled: " + isEnabled());
        System.out.println("Authorities:");
        for(GrantedAuthority grantedAuthority : getAllAuthorities())
            System.out.println(grantedAuthority.toString());
        System.out.println("=======================");
    }

}
