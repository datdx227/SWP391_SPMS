<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Student Project Management</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <c:import url="/WEB-INF/common/header.jsp"/>
        <div class="d-flex">
            <div class="d-flex flex-column min-vh-100 justify-content-between flex-grow-1 w-100 mt-5">
                <!-- Main Content-->
                <c:choose>
                    <c:when test="${panel == null}">
                        <div class="container mx-auto my-auto text-center">
                            <h1 class="text-uppercase">Welcome to Student Project Management!</h1>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:import url="panel/${panel}.jsp"/>
                    </c:otherwise>
                </c:choose>
                <!-- Footer-->
                <c:import url="/WEB-INF/common/footer.jsp"/>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/ajax.js" type="text/javascript"></script>
    </body>
</html>
