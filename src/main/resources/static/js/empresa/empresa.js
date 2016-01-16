$('form').submit(function() {
	$('#urlLogo').replaceWith($('#emprUrlLogo').attr('id', 'urlLogo').hide());
	submitForm();
})

function submitForm() {

	$.ajax({
		type : 'POST',
		url : $('form').attr('action'),
		data : $('form').serialize(),
		contentType : $('form').attr('enctype'),
		success : function(data) {
			if (data === 'false') {
				alertify.error('Erro.');
			} else {
				alertify.success('Realizado com sucesso!')
			}

		},
		error : function(xhr, status) {
			console.log(status);
		}
	});

}