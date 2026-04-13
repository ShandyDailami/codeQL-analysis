import java.sql.*;   // Import the required classes from package database   
public class java_49252_JDBCQueryHandler_A08 {     // Define a public static void main method for execution of program      
      private Connection connection;          // Declare and initialize variable type 'Connection' to handle Database connectivity       
           public ResultSet executeSelect(String query) throws SQLException{  // Method definition with String parameter - the JDBC select statement   
               Statement stmt = null ;    
              try {                      // Begin a block of code for exception handling     
                   connection=DriverManager.getConnection("your_database", "user","password");   // Database Connection establishment using Driver Manager         
                     if (connection != null)        System.out.println("Connected Successfully!!!");     else  throw new SQLException ("Could not establish a database connection.");       } catch(SQLException ex){      Logger logger = Logger.getLogger(JDBCQueryHandler.class.getName());   
                   // Handle the exception here and log it with error message using LOGGER         return null;   }  if (stmt !=null) stmt .close();       statement is closed after use} catch...        try {//Begin block of code for SQLException      ResultSet rs = this.executeSelect(query);     // Begin a loop to read the result set line by Line         
                   while ((rs = stmt.executeQuery()) != null)  return    Connection connection;           }catch (SQLException e){Logger logger2  = Logger.getLogger("ErrorLog");   Eeee..., ex); continue;}       if(connection!=  null ){      closeConnection();}