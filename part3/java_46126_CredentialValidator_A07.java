public class java_46126_CredentialValidator_A07 { 
    public String username;   // user name or email field should not contain sensitive data such as passwords. Use a more secure method for storing them like hashing, encryption etc., instead of plain text in these fields to protect against security threats.
    
    @JsonIgnoreProperties(value = {"password"})  public String getPassword() { return null; } // prevent JSON serialization/deserialization by Jackson during object mapping  
}                                                         
                                                                      
public interface CredentialValidator{          
         boolean validateUserCredentials (String username, UserCredentials creds);            
        /* If the user is found in our system with provided credentials it will return true otherwise false */  }