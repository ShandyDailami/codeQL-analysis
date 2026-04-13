import java.util.HashMap;
import java.util.Map;

public class java_35573_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_35573_CredentialValidator_A03() {
        // Initialize credentials
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        // If the username and password matches the ones stored in the map, return true
        // otherwise, return false
        if(credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "password"));  // Should print true
        System.out.println(validator.validate("admin", "wrongpassword"));  // Should print false
    }
}