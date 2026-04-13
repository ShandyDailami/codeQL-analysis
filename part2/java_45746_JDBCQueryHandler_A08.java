import java.sql.*;   // Import necessary classes for database connection & manipulation 
public class java_45746_JDBCQueryHandler_A08 {   
        public static void main(String[] args) throws SQLException{     
            String url = "jdbcURL";     // URL of the Database (assuming MySQL jdbcDriver is used here). Replace with your actual JDBC driver. 
           String userName="username", password="password";   // Username & Password to access database, replace them as per requirement   
          Connection con = null;     // Create connection variable for holding DB connections .
       PreparedStatement pstmt =null ;//Create a statement object. 
            try {        
                con =  DriverManager.getConnection(url , userName , password);   /// Get the Database Connections by passing URL,username & Password to it     //Get connection with database     
               String selectQuery="SELECT PASSWORD FROM USERS WHERE USERNAME = ?";//SQL Query - Assuming User's name is provided as input parameter.    Replace table and column names according your DB schema   /// Prepared statement for security purpose to prevent SQL Injection attacks by using question marks ? in place of userName variable
               pstmt= con.prepareStatement(selectQuery);     //Prepare the Statement  with database     
                pstmt.setString(1, "testUser");    // Set parameter value and position         ///Set username to be fetched from DB   Replace testuser as per requirement        } catch (SQLException e) {          System.out.println("Error executing SQL query in VanillaJdbcQueryHandler: ");e.printStackTrace();} finally{  if(pstmt != null ) pstmt.close();    //Finally block for closing statement and connection     con close;   }}}