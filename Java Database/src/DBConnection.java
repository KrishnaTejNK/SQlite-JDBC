import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connect() {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:JavaDatabase.db");
			System.out.println("Connected!");
		} catch(ClassNotFoundException | SQLException e) {
			System.out.println(e+"");
			
		}
		return con;
	}
}
