import java.util.Objects;

public class java_41129_CredentialValidator_A07 {
    public static void validate(String username, String password) throws CredentialException {
        if (Objects.isNull(username) || Objects.isNull(password) || username.isEmpty() || password.isEmpty()) {
            throw new CredentialException("Username or password cannot be null or empty");
        }
    }

    public static class CredentialException extends Exception {
        public java_41129_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}