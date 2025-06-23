<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Stuff List</title>
</head>
<body>
    <h1>Stuff List</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>officeID</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stuff" items="${stuffList}">
            <tr>
                <td>${stuff.id}</td>
                <td>${stuff.name}</td>
                <td>${stuff.officeID}</td>
                <td>
                    <a href="/stuff/${stuff.id}/edit">Edit</a>
                    <form action="/stuff/${stuff.id}" method="post" style="display: inline;">
                        <input type="hidden" name="_method" value="DELETE">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/stuff/new">Create New Empolyee</a>
</body>
</html>

