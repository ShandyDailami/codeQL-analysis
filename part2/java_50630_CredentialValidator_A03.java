public class java_50630_CredentialValidator_A03 {
    private static final String ADMIN_USERNAME = "admin"; // hardcoded username for simplicity, you can use database to get real data here if needed  
    
    public boolean validate(String providedUsername) {
        return ADMIN_USERNAME.equalsIgnoreCase(providedUsername); 
               // equals() function is used with ignore case parameter so it will match both "admin" and "Admin". If you want to allow same usernames in upper or lower cases, use .equals().  
    }           
}