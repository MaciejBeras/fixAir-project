<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
      table {
        border-collapse: collapse;
      }

      th, td {
        padding: 0.2rem;
        border: 1px solid black;
        text-align: center;
      }
    </style>
</head>
<body>
<nav>
    <a href="${pageContext.request.contextPath}/client/form">Add New Client</a> |
    <a href="${pageContext.request.contextPath}/client/form/all">Client List</a> |
    <a href="${pageContext.request.contextPath}/authors/form">Add New Author</a> |
    <a href="${pageContext.request.contextPath}/authors/form/all">Author List</a> |
    <a href="${pageContext.request.contextPath}/publishers/form">Add New Publisher</a> |
    <a href="${pageContext.request.contextPath}/publishers/form/all">Publisher List</a>
</nav>
<table>
    <caption>Clients</caption>
    <tr>
        <th>id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Mail</th>
        <th>Phone Number</th>
        <th>Address</th>
        <th>links</th>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td>${client.firstName}</td>
            <td>${client.lastName}</td>
            <td>${client.email}</td>
            <td>${client.phoneNumber}</td>
            <td>${client.address}</td>
            <td>
                <form:form action="/client/form/edit/${client.id}" method="post" style="display:inline;">
                    <input type="submit" value="Edit"/>
                </form:form>
                <form:form action="/client/form/delete/${client.id}" method="post" style="display:inline;"
                           onClick="return confirm('Are you sure?')">
                    <input type="submit" value="Delete"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
