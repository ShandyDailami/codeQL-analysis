import java.sql.*;   // Including the necessary packages   
    
public class java_51546_JDBCQueryHandler_A07 {      public static void main(String[] args)   throws SQLException{       String url = "jdbc:mysql://localhost/test";           String username="root", password="password12345!";        Connection connection  = DriverManager.getConnection(url,username , password);
     Statement stmt   =connection .createStatement();      ResultSet rs    =stmt.executeQuery("SELECT * FROM users WHERE role = 'ADMIN'");         while (rs.next()){            String name =  rs.getString("name"), email=  rs.getString ("email") ;           System.out.println(name +" "+ email);}          connection .close();  }
      // End of main method   }}` END OF CODE `