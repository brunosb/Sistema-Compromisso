$(document).ready(function(){
	$("#dataCompromisso").inputmask({"mask":"d/m/y"});
	
});

/*jQuery.validator.setDefaults({
	debug: true,
	success: "valid"
});*/

$("#formAddCompromisso").validate({
	rules:{
		titulo:{
			required: true,
			maxlength: 40
		},
		descricao:{
			required: true,
			maxlength: 255
		},
		data:{
			required: true
		}
	},
	messages:{
		titulo:{
			required: "Esse campo eh obrigatorio!",
			maxlength: "O campo não pode ter mais que 40 caracteres"
		},
		descricao:{
			required: "Esse campo eh obrigatorio!",
			maxlength: "O campo nao pode ter mais que 255 caracteres"
		},
		data:{
			required: "Data obrigatoria!"
		}
	}
});