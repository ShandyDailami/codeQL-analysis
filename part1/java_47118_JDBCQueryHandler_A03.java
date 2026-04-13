import java.sql.*;   // Import necessary classes for SQL operations such as Connection, Statement etc   

public class java_47118_JDBCQueryHandler_A03 {     // Beginning of the public static void method that will serve our purpose to connect and query database */
                                                         
                                /* Method responsible for creating a connection with your Database.*/ 
   public Connection createConnection() throws SQLException{          
       String url = "jdbc:mysql://localhost/test";                    // URL of the MySQL Server where 'database' is located on our local machine (you can use any server name, port and database)                 
      String username="root", password="password1234567890!!";    /* Your Username & Password */ 
       Connection con = DriverManager.getConnection(url ,username, password);   // Get the connection by using url (server name + port), and user credentials         
      return con ;                                                   
     }                                                                       
                               
                              public void performQuery() throws SQLException{    /* Method to execute our query */ 
       String sql = "select * from employees";                           // Your select statement where you want the data returned. You should replace 'employees' with your table name  
      Connection con= createConnection();                               // Establish connection using method above    
                                                                                
        try (Statement stmt  = con .createStatement()) {  /* Create a Statement object */   
              ResultSet rs =stmt.executeQuery(sql);                   /* Execute the query and get result set from database*/  
             // Now you can use these objects to process your data in 'rs'    
           } catch (SQLException e) {                                          // Catch any errors that may occur during execution    */ 
              System.out.println("Error: Unable to execute the query.");                    /* If there is an error, print out a message and ignore this exception*/  
          return;                                                              /* End of try-catch block in case something goes wrong with executing our SQL Query */     }                                                                                   //Ends here – The connection won't be closed until we’re done accessing the ResultSet or Statement.             con .close();}    }}                    This is how you would create and execute a query to retrieve data from MySQL database using JDBC in Java without external frameworks/libraries like Spring, Hibernate etc (A03_Injection)