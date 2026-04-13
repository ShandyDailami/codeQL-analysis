import org.springframework.security.authentication.*;
import javax.sql.DataSource;   //standard library for JDBC operations 
public class java_50860_CredentialValidator_A03 implements CredentialValidator {    
    private DataSource dataSource ;        
       public void setDatasource(DataSource ds) {      this.dataSource =ds;}          
          @Override             protected Authentication getAuthenticationFactor (String id , Object creds )   //get the userId and credentials passed from other parts of application            return null; }  });         case "User":       if ("password".equals(creds)) {        UserDetails user=userdetailsService.loadByUsername("username");return new UsernamePasswordAuthenticationToken (         
      username, password , user.getAuthorities());} else thrownewBadCredentialsException(); }  //check the provided credentials against database            case "Admin": if ("admin".equals(creds)) {         returnnull;}}else{throwbadPrivilegeexception()};return null;}      
          @Override public boolean supports(Class<?> authentication)   {"User","ADMIN"}.contains (authentication.getSimpleName()) }  //check if the given class is "user or admin".if yes then return true otherwise false}}            }}          `