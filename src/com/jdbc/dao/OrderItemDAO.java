package com.jdbc.dao;

import com.jdbc.model.Order_item;

public interface OrderItemDAO {
	int insertOrderItems(Order_item oi);
	Order_item fetch_ByOi_id(int order_id);

}
