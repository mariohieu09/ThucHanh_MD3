<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2023
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="content">
  <a href="/employee"><button>Go home</button></a>
  <fieldset>
    <legend>
      <h1>Name: ${requestScope['employee'].getName()}</h1>
    </legend>
    <h3>Email: ${requestScope['employee'].getEmail()}</h3>
    <h3>Address: ${requestScope['employee'].getAddress()}</h3>
    <h3>Phone number: ${requestScope['employee'].getPhoneNum()}</h3>
    <h3>Salary: ${requestScope['employee'].getSalary()}</h3>
    <h3>Department ID: ${requestScope['employee'].getDepartment_id()}</h3>
  </fieldset>
</div>

</body>
</html>
