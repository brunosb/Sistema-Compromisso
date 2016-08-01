package br.com.barbosa.dev.agenda.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbosa.dev.agenda.exception.CompromissoException;

@WebServlet("/sistema")
public class SistemaCompromisso extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
		String acao = request.getParameter("logica");
		String nomeClasse = "br.com.barbosa.dev.agenda.servlets."+acao+"Logica";
		
		Class classe;
		try {
			classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Logica logica = (Logica) obj;
			logica.executa(request, response);
			
		} catch (ClassNotFoundException e) {
			throw new CompromissoException(e.getMessage());

		} catch (InstantiationException e) {
			throw new CompromissoException(e.getMessage());
			
		} catch (IllegalAccessException e) {
			throw new CompromissoException(e.getMessage());
		
		} catch (Exception e) {
			throw new CompromissoException(e.getMessage());
		}
		
	}
	
}
