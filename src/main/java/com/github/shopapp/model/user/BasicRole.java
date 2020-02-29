package com.github.shopapp.model.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class BasicRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany(mappedBy = "authorities")
    private Set<BasicUser> users = new HashSet<>();

    public BasicRole(){

    }

    public BasicRole(String roleName){
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public Set<BasicUser> getUsers() {
        return users;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUsers(Set<BasicUser> users) {
        this.users = users;
    }

    public void setId(int id) {
        this.id = id;
    }
}
