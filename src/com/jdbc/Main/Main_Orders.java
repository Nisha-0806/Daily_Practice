package com.jdbc.Main;


import com.jdbc.DAOimpl.OrdersDAOImpl;
import com.jdbc.model.Orders;

public class Main_Orders {
	  public static void main(String[] args) {
	        // Create an instance of OrdersDAOImpl
	        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();

	        // 1. Insert a new order
	       /* Orders o = new Orders();
	        o.setUser_id(101); 
	        o.setRestaurant_id(1); 
	        o.setTotal_amount(350); 
	        o.setStatus("Pending"); 
	        o.setPayment_mode("Credit Card"); 
	        int insertResult = ordersDAO.insertOrder(o);
	        if (insertResult > 0) {
	            System.out.println("Order inserted successfully.");
	        } else {
	            System.out.println("Failed to insert order.");
	        }*/

	        // 2. Fetch the inserted order by its ID 
	        int orderId = 3;
	        Orders fetchedOrder = ordersDAO.fetchBy_Oid(orderId);
	        if (fetchedOrder != null) {
	            System.out.println("Fetched Order Details:");
	            System.out.println("Order ID: " + fetchedOrder.getOrder_id());
	            System.out.println("User ID: " + fetchedOrder.getUser_id());
	            System.out.println("Restaurant ID: " + fetchedOrder.getRestaurant_id());
	            System.out.println("Total Amount: " + fetchedOrder.getTotal_amount());
	            System.out.println("Status: " + fetchedOrder.getStatus());
	            System.out.println("Payment Mode: " + fetchedOrder.getPayment_mode());
	        } else {
	            System.out.println("No order found with ID: " + orderId);
	        }
	       

	        // 3. Update the order status
	        String newStatus = "Completed"; 
	        int updateResult = ordersDAO.updateOrder(orderId, newStatus);
	        if (updateResult > 0) {
	            System.out.println("Order status updated successfully.");
	        } else {
	            System.out.println("Failed to update order status.");
	        }
	 }
}



