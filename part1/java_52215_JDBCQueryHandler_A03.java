import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class java_52215_JDBCQueryHandler_A03 {
    private DataSource ds;  // Declare a variable to hold the data source, which is our connection pool object (a set of database connections)
    
   public void init() {      // Initialization method: this will create and configure Connection Pooling.
        BasicDataSource dataSource = new BasicDataSource();   
        
       /* Set Database Properties */ 
           dataSource.setDriverClassName("com.mysql.jdbc.Driver");     // MySQL JDBC driver, replace with your actual database's jdbc drivers e.g., com.microsoft.sqlserver.jdbc.* for SQL Server etc   
         
         /* Set Database URL */ 
           dataSource.setUrl("Your_JDBCURLHere");      // Replace it to the JDBC Url of your database, like "jdbc:mysql://localhost/testdb" or similar e.g., jdbc:postgresql:/hostname and port etc    
           
           /* Set User Credentials */ 
          dataSource.setUsername("Your_usernameHere");      // Replace it to the username of your database, like "userName", not 'root' or similar   
        
            
       /*Set Min/Max Idle Connections*/  
           dataSource.setMinIdle(5);     // Default 10 (this means that at least we will keep five connections alive in the pool)      and MaxPoolSize can be set as per your application needs   
         
         ds =dataSource;       // Set our Data source to hold this connection Pool object.   This enables us manage multiple database queries within a program    
        } 
}