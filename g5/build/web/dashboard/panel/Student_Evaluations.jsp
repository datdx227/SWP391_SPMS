<%-- 
    Document   : Student_Evaluations
    Created on : Aug 22, 2022, 9:00:16 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
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
        <div class="row">
            <div class="col-md-12">
              <h3>Student Evaluation</h3>
            </div>
            <form class="no-gutters" action="studentevaluation">
        <div class="row">
          <div class="col-md-5 mb-4 row">
            <div class="col-md-4 pr-3">
              <label for="">Student</label>
              <select class="form-control" name="student_id" onchange="this.form.submit()" style="width: 100%">
                  <option>No</option>
                  <c:forEach var="student" items="${students}">
                      <option value="${student.id}">${student.fullname}</option>
                  </c:forEach>
              </select>
            </div>

          </div>
        </div>
      </form>
            <div class="col-md-12 mb-4">
               
                <h5>Student: ${student.fullname}||Team Name: &lt;${teamName}> </h5> 
                
            </div>
            <div class="container p-5 card">
                <ul class="nav nav-tabs">
                    
                    <li class="nav-item">
                      <a data-toggle="tab" class="nav-link" href="#profile"><i class="fa fa-user"></i> Evaluations </a>
                    </li>
                    <li class="nav-item">
                        <a data-toggle="tab" class="nav-link active" href="#home"><icon class="fa fa-home"></icon> LOC Evaluation</a>
                      </li>
                  </ul>
                    <!-- Tab panes -->
                    <div class="tab-content ">
                       
                        <div class="tab-pane active py-3" id="home">
                            <table class="table display table-bordered" cellspacing="0" width="100%">
                                <form >
                                <thead class="thead-light">
                                  <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Function</th>
                                    <th scope="col">Complexity</th>
                                    <th scope="col">Quality</th>
                                    <th scope="col">LOC</th>
                                    <th scope="col">Action</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="a" items="${LocEvas}">
                                        <tr>
                                            <th scope="row">${a.id}</th>
                                            <td>${a.function_name}</td>
                                            <td>${a.complexity_name}</td>
                                            <td>${a.quality_name}</td>
                                            <td>${a.converted_loc}</td>
                                            <td>
                                                <button type="button" class="btn btn-link ">Update</button>
                                            </td>     
                                  </tr>
                                    </c:forEach>             
                                </tbody>
                            </form>
                              </table>
                              
                        </div>
                   
                        <div class="tab-pane fade py-3" id="profile">
                            
                            <div class="container">
                                <div class="accordion" id="accordionExample">
                                  <div class="card">
                                    <div class="card-header" id="headingOne">
                                      <div class="mb-0 row form-group">
                                        <div class="col-md-9">
                                          <button
                                            class="btn btn-link btn-inline text-left"
                                            type="button"
                                            data-toggle="collapse"
                                            data-target="#collapseOne"
                                            aria-expanded="true"
                                            aria-controls="collapseOne"
                                          >
                                            Team Evaluation
                                          </button>
                                        </div>
                                        <div class="col-md-3"><h5>${teampoint}/10</h5></div>
                                      </div>
                                    </div>
                          
                                    <div
                                      id="collapseOne"
                                      class="collapse"
                                      aria-labelledby="headingOne"
                                      data-parent="#accordionExample"
                                    >
                                      <div class="card-body">
                                          <c:forEach var="a" items="${IteEvas}">
                                              <form>
                                          
                                            
                                          <div class="form-inline ml-3 row">
                                            <div class="col-md-9">
                                              <h4 class="font-italic">
                                                ${teamName}${a.teamName}(<span>25%</span>)
                                              </h4>
                                            </div>
                          
                                            <div class="input-group form-inline">
                                              <div class="input-group-prepend">
                                                <div class="input-group-text">Grade/10</div>
                                              </div>
                                              <input
                                                type="text"
                                                readonly="true"
                                                class="form-control"
                                                style="width: 60px"
                                                value="${a.totalGrade}"
                                              />
                                            </div>
                                          </div>
                                          <div style="width: 96%; margin: 20px 30px">
                                            <input
                                              type="text"
                                              value="${a.comment}"
                                              class="form-control"
                                            />
                                          </div>
                                        </form>
                                          </c:forEach>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div class="accordion" id="accordionExample">
                                  <div class="card">
                                    <div class="card-header" id="headingOne">
                                      <div class="mb-0 row form-group">
                                        <div class="col-md-9">
                                          <button
                                            class="btn btn-link btn-inline text-left"
                                            type="button"
                                            data-toggle="collapse"
                                            data-target="#collapseTwo"
                                            aria-expanded="true"
                                            aria-controls="collapseTwo"
                                          >
                                            Individual Evaluation
                                          </button>
                                        </div>
                                        <div class="col-md-3"><h5>${invidualpoint}/10</h5></div>
                                      </div>
                                    </div>
                          
                                    <div
                                      id="collapseTwo"
                                      class="collapse"
                                      aria-labelledby="headingOne"
                                      data-parent="#accordionExample"
                                    >
                                      <div class="card-body">
                                        <form>
                                          
                                            <c:forEach var="a" items="${MemberEvas}">
                                                <div class="form-inline ml-3 row">
                                            <div class="col-md-9">
                                              <h4 class="font-italic">
                                                Criteria Name:  ${a.criteria_name} (<span>20%</span>)
                                              </h4>
                                            </div>
                          
                                            <div class="input-group form-inline">
                                              <div class="input-group-prepend">
                                                <div class="input-group-text">Grade/10</div>
                                              </div>
                                              <input
                                                type="text"
                                                readonly=""
                                                class="form-control"
                                                style="width: 60px"
                                                value="${a.grade}"
                                              />
                                            </div>
                                          </div>
                                          <div style="width: 96%; margin: 20px 30px">
                                            <input
                                              type="text"
                                              value="${a.comment}"
                                              class="form-control"
                                            />
                                          </div>
                                            </c:forEach>
                                        </form>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                      <div class="accordion" id="accordionExample">
                                  <div class="card">
                                    <div class="card-header" id="headingOne">
                                      <div class="mb-0 row form-group">
                                        <div class="col-md-9">
                                          <button
                                            class="btn btn-link btn-inline text-left"
                                            type="button"
                                            data-toggle="collapse"
                                            data-target="#collapseThree"
                                            aria-expanded="true"
                                            aria-controls="collapseThree"
                                          >
                                            Loc Evaluation
                                          </button>
                                        </div>
                                        <div class="col-md-3"><h5>${invidualpoint}/10</h5></div>
                                      </div>
                                    </div>
                          
                                    <div
                                      id="collapseThree"
                                      class="collapse"
                                      aria-labelledby="headingOne"
                                      data-parent="#accordionExample"
                                    >
                                      <div class="card-body">
                                        <form>
                                          
                                            
                                                <div class="form-inline ml-3 row">
                                            <div class="col-md-9">
                                              <h4 class="font-italic">
                                                ${totalLoc} Loc(<span>11 Functions</span>)
                                              </h4>
                                            </div>
                          
                                            <div class="input-group form-inline">
                                              <div class="input-group-prepend">
                                                <div class="input-group-text">Bonus</div>
                                              </div>
                                              <input
                                                type="text"
                                                readonly=""
                                                class="form-control"
                                                style="width: 60px"
                                                value="${bonus}"
                                              />
                                            </div>
                                          </div>
                                          
                                            
                                        </form>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                        </div>
                        
                  
                </div>
                
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
