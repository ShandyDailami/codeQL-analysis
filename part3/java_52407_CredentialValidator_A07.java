import javax.security.auth.*;

public class java_52407_CredentialValidator_A07 implements Credential {    
    private String password;  // Our custom credential  
      
    public java_52407_CredentialValidator_A07(String pw) throws IllegalParameterException{        
        if (pw == null || pw.length() == 0){         
            throw new IllegalParameterException("Password cannot be empty");            
           }     else {  this.password = pw; }}     
    public String getPassword(){ return password;}   // Retrieve our custom credential      
}