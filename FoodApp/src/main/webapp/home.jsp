
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jdbc.model.User" %>
<%@ page import="com.jdbc.model.Restaurant" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foodies Club</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #ff6b6b;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h1 {
            color: white;
            margin: 0;
        }

        .nav-links {
            display: flex;
            align-items: center;
        }

        .nav-links a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #ff6b6b;
            min-width: 160px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
            right: 0;
        }

        .dropdown-content a {
            color: white;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #ff4757;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            padding: 20px;
        }

        .card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 20px;
            padding: 20px;
            display: inline-block;
            width: calc(30% - 40px);
            vertical-align: top;
            transition: transform 0.2s; /* Smooth scaling effect */
        }

        .card:hover {
            transform: scale(1.05); /* Scale up on hover */
        }

        .card h3 {
            color: #ff6b6b;
            margin-bottom: 10px; /* Added margin for better spacing */
        }

        .card p {
            margin: 5px 0; /* Spacing for paragraph elements */
        }

        /* Icon styles */
        .icon {
            block-size: 1em;
            display: inline-block;
            fill: currentcolor;
            inline-size: 1em;
            vertical-align: middle;
        }

        .icon--2x {
            font-size: 2rem;
        }

        .nav-links a {
            display: flex;
            align-items: center;
        }

        .nav-links svg {
            margin-right: 8px;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>Foodies Club</h1>
        <div class="nav-links">
            <% 
                User u = (User) session.getAttribute("user");
                if (u != null) { 
            %>
                <span>Hey, <%= u.getUsername() %></span>
                <a href="cart.html">
                    <svg class="icon icon--2x">
                        <use xlink:href="#icon-cart" />
                    </svg>
                    Cart
                </a>
                <a href="orderHistory.html">Order History</a>
                <div class="dropdown">
                    <a href="#" class="dropbtn">
                        <svg class="icon icon--2x">
                            <use xlink:href="#icon-user" />
                        </svg>
                        Profile
                    </a>
                    <div class="dropdown-content">
                        <a href="profile.html">Profile</a>
                        <a href="changePassword.html">Change Password</a>
                        <a href="logout.html">Logout</a>
                    </div>
                </div>
            <% } else { %>
                <a href="login.html">Login</a>
                <a href="register.html">Register</a>
            <% } %>
        </div>
    </div>

    <div class="container">
        <% 
            ArrayList<Restaurant> resList = (ArrayList<Restaurant>) session.getAttribute("resList");
            if (resList != null && !resList.isEmpty()) { 
                for (Restaurant res : resList) { 
        %>
            <div class="card">
                <h3><%= res.getName() %></h3>
                <p><strong>ID:</strong> <%= res.getRestaurant_id() %></p>
                <p><strong>Cuisine Type:</strong> <%= res.getCuisine_type() %></p>
                <p><strong>Rating:</strong> <%= res.getRatings() %></p>
            </div>
        <% 
                } 
            } else { 
        %>
            <p>No restaurant information available.</p>
        <% } %>
    </div>

    <!-- SVG icons for cart and profile -->
    <svg xmlns="http://www.w3.org/2000/svg" class="icons">
        <symbol id="icon-cart" viewBox="0 0 92 92">
            <path d="M91.8 27.3l-10.7 33.7c-.8 2.4-2.9 4-5.4 4h-41.3c-2.4 0-4.7-1.5-5.5-3.7l-15.8-42.3h-9.1c-2.2 0-4-1.8-4-4s1.8-4 4-4h11.9c1.7 0 3.2 1.1 3.8 2.7l16.3 43.3h38l8.5-27h-47.1c-2.2 0-4-1.8-4-4s1.8-4 4-4h52.6c1.3 0 2.5.7 3.2 1.7.8 1 1 2.4.6 3.6zm-55.4 43c-1.7 0-3.4.7-4.6 1.9-1.2 1.2-1.9 2.9-1.9 4.6 0 1.7.7 3.4 1.9 4.6 1.2 1.2 2.9 1.9 4.6 1.9s3.4-.7 4.6-1.9c1.2-1.2 1.9-2.9 1.9-4.6 0-1.7-.7-3.4-1.9-4.6-1.2-1.2-2.9-1.9-4.6-1.9zm35.9 0c-1.7 0-3.4.7-4.6 1.9s-1.9 2.9-1.9 4.6c0 1.7.7 3.4 1.9 4.6 1.2 1.2 2.9 1.9 4.6 1.9 1.7 0 3.4-.7 4.6-1.9 1.2-1.2 1.9-2.9 1.9-4.6 0-1.7-.7-3.4-1.9-4.6s-2.9-1.9-4.6-1.9z"/>
        </symbol>
        <symbol id="icon-user" viewBox="0 0 92 92">
            <path d="M46 57.1c14.8 0 26.9-12.1 26.9-27 0-15-12.1-27.1-26.9-27.1s-26.9 12.1-26.9 27c0 15 12.1 27.1 26.9 27.1zm0-46.1c10.4 0 18.9 8.5 18.9 19s-8.5 19-18.9"/>