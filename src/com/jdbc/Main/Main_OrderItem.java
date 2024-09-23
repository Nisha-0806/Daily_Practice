package com.jdbc.Main;

import com.jdbc.DAOimpl.OrderItemDAOImpl;
import com.jdbc.DAOimpl.OrdersDAOImpl;
import com.jdbc.model.Order_item;
import com.jdbc.model.Orders;

public class Main_OrderItem {

	public static void main(String[] args) {
		
		OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        // Insert a new order item
        Order_item oi = new Order_item(3, 1, 3, 100); // Example values: order_id=1, menu_id=2, quantity=3, sub_total=100
        int insertResult = orderItemDAO.insertOrderItems(oi);
        if (insertResult > 0) {
            System.out.println("Order item inserted successfully.");
        } else {
            System.out.println("Failed to insert order item.");
        }
		// Example: Fetch an order by its ID
        Orders fetchedOrder = ordersDAO.fetchBy_Oid(3); // Replace with a valid order_id
        if (fetchedOrder != null) {
            System.out.println("Fetched Order: " + fetchedOrder);
        } else {
            System.out.println("Order not found.");
        }

	}

}
