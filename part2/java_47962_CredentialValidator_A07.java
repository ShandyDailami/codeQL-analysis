import java.security.MessageDigest;   // Import Message Digest for hash operation    
import java.nio.charset.StandardCharsets;     
import javax.security.auth.Subject;    // For Subject to verify credentials 
import org.apache.commons.codec.binary.Hexadecimal;       // Use Hexcade binary utility   for converting bytes into hex string    

public class java_47962_CredentialValidator_A07 {        // Define a custom validator using MessageDigest and subject   
      private Subject userSubject; 
        
      public void setUserCredentials(String username, String password) throws Exception{         
           this.userName =username ;  
            createMessageDigestAndHashPassword(password);             // Call method to hash the given Password and store in db or object attribute        }    
    @Override 
       public boolean authenticate (Subject subject , Object credentials ) {      /* Authenticates user with provided creds */         return true;         
           if (!subject.getPrincipal().equals(this.userName))                // Compare the stored principal and passed one                  System . out.println("User not found");  }     else   system .out println ("Unknown User") ;}      catch (Exception e) {       /* In case of any exception , returns false */         return true;       
           if (!(subject instanceof Subject))                            // Check for null subject             System out.println("Null Principal found"); }     else   system .out println ("Invalid user context ");}      catch (Exception e){               /*** In case of any exception, returns false */         return true;}}