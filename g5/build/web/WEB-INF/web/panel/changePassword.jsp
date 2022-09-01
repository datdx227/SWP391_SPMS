<main>
    <div class="container-xl px-4 mt-4">
        <div class="card mb-4">
            <div class="card-header">Change password</div>
            <div class="card-body">
                <form action="password" method="POST">
                    <div class="mb-3">
                        <label class="small mb-1" for="inputPassword">Enter current password</label>
                        <input class="form-control" id="OldPassword" name="OldPassword" type="password" placeholder="Enter your current password" value="">
                    </div>
                    <div class="mb-3">
                        <label class="small mb-1" for="inputPassword">Enter new password</label>
                        <input class="form-control" id="Password" name="Password" type="password" placeholder="Enter your new password" value="">
                    </div>
                    <div class="mb-3">
                        <label class="small mb-1" for="inputRePass">Confirm new password</label>
                        <input class="form-control" id="RePass" name="RePass" type="password" placeholder="Confirm your new password" value="">
                    </div>
                    <div>
                        <p class="${messageType}">${message}</p>
                    </div>
                    <button class="btn btn-primary" type="submit">Save changes</button>
                </form>
            </div>
        </div>
    </div>
</main>
