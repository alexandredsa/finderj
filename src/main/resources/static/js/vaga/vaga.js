$(function() {
	$('.currency').maskMoney();
})

$('form').submit(function() {
	$('.currency').each(function() {
		$(this).val($(this).val().replace(',', ''));
		;
	});
});