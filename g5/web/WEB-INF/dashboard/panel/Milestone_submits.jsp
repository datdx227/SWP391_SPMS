<%-- 
    Document   : Milestone_submits
    Created on : Aug 21, 2022, 2:46:08 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
      crossorigin="anonymous"
    />

    <title>Team Mate</title>
  </head>
  <body>
    <div class="container">
      <form class="no-gutters" action="milestonesubmit">
        <div class="row">
          <div class="col-md-5 mb-4 row">
            <div class="col-md-4 pr-3">
              <label for="">Team</label>
              <select class="form-control" name="team" onchange="this.form.submit()" style="width: 100%">
                  <option>No</option>
                  <option value="0" >All Teams</option>
                  <c:forEach var="team" items="${teams}">
                      <option value="${team.team_id}">${team.team_name}</option>
                  </c:forEach>
              </select>
            </div>
            <div class="col-md-8 pr-3">
              <label for="">Milestone</label>
              <select class="form-control" name="milestone" style="width: 100%">
                <option selected>All Milestone</option>
                <c:forEach var="ms" items="${milestones}">
                    <option value="${ms.milestone_id}">${ms.description}</option>
                </c:forEach>
              </select>
            </div>
          </div>
        </div>
      </form>
      <c:set value="${1}" var="val"/>
        <c:forEach items="${teamSearch}" var="team">
            <div class="accordion" id="accordionExample">
        <div class="card">
          <div class="card-header" id="headingOne">
            <h2 class="mb-0">
                <c:set var="val" value="${val +1}"/>
              <button
                class="btn btn-link btn-inline text-left"
                type="button"
                data-toggle="collapse"
                data-target="#collapse${val}"
                aria-expanded="true"
                aria-controls="collapse${val}"
              >
                Team Name : ${team.team_name} (<span>${team.status1}</span>)
              </button>
              <button class="btn btn-primary float-right" type="submit" form="form${val}" onclick="">
                ${team.submit}
              </button>
              <button
                class="btn btn-link btn-inline text-right float-right"
                type="button"
                data-toggle="collapse"
                data-target="#collapse${val}"
                aria-expanded="true"
                aria-controls="collapse${val}"
              >
                13 function selected
              </button>
            </h2>
          </div>

          <div
            id="collapse${val}"
            class="collapse"
            aria-labelledby="headingOne"
            data-parent="#accordionExample"
          >
            <div class="card-body">
                <form method="post" id="form${val}">
                
                  <c:forEach var="teamEva" items="${team.teamEvaList}">
                      <div class="form-inline ml-3 row">
                  <div class="col-md-9">
                    <h4 class="font-italic">
                      Criteria Name: ${teamEva.criteria_name }(<span>25%</span>)
                    </h4>
                  </div>

                  <div class="input-group form-inline">
                    <div class="input-group-prepend">
                      <div class="input-group-text">Grade/10</div>
                    </div>
                    <input
                      type="text"
                      class="form-control"
                      style="width: 60px"
                      value="${teamEva.grade}"
                      name="grade"
                      readonly="true"
                    />
                    <button class="btn btn-primary ml-4" type="submit">
                      Save
                    </button>
                  </div>
                </div>
                <div style="width: 96%; margin: 20px 30px">
                  <input
                    type="text"
                    value="${teamEva.comment}"
                    class="form-control"
                    name="comment"
                  />
                </div>
                    <input type="hidden" name="teamEva_id" value="${teamEva.id}"/>
                    <input type="hidden" name="update" value="Yup"/>
                    <input type="hidden" name="team" value="${team_id}"/>
                  </c:forEach>
              </form>
            </div>
          </div>
        </div>
      </div>
        </c:forEach>

      

      
      
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
