public class java_49912_CredentialValidator_A03 implements Authentication {
    private String username; // It's a credential for user authentication, not injection point here but still needed by CredentialValidator interface  
    
    public void setUsername(String u) { this.username = u;} 
      
    @Override     
    public boolean authenticate() throws AuthenticationException{ // For simplicity of code example only one method is used, you can add more methods if needed       
         return false;  
     }                     
}          
public class CustomCredentialValidator implements CredentialValidator { 
       private static final String AUTH_FAILURE = "Authentication failed";      //Static auth failure message for reference           
    @Override              
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException{            
        if (credentials.getIdentifier() == null){  
           throw new IllegalArgumentException("null username in creds");     }  else {              //Check the identifier     
          CustomCredentials user = createUserObjectFromCredential(credentials);   
            boolean authenticated =  validateWithRealmsDBAndOtherSources((user));         if (!authenticated)        return false;       throw new AuthenticationException("Not authorized: " + AUTH_FAILURE );     }      //end of check username and password. If true, then an authentication exception will be thrown         
    }}