import java.util.Base64;

public class java_40249_CredentialValidator_A03 {

    // Simulating a hardcoded secret key
    private static final String SECRET_KEY = "S3cr3tK3y";

    // Using a hash function to compute the hashed password
    public String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    // Validating the hashed password against the hardcoded secret key
    public boolean validatePassword(String password) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(hashPassword(SECRET_KEY));
    }

    // Simulating a hardcoded user credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Using a hash function to compute the hashed credentials
    public String hashCredentials(String username, String password) {
        return Base64.getEncoder().encodeToString((username + password).getBytes());
    }

    // Validating the hashed credentials against the hardcoded user credentials
    public boolean validateCredentials(String username, String password) {
        String hashedCredentials = hashCredentials(username, password);
        return hashedCredentials.equals(hashCredentials(USERNAME, PASSWORD));
    }
}