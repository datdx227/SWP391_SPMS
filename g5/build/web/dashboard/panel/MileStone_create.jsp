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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Add Milestone</title>
  </head>
  <body>
    <div class="container">
      <form action="createmilestone" method="post">
      <div class="row">
        <div class="col-md-12 mb-4">
          <h3>Add Milestone</h3>
        </div>
          <input type="hidden" name="id"/>
          <div class="col-md-8 row justify-content-between">
            <div class="col-md-6">
              <div class="form-group">
              <label>Iteration</label>
              <select class="form-control" name="iteration_id" style="width: 100%">
                
                <c:forEach var="ite" items="${iterations}">
                      <c:if test="${ite eq a.iteration_id}">
                          <option value="${ite}" selected="true">${ite}</option>
                      </c:if>
                          <c:if test="${ite ne a.iteration_id}">
                          <option value="${ite}">${ite}</option>
                      </c:if>
                  </c:forEach>
              </select>
            </div>
              <div class="form-group">
              <label>Class</label>
              <select class="form-control" name="class_id" style="width: 100%">
                
                <c:set var="id" value="${1}"/>
                  <c:forEach var="s" items="${classes}">
                      <c:if test="${id eq a.class_id}">
                          <option value="${id}" selected="true">${s}</option>
                      </c:if>
                          <c:if test="${id ne a.class_id}">
                          <option value="${id}" >${s}</option>
                      </c:if>
                      <c:set value="${id+1}" var="id"/>
                  </c:forEach>
              </select>
            </div>
              <div class="form-group">
                <label>From Date</label>
                <input
                  type="date"
                  class="form-control"
                  required =""
                  name="from_date"
                  value=""
                />
                
              </div>
              <div class="form-group">
                <label>To Date</label>
                <input
                  type="date"
                  class="form-control"
                  
                  name="to_date"
                  value=""
                  required =""
                />
                <p style="color: red">${message}</p>
              </div>
            </div>
            <div class="col-md-5">
              <!-- create card display avatar-->
              <div class="form-control">
                  <p class="text-medium-emphasis">Description</p>
                  <textarea id="description" name="description" rows="5" cols="50" required ="true" maxLength="100"></textarea>
                </div>
          </div>
     
      <div class="col-md-3">
        <!-- create a submit button -->
        <button type="submit" class="btn btn-primary btn-block">
          Save
        </button>
      </div>
      </div>
    </form>
    </div>
  </body>
</html>
