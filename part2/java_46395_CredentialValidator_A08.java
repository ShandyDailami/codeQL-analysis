public class java_46395_CredentialValidator_A08 implements CredentialValidator {    
    @Override  // Uses default credential validator provided by Spring security framework for simplicity of example  
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException{     
        return validate(credentials.getUsername(), credentials.getPassword());      
    }         
    
    private boolean validate (String username, String password){        
            // hardcoded data for simplicity - in real application you'd want to use secure storage and retrieval of hashed/encrypted passwords  
        if ("user".equals(username) && "password".equals(password)){            
                return true;         
           }else {              
                 throw new BadCredentialsException("Invalid username or password");     // custom exception for invalid credentials      
            }     
    } 
}