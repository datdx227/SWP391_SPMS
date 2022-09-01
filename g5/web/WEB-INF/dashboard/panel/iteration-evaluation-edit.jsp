<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="card m-5">
        <h5 class="card-header">Class Details</h5>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/dashboard/classes/update" method="post">
                <div class="row mb-2">
                    <div class="col-md-12">
                        <label class="form-label" for="subject">Subject</label>
                        <select class="form-select" name="subject" id="subject">
                            <c:forEach items="${subjects}" var="sub">
                                <option value="${sub.getId()}" ${sub.getId() == classes.getSubject_id()? "selected" : ""}>${sub.getSubject_name()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <input type="hidden" name="class-id" value="${classes.getId()}">
                <div class="row mb-2">
                    <div class="col-md-6">
                        <label for="class-name" class="form-label">Class Code</label>
                        <input type="text" class="form-control" id="class-code" name="class-code" value="${classes.getClass_code()}">
                    </div>
                    <div class="col-md-6">
                        <label for="iteration-name" class="form-label">Term</label>
                        <input type="text" class="form-control" id="term" name="term" value="${classes.getTerm_id()}">
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <label class="form-label" for="user">Trainer</label>
                        <input type="text" class="form-control" id="trainer" name="trainer" value="${classes.getTrainer_id()}">
                    </div>
                </div>      
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="is_block5" id="is_block5" ${classes.isIs_block5()? "checked" : ""} value="true">
                            <label class="form-check-label" for="is_block5">Yes</label>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="status" id="status" ${classess.isStatus()? "checked" : ""} value="true">
                            <label class="form-check-label" for="status">Active</label>
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Submit</button>
            </form>
        </div>
    </div>
</main>
