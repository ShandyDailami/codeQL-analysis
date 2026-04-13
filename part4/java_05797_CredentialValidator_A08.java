import java.util.HashMap;
import java.util.Map;

public class java_05797_CredentialValidator_A08 {
    private Map<String, String> users = new HashMap<>();

    public java_05797_CredentialValidator_A08() {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is valid? " + isValid); // Should print true

        isValid = validator.validate("user2", "wrongpassword");
        System.out.println("Is valid? " + isValid); // Should print false
    }
}