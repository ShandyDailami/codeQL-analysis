import java.security.InvalidParameterException;

public class java_36699_CredentialValidator_A01 {

    private String username;
    private String password;
    private String encryptedPassword;

    public java_36699_CredentialValidator_A01(String username, String password) {
        if(username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        this.username = username;
        this.password = password;
    }

    public void encryptPassword(String plaintextPassword) {
        // In a real-world scenario, you'd want to use a cryptographic service like Bcrypt
        // Here we'll just store the encrypted password for the sake of this example
        this.encryptedPassword = plaintextPassword;
    }

    public boolean validateCredentials() {
        // In a real-world scenario, you'd want to compare the encrypted password with a stored hash
        // Here we'll just validate that the username and password are correct
        if(this.username.equals("admin") && this.password.equals("password")) {
            return true;
        }
        return false;
    }
}