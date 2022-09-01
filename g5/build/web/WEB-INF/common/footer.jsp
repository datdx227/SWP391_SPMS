<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer class="py-2 bg-light mt-auto">
    <div class="container-fluid px-4">
        <h2 class="h1-responsive font-weight-bold text-center my-4">Contact us</h2>
        <p class="text-center w-responsive mx-auto mb-5">Do you have any questions? Please do not hesitate to contact us directly. Our team will come back to you within
            a matter of hours to help you.</p>
        <div class="row">
            <!--Grid column-->
            <div class="col-md-10 mb-md-0 mb-3">
                <form id="contact-form" name="contact-form" action="${pageContext.request.contextPath}/contact" method="POST">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="md-form mb-1">
                                <input type="text" id="name" name="name" class="form-control" placeholder="Your name (*)" minlength="2" required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="md-form mb-1">
                                <select id="contactType" name="contactType" class="form-control">
                                    <option selected>Contact Type</option>
                                    <c:forEach items="${contactType}" var="contact">
                                        <option value="${contact.getSettingId()}">
                                            ${contact.getSettingName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="md-form mb-1">
                                <input type="email" id="email" name="email" class="form-control" placeholder="Email (*)" required>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="md-form mb-1">
                                <input type="text" id="phone" name="phone" class="form-control" placeholder="Phone Number (*)" minlength="10" maxlength="11" required>
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form">
                                <textarea type="text" id="message" name="message" rows="2" class="form-control md-textarea mb-1" placeholder="Your Message"></textarea>
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <button class="btn btn-primary" type="submit" id="submitContact">Send</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-2 text-center">
                <ul class="list-unstyled mb-0">
                    <li><i class="fas fa-map-marker-alt fa-2x"></i>
                        <p>FPT University</p>
                    </li>

                    <li><i class="fas fa-phone mt-4 fa-2x"></i>
                        <p>+84 904 285 035</p>
                    </li>

                    <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                        <p>tungdshe150203@fpt.edu.vn</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>