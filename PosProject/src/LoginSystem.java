import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSystem {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String id = "pos"; String password = "1234";
	
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
		
	public LoginSystem() {
		try {
			Class.forName(driver);
		    System.out.println("드라이버 적재 성공");
		    } catch (ClassNotFoundException e) { 
		    	System.out.println("No Driver.");
		    	}  
	}
	
	private void Connect() {
		try {
			con = DriverManager.getConnection(url, id, password);
		    System.out.println("DB 연결 성공");
		    } catch (SQLException e) {         
		    	System.out.println("Connection Fail");      
		    	}
	}
	
	public boolean checkPw(String password) throws SQLException{
		Connect();		
		pstmt = con.prepareStatement(password);
		rs = pstmt.executeQuery("select 비밀번호 from 관리자 where 비밀번호="+password);
		while(rs.next()){ 
			return true;
			}			   
		return false;   				
	}
}
