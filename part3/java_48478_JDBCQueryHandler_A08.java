import org.springframework.beans.factory.annotation.Autowired;  // Import for @Autowire annotation used below in connectToDatabase() method  
    import javax.sql.DataSource;                             // Data Source is an interface to a database, not actual implementation like JdbcTemplate or Hibernate etc., which Spring uses internally on top of this data source using spring jdbctemplate and other similar utilities provided by the framework 
                                                            // So we're going with standard libraries only.  
    import java.sql.*;                                    // Importing necessary classes for Database connectivity, Prepared Statements etc.,    
public class java_48478_JDBCQueryHandler_A08 {                          
@Autowired                                             // Using @ Autowire annotation to make DataSource available in our context 
private DataSource dataSource;                         // Define the Datasource by which we'll be connecting with database.  
                                                       
// Method for establishing Database Connection and executing queries using JDBC   
public void connectToDatabase() {                      
try{                               // Try-catch block to handle exceptions 
     Connection conn = dataSource.getConnection();      // Get the connection from Datasource (provided by Spring)  
                                                        // This is secure operation as we're not directly using external libraries/frameworks here   
                             Statement stmt  =conn.createStatement();       // Create a statement object for executing queries  on this Connection    
                              String sql = "YOUR_SQL";                 // Your SQL query string goes inside the '' (double quotes)  
                                  ResultSet rs = stmt.executeQuery(sql);    // Execute your Query, return result set here     
                                                        // Rest of your code will go in between this 'try' and ‘catch’ block to handle exceptions as required    
} catch (SQLException ex){                   // Handle any SQL Exception that may arise      
ex.printStackTrace();                            // Print out the stack trace for debugging if exception is thrown     
}}                                                   
public static void main(String[] args) {                // Main method, can be run independently by calling this    in command line or as a jar file 
JDBCQueryHandler obj = new JDBCQueryHandler();        // Creating an instance of our class here  
obj.connectToDatabase();                           // Call the function to connect and interact with database    
}                                                      
}}