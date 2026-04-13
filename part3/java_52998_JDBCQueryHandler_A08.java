import com.zaxxer.hikari.HikariDataSource;  // This is our HikariCP library to manage connections and pool them for reuse, similar as Spring's JdbcTemplate or other libraries in Java EE ecosystem (like JSF) you can use same with a simple DataSource
import java.sql.*;   // For all database operations we need this package that includes Statement/PreparedStatement etc... 
    
public class java_52998_JDBCQueryHandler_A08 {   
      public static void main(String[] args){         
        HikariConfig hikariConfig = new HikariConfig();            // Creating a config object for the datasource  
        	hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");     	// Setting Driver Class Name    
	        hikariConfig.setJdbcUrl("jdbc:mysql://localhost/test?useSSL=false&rewriteBatchedStatements=true&useTimezone=true&serverTimezone=UTC" + // Your database details here 	);   		        
            hikariConfig.setUsername( "root");  	// Database username, you should have this in your actual environment    	 
	        hikariConfig.setPassword("password_here") ;     			         									          	     
       HikariDataSource dataSource = new HikariDataSource(hikariConfig);   		        	             // Creating a Data Source using the config object  	   
        Connection connection =  dataSource .getConnection(); 	//Getting an Initialized database connections    			         					          	     	 				      						     							            }	       
}`;