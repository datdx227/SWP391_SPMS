<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Iteration Evaluation</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Iteration Evaluation
            </div>
            <div class="card-body">
                <div class="row mb-2">
                    <form class="d-flex mb-2" action="./itervaluas" method="" id="formFilter">
                        <div class="col-auto mx-1">
                            <select class="form-select" name="team_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Teams</option>
                                <c:forEach items="${teams}" var="t">
                                    <option value="${t.getTeam_id()}" ${t.getTeam_id() == team_id? "selected" : ""}>${t.getTeam_name()}</option>
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
                    </form>
                    <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 4}">
                        <div class="col-auto mx-1">
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/itervaluas/import">Import Evaluations</a>
                        </div>
                    </c:if>
                </div>
                <table class="table">
                    <thead>
                        <tr class="table-dark">
                            <th scope="col">ID</th>
                            <th scope="col">Student</th>
                            <th scope="col">Team</th>
                            <th scope="col">Total</th>
                            <th scope="col">Team Eval</th>
                            <th scope="col">Individual Eval</th>
                            <th scope="col">LOC Eval</th>
                            <th scope="col">Bonus</th>
                                <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 4}">
                                <th scope="col" class="text-center">Edit</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${itervaluas}" var = "ivs">
                            <tr>
                                <td scope="row">${ivs.getEvaluation_id()}</td>
                                <td scope="row">${ivs.getUser_name()}</td>
                                <td scope="row">${ivs.getTeam_name()}</td>
                                <td scope="row">${ivs.getTotal_grade()}</td>
                                <td scope="row">${ivs.getComment()}</td>
                                <td scope="row">${ivs.getIndi_comment()}</td>
                                <td scope="row">${ivs.getLoc()}
                                <td scope="row">${ivs.getBonus()}</td>
                                <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 4}">
                                    <td>
                                        <div class="d-flex p-2 justify-content-between">
                                            <a class="btn btn-primary" 
                                               href="${pageContext.request.contextPath}/dashboard/itervaluas/edit?id=${ivs.getEvaluation_id()}">Edit</a>
                                        </div>
                                    </td>
                                </c:if>
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
