<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container-fluid px-4">
        <div class="card my-4 w-50 mx-auto">
            <div class="card-header">
                <span class="fs-5">
                    List of Iteration
                </span>
            </div>
            <div class="card-body">
                <div class="d-flex flex-column">
                    <c:forEach items="${iterList}" var="iter">
                        <a class="mx-auto btn w-50 btn-outline-primary my-1" href="${pageContext.request.contextPath}/submit/detail?id=${iter.getId()}">${iter.getIteration_name()}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>
