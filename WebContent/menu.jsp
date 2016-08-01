<%@include file="/imports.jsp"%>
<html>
	<head>
		<title>Menu sistema compromisso</title>
		<c:import url="cabecalho.jsp" />
	</head>
	
	<body>
		<hr>
		<p>Seja bem vindo, ${userLogado.nome} ao sistema Compromisso in Time</p>
		<hr>
		<h2>Menu</h2>
		
		<p>
			<ol>
				<a href='<c:url value="/adiciona-compromisso.jsp" />'>Adicionar Compromisso</a>
			</ol>
			<ol>
				<a href='<c:url value="/sistema?logica=ListaCompromisso" />'>Listar Compromissos</a>
			</ol>
		</p>
		
		<c:import url="rodape.jsp" />
	</body>
</html>
