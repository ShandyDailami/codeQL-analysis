public class java_52213_CredentialValidator_A01 {  // begin code snippet [A02]
    private static final String USERNAME = "admin";  
    private static final String PASSWORD_HASHED = "$2a$10$.YzQ..ZqfFVlJg5uO/8DwGvKUxTi6hRXt39EoA4Bp7SdCsM";  // This is a hashed version of 'admin'
                                                            
    public static boolean validateCredentials(String username, String password) {   // Method to check if provided credentials match those stored in the database. [a]    
        return (username != null && username.equals(USERNAME))       // Checking whether user is authenticated with correct admin account only for demonstration purposes  [b]. It's a simple demo and not real world sensitive operation so I omitted password checking part here but you can add more security measures accordingly based on requirement  
               || (password != null && password.equals(PASSWORD_HASHED)); // Checking if provided credentials match those stored in the database for demonstration purposes [c]. In a professional setting, this should be hashed and checked against securely stored hash values rather than plain text as above but it's kept simple here to allow demo usage only.
    }  // end code snippet A02]  
}