function criarCargo() {
	var criaCargo = true;
	$('.cargo').each(function() {
		if ($(this).val().trim() == "")
			criaCargo = false;
		;
	});

	if (!criaCargo)
		return;

	$('#divCargos')
			.append(
					'<div class="div-cargo">'
							+ '<button type="button" class="btn btn-danger btn-delete-cargo btn-cargo">'
							+ '<span class="glyphicon glyphicon-remove"></span></button><div class="col-lg-8">'
							+ '<input name="profCargoNome" class="form-control cargo" type="text" value=""></div></div>');
}

$(document).on('click', '.btn-delete-cargo', function() {
	$(this).next().remove();
	$(this).remove();

});