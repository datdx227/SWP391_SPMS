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
                <div class="col-md-12">
                    <label for="class-code" class="form-label">Class Code</label>
                    <input type="text" class="form-control" id="class-code" name="class-code" value="${classes.getClass_code()}">
                </div>
                <div class="col-md-12">
                    <label class="form-label" for="term">Term</label>
                    <select class="form-select" name="term" id="term">
                        <c:forEach items="${terms}" var="t">
                            <option value="${t.getTerm_name()}" ${t.getTerm_name() == classes.getTerm_name()? "selected" : ""}>${t.getTerm_name()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-12">
                    <label class="form-label" for="trainer">Trainer</label>
                    <select class="form-select" name="trainer" id="trainer">
                        <c:forEach items="${trainers}" var="tr">
                            <option value="${tr.getTrainer_id()}" ${tr.getTrainer_id() == classes.getTrainer_id()? "selected" : ""}>${tr.getTrainer_name()}</option>
                        </c:forEach>
                    </select>
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
                            <input class="form-check-input" type="checkbox" role="switch" name="status" id="status" ${classes.isStatus()? "checked" : ""} value="true">
                            <label class="form-check-label" for="status">Active</label>
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Submit</button>
            </form>
        </div>
    </div>
</main>
