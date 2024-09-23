package com.jdbc.Main;

import com.jdbc.DAOimpl.OrderHistoryDAOImpl;
import com.jdbc.model.OrderHistory;

public class Main_OrderHistory {

	public static void main(String[] args) {
		        // Create an instance of OrderHistoryDAOImpl
		        OrderHistoryDAOImpl orderHistoryDAO = new OrderHistoryDAOImpl();

		        // 1. Insert a new order history
		       /* OrderHistory oh = new OrderHistory(102, 3, 500, "Pending");
		        int insertResult = orderHistoryDAO.insertOrderHistory(oh);
		        System.out.println(insertResult > 0 ? "Order history inserted successfully." : "Failed to insert order history.");*/

		        // 2. Fetch order history by user ID
		        int userId = 102; // Example user ID
		        OrderHistory fetchedOrderHistory = orderHistoryDAO.fetchOrderBy_Uid(userId);
		        if (fetchedOrderHistory != null) {
		            System.out.println("Fetched Order History: " + fetchedOrderHistory);
		        } else {
		            System.out.println("No order history found for user ID: " + userId);
		        }

		        // 3. Update the status of an order history entry
		       if (fetchedOrderHistory != null) {
		            int oh_id = fetchedOrderHistory.getOh_id();
		            int updateResult = orderHistoryDAO.updateOrderHistory(oh_id, "Completed");
		            System.out.println(updateResult > 0 ? "Order history status updated successfully." : "Failed to update order history status.");
		        }
		    }

	}


