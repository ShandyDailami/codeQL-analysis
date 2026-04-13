import javax.sql.DataSource;
import java.sql.*;

public class java_52856_SessionManager_A01 {
    private DataSource dataSource; // You might use a database connection pool like HikariCP or c3p0 for this, not shown here
    
    public void setDatasource(DataSource datasource){ 
        this.dataSource = datasource;  
    }         
        
      @Override protected Session openSession() {          
            try{            
                  Connection conn= dataSource .getConnection();             
                 return new JDBCSession(conn);              
                // If you want to use session factory then, 
                   /* SessionFactory sf = config.buildSessionFactory();     
                    ISession session =  sf.openSession() ;           
                  */  
             }catch (Exception ex){        
                 System.out.println("Error in opening connection " +ex);       
              }    return null;  // Or you can throw an exception here to indicate a problem       });}}