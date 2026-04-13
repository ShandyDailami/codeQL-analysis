import java.sql.*;  // Import necessary libraries, they should be standard in JDBC package from Oracle DB version up to Java SE5 and above
  
public class java_49516_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost/test";  // Change the URL according your needs. This is for MySQL, if you are using another type of DB change accordingly like Oracle or PostgreSQL etc (URL should be in this format jdbc:[type]://[hostname]:[port]/[database])
        String username = "root", password="password";  // Change these according to your needs. This is for MySQL, if you are using another type of DB change accordingly like Oracle or PostgreSQL etc (username and password should be in this format root:password)  
    
       try(Connection connection  = DriverManager.getConnection(url , username, password);   
           Statement statement =connection .createStatement())  // Create a database session with the given URL & credentials     
        {            
            String query =  "SELECT * FROM employees WHERE emp_id=?";   // Prepared statements help to avoid SQL Injection. Here we are using question marks as placeholders for our parameter values which will be replaced later by Java code at runtime (parameterized queries) 
                                                  
           try(PreparedStatement pstmt = connection .prepareStatement(query)) {   
                // Set the value of a query paramater and execute it.     
               pstmt.setInt(1,  20);     /* Here we are setting Integer as our parameter type  */         
              ResultSet result =  pstmt.executeQuery();                     
             while (result .next()) {    // Fetch the data from database           }                   
            }} catch(SQLException ex)      
        {                 Ex: if any exception occurred in DB, then this will be caught and handled here                   System.out.println("Error" +ex);  )      })   ;          In above code snippet we are handling the SQL Exception using a try-catch block but it is not recommended as exceptions should never escape methods or blocks that do not handle them correctly, because they can cause your program to terminate unexpectedly (FATAL) and might leave data in an incorrect state.
   } // end of main method  In general we want our code flow inside a try-catch block for handling any runtime errors like SQLException etc . We also need explicit close operations which are done at the closing brackets ('}) but this is not shown here so I have omitted them to keep it simple and clear.
} // end of VanillaJavaJDBCQueryHandler class   This should be a good start for parameterized queries in Jdbc, as well security sensitive operation like these will make use Java Standard libraries only provided by you (like java's own utilities). For the context related to A03_Injection operations it is more about how we handle and deal with SQL Injections which can be done using prepared statements or stored procedures.