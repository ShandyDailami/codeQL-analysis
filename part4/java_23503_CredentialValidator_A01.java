import java.security.InvalidParameterException;

public class java_23503_CredentialValidator_A01 {
    private String userName;
    private String password;
    private String encryptedPassword;

    public java_23503_CredentialValidator_A01(String userName, String password) {
        if (userName == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }
        this.userName = userName;
        this.password = password;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        if (encryptedPassword == null) {
            throw new InvalidParameterException("Encrypted password must not be null");
        }
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isPasswordValid() {
        // Implement the logic for checking if the password is valid
        // Here, we're just using a dummy check. In reality, you'd have a method in your secure storage class
        // that performs the actual password check.
        return this.password.equals(this.encryptedPassword);
    }
}