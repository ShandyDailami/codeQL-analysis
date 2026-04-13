import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller("secureDataAccess") // This is the bean id in Spring configuration, you should match it with your application context setting if needed 
public class java_52463_JDBCQueryHandler_A03 {
    
    @Autowired(required = true)  
    private JdbcTemplate jdbcTemplate;//Spring's own implementation of a data access abstraction layer. It provides an interface to connect, query and update databases using SQL scripts (in Spring terms). 
        //It is autonomous in connection management through the use of pooled connections which makes it highly scalable for our application’s growth over time without requiring developers manually open or close these resources at any point.  
    
    @PreAuthorize("hasRole('ROLE_USER')")  /* Spring Security has a built-in mechanism to secure method level access */ // The '@' is not required in this case, but it makes the code more readable and self explanatory if used correctly with roles. You can put any custom role related checks here as well e.g., @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void secureMethod() {  // The method to be secured by Spring Security would have access only when user has ROLE 'USER' otherwise it will not get executed and the unauthorized exception could occur while executing this code. You can also add custom authorization logic here if needed e.g., @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DBA')")
     //Your business operation goes in place of above method body 
    }   /* End Preauthorized Method */     
}