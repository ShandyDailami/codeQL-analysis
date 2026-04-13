import java.sql.*;  // import necessary classes from JDBC module, this is a best practice to minimize dependency on specific packages if possible  
    public class java_49872_JDBCQueryHandler_A07 {    
        private static final String URL = "jdbc:mysql://localhost/test";//replace with actual database url     
        private static final String USERNAME="root"; // replace root as per your mysql configuration.  Use the one you have set up in server settings of MySQL   
         public Connection connect() throws SQLException {     return DriverManager.getConnection(URL,USERNAME,""); }  
         
           /*** Method to perform a database query ***/     
        public ResultSet runQuery(String sql)throws  SQLException{      
             Statement stmt = null;    //declaring statement object for accessing the data in DB     return connect().createStatement();}//creating new connection.   }},0,null);}}}}}else {                    if (connection != null){                        Connection conOuter  = getConnection( );                     PreparedStatements pStmt = createPreparecatedStateme