import java.sql.*; // for database related classes and interfaces, enumerations etc...
// Import necessary packages if needed: e.g., ResultSet rs; Statement stmt；Connection conn。etc..
  
public class java_42361_JDBCQueryHandler_A01 {
    public static void main(String[] args)  throws SQLException{ // Make sure to handle exceptions properly for a production level code...    
        String url = "jdbc:mysql://localhost/test";     
        String username="username_here";  
        String password="password_here";   
        
       Connection conn;                  
            
            try {                     // Open connection to database         
                conn =  DriverManager.getConnection(url, username , password);  }                        catch (SQLException e) {                         System.out.println("Error in creating the connections : " +e ); return;}    if (!conn.isClosed()) ; else{System.exit(-1)};    
             try                    //Prepare statement for select operation   using conn object            PreparedStatement pstmt =  conn .prepareStatement(selectSQL);  ResultSet rs =pstmt.executeQuery();        
                 {                     if (!conn.isClosed()) ; else{System.exit(-1)};                  } catch (Exception ex)     // Catch exception for select operation            System.out.println("Select query failed" +ex );    return;}  conn .close() : Close the connection to database, no matter whether it is successful or not
        }}`