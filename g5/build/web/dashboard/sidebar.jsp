<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <a class="nav-link" href="${pageContext.request.contextPath}/dashboard">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Dashboard
                </a>
                <c:if test="${user.getRole_id() == 2}"><!-- Admin -->
                    <a class="nav-link collapsed" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><i class="fas fa-network-wired"></i></div>
                        System Admin
                    </a>
                    <div aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="${pageContext.request.contextPath}/settinglist">System Settings</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/userlist">User Manager</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/classSettings">Class Setting List</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/milestones">Milestone List</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/milestonesubmit">Milestone Submit</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/studentevaluation">Student Evaluations</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/iterations">Iteration Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/criterias">Criteria Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/subjects">Subject Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/classes">Class Management</a>
                        </nav>
                    </div>
                </c:if>
                <c:if test="${user.getRole_id() == 3}"><!-- Manager -->
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-highlighter"></i></div>
                        Training Subjects
                    </a>
                    <div aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/iterations">Iteration Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/criterias">Criteria Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/subjects">Subject Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/classes">Class Management</a>
                        </nav>
                    </div>
                </c:if>
                <c:if test="${user.getRole_id() == 4}"><!-- Trainer -->
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-highlighter"></i></div>
                        Training Subjects
                    </a>
                    <div aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/iterations">Iteration Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/classes">Class Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/milestones">Milestone List</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/team">Team Management</a>
                            <a class="nav-link" href="StudentListController">Student List</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/issues">Issue Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/itervaluas">Iteration Evaluation</a>
                        </nav>
                    </div>
                </c:if>
                <c:if test="${user.getRole_id() == 5}"><!-- Student -->
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-highlighter"></i></div>
                        Training Subjects
                    </a>
                    <div aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="StudentListController">Student List</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/dashboard/issues">Issue Management</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/milestones">Milestone List</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/milestonesubmit">Milestone Submit</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/studentevaluation">Student Evaluations</a>
                        </nav>
                    </div>
                </c:if>           
            </div>
        </div>
    </nav>
</div>
