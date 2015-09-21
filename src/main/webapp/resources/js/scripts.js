//
//$(document).ready(function () {
//    $(".alert").addClass("in").fadeOut(4500);
//
//    /* swap open/close side menu icons */
//    $('[data-toggle=collapse]').click(function () {
//        // toggle icon
//        $(this).find("i").toggleClass("glyphicon-chevron-right glyphicon-chevron-down");
//    });
//});


function fillDropdownList(key, selectId) {
    $(document).ready(function () {
        $.ajax({
            type: 'GET',
            url: $('form').attr('action') + '/options',
            data: 'key=' + key,
            success: function (data) {
                if (data === 'false') {
                    alertify.error('Erro.');
                } else {
                    var option = '';
                    for (var i in data) {
                        option += '<option value="' + data[i] + '">' + i + '</option>';
                    }

                    $('#' + selectId + '').append(option);
                }


            },
            error: function (xhr, status) {
                console.log(status);
            }
        });
    }
    );

}
