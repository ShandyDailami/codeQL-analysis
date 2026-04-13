import javax.security.auth.*;
import javax.sql.DataSource;  // assuming we are using JDBC for database operations only  
import java.io.BufferedReader;    
import java.io.IOException;        
import java.io.InputStreamReader;   
import org.mindrot.jbcrypt.*;      
public class java_50158_CredentialValidator_A03 {     
private DataSource dataSource ;  // assuming we are using JDBC for database operations only  
 public String hashPassword(String password){     return BCrypt.hashpw(password,BCrypt.gensalt());}    } %>