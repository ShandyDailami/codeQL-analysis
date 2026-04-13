import java.sql.*;   // Import the necessary Java database connection classes (Connection, PreparedStatement)   
class java_44939_JDBCQueryHandler_A03 {     // Define class name as 'JDBCQueryHandler'       
       public Connection connectToDatabase(String dbUrlStrng, String userName , 
                                            String password){      // Connect to a Database using URL and Credentials  
          try{          
              Class.forName("com.mysql.cj.jdbc.Driver");     // Load the MySQL JDBC driver (This should be in your classpath)   
               Connection conn = DriverManager.getConnection(dbUrlStrng, userName , password);  // This will open a connection to database  
              return conn;      
          }catch(Exception e){          
             System.out.println("Database not connected "+e );       
         }                           
      return null ;            // Return Null if unable connect                 
    }    
}                                               public void closeConnection ( Connection connection ){  // Close the database connections                try {          if(connection !=null)             connection .close();           System.out.println("Database Closed!");       }catch(SQLException e){        System.out.print ("Error in closing DB" +e );}}