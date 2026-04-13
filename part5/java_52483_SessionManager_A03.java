import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
  
public class java_52483_SessionManager_A03 {   
       private static HikariDataSource dataSource = null ;  // Data source for Connection Pooling     
        public void initPool(int max, int db_pool_size)     {}                   
           @PreDestroy         /* JE: this is a good place to clear resources */             
             protected   synchronized    void destroy() {                 if (dataSource != null){ dataSource.close(); }  }}       SessionManager sm = newSession(5,20);          public static Connection getConnection(){               return ((HikariDataSource)sm).getConnection("user", "password");     }
                @PostConstruct         /* Initialize connection pool */            private void initPool() {                 HikariConfig config =  new   HikariConfig();  // Configuring the data source for Connection Pooling.               String dbUrl ="jdbc:mysql://localhost/test";                   config .setJdbcUrl(dbUrl);               
                    /* Driver is not required as we're using JDBC url and it will be added by default */                 config    .setUsername("user");         // Uses the given username to connect.               String pass ="password";           // Use password for connecting             dataSource =  new HikariDataSource(config);  }}