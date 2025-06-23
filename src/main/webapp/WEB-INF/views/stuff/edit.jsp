<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Stuff</title>
</head>
<body>
<h1>Edit Stuff</h1>
<form action="/stuff/${stuff.id}" method="post">
    <input type="hidden" name="_method" value="PATCH">

    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" value="${stuff.name}"><br><br>

    <label for="officeID">officeID:</label><br>
    <input type="number" id="officeID" name="officeID" value="${stuff.officeID}"><br><br>

    <input type="submit" value="Update">
</form>
<a href="/stuff">Back to List</a>
</body>
</html>