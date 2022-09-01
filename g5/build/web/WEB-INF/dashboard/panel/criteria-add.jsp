<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="card m-5">
        <h5 class="card-header">Iteration Details</h5>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/dashboard/criterias/add" method="post">
                <div class="row mb-2">
                    <div class="col-md-6">
                        <label for="iteration" class="form-label">Iteration <span class="text-danger">*</span></label>
                        <select class="form-select" name="iteration" id="iteration" required>
                            <c:forEach items="${iterations}" var="iter">
                                <option value="${iter.getId()}"> ${iter.getIteration_name()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label for="criteria-name" class="form-label">Criteria Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="criteria-name" name="criteria-name" required>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-md-6">
                        <label for="eval-weight" class="form-label">Evaluation Weight <span class="text-danger">*</span></label>
                        <div class="input-group mb-3">
                            <input type="number" class="form-control" id="eval-weight" name="eval-weight" min="1" max="100" value="1" required>
                            <span class="input-group-text">%</span>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="eval-weight" class="form-label">Max LOC <span class="text-danger">*</span></label>
                        <input type="number" class="form-control" id="max-loc" min="0" name="max-loc" required>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="team-eval" id="team-eval" value="true">
                            <label class="form-check-label" for="team-eval">Team Evaluation</label>
                        </div>
                    </div>
                </div>
                <div class="row mb-2">
                    <div class="col-md-12">
                        <div class="form-check form-switch">
                            <input class="form-check-input" type="checkbox" role="switch" name="status" id="status" value="true">
                            <label class="form-check-label" for="status">Active</label>
                        </div>
                    </div>
                </div> 
                <div class="row mb-2">
                    <div class="col-md-12">
                        <label class="form-label" for="description">Description</label>
                        <textarea class="form-control" name="description" id="description" placeholder="Description of Criteria"></textarea>
                    </div>
                </div> 
                <button class="btn btn-primary" type="submit">Add new Criteria</button>
            </form>
        </div>
    </div>
</main>
