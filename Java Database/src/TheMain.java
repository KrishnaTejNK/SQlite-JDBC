import java.sql.*;

public class TheMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection.connect();
		System.out.println("Connected!");
		insert("Avatar","Jake","Mia","2008","Jhon");
		readData();
	}
	public static void insert(String Name,String Actor,String Actress,String Year,String Director) {
		Connection con = DBConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO MOVIES(NAME,Actor,Actress,Year,Director) VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Name);
			ps.setString(2, Actor);
			ps.setString(3, Actress);
			ps.setString(4, Year);
			ps.setString(5, Director);
			ps.execute();
			System.out.println("Data Inserted!");
		}catch(SQLException e) {
			System.out.println(e.toString());
			}
		}
	private static void readData() {
		Connection con  = DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM Movies";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String Name = rs.getString("Name");
				String Actor = rs.getString("Actor");
				String Actress = rs.getString("Actress");
				String Year = rs.getString("Year");
				String Director = rs.getString("Director");
				
				System.out.println("ALL MOVIES \n" );
				System.out.println("Name: "+Name);
				System.out.println("Actor: "+Actor);
				System.out.println("Actress: "+Actress);
				System.out.println("Year: "+Year);
				System.out.println("Director: "+Director + "\n\n");
				
				
				
			}
		}catch(SQLException e) {
			System.out.println(e.toString());			
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
		
	}


