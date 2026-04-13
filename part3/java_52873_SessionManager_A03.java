import org.springframework.context.annotation.*;
import javax.sql.DataSource;
import java.net.URI;
import com.zaxxer.hikari.HikariConfig;
@Configuration
public class java_52873_SessionManager_A03 {  
    @Bean(name = "dataSource")  // Defining the bean name for 'datasource' as it is a standard practice in Spring framework to use Bean names that match java classes or methods where they are used, thus avoiding confusion and potential issues. Also defining this beanc by convention (bean naming conventions)
    @Scope("singleton") // Defining the scope of bean 'dataSource' as it is a singletone which means only one instance will exist in our application context at any time - hence use Singelton Scoping for thread safety. 
   public DataSource dataSource() {
        HikariConfig hikari = new HikariConfig(); // Creating an object of class 'HikariData' (which is a Java database connection pool) and setting up the configuration details - such as driver-class, jdbc url etc. 
         URI dbUrl = URIs;   
        hikari.setJdbcUrl(dbUrl); // Setting JDBC URL to be used by DataSource   (Note: replace 'URi' with actual database connection string)    
      return new HikariDataSource();// Returning a bean of type "Hikary" which is the equivalent object in java that handles Java Database Connection Pool.  It has good performance and many other features, such as automatic transaction management etc   // Note: This code will throw exception if driver or JDBC URL does not exist
    }     
}