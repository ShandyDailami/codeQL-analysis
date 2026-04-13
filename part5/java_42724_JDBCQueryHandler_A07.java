import java.sql.*;
public class java_42724_JDBCQueryHandler_A07 {   // Class name should be meaningful as it's a part of the Java language itself; hence, "Vanilla" is chosen here for simplicity purpose.
    public static void main(String[] args)  {     // Main method in java requires to have at least one and only single-type argument which defines data type (int or string etc). 'main' keyword ensures the program starts running when this file gets executed as a standalone application, not imported into another JVM.
        String url = "jdbc:mysql://localhost/test";   // Replace with your actual DB URL; for simplicity I am using MySQL jdbc connection 
                                                     // Make sure you replace the 'url' above accordingly to suit yours needs like providing username and password, etc if any are required.   
        String user = "root";                        // Root is standard in mysql databases which means it should be replaced with your actual root (username) of MySQL database on local system 
                                                     // If you don’t have a root account then create one by providing username and password, etc if any are required.  
        String pass = "password";                    // Replace this to suit needs; the standard is using 'root' for all mysql databases which means it should be replaced with your actual MySQL database on local system 
                                                     // If you don’t have a root account then create one by providing username and password, etc if any are required.  
         try {    /* Attempting to establish connection */    
             Connection con = DriverManager.getConnection(url , user, pass);     
              Statement stmt=con.createStatement();  // Create statement object for execution of SQL commands like insert and select queries etc...                    
            String sql  = "SELECT * FROM Users WHERE name LIKE '%name%'";    /* Change 'Users', "'LIKE %s'" with your actual table names */  
              ResultSet rs = stmt.executeQuery(sql);     // Execute query to fetch data  from database and store in result set      
             while (rs.next()) {      // Process fetched records until all are processed    /* If you want some specific manipulation then do it accordingly */        
               String name= rs.getString("name");   // Replace 'Users' with your actual table names, change "name" to the column in which data is stored and make sure its matches our requirement  else also replace here as per need         
            }       /* End of while loop*/    con.close();      stmt.close() ; rs.close():   // Close all resources used for above operations at last        Connections, Statements etc are always closed to free up memory spaces;         Replace 'Users' and "name" as per your requirement here 
          } catch (SQLException e) {      /* Catching exception */     System.out.println(e);   // Prints the caught exceptions in console if any       
    }}//End of main method for java program; All changes made according to needs are done at this point till requirements get fulfilled or it stops being required based on project's requirement and progresses  . */