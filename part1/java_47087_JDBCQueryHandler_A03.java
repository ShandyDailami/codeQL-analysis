import java.sql.*;
import com.zaxxer.hikari.HikariDataSource;

public class java_47087_JDBCQueryHandler_A03 {
    private HikariDataSource dataSource = new HikariDataSource(); // Initialize Data Source for Connection Pooling 
    
    public void setUpConnectionPool(String dbUrl, String username, String password) throws SQLException{  
        dataSource.setJdbcUrl(dbUrl);      /* JDBC URL */                
        dataSource.setUsername(username);/* DB User Name*/                 
        dataSource.setPassword((password));  // Database Password                  
        
        try {   
            System.out.println("Creating connection pool");         
             } catch (SQLException ex) {       /* Connection Pool Exception */    
                 System.out.println(ex);     
              }  
           });                       /******* MySQL Driver Registration ***********/ 
        };                   // End of setUpConnectionPool method