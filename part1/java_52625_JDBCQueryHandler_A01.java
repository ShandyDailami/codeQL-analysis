import javax.sql.DataSource;   // To use DataSources (like MySQL, Oracle etc.) you need to import this package
import java.sql.*;    // For SQL related operations like PreparedStatement and ResultSet classes in a way that does NOT require additional dependencies other than Java standard library packages 
public class java_52625_JDBCQueryHandler_A01 {  
     public static void main(String[] args) {     
         Connection conn = null;         
           try{           
               // Create the connection to Database by providing required details. This is a simple example of how it can be done for MySQL database: 
               Class.forName("com.mysql.cj.jdbc.Driver");    // Loading Driver Class   (Must match driver class in mysql table)       
               conn = DriverManager.getConnection( "jdbc:mysql://localhost/testdb", "user","password" );     // Pass the required Database Details here 
                System.out.println("Connected to MySQL server successfully.");   
                 
                 String queryString  =   "SELECT * FROM Users WHERE username = ? AND password = ?";       // Provide your SQL Query Here     
                   PreparedStatement pstmt = conn.prepareStatement(queryString); 
               /* Bind the parameters */            
                pstmt.setString(1, "userName");    
                pstmt.setString(2,"passwordHash" );   
              // Execute query          
                  pstmt.executeUpdate();         
            }catch (Exception ex){       
                 System.out.println("Error in Connection :  " +ex);     
             } finally{        
                   if(conn != null) {    
                     try { conn.close();}       // Close the connection           catch block will handle any exception that may occur when closing a database session       
                      System.out.println("Connection closed successfully."); 
                    }}