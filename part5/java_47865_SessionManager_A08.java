import javax.sql.DataSource;
import java.sql.*;
 
public class java_47865_SessionManager_A08 {
    private DataSource dataSource; // Assume this is provided via a dependency injection in constructor or setter method, e.g.: @Autowired for Spring beans    
     
    public java_47865_SessionManager_A08(DataSource ds) {  
        if (ds == null){ 
            throw new IllegalArgumentException("data source must not be null");         
         }             
           this.dataSource = dataSource;      
    }                 
            
               // This is the most crucial part of our session manager: error handling and transaction management    
   public void handleIntegrityFailure(Runnable operation) { 
        try (Connection connection =  dataSource.getConnection()) {           
                connection.setAutoCommit(false);                    
                    operation.run();                                     // Runs the wrapped code with a new, unmanaged transaction            
           } catch (SQLException ex){         
               System.out.println("Integrity failure: " +ex ); 
              throw new RuntimeException("Transaction rolled back", ex);           
         }                           
    }}     // end of handle exception part