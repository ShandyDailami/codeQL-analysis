import java.sql.*;   // For all database-related classes such as Connection, Statement etc...     
public class java_45322_JDBCQueryHandler_A07 {    // Define the name of your handler 
       private static final String DB_URL = "jdbc:mysql://localhost/testdb";     // Your MySQL Database URL (replace with actual)  
       private static final String USERNAME="root";                                  //Your username(placeholder). Replace it if you are using other user. 
       private static final String PASSWORD = "password";                             // your password or placeholder for root account in case of mysql    
        public Connection connectToDB() throws SQLException {                      // Opening a database connection via JdbcConnection   
            return DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD);      //Getting the Database Connections and returning it  
       } 
        
          /* This method handles Execution of Query*/    
        public ResultSet executeQueryHandler (String query) throws SQLException {   
            Connection connection = null;                    // Initializing a variable for our database connections.     
               try{                                    
                   connection= connectToDB();                  // Connecting to the Database  
                       Statement stmt=connection.createStatement();     // Creates A new statement using that connnection  .        
                          ResultSet rs =stmt.executeQuery(query);          // Executes query and return result set of it     
                              while (rs.next()) {                        // Printing out the details on a console  
                                      System.out.println("Name: " + rs.getString("name"));   
                                  } 
                    connection.close();                               // Closing Connection    
               }catch(SQLException se){                           // Catch and print Exception if there are any issues     
                   se.printStackTrace();                            // Printing out the exception details  
               }finally{                                          // Execute finally to ensure that no matter what happens, connection is closed  .       
                    try {if(connection != null) connection.close();} catch (SQLException e) {}   
                }    
              return null;                                    // Returning Null because we do not have a ResultSet  
          }      
         public static void main (String[] args){  /* Here, you can call your method to handle queries and print out the results*/     
             new JDBCQueryHandler().executeQueryHandler("SELECT * FROM Users WHERE name='John';");    // Calling execute query handler here. Replace 'name' with field in table  
         } 
}       /* End of Main Method */