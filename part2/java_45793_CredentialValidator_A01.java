public class java_45793_CredentialValidator_A01 {  
    
    private static final List<String> KNOWN_GOOD_PASSWORDS = Arrays.asList("password", "1234567890"); // Known good passwords for demonstration purposes 
                                                         
    public boolean validate(String inputPassword) {  
        if (KNOWN_GOOD_PASSWORDS.contains(inputPassword)) return true;     
         else throw new AccessDeniedException("Invalid Password!");     // Throwing exception on incorrect password for demonstration purposes 
                                                             }   
}