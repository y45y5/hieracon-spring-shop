package com.github.shopapp.model.user;

import com.github.shopapp.dao.BasicDao;
import com.github.shopapp.dao.Dao;

import java.util.List;

public class BasicRoleDaoImp extends Dao<BasicRole> implements BasicDao<BasicRole> {

    @Override
    public List<BasicRole> getFullList() {
        return getObjectList(BasicRole.class);
    }

    @Override
    public void save(BasicRole basicRole) {
        saveObject(basicRole);
    }

    @Override
    public void update(BasicRole basicRole) {
        updateObject(basicRole);
    }

    @Override
    public void delete(BasicRole basicRole) {
        deleteObject(basicRole);
    }

}
