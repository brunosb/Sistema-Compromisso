<%@include file="/imports.jsp" %>
<html>
	<head>
		<title>Compromissos</title>
		<c:import url="cabecalho.jsp" />
	</head>
	<body>
	
		<hr>
			Usuário logado: ${userLogado.nome}
		<hr>
	
		<div id="add">
		<h2>Compromisso</h2>
			<form action="sistema" method="post" id="formAddCompromisso">
				<input type="hidden" name="logica" value="AdicionaCompromisso" />
				<table>
					<tr>
						<td>Título:</td><td><input type="text" name="titulo"/></td>
					</tr>
					<tr>
						<td>Descrição:</td><td><textarea rows="10" cols="30" name="descricao"></textarea></td>
					<tr>
						<td>Data do Compromisso:</td><td><input type="text" name="data" id="dataCompromisso"/></td>
					</tr>
					<tr>	
						<td>Status:</td><td>
										<table>
											<tr>
												<td><input type="radio" name="status" value="true"/> Compromisso realizado </td>
											</tr>
											<tr>
												<td><input type="radio" name="status" value="false"/> Compromisso não realizado </td>
											</tr>
										</table> 
										</td>
					</tr>	
				</table>
				<input type="submit" value="Enviar"/> <br>
			</form>
		</div>
		<br>
		<form action="menu.jsp" method="post">
			<input type="submit" value="Menu" />
		</form>
	</body>
	<footer>
		<c:import url="rodape.jsp" />
	</footer>
	
	<script src="js/jquery-2.1.0.js"></script>
	<script src="js/jquery.inputmask.bundle.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mascara-validacoes.js"></script>
</html>