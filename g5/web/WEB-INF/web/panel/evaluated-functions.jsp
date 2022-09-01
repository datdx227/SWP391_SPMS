<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container-fluid px-4">
        <div class="card my-4 w-50 mx-auto">
            <div class="card-header">
                <span class="fs-5">
                    List of Evaluated Functions
                </span>
            </div>
            <div class="card-body">
                <div class="d-flex flex-column">
                    <c:forEach items = "${functions}" var="func">
                        <a class="mx-auto btn w-50 btn-outline-primary my-1" href="${pageContext.request.contextPath}/updates/detail?id=${func.getFunctionId()}">${func.getTitle()}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>
