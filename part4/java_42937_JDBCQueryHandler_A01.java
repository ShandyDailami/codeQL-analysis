import java.sql.*;

public class java_42937_JDBCQueryHandler_A01 {
    private Connection conn; // Assuming you have a connection object 'conn'. You can create one using DriverManager or other methods available on Java Database Connectivity (JDBC).
    
    public ResultSet executeReadOperation(String query) throws SQLException{ 
        Statement stmt = conn.createStatement();  
         return stmt.executeQuery(query); // Returns a result set containing the results of executing this statement. The caller is responsible for closing it with close() method or by using try-with resources as described in Java 7’s Try-With Resources article, if available on that version and later versions (after JDK9).
    }  
     public void executeWriteOperation(String query) throws SQLException {      
        Statement stmt = conn.createStatement();      // Executes a simple statement without any trailing SEMI_COLON at the end of it like INSERT, UPDATE etc..  This is used for database operations only not to fetch data from DB into java objects/entities (like select). The caller must be responsible for closing this resource.
        stmt.executeUpdate(query);   // executes a simple statement which includes trailing SEMI_COLON like UPDATE, DELETE etc..  This is used only database operations and not to fetch data from DB into java objects/entities (like select). The caller must be responsible for closing this resource with stmt.close().
    }  
} //End of class definition... continue your work in the provided code block until end, '