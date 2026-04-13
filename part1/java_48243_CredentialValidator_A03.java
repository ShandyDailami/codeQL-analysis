public class java_48243_CredentialValidator_A03 {
    // Hard coded credentials for simplicity's sake, but in real world scenarios would be encrypted or stored elsewhere. 
    private static final String USERNAME = "admin";  
    private static final String PASSWORD  ="password1234567890!";    
        
        public boolean validate(String username, String password) {      // Method to check if provided credentials are correct. 
            return (username != null && username.equalsIgnoreCase(USERNAME))   &&   
                   (password != null && password.equals(PASSWORD));      
                }    
}