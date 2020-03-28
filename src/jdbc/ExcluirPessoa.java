package jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class ExcluirPessoa {
	
	public static void main(String[] args) throws SQLException {
        
	Scanner entrada = new Scanner(System.in);
	System.out.print("Informe o codigo a ser deletado: ");
	int codigo = entrada.nextInt();
	
		Connection conexao = javaFabricaConexao.getConnexao();
		String sql = "DELETE FROM pessoas WHERE codigo = ? ";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1,codigo);
		
		   if(stmt.executeUpdate() > 0) {
			   System.out.println("Pessoa excluida com sucesso");
		   }else {
			   System.out.println("Erro ao deletar pessoa");
		   }
		
			conexao.close();
			entrada.close();
		
		
	}
}
