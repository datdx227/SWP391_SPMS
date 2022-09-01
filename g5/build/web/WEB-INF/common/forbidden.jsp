<%-- 
    Document   : forbidden
    Created on : Aug 24, 2022, 9:32:22 PM
    Author     : Seth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <title>Forbidden Request</title>
    </head>
    <body>
        <div class="d-flex flex-column h-100 align-items-center justify-content-center">
            <h1 class="text-warning fw-bolder">403</h1>
            <h3 class="text-danger fw-bold">Access forbidden!</h3>
            <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/home">Back to Homepage</a>
        </div>
    </body>
</html>
