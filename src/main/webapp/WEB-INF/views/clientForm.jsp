<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client Form</title>
    <style>
      .error {
        color: red;
        font-weight: bold;
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
<h2>Client Form</h2>
<form:form action="/client/form" modelAttribute="client" method="post">
    <form:hidden path="id" id="id"/>

    <label for="firstName">First Name:</label>
    <form:input path="firstName" id="firstName" required="true"/><br><br>
    <form:errors path="firstName" element="div" cssClass="error"/>

    <label for="lastName">Last Name:</label>
    <form:input path="lastName" id="lastName" required="true"/><br><br>
    <form:errors path="lastName" element="div" cssClass="error"/>

    <label for="gender">Gender:</label>
    <form:radiobuttons path="gender" items="${genders}" required="true"/><br><br>
    <form:errors path="gender" element="div" cssClass="error"/>

    <label for="lastName"> Email:</label>
    <form:input path="email" id="email" required="true"/><br><br>
    <form:errors path="email" element="div" cssClass="error"/>

    <label for="phoneNumber"> Phone number:</label>
    <form:input path="phoneNumber" id="phoneNumber" required="true"/><br><br>
    <form:errors path="phoneNumber" element="div" cssClass="error"/>

    <label for="address"> Address:</label>
    <form:input path="address" id="address" required="true"/><br><br>
    <form:errors path="address" element="div" cssClass="error"/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
