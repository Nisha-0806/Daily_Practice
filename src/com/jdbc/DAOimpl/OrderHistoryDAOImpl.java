package com.jdbc.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.dao.OrderHistory_DAO;
import com.jdbc.model.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistory_DAO {

    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/Online_Food_App";
    private static final String USER = "root";
    private static final String PASSWORD = "Nisha*123";

    // JDBC objects
    static Connection con;
    static PreparedStatement pstmt;
    static ResultSet res;

    // SQL queries
    private static final String INSERT_ORDER_HISTORY = "INSERT INTO order_history (user_id, order_id, total, status) VALUES (?, ?, ?, ?)";
    private static final String FETCH_ORDER_HISTORY_BY_USER_ID = "SELECT * FROM order_history WHERE user_id = ?";
    private static final String UPDATE_ORDER_HISTORY_STATUS = "UPDATE order_history SET status = ? WHERE oh_id = ?";

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
    public OrderHistory fetchOrderBy_Uid(int user_id) {
        OrderHistory orderHistory = null;
        try {
            // Prepare the SQL statement to fetch order history by user ID
            pstmt = con.prepareStatement(FETCH_ORDER_HISTORY_BY_USER_ID);
            pstmt.setInt(1, user_id);
            res = pstmt.executeQuery();

            // If order history is found, create an OrderHistory object
            if (res.next()) {
                orderHistory = new OrderHistory();
                orderHistory.setOh_id(res.getInt("oh_id"));
                orderHistory.setUser_id(res.getInt("user_id"));
                orderHistory.setOrder_id(res.getInt("order_id"));
                orderHistory.setTotal(res.getInt("total"));
                orderHistory.setStatus(res.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public int insertOrderHistory(OrderHistory oh) {
        int result = 0;
        try {
            // Prepare the SQL statement for inserting a new order history record
            pstmt = con.prepareStatement(INSERT_ORDER_HISTORY);
            pstmt.setInt(1, oh.getUser_id());
            pstmt.setInt(2, oh.getOrder_id());
            pstmt.setInt(3, oh.getTotal());
            pstmt.setString(4, oh.getStatus());

            // Execute the update and return the result
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateOrderHistory(int oh_id, String status) {
        int result = 0;
        try {
            // Prepare the SQL statement to update order history status
            pstmt = con.prepareStatement(UPDATE_ORDER_HISTORY_STATUS);
            pstmt.setString(1, status);
            pstmt.setInt(2, oh_id);

            // Execute the update and return the result
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
