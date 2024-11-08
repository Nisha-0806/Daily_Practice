package com.jdbc.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.dao.OrderItemDAO;
import com.jdbc.model.Order_item;

public class OrderItemDAOImpl implements OrderItemDAO{
	// Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/Online_Food_App";
    private static final String USER = "root";
    private static final String PASSWORD = "Nisha*123";

    // JDBC objects
    static Connection con;
    static PreparedStatement pstmt;
    static ResultSet res;

    // SQL queries
    private static final String INSERT_ORDER_ITEM = "INSERT INTO Order_items (order_id, menu_id, quantity, sub_total) VALUES (?, ?, ?, ?)";
    private static final String FETCH_ORDER_ITEM_BY_ID = "SELECT * FROM Order_items WHERE orderitem_id = ?";

    // Static block to load the JDBC driver and establish a connection
    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrderItems(Order_item oi) {
        int result = 0;
        try {
            // Prepare the SQL statement for inserting a new order item
            pstmt = con.prepareStatement(INSERT_ORDER_ITEM);
            pstmt.setInt(1, oi.getOrder_id());
            pstmt.setInt(2, oi.getMenu_id());
            pstmt.setInt(3, oi.getQuantity());
            pstmt.setInt(4, oi.getSub_total());

            // Execute the update and return the result
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Order_item fetch_ByOi_id(int orderitem_id) {
        Order_item orderItem = null;
        try {
            // Prepare the SQL statement to fetch an order item by its ID
            pstmt = con.prepareStatement(FETCH_ORDER_ITEM_BY_ID);
            pstmt.setInt(1, orderitem_id);
            res = pstmt.executeQuery();

            // If an order item is found, create an Order_item object
            if (res.next()) {
                orderItem = new Order_item(
                    res.getInt("orderitem_id"),
                    res.getInt("order_id"),
                    res.getInt("menu_id"),
                    res.getInt("quantity"),
                    res.getInt("sub_total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }
}
