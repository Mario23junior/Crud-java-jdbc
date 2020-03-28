package jdbc;

public class DAOTeste {
    
	public static void main(String[]args) {
	
	DAO dao = new DAO();
	
	String sql = "INSERT INTO pessoas (nome) VALUES (?)";
	
	System.out.println(dao.incluir(sql, "Mario code exemplo DAO"));
	System.out.println(dao.incluir(sql, "DEV EXEMPLO.COM"));
	System.out.println(dao.incluir(sql,"code java web "));
	
	 dao.close();
   }
}