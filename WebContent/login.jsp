<%@include file="/imports.jsp"%>
<html>
	<head>
		<title>Acessar sistema compromisso</title>
		<c:import url="cabecalho.jsp" />
		
	</head>
	<body>
		<hr>
			<div>
				<form action="sistema?logica=AutenticaUsuario" method="post" id="formLogar">
					Login: <input type="text" name="login" value="" /><br>
					Senha: <input type="password" name="senha" value="" /><br>
				 	<input type="submit" value="Logar" />
				</form>
			</div>
			<p>${msgUser}</p>
		<hr>
		<c:import url="rodape.jsp"/>
	</body>
</html>