<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex flex-column w-100">
    <form action="${pageContext.request.contextPath}/updates/${action}" method="post">
        <div class="d-flex flex-row mb-2 justify-content-between">
            <p class="fw-bold fst-italic">Updating History</p>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
        <input type="hidden" name="functionId" value="${functionId}">
        <input type="text" class="form-control mb-2" name="updateName" value="${title}" placeholder="Update Title" required>
        <div class="row mb-2">
            <div class="col-md-6">
                <select class="form-select" name="milestone" required>
                    <c:forEach items="${milestoneList}" var="mile">
                        <option value="${mile.getMilestone_id()}" ${mile.getMilestone_id() == currentMilestone ? "selected" : ""}>Milestone ${mile.getMilestone_id()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6">
                <input type="datetime" class="form-control" name="updateDate" value="${updateDate}" disabled readonly>
            </div>
        </div>
        <textarea class="form-control" name="description" placeholder="Description">${description}</textarea>
    </form>
</div>
