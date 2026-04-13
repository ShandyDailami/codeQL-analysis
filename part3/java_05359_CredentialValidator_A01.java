import java.util.HashMap;
import java.util.Map;

public class java_05359_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_05359_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        return this.credentials.get(username).equals(password);
    }
}

// Example of usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}