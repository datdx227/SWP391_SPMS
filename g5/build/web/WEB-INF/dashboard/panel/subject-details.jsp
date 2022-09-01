<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="card m-5">
        <h5 class="card-header">Subject Details</h5>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/dashboard/subjects/${crudpath}" method="post">
                <input type="hidden" name="subject-id" value="${subject.getId()}">
                <div class="row mb-2">
                    <div class="col-md-6">
                        <label for="subject-code" class="form-label">Subject Code</label>
                        <input type="text" class="form-control" id="subject-code" name="subject-code" value="${subject.getSubject_code()}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="subject-code" class="form-label">Subject Name</label>
                        <input type="text" class="form-control" id="subject-name" name="subject-name" value="${subject.getSubject_name()}" required>
                    </div>
                </div>
                <div class="col-md-12">
                    <label class="form-label" for="manager">Manager</label>
                    <select class="form-select" name="manager" id="manager">
                        <c:forEach items="${managers}" var="m">
                            <option value="${m.getManager_id()}" ${m.getManager_id() == manager_id? "selected" : ""}>${m.getManager_name()}</option>
                        </c:forEach>
                    </select>
                </div> 
                <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="status" id="status" ${subject.isStatus()? "checked" : ""} value="true">
                            <label class="form-check-label" for="status">Active</label>
                        </div>
                    </div> 
                <div class="row mb-2">
                    <div class="col-md-12">
                        <label class="form-label" for="description">Description</label>
                        <textarea class="form-control" name="description" id="description" placeholder="Description of Subject">${subject.getDescription()}</textarea>
                    </div>
                </div> 
                <button class="btn btn-primary" type="submit">Submit</button>
            </form>
        </div>
    </div>
</main>
