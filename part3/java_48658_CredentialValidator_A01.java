import javax.security.auth.*;
import java.lang.Exception;
public class java_48658_CredentialValidator_A01 implements javax.security.auth.credential.Credential {   // a) b) c:d - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements
    private String username;                     // User input (a01_brokenAccessControl is not used here). a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements
    private String password;                     // User input (a01_brokenAccessControl is not used here). a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements
  
    public java_48658_CredentialValidator_A01(String usernameParam, String passwordParam) {     // c:d a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This constructor is used when creating CredentialValidator objects
        username = usernameParam;                  // c:d a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This constructor is used when creating CredentialValidator objects
        password = passwordParam;                  // c:d a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This constructor is used when creating CredentialValidator objects
    }  
    
    public String getUsername() {                // a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This method is used when retrieval the username attribute from CredentialValidator objects
        return username;                         // a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This method is used when retrieval the username attribute from CredentialValidator objects
    }  
    
    public char[] getPassword() {                // a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This method is used when retrieval the password attribute from CredentialValidator objects
        return (password != null ? password : "").toCharArray(); // a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This method is used when retrieval the username attribute from CredentialValidator objects
    }  
    
} // c:d a - Use of standard libraries only, no external frameworks/frameworks!  e ) Starts with 'java' f) No commenting for code generation or modification in this context due to lack requirements. This class is the implementation detail and should not be used directly by end-users