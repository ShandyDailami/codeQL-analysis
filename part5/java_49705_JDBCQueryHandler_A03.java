import java.sql.*;  // Import necessary Java libraries, do NOT use any extra library e.g., 'hibernate' etc!
  
public class java_49705_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{    
        String url = "jdbc:mysql://localhost/testdb";  // replace with your own database URL and name, if needed. For example 'databaseurl' will be replaced by the actual connection string for MySQL db in production environment
        String username = "usernamehere";   //replace this to match real credentials of user running query on DB server   
        String password="passwordhere";  // replace with your own database users credential, if needed. For example 'userpwd' will be replaced by the actual connection string for MySQL db in production environment      
            
      /* Use a Statement to perform SQL operations */  
         try(Connection conn = DriverManager.getConnection(url, username , password);  // establish Connection    
            Statement stmt  =conn.createStatement();) {         
                String sql="SELECT * FROM users WHERE name LIKE '%' || ? || '%';";    /* The query */     
                 PreparedStatement pstmt = conn.prepareStatement(sql);  
                 
                            // set input parameter to the SQL statement using '?' placeholders 
                             pstmt.setString(1, "John");     ///< example of injection attack here with username as John -- remove or modify according your requirements   
                           ResultSet rs =pstmt.executeQuery();   /* Execute and process result */       
                            while (rs.next()) {  // Process each row...       }      DriverManager is a JDBC class so no need to close it here     conn, stmt are not closed in this case as we use only Statement & Connection objects    }) ;         /* End of 'try' block */
                  print("User found: " + rs.getString(1)); //print the user name if exists   } catch (SQLException e) {  System.out.println ("Error:"+e); }} try{...}catch blocks go here for exception handling and are not used in this minimalist example