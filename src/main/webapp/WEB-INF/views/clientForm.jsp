<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous" defer></script>
    <style>
      .error {
        color: red;
        font-weight: bold;
      }
      .spaced-buttons .btn {
        display: block;
        margin-bottom: 3%;
      }
      .fixair-button {
        height: calc(2 * 38px); /* Default button height in Bootstrap 5 is 38px */
        font-size: 2.5em; /* Increase font size for better appearance */
      }
      .container {
        margin-top: 50px; /* Adjust this value to lower or raise the page */
      }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <nav class="spaced-buttons mb-4">
                <a href="${pageContext.request.contextPath}/client/form/all" class="btn btn-primary fixair-button">FixAir</a>
                <a href="${pageContext.request.contextPath}/client/form" class="btn btn-primary">Add New Client</a>
                <a href="${pageContext.request.contextPath}/client/form/all" class="btn btn-primary">Client List</a>
                <a href="${pageContext.request.contextPath}/device/form/all" class="btn btn-primary">All devices list</a>
                <a href="${pageContext.request.contextPath}/authors/form/all" class="btn btn-primary">All services history</a>
                <a href="${pageContext.request.contextPath}/publishers/form" class="btn btn-primary">Contact</a>
            </nav>
        </div>
        <div class="col-md-9">
            <h2>Client Form</h2>
            <form:form action="/client/form" modelAttribute="client" method="post">

                <form:hidden path="id" id="id"/>

                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name:</label>
                    <form:input path="firstName" class="form-control" id="firstName" required="true"/>
                    <form:errors path="firstName" element="div" cssClass="error"/>
                </div>

                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name:</label>
                    <form:input path="lastName" class="form-control" id="lastName" required="true"/>
                    <form:errors path="lastName" element="div" cssClass="error"/>
                </div>

                <div class="mb-3">
                    <label for="gender" class="form-label">Gender:</label>
                    <form:radiobuttons path="gender" class="form-check-input" items="${genders}" required="true"/>
                    <form:errors path="gender" element="div" cssClass="error"/>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <form:input path="email" class="form-control" id="email" required="true"/>
                    <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number:</label>
                    <form:input path="phoneNumber" class="form-control" id="phoneNumber" required="true"/>
                    <form:errors path="phoneNumber" element="div" cssClass="error"/>
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label">Address:</label>
                    <form:input path="address" class="form-control" id="address" required="true"/>
                    <form:errors path="address" element="div" cssClass="error"/>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
