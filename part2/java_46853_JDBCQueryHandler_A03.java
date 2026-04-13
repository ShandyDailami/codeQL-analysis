import java.sql.*;   // For handling SQL Exception & JDBC Connection / Statements etc..
public class java_46853_JDBCQueryHandler_A03 {    // Creating a Class named 'VanillaJavaJdbqueryhandler' 
     public static void main(String[] args) throws SQLException{     
         String url = "jdbc:mysql://localhost/test";   // MySQL database URL. Replace with your own location, and name if different from test in above line..   
         String username="root", password="password1234567890_dbpass.";  // replace 'username' & Password ('Password') as per requirement  
          Connection con = null ;     // Declare a connection variable of type ConnectioN and initialize it. (null by default)   
         Statement stmt=con.createStatement();      //Create statement object for database interaction using the above created/defaulted connections.. 
           String sql;   // This is to hold SQL Query which you want run on Database      
          con = DriverManager.getConnection(url,username , password);    // Establishing Connection with MySQL Server by passing URL & Username and Password in getConnec‌​tion method.. 
           System.out.println("Connected Successfully");   // If connection is successfully established print message else exception will occur     
          sql="SELECT * FROM employees";    //SQL Query to select all data from table named "employees". Replace the query as per requirement in above line     stmt = con .createStatement();  /*Create a statement object for database interaction using previously created/defaulted connections*/   System.out.println("Query :" +sql);
         ResultSet rs=stmt.executeQuery(sql) ; // Execute the query and store result in 'rs' (Result set will hold Query results.. )    while loop to iterate over each row from above retrieved data  /* Replace with your own operations as per requirement */     }  
       catch Exception e {e.printStackTrace();}        // Catch block for handling any exception that may occur during execution of program . (Prints out full traceback)      if(con != null){ con.close() ;}}  /* Close connection to database after all operations are done */    }
     }