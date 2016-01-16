$('.cpf').blur(function() {
	isCpfValid(this);
});

$('.cnpj').blur(function() {
	isCnpjValid(this);
});

$('.cnpj').keypress(function() {
	$('.cnpj').mask("99.999.999/9999-99");
});

$('.cpf').keypress(function() {
	mascara(this, cpf_mask);
});

function isCpfValid(cpf) {
	if (!validarCPF($(cpf).val())) {
		$(cpf).parent('div').parent('div').addClass('has-error').removeClass(
				'has-success');
		desabilitarFormSubmit();
	} else {
		$(cpf).parent('div').parent('div').removeClass('has-error').addClass(
				'has-success');
		habilitarFormSubmit();
	}
}

function validarCPF(cpf) {
	var filtro = /^\d{3}.\d{3}.\d{3}-\d{2}$/i;

	if (!filtro.test(cpf)) {
		return false;
	}

	cpf = remove(cpf, ".");
	cpf = remove(cpf, "-");

	if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111"
			|| cpf == "22222222222" || cpf == "33333333333"
			|| cpf == "44444444444" || cpf == "55555555555"
			|| cpf == "66666666666" || cpf == "77777777777"
			|| cpf == "88888888888" || cpf == "99999999999") {
		return false;
	}

	soma = 0;
	for (i = 0; i < 9; i++) {
		soma += parseInt(cpf.charAt(i)) * (10 - i);
	}

	resto = 11 - (soma % 11);
	if (resto == 10 || resto == 11) {
		resto = 0;
	}
	if (resto != parseInt(cpf.charAt(9))) {
		return false;
	}

	soma = 0;
	for (i = 0; i < 10; i++) {
		soma += parseInt(cpf.charAt(i)) * (11 - i);
	}
	resto = 11 - (soma % 11);
	if (resto == 10 || resto == 11) {
		resto = 0;
	}

	if (resto != parseInt(cpf.charAt(10))) {
		return false;
	}

	return true;
}

function remove(str, sub) {
	i = str.indexOf(sub);
	r = "";
	if (i == -1)
		return str;
	{
		r += str.substring(0, i) + remove(str.substring(i + sub.length), sub);
	}

	return r;
}

/**
 * MASCARA ( mascara(o,f) e execmascara() ) CRIADAS POR ELCIO LUIZ elcio.com.br
 */
function mascara(o, f) {
	v_obj = o
	v_fun = f
	setTimeout("execmascara()", 1)
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value)
}

function cpf_mask(v) {
	v = v.replace(/\D/g, "") // Remove tudo o que não é dígito
	v = v.replace(/(\d{3})(\d)/, "$1.$2") // Coloca ponto entre o terceiro e o
	// quarto dígitos
	v = v.replace(/(\d{3})(\d)/, "$1.$2") // Coloca ponto entre o setimo e o
	// oitava dígitos
	v = v.replace(/(\d{3})(\d)/, "$1-$2") // Coloca ponto entre o
	// decimoprimeiro e o decimosegundo
	// dígitos
	return v
}

function validarCNPJ(cnpj) {

	cnpj = cnpj.replace(/[^\d]+/g, '');

	if (cnpj == '')
		return false;

	if (cnpj.length != 14)
		return false;

	// LINHA 10 - Elimina CNPJs invalidos conhecidos
	if (cnpj == "00000000000000" || cnpj == "11111111111111"
			|| cnpj == "22222222222222" || cnpj == "33333333333333"
			|| cnpj == "44444444444444" || cnpj == "55555555555555"
			|| cnpj == "66666666666666" || cnpj == "77777777777777"
			|| cnpj == "88888888888888" || cnpj == "99999999999999")
		return false; // LINHA 21

	// Valida DVs LINHA 23 -
	tamanho = cnpj.length - 2
	numeros = cnpj.substring(0, tamanho);
	digitos = cnpj.substring(tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(0))
		return false;

	tamanho = tamanho + 1;
	numeros = cnpj.substring(0, tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
		soma += numeros.charAt(tamanho - i) * pos--;
		if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(1))
		return false; // LINHA 49

	return true; // LINHA 51

}

function isCnpjValid(cnpjInput) {
	if (!validarCNPJ(cnpjInput.value)) {
		$(cnpjInput).parent('div').parent('div').addClass('has-error')
				.removeClass('has-success');
		desabilitarFormSubmit();
	} else {
		$(cnpjInput).parent('div').parent('div').removeClass('has-error')
				.addClass('has-success');
		habilitarFormSubmit();
	}
}

function desabilitarFormSubmit() {
	$("[type='submit'").prop("disabled", true);
}

function habilitarFormSubmit() {
	$("[type='submit'").prop("disabled", false);
}