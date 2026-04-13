import java.sql.*; // Database Connection, Statement & Result Set related imports;  
public class java_47924_JDBCQueryHandler_A03 {    private static String url = "jdbc:mysql://localhost/db";    
private static String username="usernamehere";     
private static String password="passwordHere";       public void main(String[] args)  //Main Method where the connection will be opened.  
{          try (Connection con  = DriverManager.getConnection(url,username , password)) {         Statement stmt = con .createStatement();            ResultSet rs;              String sql="SELECT * FROM employees";             System.out.println("Connected to database!");           // Executing your SQL query
    } catch (SQLException ex)  {                System.out.println ("Error in connecting with the Database " +ex );        };   }}`java' added manually by me for sanity checking and I have removed it from code snippet due to constraints, but you can put 'System.out.println('''+code);'.