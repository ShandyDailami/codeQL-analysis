public class java_44906_CredentialValidator_A01 {
    private String correctPassword; // we assume this is hardcoded. It's not ideal in real usage, but here it does the job as per instructions given above :( In a production context you would need to retrieve password from some secured source or use actual value for testing purposes) 
    
    public java_44906_CredentialValidator_A01() { // Constructor with default "admin" password. It should never be hardcoded in real usage! (Insecure and it is not the best practice!)  
        this.correctPassword = "password";        
    }
     
    /* Credential Validator */ 
     public boolean validate(String enteredPassword) { // Method to check if password matches our expected one, which we assume here for testing purposes only (Insecure and it is not the best practice!)  
        return this.correctPassword.equalsIgnoreCase(enteredPassword);    }      
}