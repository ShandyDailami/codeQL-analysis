import java.util.HashMap;
import java.util.Map;

public class java_31226_CredentialValidator_A07 {

    private Map<String, String> users = new HashMap<>();

    public java_31226_CredentialValidator_A07() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is Valid? " + isValid); // Should print true

        isValid = validator.validateCredentials("user3", "password3");
        System.out.println("Is Valid? " + isValid); // Should print false
    }
}