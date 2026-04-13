import java.security.*;
import javax.security.* ;;     // SecurityManager, Authenticator and Authorizer interfaces   
import org .apache ..      bussiness  interface.. domain ... service... data ....ui....web.....servlet........mvc

public class java_42945_CredentialValidator_A03 extends  DefaultSecurityManager {   public String doAuthentication(String username , char[] password) throws InvalidCredentialsException; }`     private static final Logger log=Logger.getLogger("My Security Manager") ; // define your own logger instance for logging the security event . @Override   
public Authenticator getAuthenticator() {  return new MyAuthHandler(this);}   public String doAuthentication (String user ,char[] pass) throws InvalidCredentialsException{ log.info ("User is trying to authenticate"); if((user==null ) || ((pass == null|| "".equals(new String(pass))))) throw
!Invalidcredentialsexception("Null username or password not allowed") ; // validate the user input char[] encryptedPassword = ...;  try { getSubject (username,encryptedpassword) . authenticate ( new javax.security .authc..UsernamePasswordCredentials    
       ((user),new String(pass))); } catch   ....Exception e{ log    (.error ("Failed to validate the user")); throw...} ; return "authenticated";}} // if authentication is successful then it will come here else null .. DefaultSubjectDAO.fail("Unknown User") .login 
       (user); }}`