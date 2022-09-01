<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Class List</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                List of Class
            </div>
            <div class="card-body">
                <div class="row mb-2">
                    <form class="d-flex mb-2" action="./classes" method="" id="formFilter">
                        <div class="col-auto mx-1">
                            <select class="form-select" name="subject_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Subjects</option>
                                <c:forEach items="${subjects}" var="sub">
                                    <option value="${sub.getId()}" ${sub.getId() == subject_id? "selected" : ""}>${sub.getSubject_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="trainer_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Trainers</option>
                                <c:forEach items="${trainers}" var="tr">
                                    <option value="${tr.getTrainer_id()}" ${tr.getTrainer_id() == trainer_id? "selected" : ""}>${tr.getTrainer_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-auto mx-1">
                            <select class="form-select" name="term_name" onchange="this.parentElement.parentElement.submit()">
                                <option value="">Filter by Terms</option>
                                <c:forEach items="${terms}" var="te">
                                    <option value="${te.getTerm_name()}" ${te.getTerm_name() == term_name? "selected" : ""}>${te.getTerm_name()}</option>
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
                            <input type="text" class="form-control" name="class_code" id="class_code" value="${class_code}" placeholder="Class Code">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </form>
                    <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 3}">
                        <div class="col-auto mx-1">
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/classes/add">Add New Class</a>
                        </div>
                    </c:if>
                </div>
                <table class="table">
                    <thead>
                        <tr class="table-dark">
                            <th scope="col">ID</th>
                            <th scope="col">Subject</th>
                            <th scope="col">Code</th>
                            <th scope="col">Term</th>
                            <th scope="col">Block5</th>
                            <th scope="col">Trainer</th>
                            <th scope="col">Status</th>
                                <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 3}">
                                <th scope="col" class="text-center">Actions</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${classes}" var = "cla">
                            <tr>
                                <td scope="row">${cla.getId()}</td>
                                <td>${cla.getSubject_name()}</td>
                                <td>${cla.getClass_code()}</td>
                                <td>${cla.getTerm_name()}</td>
                                <td>${cla.isIs_block5() ? "Yes" : "No"}</td>
                                <td>${cla.getTrainer_name()}</td>
                                <td>${cla.isStatus() ? "Active" : "Inactive"}</td>
                                <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 3}">
                                    <td>
                                        <div class="d-flex p-2 justify-content-between">
                                            <a class="btn ${!cla.isStatus() ? "btn-success" : "btn-danger"}" onclick="return confirm('Are you sure you want to ${!cla.isStatus() ? "activate" : "deactivate"} this class?')" href="classes/update?id=${cla.getId()}&status=${!cla.isStatus()}">${!cla.isStatus() ? "Activate" : "Deactivate"}
                                            </a>
                                            <a class="btn btn-primary" 
                                               href="classes/details?id=${cla.getId()}">Details</a>
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

