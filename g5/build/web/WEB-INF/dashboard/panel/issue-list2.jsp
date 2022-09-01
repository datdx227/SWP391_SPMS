<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Issue List</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                List of Issue
            </div>
            <div class="card-body">
                <div class="row mb-2">
                    <form class="d-flex mb-2" action="./issues" method="" id="formFilter">
                        <div class="col-auto mx-1">
                            <select class="form-select" name="team_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Teams</option>
                                <c:forEach items="${teams}" var="t">
                                    <option value="${t.getTeam_id()}" ${t.getTeam_id() == team_id? "selected" : ""}>${t.getTeam_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="type_name" onchange="this.parentElement.parentElement.submit()">
                                <option value="">Filter by Types</option>
                                <c:forEach items="${types}" var="ty">
                                    <option value="${ty.getType_name()}" ${ty.getType_name() == type_name? "selected" : ""}>${ty.getType_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="function_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Functions</option>
                                <c:forEach items="${functions}" var="f">
                                    <option value="${f.getFunctionId()}" ${f.getFunctionId() == function_id? "selected" : ""}>${f.getTitle()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select"  name="milestone_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Milestones</option>
                                <c:forEach items="${milestones}" var="mile">
                                    <option value="${mile.getMilestone_id()}" ${mile.getMilestone_id() == milestone_id? "selected" : ""}>${mile.getMilestone_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="assignee_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Assignees</option>
                                <c:forEach items="${assignees}" var="a">
                                    <option value="${a.getAssignee_id()}" ${a.getAssignee_id() == assignee_id? "selected" : ""}>${a.getAssignee_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="status" onchange="this.parentElement.parentElement.submit()">
                                <option value="-1">Filter by Status</option>
                                <option value="1" ${status == "1"? "selected" : ""}>Active</option>
                                <option value="0" ${status == "0"? "selected" : ""}>Inactive</option>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="order_by" onchange="this.parentElement.parentElement.submit()">
                                <option value="-1">Order by</option>
                                <option value="0" ${order_by == "0"? "selected" : ""}>Ascending</option>
                                <option value="1" ${order_by == "1"? "selected" : ""}>Descending</option>
                            </select>
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" name="issue_title" id="issue_title" value="${issue_title}" placeholder="Issue Title">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </form>
                    <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/issues">Sync Issue</a>
                </div>
                <table class="table">
                    <thead>
                        <tr class="table-dark">
                            <th scope="col">ID</th>
                            <th scope="col">Title</th>
                            <th scope="col">Type</th>
                            <th scope="col">Functions</th>
                            <th scope="col">Milestone</th>
                            <th scope="col">Assigner</th>
                            <th scope="col">Assignee</th>
                            <th scope="col">Team</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${issues}" var = "i">
                            <tr>
                                <td scope="row">${i.getIssue_id()}</td>
                                <td scope="row">${i.getIssue_title()}</td>
                                <td scope="row">${i.getIssue_type()}</td>
                                <td scope="row">${i.getFunction_title()}</td>
                                <td scope="row">${i.getMilestone_name()}</td>
                                <td scope="row">${i.getAssigner_name()}</td>
                                <td scope="row">${i.getAssignee_name()}</td>
                                <td scope="row">${i.getTeam_name()}</td>
                                <td>${i.isStatus() ? "Active" : "Inactive"}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <nav>
                    <ul class="pagination">
                        <%
                            int maxPage = (Integer) request.getAttribute("maxpage");
                            for (int i = 1; i <= maxPage; i++) {
                        %>
                        <li><a class="page-link" onclick="page(<%=i%>)"><%=i%></a></li>
                            <%}%>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</main>

<script>
    function page(num) {
        var form = document.getElementById("formFilter");
        const node = document.createElement("input");
        node.name = "page";
        node.value = num;
        node.type = "hidden";
        form.appendChild(node);
        form.submit();
    }
</script>

