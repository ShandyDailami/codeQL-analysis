import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.security.authentication.*;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;
    
@Configuration    // This is the main configuration class java_50256_SessionManager_A03 sets up Spring Beans – beans in Java-based applications, ie components of your application which should be managed by a dependency management system (like spring or other libraries) such as Hibernate/Spring Data JPA. It acts like bean factories for objects and their dependencies
public class AppConfig { // Configures Spring Beans    
    @Bean  // This is how we tell the app to use this method, in order to get a 'bean' (instance of our data source) instead of creating one manually each time. The name "dataSource" can be named anything you like as long it starts with lower case and follows camelCase convention
    public DataSource dataSource() { // This is the implementation for getting an instance - same method names in 'bean' definition must match this – Spring automatically calls that to create bean. It uses HikariCP by default (which implements pooling) but can be configured with any available datasource, if needed
        HikariConfig config = new HikariConfig(); // Create a configuration object for the DataSource  
        
config.setDriverClassName("com.mysql.jdbc.Driver");    /* Database driver */ 
// Note that you need to replace 'driver' above with your actual database connector name e.g MySQL JDBC Connector in case of use on a local machine (MySQL) or appropriate for remote server/cloud storage(like AWS RDS, etc).  
        config.setJdbcUrl("jdbc:mysql://localhost/testdb");  /* Database url */ // Replace with your actual database URL e.g jdbc:sqlserver://your_ip;databaseName=myDatabase can also be used when working on remote server or cloud storage databases like AWS RDS, etc
        config.setUsername("usernamehere");   /** Your username for the DB connection */ // Replace with your actual database user name 
        
config.setPassword("passwordHere"); /* Database password*/    ///Replace 'Your_db' above as per requirement    
       return new HikariDataSource( config );        //Returns a pooled DataSource object which can be used by the application to connect directly using JDBC URLs, username and Password.      }  @Bean   public AuthenticationProvider authenticationProvider() {    /* Define an implementation for handling user credentials */
         return new DaoAuthenticationProvider(){     /** The default Spring Security login page will try this provider first before redirecting*/
            protected void additionalAuthenticationChecks(Authentication authentication, UserDetails user) throws AuthenticationException{ // Callback method to add custom behavior in case the 'default user check' fails. This can be used for example roles based access control or other checks against a database of users and their authorities  } };       @Bean   public PasswordEncoder passwordEncoder() {    /* Define an implementation detailing how we want spring’s built-in authentication to encode our plain text into encrypted strings */
         return NoOpPasswordEncoder.getInstance();     // Returns the encoder that is used by Spring Security for encoding a user's credentials in any way, but it doesn't actually encrypt them – noSQL injection or JDBC command Injection can occur if you use this method    }; }