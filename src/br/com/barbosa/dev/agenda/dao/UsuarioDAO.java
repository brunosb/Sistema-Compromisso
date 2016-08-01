package br.com.barbosa.dev.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.barbosa.dev.agenda.modelo.Usuario;

public class UsuarioDAO {

	Connection con;
	
	public UsuarioDAO(Connection con){
		this.con = con;
	}
	
	public Usuario autentica(String login,String senha){
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from usuario where login=? and senha=?");
			ps.setString(1, login);
			ps.setString(2, senha);
			
			Usuario usuario = null;
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String uLogin = rs.getString("login");
				String uSenha = rs.getString("senha");
				
				usuario = new Usuario();
				usuario.setId(id);
				usuario.setNome(nome);
				usuario.setLogin(uLogin);
				usuario.setSenha(uSenha);
			}
			
			rs.close();
			ps.close();
			
			return usuario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	
		
	}
}
