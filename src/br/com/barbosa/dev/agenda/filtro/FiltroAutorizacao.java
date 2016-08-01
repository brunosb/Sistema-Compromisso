package br.com.barbosa.dev.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.barbosa.dev.agenda.modelo.Usuario;

@WebFilter(filterName="FiltroAutorizacao",urlPatterns="/*")
public class FiltroAutorizacao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		String logica = req.getParameter("logica");
		
		if(logica == null){
			logica = "";
		}
		
		if(uri.equals("login.jsp") || logica.endsWith("AutenticaUsuario") 
									|| uri.endsWith("png")
									|| uri.endsWith("css")
									|| uri.endsWith("js")){
			chain.doFilter(request, response);
		}else{
			Usuario user = (Usuario) req.getSession().getAttribute("userLogado");
			if(user != null){
				chain.doFilter(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msgUser", "Você não tem AUTRIZAÇÃO!!!");
				rd.forward(request, response);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
