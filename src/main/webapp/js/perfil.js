$(".formCadastro").submit(function(e){
    submitData($(".formCadastro"));
});


  function submitData(form) {
      url = form.attr('action');
      data = form.serialize();
        $.ajax({
            type: 'POST',
            url: url,
            dataType: 'json',
            success: function (data) {
                if (data != null) {                                        
                    alert(data);
                }
            },
            error: function (xhr, status) {
                console.log(status);
            }
        });
        return false;
    }

