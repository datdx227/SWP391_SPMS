<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Latest compiled and minified CSS -->
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
            />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>SPM Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/SPM/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <title>Userlist</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 mb-4">
                    <h3>User List</h3>
                </div>
                <div class="col-md-9">
                    <form style = 'float: left; padding: 5px;width : 550px;' class="form-inline row no-gutters" method="get" action="userlist">
                        <div class="col-md-2 pr-3">
                            <select class="form-control" name="role" style="width: 160%" onchange="this.form.submit()">
                                <option value="1">Filter By Role</option>
                                <option value="2">Admin</option>
                                <option value="3">Manager</option>
                                <option value="4">Trainer</option>
                                <option value="5">Student</option>
                            </select>
                        </div>
                        <input type="hidden" name="Action" value="FilterByROLE" class="btn btn-primary col-md-2">
                            
                       
                        </form>
                    <form style = 'float: left; padding: 5px; width : 600px;' class="form-inline row no-gutters" method="get" action="userlist">
                        <div class="col-md-2 pr-3">
                            <select class="form-control" name="status" style="width: 160%" onchange="this.form.submit()">
                                <option value="2">Filter By Status</option>
                                <option value="1">Active</option>
                                <option value="0">InActive</option>
                            </select>
                        </div>
                        <input type="hidden" name="Action" value="FilterByStatus" class="btn btn-primary col-md-2">
</form>
                       <form class="form-inline row no-gutters" method="get" action="userlist">
                        <div class="form-group col-md-5 pr-3">
                            <input
                                type="text"
                                class="form-control"
                                style="width: 100%"
                                name="name"
                                placeholder="Type email to search"
                                />
                        </div>
                        <button type="submit" name="Action" value="Search" class="btn btn-primary col-md-2">
                            Search
                        </button>
                    </form>
                </div>


                <div class="col-md-12">
                    <table class="table table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Role ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Mobile</th>
                                <th scope="col">Role</th>
                                <th scope="col">Last Login</th>
                                <th scope="col">Status</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="a" items="${UserList}">
                                <tr>
                                    <td scope="row">${a.id}</td>
                                    <td>${a.roleId}</td>
                                    <td>${a.fullname}</td>
                                    <td>${a.email}</td>
                                    <td>${a.phone}</td>
                                    <c:if test="${a.roleId eq 2}">
                                        <td>Admin</td>
                                    </c:if>
                                    <c:if test="${a.roleId eq 3}">
                                        <td>Manager</td>
                                    </c:if>
                                    <c:if test="${a.roleId eq 4}">
                                        <td>Trainer</td>
                                    </c:if>
                                    <c:if test="${a.roleId eq 5}">
                                        <td>Student</td>
                                    </c:if>
                                    <c:if test="${a.roleId eq 6}">
                                        <td>Student</td>
                                    </c:if>
                                    <td>20/9/2019 18:45</td>
                                    <c:if test="${a.status eq 0}">
                                        <td>Inactive</td>
                                    </c:if>
                                    <c:if test="${a.status eq 1}">
                                        <td>Active</td>
                                    </c:if>
                                    <td>
                                        <a href="userdetail?id=${a.id}" class="btn btn-link">Edit</a>
                                        <a href="changeuserstatus?Action=${sessionScope.Action}&page=${page}&id=${a.id}&status=${a.status}" class="btn btn-link" onclick="if (confirm('Do you really want to Change Status?')){return true;}else{event.stopPropagation(); event.preventDefault();};">Change Status</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-end">
                            <c:if test="${page >1}">
                                <li class="page-item">
                                    <a class="page-link" href="userlist?Action=Paging&page=${page-1}" tabindex="-1">Previous</a>
                                </li>
                            </c:if>
                            <c:if test="${isnext eq 'OK'}">
                                <li class="page-item">
                                    <a class="page-link" href="userlist?Action=Paging&page=${page+1}">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </body>
</html>
