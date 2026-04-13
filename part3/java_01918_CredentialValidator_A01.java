import java.util.HashMap;
import java.util.Map;

public class java_01918_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_01918_CredentialValidator_A01() {
        credentials = new HashMap<>();
        credentials.put("admin", "password");
    }

    public boolean isValid(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        if (validator.isValid("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}