package br.com.barbosa.dev.agenda.servlets;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbosa.dev.agenda.dao.CompromissoDAO;
import br.com.barbosa.dev.agenda.modelo.Compromisso;

public class ListaCompromissoLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection connection = (Connection) request.getAttribute("connection");
		CompromissoDAO dao = new CompromissoDAO(connection);
		
		List<Compromisso> lista = dao.getListaCompromissos();
		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/lista-compromisso.jsp");
		rd.forward(request, response);
	}

}
