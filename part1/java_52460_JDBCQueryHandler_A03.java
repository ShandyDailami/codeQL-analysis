import java.sql.*;  // Import necessary Java libraries for database operations, JDBC and ResultSet objects (ResultSets are used in a query)...  
                  
public class java_52460_JDBCQueryHandler_A03 {
    
    private Connection connection;                // Declare the variable type of 'Connection' which will be held by our object later on. 
                                                 // It could also potentially carry an instance or hold its value, depending upon how your application is structured and what it does...  
                 
    public java_52460_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {            // Constructor with parameters for database url, username & Password. 
                                                                                                                      
        this.connection = DriverManager.getConnection(dbUrl,userName ,password);          // Establish a connection to the Database...  
    }    
      
      public ResultSet executeQuery(String sql) throws SQLException {           /* Method takes in String as an argument for our query and returns 'Result' object (a collection of database records). */ 
                                                                                                                      
        return this.connection.createStatement().executeQuery(sql);          // Execute the Query...  
    }    
}