import java.util.HashMap;
import java.util.Map;

public class java_36130_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_36130_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user", "password");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("admin", "password")); // Outputs: true
        System.out.println(validator.validate("user", "wrongpassword")); // Outputs: false
        System.out.println(validator.validate("invaliduser", "password")); // Outputs: false
    }
}