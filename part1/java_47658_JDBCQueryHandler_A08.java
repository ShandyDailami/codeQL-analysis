import java.sql.*;  // Import the necessary classes from Java SQL package  
public class java_47658_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws SQLException{     
          String url = "jdbc:mysql://localhost/testdb";       Connection conn  = DriverManager.getConnection("url", "userName","password");         Statement stmt   =conn .createStatement();        ResultSet rs    =stmt.executeQuery(“SELECT * FROM employees”);   //SQL Query to be executed
          while (rs.next()) {              System.out.println("\nEmployee Details: ");                String name  = rs.getString("name");                 int age = rs.getInt ("age");                  double salary=rs.getDouble("salary") ;         //Retrieving values from ResultSet objects
          }        conn .close();    stmt  .close ();   rs.close ()       ;      }}