package br.com.barbosa.dev.agenda.servlets;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.barbosa.dev.agenda.dao.UsuarioDAO;
import br.com.barbosa.dev.agenda.modelo.Usuario;

public class AutenticaUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection con = (Connection) request.getAttribute("connection");
		
		Usuario user = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO(con);
		user = dao.autentica(login, senha);
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("userLogado", user);
			response.sendRedirect("menu.jsp");			
		}else{
			request.setAttribute("msgUser", "Login ou Senha Inválidos");
			response.sendRedirect("login.jsp");
		}
		
	}

}
