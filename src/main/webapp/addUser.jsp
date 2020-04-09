<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 06.04.2020
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form action = "/addUser" method="post">
    <input required type="text" name="name" placeholder="name">
    <input required type="password" name="password" placeholder="password">
    <input required type="number" name="age" placeholder="age">
    <input type="submit" value="Save">
</form>

</body>
</html>
