package com.github.shopapp.model.user;

import com.github.shopapp.dao.BasicUserDao;
import com.github.shopapp.dao.Dao;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasicUserDaoImp extends Dao<BasicUser> implements BasicUserDao<BasicUser> {

    @Override
    public BasicUser getByUsername(String username) {
        List<BasicUser> users = getObjectListByObject(BasicUser.class, "username", username);
        if(users.isEmpty()) return null;
        return users.get(0);
    }

    @Override
    public BasicUser getByEmail(String email) {
        return null; //TODO implement search by email and email in basic user
    }

    @Override
    public void mergeUser(BasicUser basicUser) {
        mergeObject(basicUser);
    }

    @Override
    public List<BasicUser> getFullList() {
        return new ArrayList<BasicUser>(getObjectList(BasicUser.class));
    }

    @Override
    public void save(BasicUser basicUser) {
        saveObject(basicUser);
    }

    @Override
    public void update(BasicUser basicUser) {
        updateObject(basicUser);
    }

    @Override
    public void delete(BasicUser basicUser) {
        deleteObject(basicUser);
    }
}
