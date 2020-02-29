package com.github.shopapp.model.orders;

import com.github.shopapp.dao.Dao;
import com.github.shopapp.dao.OrdersDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersDaoImp extends Dao<Orders> implements OrdersDao {
    @Override
    public List<Orders> getOrderByStatus(Status status) {
        return getObjectListByObject(Orders.class, "orderStatus", status.toString());
    }

    @Override
    public List<Orders> getFullList() {
        return getObjectList(Orders.class);
    }

    @Override
    public void save(Orders orders) {
        saveObject(orders);
    }

    @Override
    public void update(Orders orders) {
        updateObject(orders);
    }

    @Override
    public void delete(Orders orders) {
        deleteObject(orders);
    }
}
