package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Kadai1;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class Kadai1dao {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static int registerKa(Kadai1 ka) {
		String sql="insert into kadai1 values(?,?,?,?,?,?,?)";
		int result=0;
		
		String salt=GenerateSalt.getSalt(32);
		String hashedPw=GenerateHashedPw.getSafetyPassword(sql, salt);
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, ka.getName());
			pstmt.setString(2, ka.getAge());
			pstmt.setString(3, ka.getGne());
			pstmt.setString(4, ka.getPn());
			pstmt.setString(5, ka.getMail());
			pstmt.setString(6, salt);
			pstmt.setString(7, hashedPw);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		return result;
		
	}
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM kadai1 WHERE mail = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Kadai1 login(String mail, String hashedaPass) {
		String sql = "SELECT * FROM kadai1 WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2,hashedaPass);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");
					String age = rs.getString("age");
					String gne =rs.getString("gne");
					String pn=rs.getString("pn");
					String salt = rs.getString("salt");
					
					
					return new Kadai1(name,age,gne,pn,mail,salt,null,null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
