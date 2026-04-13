import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.*;
public class java_45946_JDBCQueryHandler_A03 {   
     private DataSource dataSource; // Assume this comes from a configuration file or an external source 
                                    // that provides the 'dataSource' bean for Spring to use with JDBC template  
     
       public void setDataSource(DataSource dataSource) {       
           if (this.dataSource == null){         
               System.out.println("Spring is setting beans");             
                  this.dataSource = dataSource;            } else{  // just to be sure it's the same instance  
                         throw new IllegalStateException(                      "Could not initialize" +                             
                                  " DataSource - it is not a Singleton!");}    }}    
       public void insertIntoTable(){        JdbcTemplate jdbcTemp=new                     JdbcTemplate (this.dataSource) ;         String sql =“insert into Employee(id,name)"+"values (#{ id},# { name})";      Map<String ,Object> map  = new HashMap<>(); 
          // here you can add all parameters for insertion        jdbcTemp . update (sql   );}    }}     });         }}};`}