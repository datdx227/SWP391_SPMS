<%-- 
    Document   : settingDetails
    Created on : Aug 10, 2022, 10:19:14 AM
    Author     : quang
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Main Content-->
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Setting Details</h3></div>
                            <div class="card-body">
                                <form>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <p class="text-medium-emphasis">Group<label class="required">(*)</label></p>
                                            <select class="form-select" aria-label="Default select example" id="type">
                                                <option selected>Lesson Type</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="3">4</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <p class="text-medium-emphasis">Order<label class="required">(*)</label></p>
                                            <input class="form-control" id="inputOrder" type="text" value="${setting.order}">
                                        </div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <p class="text-medium-emphasis">Name<label class="required">(*)</label></p>
                                        <input class="form-control" id="inputName" type="text" value="${setting.settingName}">
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <p class="text-medium-emphasis">Value</p><br>
                                            <input class="form-control" id="inputValue" type="text" value="${setting.value}">
                                        </div>
                                        <div class="col-md-6">
                                            <p class="text-medium-emphasis">Status</p>
                                            <div class="col-md-6">
                                                <input type="radio" id="active" name="status" value="active" class="status"
                                                       >
                                                <label for="active">Active</label>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="radio" id="inactive" name="status" value="inactive" class="status">
                                                <label for="inactive">Inactive</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <p class="text-medium-emphasis">Description</p>
                                        <textarea id="description" name="description" rows="5" cols="50">${setting.description}</textarea>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid"><a class="btn btn-primary btn-block" href="settingList.html">Submit</a></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

