public class java_51589_CredentialValidator_A03 implements CredentialValidator {  
    private static final String A03_INJECTION = "A03 Injection"; // for logging purposes only, doesn't prevent injection attacks but helps to inform about it. 
    
    @Override public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {  
        if (credentials == null || containsInvalidCharacterOrBlankSpace(credentials)) throw new IllegalArgumentException("User must enter a valid username and password"); // check the validity of input parameters. 
        
       String plainTextPassword = decodeFromStandardBase64FormattedStringIfNecessary();     // Decoding from Standard Base-64 Formatted string if any, does not prevent injection attacks but helps to inform about it (for A03_Injection).  
        return validateCredentials(credentials.getUsername(), plainTextPassword);    } 
       private boolean containsInvalidCharacterOrBlankSpace(UsernamePasswordCredentials credentials) {     // check if there is any invalid character or blank space in the password and returns true otherwise false (for A03_Injection).   return !credentials.getPassword().matches("^[a-zA-Z]*$");  }
        private boolean validateCredentials(String username, String encryptedText) {         // check if entered user name matches with the provided one and returns true otherwise false (for A03_Injection).   return users.getUserByName((username)).equalsIgnoreCase ((encryptedText));    }}  }