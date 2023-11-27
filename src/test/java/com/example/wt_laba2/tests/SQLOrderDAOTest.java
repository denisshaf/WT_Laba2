package com.example.wt_laba2.tests;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.dao.exception.DAOException;
import com.example.wt_laba2.dao.pool.factory.ConnectionPoolFactory;
import com.example.wt_laba2.dao.factory.DAOFactory;
import com.example.wt_laba2.dao.pool.ConnectionPool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SQLOrderDAOTest {

    @Test
    void createOrder() throws DAOException {
        try{
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

            connectionPool.CreateConnections();

        }catch (Exception ex){
            Assertions.fail("Problem with connection");
        }
        OrderDao orderDao = DAOFactory.getFactory().getOrderDao();
        List<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem(new Product(11,"HP 14","1199",0,"Gaming laptops",new byte[10]),3));
        orderDao.CreateOrder("Some addressssssss",cart);
    }
}