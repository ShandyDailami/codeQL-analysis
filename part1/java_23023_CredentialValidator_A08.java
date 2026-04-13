import java.util.HashMap;
import java.util.Map;

public class java_23023_CredentialValidator_A08 {
    private Map<String, String> users;

    public java_23023_CredentialValidator_A08() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (users.containsKey(username)) {
            return users.get(username).equals(password);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("user1", "password1");
        System.out.println("Is Valid? " + isValid);
    }
}