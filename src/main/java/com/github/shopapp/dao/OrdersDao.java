package com.github.shopapp.dao;

import com.github.shopapp.model.orders.Orders;
import com.github.shopapp.model.orders.Status;

import java.util.List;

public interface OrdersDao extends BasicDao<Orders>{
    List<Orders> getOrderByStatus(Status status);
}
