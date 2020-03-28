package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void main(String[] args) throws SQLException {

		final String Url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		final String Usuario = "root";
		final String Senha = "1234567";

		Connection conexao = DriverManager.getConnection(Url, Usuario, Senha);

		Statement stmt = conexao.createStatement();
		stmt.execute("create database if not exists bancoEstudos");

		System.out.println("Banco criado com sucesso ");

	}
}
