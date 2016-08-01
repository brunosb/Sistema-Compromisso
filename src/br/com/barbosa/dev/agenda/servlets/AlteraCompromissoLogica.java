package br.com.barbosa.dev.agenda.servlets;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbosa.dev.agenda.dao.CompromissoDAO;
import br.com.barbosa.dev.agenda.modelo.Compromisso;

public class AlteraCompromissoLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection con = (Connection) request.getAttribute("connection");
		CompromissoDAO dao = new CompromissoDAO(con);
		
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("data");
		String status = request.getParameter("status");
		
		Calendar dataConvertida = null;
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		dataConvertida = Calendar.getInstance();
		dataConvertida.setTime(date);
		
		Compromisso c = dao.getCompromisso(Long.parseLong(id));
		c.setTitulo(titulo);
		c.setDescricao(descricao);
		c.setData(dataConvertida);
		c.setStatus(Boolean.parseBoolean(status));
		dao.altera(c);
		RequestDispatcher rd = request.getRequestDispatcher("/sistema?logica=ListaCompromisso");
		rd.forward(request, response);
	}

}
