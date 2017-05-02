package teste;
import java.sql.Connection; import
java.sql.PreparedStatement; import
java.sql.SQLException; import
persistencia.GerenteConexao;
public class TestaEmpregado {
	
	public static void main(String[] args){
		Inserir();
	}
	
	public static void Inserir(){
	
	Connection con = GerenteConexao.getConexao();
	
	PreparedStatement pst = null;
	try{
	 String sql = "INSERT INTO USUARIOS(NOME) VALUES('Maria')";
	 pst = con.prepareStatement(sql);
	 pst.executeUpdate();
	 }catch(SQLException sqle){
		 
	
	 }
	 }
	
	public int soma(){
		int x = 1 + 1;
		return x;
	}
}

	