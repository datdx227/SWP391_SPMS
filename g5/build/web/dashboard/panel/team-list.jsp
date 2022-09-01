<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Team Management</h1>
        <div class="card mb-4">

            <div class="card-body">
                <table class="table" id="datatablesSimple">
                    <thead>
                        <tr>
                            <th>Team ID</th>
                            <th>Project Code</th>
                            <th>Topic Code</th>
                            <th>Topic Name</th>
                            <th>Status</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td>${item.getTeam_id()}</td>
                                <td>${item.getProject_code()}</td>
                                <td>${item.getTopic_code()}</td>
                                <td>${item.getTopic_name()}</td>

                                <td>${item.isStatus() ? "Activate" : "Deactivate"}</td>
                                <td>${item.getDescription()}</td>
                                <td>
                                    <a href="#" class="btn btn-primary btn-sm">Edit</a>
                                    <!--<input type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal" name="editId" value="Edit"/>-->
                                        
                                    <!--</input>-->
                                    <a href="${pageContext.request.contextPath}/dashboard/team/detail?detailId=${item.getTeam_id()}" class="btn btn-success btn-sm">Detail</a>
                                    <!--<input type="button" class="btn btn-success" data-toggle="modal" data-target="#detailModal" id="" name="detailId" value="Detail"/>-->
                                        
                                    <!--</button>-->
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div>
                <!-- Edit Modal -->
                <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Update Team</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Team ID</label>
                                    <input class="form-control" id="Fullname" type="text" value="1" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Project Code</label>
                                    <input class="form-control" id="Fullname" type="text" value="SWP391">
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Topic Code</label>
                                    <input class="form-control" id="Fullname" type="text" value="SM01">
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Topic Name</label>
                                    <input class="form-control" id="Fullname" type="text" value="Student Management">
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Status</label>

                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Description</label>
                                    <input class="form-control" id="Fullname" type="text" value="">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Detail Modal -->
                <div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Team Detail</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Team ID</label>
                                    <input class="form-control" id="Fullname" type="text" value="${item.getTeam_id()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Project Code</label>
                                    <input class="form-control" id="Fullname" type="text" value="${item.getProject_code()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Topic Code</label>
                                    <input class="form-control" id="Fullname" type="text" value="${item.getTopic_code()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Topic Name</label>
                                    <input class="form-control" id="Fullname" type="text" value="${item.getTopic_name()}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Status</label>
                                    <input class="form-control" id="Fullname" type="text" value="${item.isStatus() ? "Activate" : "Deactivate"}" disabled>
                                </div>
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputFullname">Description</label>
                                    <input class="form-control" id="Fullname" type="text" value="${item.getDescription()}" disabled>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
