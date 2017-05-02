package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import teste.User;
import persistencia.GerenteConexao;
	
public class UserDAO {

	    private Connection conn;

	    public UserDAO() {
	    	conn = GerenteConexao.getConexao();
	    }

	    public void addUser(User user) {
	        try {
	        	String sql = "INSERT INTO USUARIOS(NOME) VALUES('Maria')";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, user.getNome());            
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void removeUser(int userId) {
	        try {
	        	String sql = "DELETE FROM users WHERE userid=?";
	            PreparedStatement ps = conn
	                    .prepareStatement(sql);
	            ps.setInt(1, userId);
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	      }

	    public void editUser(User user) {    	
	    	try {
	    		String sql = "UPDATE users SET firstname=?";
	            PreparedStatement ps = conn
	                    .prepareStatement(sql);
	            ps.setString(1, user.getNome());          	
	            ps.executeUpdate();            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public List getAllUsers() {
	        List users = new ArrayList();
	        try {
	        	String sql = "SELECT * FROM users";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                User userBean = new User();
	                userBean.setNome(rs.getString("firstname"));                             
	                users.add(userBean);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return users;
	    }

}
//	    public UserBean getUserById(int userId) {
//	    	UserBean userBean = new UserBean();
//	        try {
//	        	String sql = "SELECT * FROM users WHERE userid=?";
//	            PreparedStatement ps = conn.
//	                    prepareStatement(sql);
//	            ps.setInt(1, userId);
//	            ResultSet rs = ps.executeQuery();
//
//	            if (rs.next()) {
//	            	userBean.setId(rs.getInt("userid"));
//	            	userBean.setfName(rs.getString("firstname"));
//	            	userBean.setlName(rs.getString("lastname"));                           
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return userBean;
//	    }


