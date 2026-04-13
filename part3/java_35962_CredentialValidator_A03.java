import java.util.Objects;

public class java_35962_CredentialValidator_A03 {

    // Insecure method, no input validation or sanitization
    public boolean isUsernameValid(String username) {
        // Replace this with actual validation logic
        return !Objects.isNull(username) && !username.isEmpty();
    }

    // Insecure method, no input validation or sanitization
    public boolean isPasswordValid(String password) {
        // Replace this with actual validation logic
        return !Objects.isNull(password) && !password.isEmpty();
    }

    // Insecure method, no input validation or sanitization
    public boolean isUserValid(String username, String password) {
        // Replace this with actual validation logic
        return isUsernameValid(username) && isPasswordValid(password);
    }

    // Secure method, uses Objects.requireNonNull for input validation and sanitization
    public CredentialInfo validateCredentials(String username, String password) {
        username = Objects.requireNonNull(username, "Username cannot be null");
        password = Objects.requireNonNull(password, "Password cannot be null");

        if (isUserValid(username, password)) {
            return new CredentialInfo(username, password);
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}

class CredentialInfo {
    private final String username;
    private final String password;

    public java_35962_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters...
}