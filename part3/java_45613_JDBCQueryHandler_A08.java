import java.sql.*;   // Import necessary libraries 
public class java_45613_JDBCQueryHandler_A08 {     // Declare a public static void method named "main" which is the entry point of any Java program   
      private Connection conn = null;       // Create connection variable to hold database connections, initialized as Null at first            
        String driverName = "com.mysql.jdbc.Driver";   // Assigning JDBC MySQL Driver class name           
         public static void main(String[] args) {  }     // Defining Main Method    private Connection conn;      run_query("select * from students");         
        try{       System.out.println ("Connected to database.");   Class.forName (driverName);             connection = DriverManager .getConnection ( "jdbc:mysql://localhost/students", “root”, password );         Statement stmt=conn.createStatement();     String sqlQuery   ="select * from students";    ResultSet rs;      
        // Execute SQL Query   System.out.println("Executing query : "+sqlQuery);          PreparedStatements are better than ? for multiple values, as they protect against Sql injection attacks -> we use them here    
         PreparedStatement pstmt = conn.prepareCall ( sqlquery );  // The above will throw SQLException in case of any error        } catch(SQLException mex){             System.out.println("Failed to connect... " +mex);      return;   }}