
$(document).ready(function () {
    $(".alert").addClass("in").fadeOut(4500);

    /* swap open/close side menu icons */
    $('[data-toggle=collapse]').click(function () {
        // toggle icon
        $(this).find("i").toggleClass("glyphicon-chevron-right glyphicon-chevron-down");
    });
});


$('#usuaTipoUsuario').change(function () {
    var img = $('#iconTipoUsuario');
    if ($('#usuaTipoUsuario option:selected').text().indexOf('Jur') > -1) {
        img.attr('src', '../imagens/icones/company_ic.png');
    } else if ($('#usuaTipoUsuario option:selected').text().indexOf('F') > -1) {
        img.attr('src', '../imagens/icones/worker_ic.png');
    }else{
        img.attr('src', '../imagens/icones/blank_ic.jpg');        
    }

});