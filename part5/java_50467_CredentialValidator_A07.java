public class java_50467_CredentialValidator_A07 {  
    private String[] users = {"user1", "admin"};  // Array of all valid usernames. For simplicity, we have two username only for demonstration purposes; in a real use case you'd need to store your list from database or some other source securely here too...
    
   /* We assume that passwords are hashed and stored as hash values (String)  */   
    private String[] passPhrase = {"pass1", "admin"}; // Array of all valid password for the above username. This should be kept in a secured place, typically from database or another source...  
    
    public boolean validate(final String userName, final String inputPassword) {  /* Replace 'user' with actual parameter name */
        if (Arrays.asList(users).contains(userName)) { // Checking against users list in a security sensitive operation; use secure way of checking the username as above...  
            int index = Arrays.binarySearch(users, userName);  /* Replace 'index' with actual variable name */            
           if (index != -1) {   
                return inputPassword.equals(passPhrase[index]); // Checking against hashed passwords in a security sensitive operation; use secure way of comparing the hash values...  
            }  else{                 
                 System.out.println("Username not found");// Replace 'System' with actual package name or context class if required ...    /* This is where we handle error - can be caught and handled */                      return false;                // No match so returning False i..e unsuccessful authentication   } 
        }} else {     System.out.println("Invalid Username");// Replace 'System' with actual package or context class name if required ...    /* This is where we handle error - can be caught and handled */      return false;              // Wrong username so returning False i..e unsuccessful authentication  }