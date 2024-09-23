package com.jdbc.dao;

import com.jdbc.model.OrderHistory;

public interface OrderHistory_DAO {
	OrderHistory fetchOrderBy_Uid(int user_id);
	int insertOrderHistory(OrderHistory oh);
	int updateOrderHistory(int oh_id,String status);
	

}
