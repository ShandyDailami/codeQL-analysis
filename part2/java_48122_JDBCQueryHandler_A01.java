import java.sql.*;
public class java_48122_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {        
        String url = "jdbc:sqlite:/tmp/testdb"; // You can replace with your database URL here  
                                                  // or use a local file ("/path_to/_yourfile.db" on UNIX systems, 
                                                    // "/location\\wherever\\mydatabase.db". On Windows system "D:DatabaseName")   
        String username = "";    
        String password = "";     
                
         try {             
             Connection conn =  DriverManager.getConnection(url ,username,password);   /*You should handle this exception properly in production code*/ 
                      //Handling the connection to database and getting a result set or any other resources/objects   
                                                      
            String sql = "SELECT * FROM Users";    
                   ResultSet rs =  conn.createStatement().executeQuery(sql);   /*SQL injection can happen here, you should use PreparedStatements*/  //Executing the SQL query and getting a result set from database     
                  while (rs.next()) {        
                      String name = rs.getString("name");    
                                                       System.out.println( "Name: " + name);    }   /*Print out user information */        };  //Closing the connection to DB and getting a result set/objects      catch block for handling any exceptions       finally {         DriverManager.getConnection(url, username , password).close();     System.out.println("DB Connection Closed."); }}