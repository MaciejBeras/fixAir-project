<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Device Form</title>
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
                <a href="${pageContext.request.contextPath}/device/form" class="btn btn-primary">Add New Device</a>
                <a href="${pageContext.request.contextPath}/authors/form/all" class="btn btn-primary">Author List</a>
                <a href="${pageContext.request.contextPath}/publishers/form" class="btn btn-primary">Add New Publisher</a>
                <a href="${pageContext.request.contextPath}/publishers/form/all" class="btn btn-primary">Publisher List</a>
            </nav>
        </div>
        <div class="col-md-9">
            <h2>Device Form</h2>
            <form:form action="${pageContext.request.contextPath}/device/form" modelAttribute="device" method="post">

                <form:hidden path="id" id="id"/>
                <form:hidden path="client.id" id="clientId"/>

                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <form:input path="name" class="form-control" id="name" required="true"/>
                    <form:errors path="name" element="div" cssClass="error"/>
                </div>

                <div class="mb-3">
                    <label for="serialNumber" class="form-label">Serial Number:</label>
                    <form:input path="serialNumber" class="form-control" id="serialNumber" required="true"/>
                    <form:errors path="serialNumber" element="div" cssClass="error"/>
                </div>

<%--                <div class="mb-3">--%>
<%--                    <label for="installationDate" class="form-label">Installation Date:</label>--%>
<%--                    <form:input path="installationDate" class="form-control" id="installationDate" required="true"/>--%>
<%--                    <form:errors path="installationDate" element="div" cssClass="error"/>--%>
<%--                </div>--%>

<%--                <div class="mb-3">--%>
<%--                    <label for="serviceDate" class="form-label">Service Date:</label>--%>
<%--                    <form:input path="serviceDate" class="form-control" id="serviceDate" required="true"/>--%>
<%--                    <form:errors path="serviceDate" element="div" cssClass="error"/>--%>
<%--                </div>--%>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
