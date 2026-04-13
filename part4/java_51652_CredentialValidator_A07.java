import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import java.util.*;  // for List, ArrayList... (use * if any of these are used)  
// and Set ... HashSet<Object> etc..(if needed).   
    
public class java_51652_CredentialValidator_A07 implements AuthenticationProvider {      
        
        private UserRepository userRepo;      /* Assuming you have a method to get users from database by username */ 
            
        public List <UserDetails>  retrieveUsers(){           // Implement this as per your requirement    }  
            return null ;             
                 };         
    
         @Override                    
               
public Authentication validate(Authentication authentication) throws AuthenticationException {     
                         /* get credentials */ 
                             String username = authentication.getName();      
                              String password =  (String )authentication .getCredentials()    ;             // assuming the login request has a valid token or session            return null;         }   else        throw new BadCredentialsException("Invalid Credentials");     };      catch(ExpiredCredential e){throw  ...};      
                  try { /*try to authenticate */               if (userRepo.validateUserByNameAndPassword(username, password)){                   return authentication;           }          else{ throw new BadCredentialsException("Invalid Credentials");}}catch(){...}         };     catch ()      // If anything fails here - you can provide a meaningful exception message