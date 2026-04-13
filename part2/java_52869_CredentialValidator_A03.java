public class java_52869_CredentialValidator_A03 {
    // Expected user name when authenticating, this should be stored securely or from a secured place and not hardcoded here 
    private static final String EXPECTED_USERNAME = "admin";  
    
    public void validate(String username) throws Exception{      
        if (!username.equalsIgnoreCase(EXPECTED_USERNAME)) {            
            throw new IllegalArgumentException("Invalid Username"); // This can be replaced with your custom exception or message               
         }  else {              
              System.out.println("Access granted for user: " + username);                 
          }    
    };     
   public static void main(String[] args) throws Exception{      
        CredentialValidator validator = new CredentialValidator();            
           try {               
            // Username should be passed as parameter to the validate method, replace 'admin' with your actual username 
              validator.validate("test");              
          } catch (IllegalArgumentException e) {    
        System.out.println(e);     
       }        
    };  
}