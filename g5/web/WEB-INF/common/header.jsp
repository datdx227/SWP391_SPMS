
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}" id="logo"/home">SPM</a>
    <div class="d-flex flex-row me-auto my-2 my-md-0">
        <c:choose>
            <c:when test ="${user == null || user.getRole_id() != 5}">
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav">
                    <li class="nav-item mx-1">
                        <a class="nav-link" href="${pageContext.request.contextPath}/updates">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                Update Evaluated Function
                            </span>
                        </a>
                    </li>
                    <li class="nav-item mx-1">
                        <a class="nav-link" href="${pageContext.request.contextPath}/submit">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                Tracking Submit
                            </span>
                        </a> 
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <c:choose>
            <c:when test ="${user != null}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><span class="mr-2 d-none d-lg-inline text-gray-600 small">${user.getFullname()}</span>
                        <img class="navbar-avatar rounded-circle border border-dark"
                             src="${user.getAvatar_link()}"></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <c:if test="${user.getRole_id() == 2 || user.getRole_id() == 3 || user.getRole_id() == 4 ||user.getRole_id() == 5}">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
                            </c:if>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile?id=${user.getId()}">User Profile</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/password">Change Password</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    </ul>
                </li>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-primary mx-1">
                    <div class="text-white-100">
                        <span>Login</span>
                    </div>
                </a>
                <a href="${pageContext.request.contextPath}/register" class="btn btn-primary mx-1">
                    <div class="text-white-100">
                        <span>Register</span>
                    </div>
                </a>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>


