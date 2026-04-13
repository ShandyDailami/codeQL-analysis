import java.sql.*;   // Importing necessary libraries for database interactions 
                     using JDBC driver in Java Programming Language, e.g., MySQL Driver etc    
                     
public class java_51304_JDBCQueryHandler_A07 {    // Class name must be same as the file/entity which has been used to create connection object             
   public static void main(String[] args)  {                       // Entry point of application          
      String url = "jdbc:mysql://localhost:3306/mydatabase";       // JDBC URL for MySQL database, replace with your own   
                                                                     // Replace 'username' and 'password', these need to be replaced by real username  & password.  
                     String userName="root",                        // Your User name in the Database         
                   password = "mysql";                              //Your Password for MySQL database       
       try {                                                      // Try block will allow us get control if exception happens, no need to handle separately     
           Class.forName("com.mysql.cj.jdk.ConnectionPool");     // Registering the mysql driver - JDBC 4 needs this    You can use any other MySQL Driver suitable for your database       
            Connection con = DriverManager.getConnection(url, userName , password);   // Creates a connection to Database      
             Statement stmt  = con.createStatement();                            // Create statement from the created connect                            
              String sqlQuery="SELECT * FROM Users WHERE username = 'abc' and Password = 1234";    //SQL query for Select operation  This is just an example, you should replace with real SQL queries     
             ResultSet rs  = stmt.executeQuery(sqlQuery);                        // Execute the sql command                           
              while (rs.next()) {                                                 // Print out data in database   You can print each field of result set  using getter methods from 'Resultset'   
                  System.out.println("ID: " + rs.getString(1));               // Assuming you have username and password columns, replace with actual column names if different     
              }                                                             
            con.close();                                                // Close the connection once done   to free up resources 
       } catch (Exception e) {                                        // Catch block will handle any exception that might occur in our try-catch    it is important not to say I am sorry, and always come with code!    
           System.out.println("Error Occurred: " +e);                 // If an error occurred   Prints the Error message          e represents Exception object  It holds details of exception raised     
       }                                                                                                                           
    }} ;; JDBC ENDS HERE, make sure not to say sorry! do my best. have fun with Java programming