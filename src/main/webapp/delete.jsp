<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="content">
    <a href="/employee"><button>Go Home</button></a>
    <form action="/employee" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${requestScope['id']}">
        <fieldset>
            <legend>
               <h1>Name: ${requestScope['employee'].getName()}</h1>
            </legend>
            <h3>Email: ${requestScope['employee'].getEmail()}</h3>
            <h3>Address: ${requestScope['employee'].getAddress()}</h3>
            <h3>Phone number: ${requestScope['employee'].getPhoneNum()}</h3>
            <h3>Salary: ${requestScope['employee'].getSalary()}</h3>
            <h3>Department ID: ${requestScope['employee'].getDepartment_id()}</h3>
            <input type="submit" value="Delete this employee">
        </fieldset>
    </form>
</div>
</body>
</html>
