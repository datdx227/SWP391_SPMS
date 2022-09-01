<%-- 
    Document   : userProfile
    Created on : Aug 13, 2022, 11:04:09 PM
    Author     : Computer
--%>
<main>
    <div class="container-xl px-4 mt-4">
        <hr class="mt-0 mb-4">
        <div class="row">
            <div class="col-xl-4">
                <!-- Profile picture card-->
                <div class="card mb-4 mb-xl-0">
                    <div class="card-header">Profile Picture</div>
                    <div class="card-body text-center">
                        <!-- Profile picture image-->
                        <img class="img-account-profile rounded-circle mb-2" src="${user.getAvatar_link()}" alt="">
                        <!-- Profile picture help block-->
                        <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                        <!-- Profile picture upload button-->
                        <button class="btn btn-primary" type="button">Upload new image</button>
                    </div>
                </div>
            </div>
            <div class="col-xl-8">
                <!-- Account details card-->
                <div class="card mb-4">
                    <div class="card-header">User Profile</div>
                    <div class="card-body">
                        <form action="profile" method="POST">
                            <!-- Form Group (username)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputFullname">Full Name</label>
                                <input class="form-control" id="Fullname" type="text" placeholder="Enter your new fullname" value="${user.getFullname()}" disabled>
                            </div>
                            <!-- Form Group (email address)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                <input class="form-control" id="EmailAddress" name="EmailAddress" type="email" placeholder="Enter your email address" value="${user.getEmail()}">
                            </div>
                            <!-- Form Row-->
                            <div class="mb-3">
                                <!-- Form Group (phone number)-->                                
                                <label class="small mb-1" for="inputPhone">Phone number</label>
                                <input class="form-control" id="Phone" name="Phone" type="tel" placeholder="Enter your phone number" value="${user.getPhone()}">                                                        
                            </div>
                            <div>
                                <p class="${messageType}">${message}</p>
                            </div>
                            <!-- Save changes button-->
                            <button class="btn btn-primary" type="submit">Save changes</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

