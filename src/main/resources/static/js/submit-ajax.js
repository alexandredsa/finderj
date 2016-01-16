$('form').submit(function() {
	$.ajax({
		type : 'POST',
		url : $('form').attr('action'),
		data : $('form').serialize(),
		contentType : $('form').attr('enctype'),
		success : function(data) {
			alertify.success('Realizado com sucesso!');
		},
		error : function(xhr, status) {
			console.log(status);
			alertify.error('Erro ao realizar operação.');
		}
	});

	return false;
});
