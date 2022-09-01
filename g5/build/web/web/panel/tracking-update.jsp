<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Update Evaluated Function</h1>
        <div class="card mb-4">
            <div class="card-body">
                <div class="row mb-2">
                    <div class="col-md-6">
                        <div class="d-flex flex-column w-100">
                            <p class="fw-bold fst-italic">Function: Function 1</p>
                            <p>Evaluated in: Milestone 1, with below comments</p>
                            <textarea class="form-control" value="Evaluating Comments" disabled readonly>
                            </textarea>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <c:choose>
                            <c:when test="${subPanel == null}">
                            </c:when>
                            <c:otherwise>
                                <c:import url="panel/${subPanel}.jsp"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="d-flex flex-row mb-2 justify-content-between">
                        <p class="fw-bold fst-italic">Updating History</p>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/updates/add?id=${currentFunctionId}">New Update</a>
                    </div>
                    <table class="table">
                        <thead>
                            <tr class="table-dark">
                                <th scope="col">ID</th>
                                <th scope="col">Update</th>
                                <th scope="col">Updated At</th>
                                <th scope="col">Milestone</th>
                                <th scope="col" class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items = "${updates}" var = "update">
                                <tr>
                                    <th>${update.getId()}</th>
                                    <td>${update.getTitle()}</td>
                                    <td>${update.getUpdateDate()}</td>
                                    <td>${update.getMilestoneId()}</td>
                                    <td>
                                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/updates/update?id=${update.getId()}">Edit</a>
                                        <a class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this update record?')" href="${pageContext.request.contextPath}/updates/delete?id=${update.getId()}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>    
        </div>
    </div>
</main>
