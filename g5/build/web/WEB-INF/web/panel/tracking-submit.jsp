<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Tracking Submits</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Team 1, Iteration 1
            </div>
            <div class="card-body">
                <div class="row mb-2">
                    <p>Found 5 functions which you can choose to submit</p>
                </div>
                <form action="${pageContext.request.contextPath}/submit/update" method="post">
                    <table class="table">
                        <thead>
                            <tr class="table-dark">
                                <th scope="col"></th>
                                <th scope="col">Function</th>
                                <th scope="col">Feature</th>
                                <th scope="col">Status</th>
                                <th scope="col">Assignee</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${functions}" var="func">
                                <tr>
                                    <td><input class="form-check-input" type="checkbox" value="${func.getFunctionId()}" name="submitId"></td>
                                    <td>${func.getTitle()}</td>
                                    <td>${func.getFeature()}</td>
                                    <td>${func.isSubmitStatus() ? "Committed" : "Pending"}</td>
                                    <td>
                                        <select class="form-select" name="assigneeId">
                                            <c:forEach items="${students}" var="student">
                                                <option value="${student.getId()}"}>${student.getFullname()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <button type="submit" class="btn btn-outline-primary">Update Assignee & Submit for Selected Functions</button>
                </form>
            </div>    
        </div>
    </div>
</main>
