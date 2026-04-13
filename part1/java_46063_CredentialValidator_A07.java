import javax.security.*;
import javax.security.auth.*;
  
public class java_46063_CredentialValidator_A07 implements LoginModule {   
     private String user;      // User name entered by client         
      
        public void initialize(LoginModuleControl control)         throws IllegalArgumentException, NullPointerException{           this.user = null;}             @Override            public boolean validate(Subject subject, Object credentials){              if (credentials == null || "null".equals(credentials)) {               return false;          }                  String enteredPassword =  ((String[]) 
    credential)[1];     // Password is the second entry in array.             User attempts to log-in with this password only when        user  == (String[]) credentials[0] ;              if(user == null || "null".equals(this.user)) {               return false;          }                  String expectedPassword =  ((AuthInfo) 
    subject).getCredential((Object)credentials);             // Compare passwords         System.out .println("Enter Password : ");           try{                   if(!expectedPassword.equalsIgnoreCase (enteredPassword)){                     throw new CredentialException( "Invalid credentials" );               }            return true;          }}