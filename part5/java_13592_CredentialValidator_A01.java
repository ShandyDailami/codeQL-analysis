import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13592_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_13592_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // You can add more credentials here
        // For example:
        // this.credentials.put("admin", "admin");
        // this.credentials.put("user", "user");
    }

    public boolean validate(String user, String password) {
        // Check if the user and password exist in the map
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            System.out.println("Access granted for user: " + user);
            return true;
        } else {
            System.out.println("Access denied for user: " + user);
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "admin");
        validator.validate("user", "user");
        validator.validate("invalid", "invalid");
    }
}