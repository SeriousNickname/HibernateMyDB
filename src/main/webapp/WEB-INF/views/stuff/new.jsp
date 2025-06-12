<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Stuff</title>
</head>
<body>
<h1>Create New Stuff</h1>
<form action="/stuff" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br><br>

    <label for="officeID">officeID:</label><br>
    <input type="number" id="officeID" name="officeID"><br><br>

    <input type="submit" value="Create">
</form>
<a href="/stuff">Back to List</a>
</body>
</html>