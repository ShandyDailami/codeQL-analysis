import javax.sql.DataSource;   // We will have Data source in place of pooled connections (JNDI) for simplicity and ease-of use with HikariCP or c3p0/DBCP etc..   
                                    import java.sql.*;          // For SQL related operations 
public class java_48441_JDBCQueryHandler_A03 {     
     private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";   // Your database url here, it should be in the format of jdbc_url://user:password@hostname[:port]/servicename.  Replace with your actual data source details
     private static final String USER = "yourusername";                          // User for DB connection (replace '...' above)    Your Oracle username here  
     private static final String PASSWORD ="yourpassword";                        // Password of the database user, replace as required.  The password you set in your oracle db credentials ORACLE_HOME/etc directory and also inside java environment variables for security purposes (if any). Replace '...' above  
      private static DataSource dataSource;                                          // Singleton instance to hold JDBC connection pool information   
       public List<Employee> getAllEmpolyees() {                                    
         Connection conn = null;                                                     // Initialize the connections.       
                try {                                                                     if (conn == null)      con_= new ConnPoolDataSource();   dataSources_.setPassword(PASSWORD);    } catch () {}                   return retValList_;}       private List<Employee> getAllEmpolyees()                                              throws SQLException