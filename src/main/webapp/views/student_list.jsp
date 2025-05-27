<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>Student List</h2>
<a href="${pageContext.request.contextPath}add-student">Add Student</a>
<table border="1" cellpadding="8">
    <thead>
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>DOB</th><th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.dob}</td>
            <td>
                <a href="${pageContext.request.contextPath}edit-student/${student.id}">Edit</a>
                |
                <a href="${pageContext.request.contextPath}delete-student/${student.id}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
