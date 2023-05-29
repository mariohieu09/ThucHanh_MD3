
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #submit{
            width: 100px;
            height: 25px;
            background-color: beige;
            font-family: Tahoma;
            font-size: 15px;
            cursor: pointer;
        }
        button{
            background-color: beige;
            cursor: pointer;
            border-radius: 5px;
            padding: 5px;
        }
    </style>
</head>
<body>
<a href="/employee"><button>Go back to home page</button></a>
<div class="content">
    <form action="/employee" method="post">
        <input type="hidden" name="id" value="${requestScope['id']}">
        <input type="hidden" name="action" value="edit">
        <label for="name">Enter new name: </label>
        <input type="text" id="name" name="name"><br>
        <label for="email">Enter new email: </label>
        <input type="text" id="email" name="email"><br>
        <label for="address">Enter new address: </label>
        <input type="text" id="address" name="address"><br>
        <label for="phone">Enter new phone number: </label>
        <input type="text" id="phone" name="phone"><br>
        <label for="salary">Enter new salary: </label>
        <input type="text" id="salary" name="salary"><br>
        <label for="department_id">Select the department: </label>
        <select name="department_id" id="department_id">
            <option value="1">CO1</option>
            <option value="2">C02</option>
            <option value="3">C03</option>
        </select>
        <input type="submit" value="Submit" id="submit">
    </form>
</div>

</body>
</html>
