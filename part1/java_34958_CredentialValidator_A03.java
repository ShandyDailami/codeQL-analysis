import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_34958_CredentialValidator_A03 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user";
        String password = "password";

        if (!validator.validate(username, password)) {
            System.out.println("Invalid credentials");
        } else {
            System.out.println("Access granted");
        }
    }
}

class CredentialValidator {
    private Map<String, String> credentials;

    public java_34958_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user", "password");
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        String expectedPassword = this.credentials.get(username);

        return password.equals(expectedPassword);
    }
}