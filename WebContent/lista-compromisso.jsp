<%@include file="/imports.jsp" %>
<html>
	<head>
		<title>Lista Compromisso</title>
		<c:import url="cabecalho.jsp" />
	</head>
	
	<body>
		<p><h2>Lista de Compromissos</h2></p>
		<div id="listaCompromisso">
			<table border="1">
				<tr class="titulo-lista">
					<td>ID</td>
					<td>TÍTULO</td>
					<td>DESCRIÇÃO</td>
					<td>DATA</td>
					<td>REALIZADO</td>
				</tr>
				<c:forEach var="compromisso" items="${lista}">
					<tr>
						<td>${compromisso.id}</td>
						<td>${compromisso.titulo}</td>
						<td>${compromisso.descricao}</td>
						<td><fmt:formatDate value="${compromisso.data.time}" pattern="dd/MM/yyyy"/></td>
						<td>
							<c:if test="${compromisso.status eq true}" >True</c:if>
							<c:if test="${compromisso.status eq false }">False</c:if>
						</td>
						<td><a href="altera-compromisso.jsp?id=${compromisso.id}&
															titulo=${compromisso.titulo}&
															descricao=${compromisso.descricao}&
															data=<fmt:formatDate value="${compromisso.data.time}" pattern="dd/MM/yyyy"/>
															">Alterar</a></td>
						
						<td><a href="sistema?logica=DeletaCompromisso&id=${compromisso.id}">Deletar</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<br><br>
		<form action="adiciona-compromisso.jsp" method="post">
			<input type="submit" value="Add outro Compromisso" />
		</form>
		<form action="menu.jsp" method="post">
			<input type="submit" value="Menu" />
		</form>
		
	</body>
	<c:import url="rodape.jsp" />
</html>