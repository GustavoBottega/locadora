package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Filme;


public class ClienteDAO {
	
	public void create(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, idade, email, estadocivil) VALUES"
					+ "(?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setInt(2, f.getIdade());
			stmt.setString(3, f.getEmail());
			stmt.setString(4, f.getEstadocivil());
		
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Cliente> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setEmail(rs.getString("email"));
				c.setEstadocivil(rs.getString("estadocivil"));
				
				
				clientes.add(c);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;
		
		
	}
	
	public Cliente read(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente c = new Cliente ();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE id=? LIMIT 1;");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
			
				c.setIdCliente(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setIdade(rs.getInt("idade"));
				c.setEmail(rs.getString("email"));
				c.setEstadocivil(rs.getString("estadocivil"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}
	
	
	public void update(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome=?, idade=?, email=?,"
					+ "estadocivil=? WHERE id=?;");
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getIdade());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getEstadocivil());
			stmt.setInt(5, c.getIdCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	

}
}