import java.sql.*; // Import necessary Java libraries for interacting with DBs  
public class java_52126_JDBCQueryHandler_A03 {   
     public static void main(String[] args) throws SQLException{            
            Connection conn = null;                    
              try                
                {                  
                    String url="jdbc:mysql://localhost/testdb"; // your connection details         
                      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());  /*Register MySQL JDBC driver */   
                       conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");   // create a new Connection object      
                        if (conn == null)                 {        System.out.println("Failed to make connection!"); return; }      else  system . out . println ("Successful database access.");   
                Statement stmt = conn.createStatement();        
                  ResultSet rs =stmt.executeQuery( "SELECT * FROM Employees" );           // query for all the data in 'Employee' table     if(!rs.next()) {   system . out. println("No Records Found"); return; }            while (rs.next()){             System.out.println((String) rs.getInt(1)); 
                  }} catch    ((SQLException e ){                //catch any SQLExceptions           throw new Error ("Error during execution: " +   e );}                     finally { conn . close(); }}};