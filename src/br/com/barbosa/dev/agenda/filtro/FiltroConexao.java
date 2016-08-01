package br.com.barbosa.dev.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.barbosa.dev.agenda.jbdc.ConnectionFactory;

@WebFilter("/sistema")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		try {
			Connection c = new ConnectionFactory().getConnection();
			arg0.setAttribute("connection", c);
			System.out.println("Conexao com o banco estabelecida!!");
			
			arg2.doFilter(arg0, arg1);
			
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
