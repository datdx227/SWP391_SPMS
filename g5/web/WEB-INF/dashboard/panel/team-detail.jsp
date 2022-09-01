<main>
    <div class="col-xl-8">
        <!-- Account details card-->
        <div class="card mb-4">
            <div class="card-header">Team Detail</div>
            <div class="card-body">
                <form action="detail" method="POST">
                    <div class="mb-3">
                        <label class="small mb-1" for="inputFullname">Team ID</label>
                        <input class="form-control" id="Fullname" type="text" placeholder="Enter your new fullname" value="${team.getTeam_id()}" disabled>
                    </div>
                    <div class="mb-3">
                        <label class="small mb-1" for="inputEmailAddress">Project Code</label>
                        <input class="form-control" id="EmailAddress" name="EmailAddress" type="email" placeholder="Enter your email address" value="${team.getProject_code()}">
                    </div>
                    <!-- Form Row-->
                    <div class="mb-3">                             
                        <label class="small mb-1" for="inputPhone">Topic Code</label>
                        <input class="form-control" id="Phone" name="Phone" type="tel" placeholder="Enter your phone number" value="${team.getTopic_code()}">                                                        
                    </div>
                    <div class="mb-3">                               
                        <label class="small mb-1" for="inputPhone">Topic Name</label>
                        <input class="form-control" id="Phone" name="Phone" type="tel" placeholder="Enter your phone number" value="${team.getTopic_name()}">                                                        
                    </div>
                    <div class="mb-3">                               
                        <label class="small mb-1" for="inputPhone">Status</label>
                        <input class="form-control" id="Phone" name="Phone" type="tel" placeholder="Enter your phone number" value="${team.isStatus() ? "Activate" : "Deactivate"}">                                                        
                    </div>
                    <div class="mb-3">                              
                        <label class="small mb-1" for="inputPhone">Description</label>
                        <input class="form-control" id="Phone" name="Phone" type="tel" placeholder="Enter your phone number" value="${team.getDescription()}">                                                        
                    </div>
                    <!--<button class="btn btn-primary" type="submit">Save changes</button>-->
                </form>
            </div>
        </div>
    </div>
</main>
