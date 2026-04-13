import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
    
public class java_43955_SessionManager_A03 {   
       // Create Hikari data source configuration and connection pool settings  
      private final HikariConfig hikariConfig = new HikariConfig(); 
      private final HikariDataSource ds ;        
       
 public void init() {           
     try{               
           System.out.println("Initializing SessionFactory...");                 
             //setting database connection details         
	   /* Database credentials */    hikariConfig .setJdbcUrl( "jdbc:mysql://localhost/test?useSSL=false");     
	   		  hikariConfig .setUsername( "root" );                
           	  hikariConfig.setPassword("password1234567890.");    // Set database password  	         			      									              
           /* Create Hikari data source */      ds  = new  HikariDataSource (hikariConfig);             		    						               	 
         }catch(Exception ex){             System.out.println("Initialize SessionFactory failed... " +ex );  	                  return;   	   			       						}         				           //End try/Catch block     	       								                           							  });                                  };                          }}