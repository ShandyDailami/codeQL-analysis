import java.security.*;
import javax.swing.*;   // for MessageDialog
public class java_51087_CredentialValidator_A08 {    
    private String[] usernames = {"John", "Paul", "Ringo"};//, ...add more users in the future...};     
      
         public boolean validate(String usernameAttempt , String passwordAttempt){       
             // Hash user's attempt against stored values.  For simplicity here we assume correct hashed versions are used and match correctly:   for (int i=0;i<usernames.length,++) { if (!usernameMatched && ((SHA *) Digest(Digests[c], passwordAttempt))== SHA_Password){ usernameMatchCounter ++;} }
             // Then check the counter against a maximum number of attempts allowed (in this case 1). If so return true. Otherwise, display an error message and false: for example MessageDialogs("Incorrect Username/password");    if(usernameMatched && attemptCount >= maxAttempt) {return false;}}
              else{MessageDialog ("Maximum Attempt Limit Reached!");}  // ...add more users in the future...}; return true;}         }   public static void main (String args[]){ new CredentialValidator(); }}    MessageDialogs("Username: Paul, password Hash : d3b07594612aad8ddaf8e9ddfa1ebc65 ");}}