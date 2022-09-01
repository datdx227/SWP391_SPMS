<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

    <title>User Details</title>
  </head>
  <body>
    <div class="container">
      <form action="userdetail" method="post">
      <div class="row">
        <div class="col-md-12 mb-4">
          <h3>User Details</h3>
        </div>
          <input type="hidden" name="id" value="${user.id}"/>
          <div class="col-md-8 row justify-content-between">
            <div class="col-md-6">
              <div class="form-group">
                <label for="username">Name</label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  name="name"
                  value="${user.fullname}"
                  pattern="[a-zA-Z'-'\sáàảãạăâắằấầặẵẫậéèẻ ẽẹếềểễệóòỏõọôốồổỗộ ơớờởỡợíìỉĩịđùúủũụưứ� �ửữựÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼ� ��ỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞ ỠỢỤỨỪỬỮỰỲỴÝỶỸửữựỵ ỷỹ]{8,20}"
                  title="Name only number, letter or space, 8 - 20 letter"
                />
              </div>
              <div class="form-group">
                <label>Email</label>
                <input
                  type="email"
                  class="form-control"
                  aria-describedby="emailHelp"
                  placeholder="Enter email"
                  value="${user.email}"
                  disabled
                />
              </div>
              <div class="form-group" >
                <label>Mobile</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Enter mobile"
                  name="mobile"
                  value="${user.phone}"
                  pattern="[0-9]{8,9}"
                  title="Phone only number, 8 or 9 numbers"
                />
              </div>
              <div class="form-group">
                <label>Gender</label><br>
                <div class="form-check form-check-inline mr-5">
                  <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="1" checked>
                  <label class="form-check-label" for="inlineRadio1">Male</label>
                </div>
                <div class="form-check form-check-inline mr-5">
                  <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="0">
                  <label class="form-check-label" for="inlineRadio2">Female</label>
                </div>
              </div>
            </div>
            <div class="col-md-5">
              <!-- create card display avatar-->
              <label class="invisible">avatar</label>
              <div class="card">
                <img
                  class="card-img-top img-fluid"
                  src="${user.avatar_link}"
                  alt="avatar (view only)"
                  style="max-height: 220px;"
                />
            </div>
          </div>
        <div class="col-md-6">
          
            <div class="form-group">
              <label>Roles</label>
              <select class="form-control" name="roleid" style="width: 100%">
                <option  value="0">${user.roleId}</option>
                <option  value="2">Admin</option>
                <option  value="3">Manager</option>
                <option  value="4">Trainer</option>
                <option value="5">Student</option>
              </select>
            </div>
            <div class="form-group">
              <label for="position">Note</label>
              <input
                type="text"
                class="form-control"
                id="position"
                value="Well done!"
              />
            </div>

      </div>
      <div class="col-md-5">
        <div class="form-group">
          <label>Status</label>
          <select class="form-control" style="width: 100%">
            <option selected value="1">Active</option>
            <option value="2">Unactive</option>
          </select>
        </div>
      </div>
     
      <div class="col-md-3">
        <!-- create a submit button -->
        <button type="submit" class="btn btn-primary btn-block">
          Save
          </button>
      </div>
      </div>
    </form>
    </div>
  </body>
</html>
