<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="card m-5">
        <h5 class="card-header">Iteration Details</h5>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/dashboard/iterations/${crudpath}" method="post">
                <div class="row mb-2">
                    <div class="col-md-12">
                        <label class="form-label" for="subject">Subject</label>
                        <select class="form-select" name="subject" id="subject">
                            <c:forEach items="${subjects}" var="sub">
                                <option value="${sub.getId()}" ${sub.getId() == iteration.getSubject_id()? "selected" : ""}>${sub.getSubject_name()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <input type="hidden" name="iteration-id" value="${iteration.getId()}">
                <div class="row mb-2">
                    <div class="col-md-6">
                        <label for="iteration-name" class="form-label">Iteration Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="iteration-name" name="iteration-name" value="${iteration.getIteration_name()}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="eval-weight" class="form-label">Evaluation Weight <span class="text-danger">*</span></label>
                        <div class="input-group mb-3">
                            <input type="number" class="form-control" id="eval-weight" name="eval-weight" min="1" max="100" value="${iteration.getEval_weight()}" required>
                            <span class="input-group-text">%</span>
                        </div>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="on-going" id="on-going" ${iteration.isOn_going()? "checked" : ""} value="true">
                            <label class="form-check-label" for="on-going">On-Going</label>
                        </div>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="status" id="status" ${iteration.isStatus()? "checked" : ""} value="true">
                            <label class="form-check-label" for="status">Active</label>
                        </div>
                    </div>
                </div> 
                <div class="row mb-2">
                    <div class="col-md-12">
                        <label class="form-label" for="description">Description</label>
                        <textarea class="form-control" name="description" id="description" placeholder="Description of Iteration">${iteration.getDescription()}</textarea>
                    </div>
                </div> 
                <button class="btn btn-primary" type="submit">Save Iteration Details</button>
            </form>
        </div>
    </div>
</main>
