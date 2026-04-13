import java.util.Base64;

public class java_25264_CredentialValidator_A03 {
    // Real password used for validation
    private String password;

    // Stored hashed password
    private String hashedPassword;

    public java_25264_CredentialValidator_A03(String password) {
        this.password = password;
        this.hashedPassword = hashPassword(password);
    }

    public boolean isValidPassword(String password) {
        // Checking if the password matches the hashed password
        return hashPassword(password).equals(this.hashedPassword);
    }

    // Hashing password for security
    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}