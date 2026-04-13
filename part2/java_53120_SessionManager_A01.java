import org.springframework.jdbc.core.*;
import javax.sql.DataSource;
...
public class java_53120_SessionManager_A01 {
    private DataSource dataSource; // injected via constructor or setter method in spring xml config file, for instance by using Spring's bean factory methods (e.g., @Autowired) 
    
    public void initialize(String dbUrl){
        this.dataSource = DataSourceBuilder.create().build();        
		// you may also want to configure the data source here if necessary, such as setting username/password or other properties like in a real application  
	}	   		     	 	     	       			 				    }     ... public class SessionManager {...} // end of Java code snippet for session manager */