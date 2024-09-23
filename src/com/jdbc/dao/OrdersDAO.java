package com.jdbc.dao;

import com.jdbc.model.Orders;

public interface OrdersDAO {
	int insertOrder(Orders o);
	Orders fetchBy_Oid(int id);
	int updateOrder(int id,String status);

}
