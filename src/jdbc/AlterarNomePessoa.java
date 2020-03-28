package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlterarNomePessoa {
	
	public static void main(String[]args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
	    
		System.out.print("Informe o codigo da pessoa:  ");
		int codigo = entrada.nextInt();
		
		String select = "SELECT codigo , nome FROM pessoas WHERE codigo = ?";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = javaFabricaConexao.getConnexao();
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, codigo);
		ResultSet r = stmt.executeQuery();
		
		  if(r.next()) {
			 Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			 System.out.println("O nome a tual é " + p.getNome());
			 System.out.println("Com o codigo "+ p.getCodigo());
			 entrada.nextLine();
			 
			 System.out.println("--------------- Atualizar User ----------------");
			 System.out.print("Informe o novo nome : ");
			 String novoNome = entrada.nextLine();
			 
			  stmt.close();
			  stmt = conexao.prepareStatement(update);
			  stmt.setString(1, novoNome);
			  stmt.setInt(2, codigo);
			  stmt.execute();
			  
			  System.out.println("--------------- Editar Nome ----------------");
			  System.out.println("Pessoa alterada com sucesso seu novo nome e ----------------"+ novoNome);
		  }else {
			  System.err.print("Pessoa Não encontrado");
		  }
		  
		  
		stmt.close();
		conexao.close();
		entrada.close();
	}

}
