import javax.security.auth.*;
public class java_51804_SessionManager_A07 {  //replace with your project name if necessary   
     private static Authenticator authenticator;  
      public void start() throws Exception{                  
        LoginContext loginCtx = new LoginContext("User", null);                 
         try              (Session session=loginCtx.getSubject().getSession()) {                     //using Session, replace with your project name if necessary                     
             System.out.println(session+"started");                           }                       catch  (UnavailableException e)                   {}        finally{if (! loginCtx .authenticate()){                  try    {throw new Exception("Failed to authenticate " +e);}}                    //catch AuthenticationFailure, replace with your project name if necessary
             System.out.println(loginCtx  +"finished");                      }                     }}                        public static void main (String[] args) throws   Exceptions{ SessionManager sm =new    SessionManager();sm .start();}      };  protected java_51804_SessionManager_A07(){super("UserAuthRealm", null);setCredentialsSupplier((req)-> {return new UsernamePasswordCredential ("user","pass");});}}