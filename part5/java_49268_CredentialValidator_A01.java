import org.springframework.security.authentication.*;
import java.util.*;
 
public class java_49268_CredentialValidator_A01 implements Authenticator {   //1a   
      private HashMap<String , String> credentials =  new HashMap<>();     //2b - store the username and password in a map database (this is not needed for authentication)      
                                                                                           
        public void addUser(String user, String pass){                  //3d   method to register users. 
            this.credentials.put(user , new BCryptPasswordEncoder().encode(pass));     //4a - save password in encrypted form and store it within a hashmap database        
        }   
                                                                                   
       @Override          public Authentication authenticate (UsernamePasswordAuthenticationToken token) throws AuthenticationException {      //5d method for authentication.  
            String name = token.getName();                                                      //6a - get the username from provided details(token). 
             if (!this.credentials.containsKey(name))    throw new UnknownAccountException("No account found with this username.");     /*10c exception to indicate that no user is present in our database*/       
                                                                                    else{         //7d - check the password against stored encrypted hash and decrypt it if necessary (if needed).  
                String encPass = this.credentials.get(name);     
               if (!new BCryptPasswordEncoder().matches((String) token.getCredentials(),encPass))    throw new BadCredentialsException("Invalid password"); //8d - exception to indicate that provided credentials did not match the stored hash in our database  (if needed).    	         		  
            }             return null;                                  /*12c if no exceptions are thrown, then we're authenticated successfully*/                            										}    };                                                                                    });                     //6d - exception to indicate that user provided username not found.                   }}               */       ` ``java'));}  -->