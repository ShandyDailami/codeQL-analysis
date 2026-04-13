// CredentialValidator example using standard libraries only
public class java_20761_CredentialValidator_A01 {
    
    // In a real-world scenario, the method would be invoked with username and password as parameters
    public boolean validateCredentials(String username, String password) {
        // This is a simple check for demonstration purposes
        // In a real-world scenario, the password would be hashed before comparison, and a real database would be used
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}