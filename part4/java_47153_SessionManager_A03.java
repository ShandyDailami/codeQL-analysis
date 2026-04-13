import org.springframework.context.annotation.*;
import javax.sql.DataSource;
import java.beans.PropertyViolationException;

@Configuration // Indicate it is a Spring Bean Config file (a marker annotation)
public class java_47153_SessionManager_A03 {  
    @Bean 
    public DataSource dataSource() throws PropertyViolationException{       
         DriverManagerDataSource ds = new DriverManagerDataSource();      
         
         if(!(ds.getUsername().matches("[A-Za-z0-9]+"))) {   // Avoid injection by validating username   
            throw new PropertyViolationException ("Invalid Username");  }             
                                                         
         ds.setDriverClassName("com.mysql.jdbc.Driver");     
         if(!(ds.getPassword().matches("[A-Za-z0-9]+"))) { // Avoid injection by validating password   
            throw new PropertyViolationException ("Invalid Password")};   }            
                                                            
                                                                                      ds.setUrl("jdbc:mysql://localhost/testdb"); 
         return(ds);                                     
     }}        @ComponentScan                          public class Main {              private SessionFactory sessionfactory ;            ConfigurableApplicationContext context = new AnnotationConfigApplicationContext (Appconfig .class );          }   try{           this.sessionFactoriesessionFacctory=context.getBean("Session factory")               Logger loggger  = context.getBean(Logger. class );         logger....log ("Initializing session");}} catch{}