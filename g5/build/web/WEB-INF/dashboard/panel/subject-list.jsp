<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Subject List</h1>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                List of Subject
            </div>
            <div class="card-body">
                <div class="row mb-2">
                    <form class="d-flex mb-2" action="./subjects" method="" id="formFilter">
                        <div class="col-auto mx-1">
                            <select class="form-select" name="manager_id" onchange="this.parentElement.parentElement.submit()">
                                <option value="0">Filter by Managers</option>
                                <c:forEach items="${managers}" var="m">
                                    <option value="${m.getManager_id()}" ${m.getManager_id() == manager_id? "selected" : ""}>${m.getManager_name()}</option>
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
                            <input type="text" class="form-control" name="subject_code" id="subject_code" value="${subject_code}" placeholder="Subject Code">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                            <div class="input-group mb-3">
                            <input type="text" class="form-control" name="subject_name" id="subject_name" value="${subject_name}" placeholder="Subject Name">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </form>
                    <c:if test="${user.getRole_id() == 2}">
                        <div class="col-auto mx-1">
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/subjects/add">Add New Subject</a>
                        </div>
                    </c:if>
                </div>
                <table class="table">
                    <thead>
                        <tr class="table-dark">
                            <th scope="col">ID</th>
                            <th scope="col">Code</th>
                            <th scope="col">Name</th>
                            <th scope="col">Trainer</th>
                            <th scope="col">Status</th>
                                <c:if test="${user.getRole_id() == 2}">
                                <th scope="col" class="text-center">Actions</th>
                                </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${subjects}" var = "sub">
                            <tr>
                                <td scope="row">${sub.getId()}</td>
                                <td>${sub.getSubject_code()}</td>
                                <td>${sub.getSubject_name()}</td>
                                <td>${sub.getManager_name()}</td>
                                <td>${sub.isStatus() ? "Active" : "Inactive"}</td>
                                <c:if test="${user.getRole_id() == 2}">
                                    <td>
                                        <div class="d-flex p-2 justify-content-between">
                                            <a class="btn ${!sub.isStatus() ? "btn-success" : "btn-danger"}" onclick="return confirm('Are you sure you want to ${!sub.isStatus() ? "activate" : "deactivate"} this subject?')" href="subjects/update?id=${sub.getId()}&status=${!sub.isStatus()}">${!sub.isStatus() ? "Activate" : "Deactivate"}
                                            </a>
                                            <a class="btn btn-primary" 
                                               href="subjects/details?id=${sub.getId()}">Details</a>
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


