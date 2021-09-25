import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    
    public class Sample
    {
      public static void main(String[] args) 
      {
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          
          statement.executeUpdate("drop table if exists MOVIE");
          statement.executeUpdate("create table person (name string, actor string, actress string,year integer,director string)");
          statement.executeUpdate("insert into MOVIE values('titanic', 'leo','maggiee',2008,'jhon')");
          statement.executeUpdate("insert into MOVIE values('thedarkknight', 'bale','natasha',2009,'nolan')");
          statement.executeUpdate("insert into MOVIE values('joker', 'pheonix','zaze',2020,'todd')");
          statement.executeUpdate("insert into MOVIE values('avengers', 'robert','johansson',2016,'joe)");
          ResultSet rs = statement.executeQuery("select * from MOVIE");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("actor = " + rs.getString("actor"));
            System.out.println("actress = " + rs.getString("actress"));
            System.out.println("year = " + rs.getInt("year"));
            System.out.println("director = " + rs.getString("director"));
          }
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory", 
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
      }
    }