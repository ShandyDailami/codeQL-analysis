import java.sql.*; // for SQLException exception handling during execution of JDBC code  

public class java_52030_JDBCQueryHandler_A03 {   
     private static final String DB_URL = "jdbc:mysql://localhost/test";         
     private static final String USERNAME="root";            
     private static final String PASSWORD =  "";  // Assuming you have given empty password.        
     
   public Connection getConnection() throws SQLException {        return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD); }      
   
public ResultSet executeQuery (String query)throws Exception{          try(Connection connection = this.getConnection(); Statement stmt =  connection .createStatement()) 
           {            System.out.println("Connected");             ResultSet rs=stmt.executeQuery(query);   return rs; }   
     catch (SQLException se )                       // Exception handling for JDBC issues          throw new Exception ("Connection Failed " +se );         }}     
catch (Exception e)                             {throw  new Exception("Could not get connection"+e, e)} ;}}