<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Device List</title>
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
<div class="container mt-5">
    <div class="row">
        <div class="col-md-3">
            <nav class="spaced-buttons mb-4">
                <a href="${pageContext.request.contextPath}/client/form/all" class="btn btn-primary fixair-button">FixAir</a>
                <a href="${pageContext.request.contextPath}/client/form" class="btn btn-primary">Add New Client</a>
                <a href="${pageContext.request.contextPath}/client/form/all" class="btn btn-primary">Client List</a>
                <a href="${pageContext.request.contextPath}/device/form/all" class="btn btn-primary">All devices list</a>
                <a href="${pageContext.request.contextPath}/serviceRecord/form/all" class="btn btn-primary">All services history</a>
                <a href="${pageContext.request.contextPath}/technicalSupport/all" class="btn btn-primary">Contact</a>
            </nav>
        </div>
        <div class="col-md-9">
            <h2>Devices List</h2>
            <table class="table table-striped">
                <thead class="table-dark">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Serial Number</th>
                    <th>Installation Date</th>
                    <th>Description</th>
                    <th>Client</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="device" items="${devices}">
                    <tr>
                        <td>${device.id}</td>
                        <td>${device.name}</td>
                        <td>${device.serialNumber}</td>
                        <td>${device.installationDate}</td>
                        <td>${device.description}</td>
                        <td>${device.client.firstName} ${device.client.lastName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>