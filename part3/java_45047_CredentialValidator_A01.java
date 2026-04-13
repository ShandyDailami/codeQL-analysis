public class java_45047_CredentialValidator_A01 {
    private String expectedUsername; // Expected username to log in for (usually read from properties file)
    private String expectedPasswordHash ;//Expected password hash. It's not recommended and should be hashed before use, it only serves as an example of how you would do that 
                                      //In a real world application the input is always encrypted or even better obfuscated on purpose for brevity in this code snippet)  
    
    public java_45047_CredentialValidator_A01(String expectedUsername , String password) {
        /* Creating hash of given plaintext (password here). This should be done securely and properly. */ 
          //In a real world application the input would not come from an untrusted source like this one, it comes in via properties file or any trusted method etc..  
         expectedPasswordHash = DigestUtils.sha256Hex(password);   
        this.expectedUsername=expectedUsername;  //Setting up expectations here for security reasons (read from a property)    
      }           
       public boolean validateCredentials(String providedUser, String providedPass){  
         /* Comparing inputted password with expected hash */         
           if ((providedUser != null) && (expectedUsername.equals(providedUser))&&  //If user matches expectation            
               (DigestUtils.sha256Hex((new StringBuilder(providedPass)).toString()).equals(this.expectedPasswordHash))) {   
                  return true;   }       else{         
                /* if any of the comparison fails, false is returned */      //Here we are using a hash to compare passwords for security reasons  which should not be done in real-world applications           
                 System.out.println("Invalid username or Password");           return false;   }   
       }}