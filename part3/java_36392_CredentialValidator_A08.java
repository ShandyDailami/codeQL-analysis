import java.util.HashMap;
import java.util.Map;

public class java_36392_CredentialValidator_A08 {

    private Map<String, String> userData;

    public java_36392_CredentialValidator_A08() {
        userData = new HashMap<>();
        userData.put("user1", "password1");
        userData.put("user2", "password2");
        userData.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        return userData.get(username) != null && userData.get(username).equals(password);
    }
}

// Usage:
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean valid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + valid);

        valid = validator.validateCredentials("user4", "password4");
        System.out.println("Is valid: " + valid);
    }
}