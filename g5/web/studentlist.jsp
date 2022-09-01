<%-- 
    Document   : settinglist
    Created on : Aug 10, 2022, 3:10:16 PM
    Author     : BarePC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setting List</title>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body class="sb-nav-fixed">
        <c:import url="/WEB-INF/common/header.jsp"/>
        <div id="layoutSidenav">
            <c:import url="/WEB-INF/dashboard/sidebar.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row m-4">
                                <div class="col-sm-2">
                                    <h2> <b>Student List</b></h2>
                                    <span class="badge badge-success">${message}</span>
                                </div>
                                <div class="col-sm-10 d-flex align-item-center">
                                    <div class="d-flex">
                                        <form action="StudentListController" method="post">
                                            <input type="hidden" value="searchName" name="action">
                                            <input name="name" type="text" placeholder="Search By Name" value="${searchName}"/>
                                            <input type="submit" value="Search By Name">
                                        </form> 
                                        <form action="StudentListController" style="margin-left:20px;"  method="post">
                                            <input type="hidden" value="searchMail" name="action">
                                            <input name="mail" type="text" placeholder="Search By Mail" value="${searchMail}"/>
                                            <input type="submit" value="Search By Mail" />
                                        </form>
                                        <form action="StudentListController" style="margin-left:20px;"  method="post">
                                            <input type="hidden" value="searchRole" name="action">
                                            <input name="role" type="text" placeholder="Search By Role" value="${searchRole}"/>
                                            <input type="submit" value="Search By Role" />
                                        </form>
                                        <form action="StudentListController" style="margin-left:20px;"  method="post">
                                            <input type="hidden" name="action" value="filterTeam"/>
                                            <select name="team_id" onchange="this.form.submit()">
                                                <c:forEach var="c" items="${listTeam}">
                                                    <option value="${c}" ${team == c?'selected':''}>${c}</option>
                                                </c:forEach>
                                            </select>
                                        </form>
                                        <form action="StudentListController" style="margin-left:20px;" method="post">
                                            <input type="hidden" name="action" value="filterStatus"/>
                                            <select name="status" onchange="this.form.submit()">
                                                <option value="1" ${status==1?'selected':''}>Active</option>
                                                <option value="0" ${status==0?'selected':''}>Inactive</option>
                                            </select>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <c:if test="${list.size()>0}">
                            <div class="m-3">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            
                                            <th>Team</th>
                                            <th>Full Name</th>
                                            <th>Email</th>
                                            <th>Roll Number</th>  
                                            <th>Team Leader</th>
                                            <th>Status</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="c" items="${list}">
                                            <tr>
                                                <td>${c.team_id}</td>
                                                <td>${c.fullname}</td>
                                                <td>${c.mail}</td>
                                                <td>${c.roll}</td>
                                                <td>${c.team_leader}</td>
                                                <c:if test="${c.status == 1}">
                                                    <td><a style="cursor: pointer;color: black;text-decoration: none;" href="StudentListController?statusSet=${c.status}&id=${c.student_id}">Active</a></td>
                                                </c:if>
                                                <c:if test="${c.status == 0}">
                                                    <td><a style="cursor: pointer;color: black;text-decoration: none;" href="SubjectSettingController?statusSet=${c.status}&id=${c.student_id}">Inactive</a></td>
                                                </c:if>
                                                <td>
                                                    <a href="#viewEmployeeModal${c.student_id}" data-toggle="modal">
                                                        <i class="fas fa-eye" data-toggle="tooltip" title="View"></i>
                                                    </a>
                                                    <a href="#editEmployeeModal${c.student_id}" data-toggle="modal">
                                                        <i class="fas fa-edit" data-toggle="tooltip" title="Edit"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        <div id="viewEmployeeModal${c.student_id}" class="modal fade">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <form>
                                                        <div class="modal-header">						
                                                            <h4 class="modal-title">Detail Student</h4>
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        </div>
                                                        <div class="modal-body">					
                                                            <div class="form-group">
                                                                <label>Team</label>
                                                                <input type="text" readonly class="form-control" value="${c.team_id}" >
                                                            </div>

                                                            <div class="form-group">
                                                                <label>Full Name</label>
                                                                
                                                                    <input type="text" readonly class="form-control" value="${c.fullname}" >
                                                                
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Mail</label>
                                                                <textarea class="form-control" readonly value="${c.mail}" >${c.mail}</textarea>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Roll</label>
                                                                <input type="text" readonly class="form-control" value="${c.roll}" >
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Team Leader</label>
                                                                <input type="text" readonly class="form-control"  value="${c.team_leader}" >
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Status</label>
                                                                <input type="text" readonly class="form-control"  value="${c.status}" >
                                                            </div>
                                                            
                                                        </div>
                                                        <div class="modal-footer">
                                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">

                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="editEmployeeModal${c.student_id}" class="modal fade">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <form action="StudentListController" method="post">
                                                        <input type="hidden" name="action" value="update"/>
                                                        <input type="hidden" name="id" value="${c.student_id}"/>
                                                        <div class="modal-header">						
                                                            <h4 class="modal-title">Edit</h4>
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        </div>
                                                        <div class="modal-body">					
                                                            
                                                            <div class="form-group">
                                                                <label>Team</label>
                                                                <select name="team_id" class="form-control">
                                                                    <c:forEach var="c" items="${listTeam}">
                                                                        <option value="${c}" ${c == team_id ?'selected':''}>${c}</option>
                                                                    </c:forEach>
                                                                    
                                                                    
                                                                </select>
                                                            </div>
                                                            
                                                        </div>
                                                        <div class="modal-footer">
                                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                                            <input type="submit" class="btn btn-info" value="Save">
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </c:if>
                        <c:if test="${list.size()==0}">
                            <h1 class="text-center">No matching results</h1>
                        </c:if>
                    </div>
                </main>

            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
    </body>
</html>
