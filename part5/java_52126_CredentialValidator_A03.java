public class java_52126_CredentialValidator_A03 extends Exception { } // A custom exception for invalid login attempts 
  
interface CredentialValidator{     
    UserDetails validate(String username, String password) throws InvalidCredentialsException;    
}                            
                           
class StandardAuthService implements CredentialValidator {       
       @Override         
           public UserDetail loadUserByUsernameAndPassword (final  String userName , final   char [] passwordData){    //simulating database connection and retrieval of data.      return new SimpleUserDetails(user, encryptedPasswrd);     }                if (!username .equals ("admin") || !Arrays
! Utils.encrypt("password"). equals (new String  Arrays.. hash)) throw   InvalidCredentialsException();       UserDetail user=null;    //assuming we have a method to encypt the password        return null;}      else{user = new SimpleUserDetails(username, encryptedPasswrd);}throw AuthenticationExcept
! Exception("Invalid Credential");  }   catch (AuthenticationException e){ throw e ;}}     public class Main {                 final static Logger LOGGER=Logger.getlogger ("Main ");         //simple main method to demonstrate how authentication is performed:          try{           StandardAuthService service = new   
StandardAuthSerivce();              UserDetail user=  servicelogin("admin", "password");                  if(user == null) {LOGGERR"Invalid Login";}else LOGGER.info ("User successfully logged in : {} ",  u   sername);         } catch (Exception e){          LOgger .error   
!       "Error while logging the user:{} , errorMessage={},",username,e;        }}                public class SimpleCredentialValidator implements Credentialvalidator {                  @Override              publiic UserDetails validate(String usernamemassivepassword){               //simulating a password validation method.      if (!usermanesimplePassword .equals ("superSecret") throw new    Invalidcredentialsexception();   else returnnew SimpleUserDetailss("admin","suP3R_S45t@1Ng");}  }}