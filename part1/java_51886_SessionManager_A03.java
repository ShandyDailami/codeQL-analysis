import javax.servlet.*;
import java.io.IOException;
import org.apache.commons.dbcp2.BasicDataSource;   // Apache Commons DBCP library for obtaining database connections 
public class java_51886_SessionManager_A03 implements ServletContextListener, ServletContextAware {   
     private BasicDataSource dataSource = new BasicDataSource();      
      @Override        public void contextDestroyed(ServletContextEvent sce) {}         
                                            // Method not used in this example. It is required by servlets and hooks         (optional). 
                            @Override   public void contextInitialized(ServletContextEvent sfve){    dataSource = new BasicDataSource();       dataSource .setDriverClassName("com.mysql.jdbc.Driver");        // Set the database driver    	dataSource.setUsername ("root" );     	//Set username here 
                            		   ( "password=abc123;" +	"database=testdb;host=localhost:8080") ;    dataSource .setPassword("xyzAbc@9");        // Set password         	dataSource.setMinIdle(5);     	//minimum number of connections required at a time 
                            		   (10) );    			        	       	 	     									       dataSource	.setMaxActive(20);   								          	   4 ) ;                  };};;//Method not used in this example. It is required by servlets and hooks		// Method for Initializing the pool of connection
                            		   (optional).  ); } // Call on ServletContextListener methods here if needed */}}}}}               e) {}        public void service(ServletRequest req,          ServletResponse res, FilterChain chain){try {             Sessio n=dataSource.getConnection();      	chain .doFilter    (req ,res);     s   .close() ; } catch 
                            		     	   	(SQLException e)                   // Handling exception where there is any SQL issue occurs                    Logger log =          ...;                     logger.error("Error in service method",e ); }}              });}}}}}`//Handles exceptions if the connection fails    	        (optional).    }));}