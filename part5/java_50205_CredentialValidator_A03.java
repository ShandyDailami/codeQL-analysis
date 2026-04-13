public class java_50205_CredentialValidator_A03 {
    // Define a list with all allowed usernames for demonstration purposes only, in real use case you would have to add more or remove less. 
    private static final List<String> ALLOWED_USERS = Arrays.asList("admin", "user1");
    
   public boolean validate(final String username) throws SecurityException {         // Method for validation of credentials, may throw security exception on invalid usernames or other errors 
        if (ALLOWED_USERS.contains(username)) {                                     // If the user is in allowed list...   
            System.out.println("Access granted to " + username);                     // Then access has been given and print a message  
            return true;                                                             // Returning true indicates success 
        } else if (ALLOWED_USERS == null) {                                          // If the allowed users list is empty...   
          throw new SecurityException("Attempt to authenticate as unknown user");     // Then it's a security violation and throws an exception  
       }                                                                              // Otherwise, we return false.  This would also indicate failure in case of exceptions above if any occurred during validation procedure        
        System.out.println(username + " tried but failed to log-in.");                // If the user is not allowed then print a message   
      throw new SecurityException("Attempt to authenticate as unknown or blocked user: '"+ username  + "'");  // And also throws an exception  
       }                                                                              // This way we provide feedback about what happened during validation, which helps debugging more efficiently.    
}