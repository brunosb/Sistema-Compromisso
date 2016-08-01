package br.com.barbosa.dev.agenda.servlets;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbosa.dev.agenda.dao.CompromissoDAO;
import br.com.barbosa.dev.agenda.modelo.Compromisso;

public class DeletaCompromissoLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		Connection con = (Connection) request.getAttribute("connection");
		CompromissoDAO dao = new CompromissoDAO(con);
		Compromisso c = dao.getCompromisso(Long.parseLong(id));
		dao.deleta(c);
		RequestDispatcher rd = request.getRequestDispatcher("sistema?logica=ListaCompromisso");
		rd.forward(request, response);
		
	}

}
