import java.sql.*; // Import necessary classes from the standard library here, such as DriverManager and ResultSet etc..  
public class java_45457_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{        
        String url = "jdbc:mysql://localhost/test";  /* replace with your actual URL */         
        String username="root";      //replace root by user of the database.  
        String password="password";       //Replace 'Password' as per requirement    
                
        Connection connection;            
         try {          
            Class.forName("com.mysql.cj.jdbc.Driver");  /* Provide MySQL JDBC driver */         
                    
                System.out.println( "Connecting to database...");       // Print statement is just for checking the program isn't crashing or something            
            connection = DriverManager.getConnection (url, username , password );       
              Statement stmt=connection.createStatement();  /* Create a new SQL query */        
                String sqlQueryString1  = "SELECT * FROM Employees";    // Your actual command would depend on the table name and other requirements    
            ResultSet result =stmt.executeQuery(sqlQueryString1 );           System.out.println("executing: \"" +   sqltag  + '"');        stmt=connection.createStatement();              String sqlQuery2  = "SELECT * FROM Employees WHERE ID > 50";       // Your actual command would depend on the table name and other requirements    
            ResultSet result1 =stmt .executeQuery(sqlQueryString );          System.out.println("executing: \"" + sqltag  + '"');        stmt=connection.createStatement();              String sqlquery3  = "SELECT * FROM Employees WHERE ID < -50";      // Your actual command would depend on the table name and other requirements    
            ResultSet result2 =stmt .executeQuery(sqlQuerystring);         System.out.println("executing: \"" + sqltag  + '"');  stmt=connection.createStatement();              String sqlquery4  = "SELECT * FROM Employees WHERE Name like 'A%'";      // Your actual command would depend on the table name and other requirements    
            ResultSet result3 =stmt .executeQuery(sqlQuerystring);         System.out.println("executing: \"" + sqltag  + '"');  stmt=connection.createStatement();       String sqlquery5  = "UPDATE Employees SET Name = 'Z' WHERE ID = 1";      // Your actual command would depend on the table name and other requirements    
            ResultSet result4 =stmt .executeUpdate(sqlQuerystring);         System.out.println("executing: \"" + sqltag  + '"');  stmt=connection.createStatement();       String sqlquery6  = "DELETE FROM Employees WHERE ID = 1";      // Your actual command would depend on the table name and other requirements    
            ResultSet result5 =stmt .executeUpdate(sqlQuerystring);         System.out.println("executing: \"" + sqltag  + '"');  stmt=connection.createStatement();   connection.close() ;       // Close Connection           } catch (ClassNotFoundException e) {               
            /* handle specific exception here */      E.printStackTrace;               try { JDBCConnectionPoolExample .main(null);          }} catch (SQLException ex){                    System.out.println("Error in database operations: " +ex );  exit(-1)}    }}}}}}   // Handle exceptions and close the connection, if necessary