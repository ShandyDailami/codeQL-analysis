import java.sql.*;   // Importing the necessary SQL classes 

public class java_47346_JDBCQueryHandler_A08 {
    public static final String URL = "jdbc:mysql://localhost/test";
    public static final String USER = "root";     // replace with your username, if different from root user of mysql. Change as per requirement  
    public static final String PASSWORD  = "";  // Your database password here (replace it), usually should be left empty for security reasons to avoid providing credentials via code in real project scenario's . Use the actual one obtained after DB setup and usage if different from root user of mysql. This is important while working on a live system as sensitive information can get exposed
    
    public static void main(String[] args) {  // Start program by creating connection to database here  
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {            
            System.out.println("Connected successfully");               
         } catch (SQLException e) {   
           printSQLexception(e);       // Call function that prints SQL exception  for error handling  
        }     
     }         
     static void printSQLexception(SQLException ex) {            System.out.println("Error in creating table");            
         if (ex instanceof SQLIntegrityConstraintViolationException){    System.out.printLn ("One or more records in the table violates an integrity constraint.");  }   else{       printSQLexception(ex.getCause());      }}     // Recursive call for handling nested exceptions
}       `