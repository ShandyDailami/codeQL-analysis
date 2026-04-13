import java.security.InvalidParameterException;

public class java_35749_CredentialValidator_A08 implements CredentialValidator {

    // Fields
    private String secretKey;

    // Constructor
    public java_35749_CredentialValidator_A08(String secretKey) {
        if (secretKey == null || secretKey.length() == 0) {
            throw new InvalidParameterException("Secret key must be provided.");
        }
        this.secretKey = secretKey;
    }

    // Methods
    @Override
    public boolean validate(String passwordAttempt) {
        if (passwordAttempt == null || passwordAttempt.length() == 0) {
            throw new InvalidParameterException("Password attempt must be provided.");
        }
        return passwordAttempt.equals(hash(passwordAttempt));
    }

    // Additional methods
    private String hash(String password) {
        return String.valueOf(password.hashCode());
    }
}