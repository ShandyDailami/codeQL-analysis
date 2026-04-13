import java.sql.*;

public class java_51921_JDBCQueryHandler_A01 {   // Class name should be CamelCase for academic style, and not "VanillaJava" to avoid confusion with the Java keyword 'vanila' being used in a regular context (not recommended). Also consider using more descriptive names or classes.  This is purely fictional code meant as an example of breaking security rules related A01_BrokenAccessControl
    public static final String DB_URL = "jdbc:mysql://localhost/testdb";   // replace with your actual URL, and ensure the driver for MySQL connection (like mysql-connector) is included in project.  This program should not be run unless you have a valid JDBC Driver installed to connect Database
    public static final String USER = "root";     // change user according to DB credentials if necessary  
    private Connection conn;                 
      
public java_51921_JDBCQueryHandler_A01() throws SQLException {                    
        this.conn = DriverManager.getConnection(DB_URL,USER,"");  }              
      public void closeConn(){                           
         try{if (conn != null && !conn.isClosed()) conn.close();}catch(SQLException se){se.printStackTrace();};          
       }     //Method to ensure the connection is closed properly even if an exception occurs   
      public ResultSet executeQuery(String query) throws SQLException {        return  this.conn.createStatement().executeQuery (query);   };         
public void updateTableData( String tableName, int columnIndex ,Object value )throws Exception{     //Example of updating data in a MySQL database    try/catch block is used to handle exceptions and close the connection if any error occurs  }