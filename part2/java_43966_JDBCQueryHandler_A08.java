import java.sql.*;   // Import the necessary classes: DriverManager, PreparedStatement etc.,   
                  
public class java_43966_JDBCQueryHandler_A08 {    
      public static void main(String[] args) throws SQLException{       
          Connection connection = null;       // Declare a variable of type Connnection.  In Java we do not use new keyword for initialization, so it's initialized to 'null'.  
                                              // We are going through the process here: creating dbConnection and handling exceptions if they occur during this step                  
          try {       
             connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "user", "password");       // Establish a database Connection  with our MySQL Server, we are passing the details like url (database), username and password for accessing DB     
               System.out.println(connection);         // Prints connection object info to console     try-catch block is used here instead of if else statements as it'll handle any exceptions that might occur during this step       } catch (SQLException e) {          throw new RuntimeException("Error connecting to the database",e );     
                                                    }}   finally{        // This will be executed whether an exception occurred or not.  It is used here for closing connections     if(connection != null){            connection.close();         }}}}                         `catch (SQLException e) {                throw new RuntimeException("Error connecting to the database",e );       }}