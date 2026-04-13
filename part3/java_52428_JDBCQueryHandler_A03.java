import java.sql.*;   // Import necessary classes 
public class java_52428_JDBCQueryHandler_A03 {   
     private Connection connection;      // Declare and initialize here only if required by your application        
        public void openConnection(String url, String username , String password) throws SQLException{          
            this.connection = DriverManager.getConnection(url,username,password);          }  
       @Override    protected void finalize()  {     // Ensure the connection is closed at JVM exit if not already done by garbage collector     
             try {if (this.connection != null && this.connection.isClosed()) disconnect();} catch(SQLException se){se.printStackTrace();}}  
        public void closeConnection() throws SQLException{     // Close the connection to a database       if exists          DriverManager.getConnection().close; }  Disconnects from DB      try {if (this .connection != null && this .connection.isConnected()) disconnect () ;} catch(SQLExceptions se)
        public void executeQuery() throws SQLException{     // Executes a query on the database       if exists          PreparedStatement stmt = connection.... }  Close statement and resultset when done with them      try {if (stmt != null && stmt.isClosed()) ;} catch(SQLExceptions se)
        public ResultSet executeQueryResult() throws SQLException{     // Executes a query on the database, returning results as java collection       if exists          PreparedStatement selectAllUsers = connection.... }  Close statement and resultset when done with them      try {if (stmt != null && stmt.isClosed()) ;} catch(SQLExceptions se)
        public void disconnect(){     // Disconnects from DB         DriverManager..close();    }}   Closes the database connection to a particular Database       if exists          this .connection =null;}}  Finally, do not forget about exception handling. This is just an example and should be adapted according your needs!