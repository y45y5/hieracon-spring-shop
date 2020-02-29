package com.github.shopapp.dao;

import com.github.shopapp.model.user.BasicUser;

public interface BasicUserDao<T> extends BasicDao<T> {
    BasicUser getByUsername(String username);
    BasicUser getByEmail(String email);

    void mergeUser(T t);
}
