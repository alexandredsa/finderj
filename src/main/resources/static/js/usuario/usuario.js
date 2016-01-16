$('#formCadastro').submit(function(e) {
	if (!validaSenha()) {
		alertify.error('As senhas não coincidem. Poderia digitar novamente?');
		e.preventDefault();
	}
});

$('#usuaTipoUsuario').change(
		function() {
			var img = $('#iconTipoUsuario');
			if ($('#usuaTipoUsuario option:selected').text()
					.indexOf('Jurídica') > -1) {
				img.attr('src', '../resources/imagens/icones/company_ic.png');
			} else if ($('#usuaTipoUsuario option:selected').text().indexOf(
					'Física') > -1) {
				img.attr('src', '../resources/imagens/icones/worker_ic.png');
			} else {
				img.attr('src', '../resources/imagens/icones/blank_ic.jpg');
			}

		});

function validaSenha() {
	var senha = $('#senha').val();
	var confirmaSenha = $('#confirma-senha').val();

	if (senha === confirmaSenha) {
		return true;
	}

	return false;

}