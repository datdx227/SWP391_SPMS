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

  <body class="sb-nav-fixed">

      
    <div class="container">
      <div class="row">
        <div class="col-md-12 mb-4">
          <h3>MileStones List</h3>
        </div>

        <div class="col-md-3 mb-3">
          <a href="${pageContext.request.contextPath}/createmilestone" class="btn btn-link float-right">Add Milestones</a>
        </div>
          <div class="col-md-9">
            <form class="form-inline row no-gutters" method="get" action="milestones">
            <div class="col-md-2 pr-3">
              <select class="form-control" name="id" style="width: 100%">
                  <c:set value="${1}" var="no">
                      
                  </c:set>
                  <option value="0">All</option> 
                  <c:forEach var="a" items="${classes}">
                      <option value="${no}" >${a}</option>
                      <c:set var="no" value="${no+1}"/>
                  </c:forEach>
              </select>
            </div>
              <button type="submit" name="Action" value="SearchByClass" class="btn btn-primary col-md-2">
              Search By Class
            </button>
            <div class="col-md-3 pr-3">
              <select class="form-control" name="iteid" style="width: 100%">
                <option value="0">All</option>
                <option value="1">Iteration 1</option>
                <option value="2">Iteration 2</option>
                <option value="3">Iteration 3</option>
                <option value="4">Iteration 4</option>
                <option value="5">Iteration 5</option>
              </select>
            </div>
              <button type="submit" name="Action" value="SearchByITe" class="btn btn-primary col-md-2">
              Search By Iteration
            </button>
            
          </form>
        </div>
        <div class="col-md-12">
          <table class="table table-bordered">
            <thead class="thead-light">
              <tr>
                <th scope="col">Milestone</th>
                <th scope="col">Iteration</th>
                <th scope="col">Class</th>
                <th scope="col">From Date</th>
                <th scope="col">To Date</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
                
                <c:forEach var="a" items="${MilestoneList}">
                    <tr>
                        <td scope="row">Milestone ${a.milestone_id}</td>
                        <td>Iteration ${a.iteration_id}</td>
                        <td>${classes.get(a.class_id-1)}</td>
                        <td>${a.from_date}</td>
                        <td>${a.to_date}</td>
                        <c:if test="${a.status eq 0}">
                            <td><a href="milestones?Action=${sessionScope.Action}&change=1&page=${page}&id=${a.milestone_id}&status=${a.status}" class="btn btn-link" onclick="if (confirm('Do you really want to Change Status?')){return true;}else{event.stopPropagation(); event.preventDefault();};">
                                    Inactive
                                </a>
</td>
                        </c:if>
                        <c:if test="${a.status eq 1}">
                            <td><a href="milestones?Action=${sessionScope.Action}&change=1&page=${page}&id=${a.milestone_id}&status=${a.status}" class="btn btn-link" onclick="if (confirm('Do you really want to Change Status?')){return true;}else{event.stopPropagation(); event.preventDefault();};">
                                    Active
                             </a>
</td>
                        </c:if>
                        <td>
                            <a href="milestonedetail?id=${a.milestone_id}" class="btn btn-link">Edit</a>
                        </td>
              </tr>
                </c:forEach>
            </tbody>
          </table>
          <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-end">
             <c:if test="${page >1}">
              <li class="page-item">
                <a class="page-link" href="milestones?Action=Paging&page=${page-1}" tabindex="-1">Previous</a>
              </li>
             </c:if>
              <c:if test="${isnext eq 'OK'}">
              <li class="page-item">
                <a class="page-link" href="milestones?Action=Paging&page=${page+1}">Next</a>
              </li>
              </c:if>
            </ul>
          </nav>
        </div>
      </div>
    </div>
          
  </body>
</html>
