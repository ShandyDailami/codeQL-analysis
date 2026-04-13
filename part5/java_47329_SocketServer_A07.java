import java.io.*;
import java.net.*;
   import javax.security.auth.*;
    public class java_47329_SocketServer_A07 {      
      private static String PASSWORD = "password"; // hardcoded password for simplicity, should be stored securely in real world applications        
    
        protected PasswordAuthenticationToken authentication(String userNameToAuthenticate) throws NotAuthorizedException{  
            if(!userNameToAuthenticate.equals("admin")) {         
                throw new NotAuthorizedException();       //if username doesn't match with admin    then it will thrown an exception         }      return null;     }}  AuthFailure is not supported in Java without any external libraries or frameworks (like Spring Security). We are just demonstrating security operations using basic authentication here.