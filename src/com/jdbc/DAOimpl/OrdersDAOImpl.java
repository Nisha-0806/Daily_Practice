package com.jdbc.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.dao.OrdersDAO;
import com.jdbc.model.Orders;

public class OrdersDAOImpl implements OrdersDAO {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/Online_Food_App";
    private static final String USER = "root";
    private static final String PASSWORD = "Nisha*123";

    // JDBC objects
    static Connection con;
    static PreparedStatement pstmt;
    static ResultSet res;

    // SQL queries
    private static final String INSERT_ORDER = "INSERT INTO orders (user_id, restaurant_id, total_amount, status, payment_mode) VALUES (?, ?, ?, ?, ?)";
    private static final String FETCH_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";
    private static final String UPDATE_ORDER_STATUS = "UPDATE orders SET status = ? WHERE order_id = ?";

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
    public int insertOrder(Orders o) {
        int result = 0;
        try {
            // Prepare the SQL statement for inserting a new order
            pstmt = con.prepareStatement(INSERT_ORDER);
            pstmt.setInt(1, o.getUser_id());
            pstmt.setInt(2, o.getRestaurant_id());
            pstmt.setDouble(3, o.getTotal_amount());
            pstmt.setString(4, o.getStatus());
            pstmt.setString(5, o.getPayment_mode());

            // Execute the update and return the result
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Orders fetchBy_Oid(int id) {
        Orders order = null;
        try {
            // Prepare the SQL statement to fetch an order by its ID
            pstmt = con.prepareStatement(FETCH_ORDER_BY_ID);
            pstmt.setInt(1, id);
            res = pstmt.executeQuery();

            // If an order is found, create an Orders object
            if (res.next()) {
                order = new Orders();
                order.setOrder_id(res.getInt("order_id"));
                order.setUser_id(res.getInt("user_id"));
                order.setRestaurant_id(res.getInt("restaurant_id"));
                order.setTotal_amount(res.getInt("total_amount"));
                order.setStatus(res.getString("status"));
                order.setPayment_mode(res.getString("payment_mode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int updateOrder(int id, String status) {
        int result = 0;
        try {
            // Prepare the SQL statement to update the order status
            pstmt = con.prepareStatement(UPDATE_ORDER_STATUS);
            pstmt.setString(1, status);
            pstmt.setInt(2, id);

            // Execute the update and return the result
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
