<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.details.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e9ecef;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 1200px;
        margin: auto;
        background: white;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        padding: 30px;
    }
    h1 {
        text-align: center;
        color: #333;
        font-size: 36px;
        margin-bottom: 20px;
    }
    .card-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        gap: 20px;
    }
    .card {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: calc(33.333% - 20px); /* 3 cards per row */
        transition: all 0.3s ease;
    }
    .card:hover {
        transform: translateY(-5px);
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
    }
    .card h2 {
        margin: 0 0 10px;
        font-size: 24px;
        color: #007BFF;
    }
    .card p {
        margin: 10px 0;
        font-size: 16px;
        color: #555;
    }
    .card p strong {
        color: #333;
    }
    .btn-group {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
    }
    button {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        background-color: #007BFF;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #0056b3;
    }
    a {
        text-decoration: none;
    }
    .no-records {
        text-align: center;
        font-size: 18px;
        color: #888;
        margin-top: 20px;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Employee Information</h1>
    <div style="text-align: center; margin-bottom: 20px;">
        <a href="addEmployee.jsp"><button>Add Employee</button></a>
    </div>

    <div class="card-container">
        <%
        ArrayList<Employee> empli = (ArrayList<Employee>) session.getAttribute("empli");
        if (empli != null) {
            for (Employee e : empli) {
        %>
        <div class="card">
            <h2><%= e.getEmpname() %></h2>
            <p><strong>Designation:</strong> <%= e.getDesig() %></p>
            <p><strong>Email:</strong> <%= e.getEmail() %></p>
            <p><strong>Password:</strong> <%= e.getPassword() %></p>
            <div class="btn-group">
                <a href="EditEmployee?id=<%= e.getEmpid() %>"><button>Edit</button></a>
                <a href="DeleteEmp?id=<%= e.getEmpid() %>"><button>Delete</button></a>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <div class="no-records">
            <p>No employee records found.</p>
        </div>
        <%
        }
        %>
    </div>
</div>
</body>
</html>
