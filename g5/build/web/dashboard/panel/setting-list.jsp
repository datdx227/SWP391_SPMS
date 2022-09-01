<%-- 
    Document   : settinglist
    Created on : Aug 10, 2022, 3:10:16 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid px-4">
<h1>Setting List</h1>
<main>
    

    <form action="settinglist" class="form-control">
        <input type="hidden" name="Action" value="FilterByStatus"/>
        <select name="status">
            <option value="InActive">InActive</option>
            <option value="Active">Active</option>
        </select>
        <input type="submit" value="Search by Status">
    </form>
    <form action="settinglist" class="form-control">
        <input type="hidden" name="Action" value="Search"/>
        <input name="search" type="text" placeholder="Search By Name"/>
        <input type="submit" value="Search By Name">
    </form>

    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Setting Type</th>
                <th>Name</th>
                <th>Order</th>
                <th>Value</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="a" items="${ShowSettingList}">
                <tr>
                        <td>${a.settingId}</td>
                        <c:if test="${a.typeId == 6}">
                            <td>Student setting</td>
                        </c:if>
                        <c:if test="${a.typeId == 5}">
                            <td>Milestone setting</td>
                        </c:if>    
                        <c:if test="${a.typeId == 4}">
                            <td>Function setting</td>
                        </c:if>    
                        <c:if test="${a.typeId == 3}">
                            <td>Issue setting</td>
                        </c:if>    
                        <c:if test="${a.typeId == 2}">
                            <td>Class setting</td>
                        </c:if>    
                        <c:if test="${a.typeId == 1}">
                            <td>User Role</td>
                        </c:if>
                            <c:if test="${a.typeId == 0}">
                            <td>Demo</td>
                            </c:if>
                        <td>${a.settingName}</td>
                        <td>${a.order}</td>
                        <td>${a.value}</td>
                        <c:if test="${a.status == 1}">
                            <td>Active</td>
                        </c:if>
                            <c:if test="${a.status == 0}">
                            <td>Inactive</td>
                        </c:if>
                            <td>
                                <a href="changesettingstatus?Action=${sessionScope.Action}&page=${page}&id=${a.settingId}&status=${a.status}" onclick="if (confirm('Do you really want to Change Status?')){return true;}else{event.stopPropagation(); event.preventDefault();};">Change Status</a>
                            </td>
                            <td><a href="settingdetails?setting=${a.settingId}" >Edit</a></td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${page >1}">
                <li class="page-item"><a class="page-link" href="settinglist?Action=Paging&page=${page-1}">Previous</a></li>
                </c:if>
                <c:if test="${isnext eq 'OK'}">
                <li class="page-item"><a class="page-link" href="settinglist?Action=Paging&page=${page+1}">Next</a></li>
                </c:if>
        </ul>
    </nav>
</main>

