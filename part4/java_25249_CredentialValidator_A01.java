import java.util.HashMap;
import java.util.Map;

public class java_25249_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_25249_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate with valid credentials
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Invalid credentials!");
        }

        // Validate with invalid credentials
        if (validator.validate("admin", "wrongpassword")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}