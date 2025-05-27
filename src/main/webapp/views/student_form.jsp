<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:if test="${student.id != 0}">Edit</c:if><c:if test="${student.id == 0}">Add</c:if> Student</title>
</head>
<body>

<h2><c:if test="${student.id != 0}">Edit</c:if><c:if test="${student.id == 0}">Add</c:if> Student</h2>

<c:choose>
    <c:when test="${student.id == 0}">
        <c:set var="formAction" value="${pageContext.request.contextPath}add-student"/>
    </c:when>
    <c:otherwise>
        <c:set var="formAction" value="${pageContext.request.contextPath}edit-student"/>
    </c:otherwise>
</c:choose>

<form action="${formAction}" method="post">
    <input type="hidden" name="id" value="${student.id}" />

    Name: <label>
    <input type="text" name="name" value="${student.name}" required/>
</label><br/>

    Email: <label>
    <input type="email" name="email" value="${student.email}" required/>
</label><br/>

    DOB: <label>
    <input type="date" name="dob" value="${student.dob}" required/>
</label><br/><br/>

    <button type="submit">
        <c:if test="${student.id == 0}">Add</c:if>
        <c:if test="${student.id != 0}">Update</c:if>
    </button>
</form>

<a href="${pageContext.request.contextPath}list-student">Back to List</a>

</body>
</html>
