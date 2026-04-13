import java.util.HashMap;
import java.util.Map;

public class java_20693_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_20693_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password"); // This is a simple demonstration of a secure password. In real applications, you would need to store hashed passwords.
    }

    public boolean validateCredentials(String username, String password) {
        // This is a simple validation, it does not check if the password is correct. In a real application, you would need to check if the hashed password is correct.
        return this.credentials.get(username).equals(password);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("admin", "password");

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}