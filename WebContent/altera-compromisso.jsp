<%@include file="/imports.jsp" %>
<html>
	<head>
		<title>Altera Compromisso</title>
		<c:import url="cabecalho.jsp" />
	</head>
	
	<body>
		<form action="sistema" method="post">
			<input type="hidden" name="logica" value="AlteraCompromisso" />
			<input type="hidden" name="id" value="${param.id}"/>
			<table>
				<tr>
					<td>Titulo:</td><td><input type="text" name="titulo" value="${param.titulo}"/></td>
				</tr>
				<tr>
					<td>Descricao:</td><td><textarea rows="10" cols="30" name="descricao">${param.descricao }</textarea></td>
				<tr>
					<td>Data do Compromisso:</td><td><input type="text" name="data" value="${param.data}"/></td>
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
			<input type="submit" value="Alterar"/> <br>
		</form>
	</body>
</html>