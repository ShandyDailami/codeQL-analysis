public class java_53100_CredentialValidator_A07 {
    private String[] users = {"user1", "admin"}; // hard-coded list of allowed usernames and password in this example
    
   public boolean validate(String user, String pass) throws Exception{
       if (Arrays.asList(users).contains(user)) { 
           return true;    // User is validated successfully with the given username/password combination        
      } else throw new AuthenticationFailedException("Invalid Credentials");   // If user not found, authentication failed and throws an exception to notify about it.       
       /* Note: In a real-world application you should use more secure methods 
          like hashing passwords instead of plain text storage or comparison with prehashed version */        
    }    
}