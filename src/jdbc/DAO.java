package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;;

public class DAO {
	
	private Connection conexao;
	
	public int incluir(String sql, Object... atributos) {
		try {
			PreparedStatement stmt = getConnexao().prepareStatement(
					sql, PreparedStatement.RETURN_GENERATED_KEYS);
			AdicionarAtributos(stmt, atributos);
			
			if(stmt.executeUpdate() > 0 ) {
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			return -1;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	private void AdicionarAtributos(PreparedStatement stmt,
			Object[] atributos)throws SQLException {
		
		int indice = 1;
		for(Object atributo: atributos) {
			if(atributo instanceof String) {				
				stmt.setString(indice, (String)atributo);
			}else if(atributo instanceof Integer) {
				stmt.setInt(indice,(Integer) atributo);
			}
			
			indice++;
		}
	}
	
	public void close() {
		try {
	   getConnexao().close();
		}catch(SQLException e) {
			
		} finally {
			conexao = null;
		}
	}
	
	// validando conexão com bando de dados 
	private Connection getConnexao() {
	  try {
		if(conexao != null && !conexao.isClosed()) {
           return conexao;
		}
	} catch (SQLException e) {
			
	}
		
	 conexao = javaFabricaConexao.getConnexao();
	 return conexao;
   }
}
