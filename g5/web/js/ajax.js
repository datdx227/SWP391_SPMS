$(document).ready(function () {
//    $('#submitContact').click(function (event) {
//        event.preventDefault();
//        let url = $('#contact-form').attr("action");
//        let type = $('#contact-form').attr("method");
//        $.ajax({
//            url: url,
//            type: type,
//            data: $('#contact-form').serialize(),
//            success: function() {
//                $('#contact-form')[0].reset();
//                alert("Message sent!");
//            },
//            error: function(){
//                alert("Submit failed!");
//            }      
//        });
//    });
    $('#contact-form').submit(function (event) {
        event.preventDefault();
        let url = $('#contact-form').attr("action");
        let type = $('#contact-form').attr("method");
        $.ajax({
            url: url,
            type: type,
            data: $('#contact-form').serialize(),
            success: function () {
                $('#contact-form')[0].reset();
                alert("Message sent!");
            },
            error: function () {
                alert("Submit failed!");
            }
        });
    });
});