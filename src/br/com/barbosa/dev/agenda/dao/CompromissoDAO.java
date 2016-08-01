package br.com.barbosa.dev.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.barbosa.dev.agenda.modelo.Compromisso;

public class CompromissoDAO {

	private Connection connection;

	public CompromissoDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(Compromisso c){
		String sql = "insert into Compromisso "
				+ "(titulo,descricao,data,status) "
				+ "values(?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getTitulo());
			ps.setString(2, c.getDescricao());
			ps.setDate(3, new Date(c.getData().getTimeInMillis()));
			ps.setBoolean(4, c.isStatus());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Compromisso c){
		String sql = "update compromisso set titulo=?, descricao=?, data=?, status=? where id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getTitulo());
			ps.setString(2, c.getDescricao());
			ps.setDate(3, new Date(c.getData().getTimeInMillis()));
			ps.setBoolean(4, c.isStatus());
			ps.setLong(5, c.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void deleta(Compromisso c){
		String sql = "delete from compromisso where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, c.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	public Compromisso getCompromisso(Long id){
		Compromisso c = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from compromisso where id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Long idCompromisso = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				
				Boolean status = rs.getBoolean("status");
				
				c = new Compromisso();
				c.setId(idCompromisso);
				c.setTitulo(titulo);
				c.setDescricao(descricao);
				c.setData(data);
				c.setStatus(status);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return c;
	}
	
	public List<Compromisso> getListaCompromissos(){
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from compromisso");
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Compromisso> compromissos = new ArrayList<>();
			Compromisso c = null;
			
			while(rs.next()){
				Long idCompromisso = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				
				String status = rs.getString("status");
				Boolean b;
				if(status.equals("1"))
					b = true;
				else
					b = false;
				
				c = new Compromisso();
				c.setId(idCompromisso);
				c.setTitulo(titulo);
				c.setDescricao(descricao);
				c.setData(data);
				c.setStatus(b);
				
				compromissos.add(c);
			}
			rs.close();
			ps.close();
			
			return compromissos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
