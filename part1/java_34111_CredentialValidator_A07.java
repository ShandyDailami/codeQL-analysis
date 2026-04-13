import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class java_34111_CredentialValidator_A07 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validate(new Credentials("user1", "password1"));
            System.out.println("Authentication succeeded.");
        } catch (AuthenticationFailureException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}

class CredentialValidator {
    private Map<String, String> credentials;

    public java_34111_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public void validate(Credentials credentials) throws AuthenticationFailureException {
        if (!this.credentials.containsKey(credentials.getUsername())) {
            throw new AuthenticationFailureException("Invalid username or password.");
        }

        if (!this.credentials.get(credentials.getUsername()).equals(credentials.getPassword())) {
            throw new AuthenticationFailureException("Invalid username or password.");
        }
    }
}

class Credentials {
    private String username;
    private String password;

    public java_34111_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}

class AuthenticationFailureException extends Exception {
    public java_34111_CredentialValidator_A07(String message) {
        super(message);
    }
}