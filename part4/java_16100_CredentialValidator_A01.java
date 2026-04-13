import java.util.HashMap;
import java.util.Map;

public class java_16100_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_16100_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password"); // This is a very basic example of storing passwords securely
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            return this.credentials.get(username).equals(password);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}