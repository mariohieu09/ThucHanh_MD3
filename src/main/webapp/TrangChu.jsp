<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            display: flex;
            flex-direction: row;
            width: 100%;
            justify-content: center;
            align-items: center;
            height: 600px;
            background-color: salmon;
        }
        .content{
            width: 80%;

        }
        button{
            background-color: beige;

            cursor: pointer;
            border-radius: 5px;
            padding: 5px;
        }
        #create{
            margin-left: 200px;
            width: 200px;
        }
        table{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class="content">
    <a href="/employee?action=create"><button id="create">Create an employee now?</button></a>
    <form action="/employee" method="post">
        <input type="hidden" name="action" value="search">
        <input type="text" name="name" placeholder="Enter name here">
        <input type="submit" value="submit">
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone number</th>
            <th>Salary</th>
            <th>Department ID</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${requestScope['list']}" var="employee">
            <tr>
                <td>${employee.getId()}</td>
                <td>${employee.getName()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getAddress()}</td>
                <td>${employee.getPhoneNum()}</td>
                <td>${employee.getSalary()}</td>
                <td>${employee.getDepartment_id()}</td>
                <td><a href="/employee?action=edit&id=${employee.getId()}"><button>Edit</button></a><a href="/employee?action=delete&id=${employee.getId()}"><button>Delete</button></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
