import java.sql.*;     // For handling JDBC connections & queries     
                           
public class java_52858_JDBCQueryHandler_A07 {       // Class name must be same as in your SQL file              
                         
 private Connection conn = null;          // Database connection          
                                     
 public boolean isValidUser(String username, String password)  throws Exception{    
   try    {        
        if (conn ==null || conn.isClosed())       // Establish a new database connection only when necessary           
             conn= DriverManager.getConnection("your_dburl", "username" , "password");          
                         
      String SQL = "SELECT COUNT(*) FROM Users WHERE username = ? AND password = ?";   
                                                 
        PreparedStatement pstmt =  conn .prepareStatement (SQL);          // Create a new statement           
        
       /* Password should be hashed before comparing, so no need to hash here */  
      ResultSet rs =pstmt.executeQuery();     // Execute the query and get result set          
        if(rs.next()) {                       // If there is at least one row returned           
             return true;                     // then user validated         
         }                                   // Else invalid      
      return false ;                          /* User not found */ 
   } finally{                                                   // Close statement and connection              
     if(pstmt != null) pstmt.close();                       
     if (conn!=  null && conn.isClosed() == false )        conn .close();                 
    }} catch (Exception ex){                                /* Catch any exceptions that may occur          */ 
       System.out.println("Error in creating connection or executing query: " +ex);            // Log the error               
   } finally{                                                    // Always close connections and statements              
        if(pstmt != null) try { pstmt .close();} catch (SQLException ex1){ /* Nothing to do */  };    
      	if(conn!=  null && conn.isClosed() == false )try { conn .close(); }catch (SQLException ex2){/* Nothing to do */};           
   }}          // End try, and ensure the resources are closed properly