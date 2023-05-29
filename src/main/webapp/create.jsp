<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2023
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="content">
    <a href="/employee"><button>Go Home</button></a>
    <form action="/employee" method="post">
        <input type="hidden" name="action" value="create">
        <label for="name">Enter name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="name">Enter email:</label>
        <input type="text" id="email" name="email"><br>
        <label for="name">Enter address:</label>
        <input type="text" id="address" name="address"><br>
        <label for="name">Enter phone number:</label>
        <input type="text" id="phone" name="phone"><br>
        <label for="name">Enter salary:</label>
        <input type="text" id="salary" name="salary"><br>
        <label for="department_id">Select the department: </label>
        <select name="department_id" id="department_id">
            <option value="1">CO1</option>
            <option value="2">C02</option>
            <option value="3">C03</option>
        </select>
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
